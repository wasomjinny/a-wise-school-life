<?php

include_once($_SERVER['DOCUMENT_ROOT'].'/school/inc/session/session.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');

$user_id = trim($_POST['member_id']);
$user_pw = trim($_POST['password']);

$expire = time() + 3600 * 24 * 365;


  $sql = "SELECT * FROM admin where loginid = '".$user_id."' and password = '".$user_pw."'";
  $result = mysqli_query($conn, $sql);
  $row = mysqli_fetch_array($result);
  if($row==NULL) {
?>

<script language="javascript">
	//로그인을 다시 하라는 경고문을 출력한다
	alert("이름 또는 비밀번호가 틀립니다. 다시 입력하여 주십시오");
	history.back();
</script>

<?php
  }

  else {
    session_start();
    $_SESSION['admin'] = 'h';
    $_SESSION['member_id'] = $row['no'];
    $_SESSION['power'] = $row['power'];

    header('Location: /school/mainpage.php');
    exit;

  }

?>
