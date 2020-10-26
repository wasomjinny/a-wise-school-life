<?php
/*
급식 랭킹에 사용되는 api
*/
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');

//kind의 값이 1이면 기존메뉴, 2이면 추천메뉴
$kind = request('kind');
$response = array();

if($kind=="1"){
	$sql = "select a.no, a.name,
					(select sum(b.good_no-b.bad_no)
					from foodmenu b where b.food_no = a.no) as good_no
					from food a order by good_no desc";
//좋아요에서 싫어요를 뺀 숫자를 good_no에 저장
} else if($kind=="2"){
	$sql = "select no, name, good_no from recommend_food order by good_no desc";
}

$result=mysqli_query($conn,$sql);
$i = 1;
while($r = mysqli_fetch_array($result)){
	if($r["good_no"]>0){
		array_push($response,
		array(
			'no'=>"".$i,
			'food_no'=>"".$r['no'],
			'food_name'=>"".$r['name'],
			'good_no'=>"".$r['good_no']));
	}
	$i++;
}

echo json_encode(null2blank($response));

?>
