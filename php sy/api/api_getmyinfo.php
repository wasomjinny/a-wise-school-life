<?php
/*
내 정보 설정하기에서 기존 내 정보를 읽어오는 api
*/
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');

$user_no	 = request('user_no');  // 학생번호 읽어옴

$response = array();
$response['val_bus'] = '';
$response['val_busstop'] = '';
$response['val_allergy'] = '';

//등록된 노선번호, 정류장번호, 알러지정보를 읽어옴.
$sql = "select * from student
				where no= $user_no";

$result=mysqli_query($conn,$sql);

if(!$result){
	$response['val_bus'] = '';
	$response['val_busstop'] = '';
	$response['val_allergy'] = '';
	echo json_encode($response);
	exit;
} else {

	$r = mysqli_fetch_array($result);
	$response['val_bus'] = $r['bus_no'];
	$response['val_busstop'] = $r['busstop_no'];
	$response['val_allergy'] = $r['allergy_info'];
}

//버스노선 목록을 읽어와서 $bus_info에 배열로 저정
$bus_info = array();

$sql = "SELECT no,name FROM busschedule where isuse=1 order by no";
$result=mysqli_query($conn,$sql);
array_push($bus_info,
array(
	'no'=>"0",
	'name'=>"선택되지 않음"));
while($r = mysqli_fetch_array($result)){
	$no   = $r['no'];
	$name   = $r['name'];
	array_push($bus_info,
  array(
		'no'=>"".$no,
		'name'=>"".$name));
}

$response['bus_info'] = $bus_info;

$busstop_info = array();
//버스정류장 목록을 읽어와서 $busstop_info에 배열로 저정
$sql = "select b.no, b.name, a.bs_no as bsno from busroutine a
				left join code b on b.no = a.bus_stop order by a.bs_no, a.seq";
$result=mysqli_query($conn,$sql);
array_push($busstop_info,
array(
	'no'=>"0",
	'name'=>"선택되지 않음",
	'bsno'=>""));
while($r = mysqli_fetch_array($result)){
	$no   = $r['no'];
	$name   = $r['name'];
	$bsno = $r['bsno'];
	array_push($busstop_info,
	array(
		'no'=>"".$no,
		'name'=>"".$name,
		'bsno'=>"".$bsno));
}

$response['busstop_info'] = $busstop_info;

$allergy_info = array();
//알러지 목록(18개)을 읽어와서 $allergy_info에 배열로 저정
$sql = "SELECT sort,name FROM code where parent_no=310 order by sort";
$result=mysqli_query($conn,$sql);

while($r = mysqli_fetch_array($result)){
	$no   = $r['sort'];
	$name   = $r['name'];
	array_push($allergy_info,
	array(
		'no'=>"".$no,
		'name'=>"".$name));
}

$response['allergy_info'] = $allergy_info;

echo json_encode(null2blank($response));

?>
