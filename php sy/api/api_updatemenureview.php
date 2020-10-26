<?php
/*
학생들의 급식리뷰를 업데이트하는 api
*/
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');

//앱에서 넘어오는 데이터
$student_no	 = request('student_no');
$menudate	 = request('menudate');
$lunchdinner	 = request('lunchdinner');
$remark	 = request('remark');
$foodmenu = request('arrfoodmenu');

$update_status = true;

//remark 등록
if($remark !=null && $remark !=""){
	$sql = "select * from foodreviewremark
					where student_no = $student_no and menudate='$menudate'
					and lunchdinner=$lunchdinner";
	$result = mysqli_query($conn,$sql);
	if($row=mysqli_fetch_array($result)){
		//이미 등록되어 있으면 기존의 내용 업데이트
		$sql_update = "update foodreviewremark
									set remark = '$remark'
									where student_no = $student_no and menudate='$menudate'
									and lunchdinner=$lunchdinner";
		$retval = mysqli_query($conn,$sql_update);
		$update_status = $retval ? true : false;
	} else {
		//등록되어 있지 않으면 신규 등록
		$sql_update = "insert into foodreviewremark (student_no,menudate,lunchdinner,remark)
									values ('$student_no','$menudate',$lunchdinner,'$remark')";
		$retval = mysqli_query($conn,$sql_update);
		$update_status = $retval ? true : false;
	}
}
//$foodmenu값이 ","로 구분되어 있어 split해 줌(explode)
$arrfoodmenu = explode(",",$foodmenu);
if(sizeof($arrfoodmenu)>0){
	for($i=0;$i<sizeof($arrfoodmenu);$i++){
		// 각 메뉴들의 review정보가 "/"로 구분되어 있어 split해줌
		$foodmenudetail = explode("/",$arrfoodmenu[$i]);
		$foodmenu_no = $foodmenudetail[0];
		$good_no = $foodmenudetail[1];
		$bad_no = $foodmenudetail[2];
		$review_status = $foodmenudetail[3];
		$sql_update = "update foodmenu set good_no = $good_no, bad_no = $bad_no
		           		where no=$foodmenu_no";
		$retval = mysqli_query($conn,$sql_update);
		$update_status = $retval ? true : false;

		//학생들의 리뷰정보를 업데이트해줌.(있으면 업데이트, 없으면 신규등록)
		$sql_select = "select * from foodreviewmenu where foodmenu_no = $foodmenu_no and student_no = $student_no";
		$result=mysqli_query($conn,$sql_select);
		if($row=mysqli_fetch_array($result)) {
			$sql_update = "update foodreviewmenu set review_status = $review_status
										where foodmenu_no = $foodmenu_no and student_no=$student_no";
			$retval = mysqli_query($conn,$sql_update);
			$update_status = $retval ? true : false;
		} else {
			$sql_update = "insert into foodreviewmenu (student_no,foodmenu_no,review_status)
										values ($student_no,$foodmenu_no,$review_status)";
			$retval = mysqli_query($conn,$sql_update);
			$update_status = $retval ? true : false;
		}
	}
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
