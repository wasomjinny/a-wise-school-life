<?php
/*
기사님이 공지사항을 들록하는 api
*/
//공통으로 사용하는 함수들을 모아놓은 파일과 DB접속을 위한 파일
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');

//앱에서 넘어오는 데이터 Get 방식으로 넘어옴
$token	 = request('token'); //내용

if($token != null){
	$reg_date = date('Y-m-d');
	//등록이 되어 있지 않으면 등록, 추천값을 1로 세팅
	$sql= "INSERT INTO user_token (token) VALUES ( '$token')
	 			ON DUPLICATE KEY UPDATE token = '$token';";
	mysqli_query($conn,$sql);

	//정상적으로 추가되었다고 response함.
	$response['value'] = '1';
	$response['message'] = '정상적으로 저장되었습니다.';
} else {
	$response['value'] = '2';
	$response['message'] = '정상적으로 저장되지 않았습니다.';
}

//response를 json으로 인코딩
echo json_encode(null2blank($response));

?>
