<?php
/*
학생들의 개인설정(이용버스노선, 정류장, 알러지정보)를 업데이트하는 api
*/
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');

// 앱에서 넘어오는 데이터
$user_no	 = request('user_no');
$bus_no	 = request('bus_no');
$busstop_no	 = request('busstop_no');
$allergy_info	 = request('allergy_info');

$sql = "update student
				set bus_no = $bus_no,
				busstop_no = $busstop_no,
				allergy_info = '$allergy_info'
				where no= $user_no";

if($result=mysqli_query($conn,$sql)){
	$response['value'] = '1';
	$response['message'] = '정상적으로 저장되었습니다.';
} else {
	$response['value'] = '0';
	$response['message'] = '저장중에 오류가 발생하였습니다.';
}

echo json_encode(null2blank($response));

?>
