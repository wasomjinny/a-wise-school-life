<?php
/*
버스 공지사항의 목록을 불러오는 api
*/
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');

$response = array();
//등록날짜 역순으로 불러옴
$sql = "select * from bulletin order by reg_date desc";

$result=mysqli_query($conn,$sql);

while($r = mysqli_fetch_array($result)){
	$no   = $r['no'];
	$title   = $r['title'];
	$reg_date = $r['reg_date'];
	$content = $r['content'];
	array_push($response,
	array(
		'no'=>"".$no,
		'title'=>"".$title,
		'reg_date'=>"".$reg_date,
		'content'=>"".$content));
}

echo json_encode(null2blank($response));

?>
