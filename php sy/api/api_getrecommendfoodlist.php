<?php
/*
추천메뉴 등록에서 등록된 메뉴목록을 보여주는 api
*/
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');

$student_no = request('student_no');

$response = array();
$sql = "select a.*, b.no as isregister from recommend_food a
				left outer join recommend_food_review b on b.food_no = a.no
						and b.student_no = $student_no
				order by a.good_no desc";

$result=mysqli_query($conn,$sql);

while($r = mysqli_fetch_array($result)){
	$isregister = $r['isregister'] ? 1 : 0; //추천되어 있으면 1, 없으면 0
	array_push($response,
	array(
		'no'=>"".$r['no'],
		'food_name'=>"".$r['name'],
		'good_no'=>"".$r['good_no'],
		'review_status'=>"".$isregister));
}

echo json_encode(null2blank($response));

?>
