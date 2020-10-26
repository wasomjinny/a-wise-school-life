<?php
/*
로그인을 체크하는 api
*/
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');


$id	 = request('user_id');  // 등록한 ID
$pswd = request('user_pwd');   // 비밀번호
$site_pswd = request('site_pswd');      // 학생(1)인지 선생인지 구분(2)

//ID를 등록하지 않았을 때 에러 메시지
if (!$id){
		$response['code'] = '206';
		$response['message'] = "ID 정보가 없습니다.";
		echo json_encode($response);
		exit;
}


$response = array();
$response['code'] = '';
$response['message'] = '';

//입력해야 앟 데이터 중 빠진 내용이 있을 때
if(!$id || !$pswd || !$site_pswd){

	$response['code'] = '201';
	$response['message'] = "ID 또는 비밀번호를 입력하세요.";

} else {

	if($site_pswd == "1"){ //학생이면
		$sql = "select * from student where loginid = '$id'
						and password = '$pswd'";
	} else { //선생이면
		$sql = "select a.*, b.name as gwamok_name from teacher a
		 				left join code b on b.no = a.gwamok where a.loginid = '$id'
						and a.password = '$pswd'";
	}

	$result=mysqli_query($conn,$sql);
	if($r = mysqli_fetch_array($result)){

		$response['code'] = '200';
		$response['message'] = '로그인에 성공하였습니다.';

		$user_no   = $r['no'];
		$user_id   = $r['loginid'];
		$user_pw   = $r['password'];
		$user_name = $r['name'];
		$user_tel = $r['tel'];
		if($site_pswd == "1"){ //학생일 경우
			$user_kind = "1"; //학생선생 구분의 용도
			$user_info_value1 = $r['grade'];
			$user_info_value2 = $r['ban'];
			$user_info_value3 = $r['std_no'];
			$bus_no = $r['bus_no'];
			$busstop_no = $r['busstop_no'];
			$allergy_info = $r['allergy_info'];

		} else { //선생일 경우
			$user_kind = "2";
			$user_info_value1 = $r['gwamok_name'];
			//기사선생님의 경우 운행하는 노선의 번호를 지정
			//앱에서 기사일 경우만 운행을 조정하는 화면이 나타남
			$user_info_value2 = $r['bus_no'];
			$user_info_value3 = "";
			$bus_no = "";
			$busstop_no = "";
			$allergy_info = "";
		}
		$response['result'] = array(
			'user_no'=>"".$user_no,
			'user_id'=>"".$user_id,
			'user_pw'=>"".$user_pw,
			'user_name'=>"".$user_name,
			'user_tel'=>"".$user_tel,
			'user_kind'=>"".$user_kind,
			'user_info_value1'=>"".$user_info_value1,
			'user_info_value2'=>"".$user_info_value2,
			'user_info_value3'=>"".$user_info_value3,
			'bus_no'=>"".$bus_no,
			'busstop_no'=>"".$busstop_no,
			'allergy_info'=>"".$allergy_info
		);

	} else { //로그인 성공
		$response['code'] = '202';
		$response['message'] = "ID 또는 비밀번호가 등록되어 있지 않습니다.";
		echo json_encode($response);
		exit;
	}
}

echo json_encode(null2blank($response));
?>
