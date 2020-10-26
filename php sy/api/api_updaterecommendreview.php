<?php
/*
추천메뉴의 리뷰를 업데이트하는 api
*/
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');

//앱에서 넘어오는 데이터
$student_no	 = request('student_no');
$food_no	 = request('food_no');
$review_status	 = request('review_status');

//학생의 리뷰정보가 있는지를 조사
$sql = "select * from recommend_food_review
				where student_no = $student_no and food_no = $food_no";
$result = mysqli_query($conn,$sql);
if($row=mysqli_fetch_array($result)){
	$isExist = true;
} else {
	$isExist = false;
}

//리뷰정보가 없고 좋아요를 선택(1)했을 때
if($review_status =="1" && !$isExist){
	//리뷰 테이블에 레코드 추가하고
	$sql = "insert into recommend_food_review (student_no,food_no)
	 				values ($student_no,$food_no)";
	$retval = mysqli_query($conn,$sql);
	//메뉴의 좋아요 카운터를 1 증가시킴
	$sql ="update recommend_food set good_no = good_no +1
					where no = $food_no";
	$retval = mysqli_query($conn,$sql);
	//리뷰정보가 있고 좋아요를 해제(0)했을 때
} else if($review_status =="0" && $isExist) {
	//리뷰테이블에 해당 학생의 리뷰정보를 삭제하고
	$sql = "delete from recommend_food_review
					where student_no = $student_no and food_no = $food_no";
	$retval = mysqli_query($conn,$sql);
	//메뉴의 좋아요 카운터를 1감소 시킴
	$sql ="update recommend_food set good_no = good_no -1
					where no = $food_no";
	$retval = mysqli_query($conn,$sql);
}

if($retval){
	$response['value'] = '1';
	$response['message'] = '정상적으로 저장되었습니다.';
} else {
	$response['value'] = '0';
	$response['message'] = '정상적으로 처리되지 않았습니다.';
}

echo json_encode(null2blank($response));

?>
