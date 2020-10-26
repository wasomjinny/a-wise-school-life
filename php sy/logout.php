<?php
	session_start();
	$_SESSION['member_id'] = '';
	session_destroy();
?>

<script language="javascript">
	//로그인을 다시 하라는 경고문을 출력한다
	top.location.href = 'login1.php';
</script>

<?php
    exit;
?>
