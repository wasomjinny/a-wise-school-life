<?php
/*
추천음식을 등록하는 api
*/
//공통으로 사용하는 함수들을 모아놓은 파일과 DB접속을 위한 파일
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');

//앱에서 넘어오는 데이터 Get 방식으로 넘어옴
$student_no	 = request('student_no'); //등록학생 번호
$food_name	 = request('food_name'); //등록한 요리 이름

//기존에 등록되어 있는지 확인
$sql = "select * from recommend_food where name = '$food_name'";
$result = mysqli_query($conn,$sql);
if($row=mysqli_fetch_array($result)){
	//만일 등록되어 있다면
	$response['value'] = '2';
	$response['message'] = '이미 추천메뉴로 등록되어 있습니다.';
} else {
	//등록이 되어 있지 않으면 등록, 추천값을 1로 세팅
	$sql = "insert into recommend_food (name,reg_no,good_no)
	 				values ('$food_name',$student_no,1);";
	mysqli_query($conn,$sql);
	//방금 등록한 레코드의 no값을 읽어 온다.
	$sql = "select no from recommend_food where name='$food_name'
					and reg_no = $student_no order by no desc";
	$result = mysqli_query($conn, $sql);
	$r=mysqli_fetch_array($result);
	$food_no = $r['no'];
	//추천메뉴 리뷰 테이블에 레코드 추가
	$sql = "insert into recommend_food_review (student_no,food_no)
	 				values ($student_no,$food_no);";
	mysqli_query($conn,$sql);

	//정상적으로 추가되었다고 response함.
	$response['value'] = '1';
	$response['message'] = '정상적으로 저장되었습니다.';
}

//response를 json으로 인코딩
echo json_encode(null2blank($response));

?>
