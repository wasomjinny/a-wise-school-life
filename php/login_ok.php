<?php

include_once($_SERVER['DOCUMENT_ROOT'].'/school/inc/session/session.php'); // 일정 기간 안 들어가면 로그아웃
include_once($_SERVER['DOCUMENT_ROOT'].'/school/inc/connect.php'); //접속 정보

$user_id = trim($_POST['member_id']);  //받을 때는 $_POST // trim은 데이터 양쪽 끝의 빈칸 없앰
$user_pw = trim($_POST['password']);


  $sql = "SELECT * FROM admin where loginid = '".$user_id."' and password = '".$user_pw."'";
  $result = mysqli_query($conn, $sql);  //실행시킴
  $row = mysqli_fetch_array($result);  //실행시킨 것을 보여줌
  if($row==NULL) {//로그인을 잘못했을때
?>

<script language="javascript">
	//로그인을 다시 하라는 경고문을 출력한다
	alert("이름 또는 비밀번호가 틀립니다. 다시 입력하여 주십시오"); //alert는 경고창을 띄워줌
	history.back(); //앞에 로그인 창으로 다시 돌아감
</script>

<?php
  }

  else {
    session_start();
    $_SESSION['admin'] = 'h';
    $_SESSION['member_id'] = $row['no'];
    $_SESSION['power'] = $row['power'];     //세션정보를 저장

    header('Location: /school/mainpage.php'); //어디로 가는것

  }

?>
