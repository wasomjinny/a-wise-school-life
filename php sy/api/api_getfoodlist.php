<?php
/*
오늘의 급식 목옥과 급식 리뷰에 공통으로 사용되는 api
*/
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');

$menudate = request('menudate'); //급식일자
$lunchdinner = request('lunchdinner'); //점심:0, 저녁:1 구분
$student_no = request('student_no'); //학생번호

//학생이 해당일자에 리뷰정보를 불러온다
$sql = "select remark from foodreviewremark
				where menudate = '$menudate' and lunchdinner = $lunchdinner
				and student_no = $student_no";

$result = mysqli_query($conn,$sql);
if($result){ //리뷰가 있으면
	$r = mysqli_fetch_array($result);
	$response['remark'] = $r['remark'];
} else {
	$response['remark'] = '';
}

//선택한 급식일자에 해당하는 메뉴목록을 불러옴.
//학생의 선호도 정보를 outer join으로 불러옴.
$menu_info = array();
$sql = "select a.*, b.name as food_name, b.cal, b.allergy, c.review_status
				from foodmenu a
 				left join food b on b.no = a.food_no
				left outer join foodreviewmenu c on c.foodmenu_no = a.no
															and c.student_no = $student_no
				where a.menudate = '$menudate' and a.lunchdinner = $lunchdinner
				order by a.sort";

$result=mysqli_query($conn,$sql);

while($r = mysqli_fetch_array($result)){
	array_push($menu_info,
	array(
		'no'=>"".$r['no'],
		'food_no'=>"".$r['food_no'],
		'food_name'=>"".$r['food_name'],
		'good_no'=>"".$r['good_no'],
		'bad_no'=>"".$r['bad_no'],
		'cal'=>"".$r['cal'],
		'allergy'=>"".$r['allergy'],
		'review_status'=>"".$r['review_status']));
}

$response['menu_info'] = $menu_info;

echo json_encode(null2blank($response));

?>
