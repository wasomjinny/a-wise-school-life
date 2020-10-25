<?
include_once($_SERVER['DOCUMENT_ROOT'].'/school/inc/session/session_check.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');

$todo = isset($_POST['todo']) ? $_POST['todo'] : $_GET['todo'];
$code_no = isset($_POST['code_no']) ? $_POST['code_no'] : $_GET['code_no'];

$msg = '';
$err = '';

if($todo == 'insert_commit' || $todo == 'update_commit') {
	//----------------------
	// 코드 등록, 수정하기
	//----------------------
	//echo '<pre>'.print_r($_POST,true).'</pre>';exit;


	$name = trim($_POST['name']);
	$name = stripslashes($name);
	$name = str_replace('"','&quot;',$name);
	$name = str_replace("'",'&#039;',$name);
	$name = str_replace('<','&lt;',$name);
	$name = str_replace('>','&gt;',$name);
	$gwamok = intval($_POST['gwamok']);
	$tel = $_POST['tel'];
	$loginid = $_POST['loginid'];
	$password = $_POST['password'];

	if($code_no == '') {

		$sql.= "insert into teacher (name,gwamok,tel,loginid,password) ";
		$sql.= "values ('$name',$gwamok,'$tel','$loginid','$password'); ";

		$msg = '등록되었습니다.';

		$history_flag = 'code_insert';

	}
	else {

		$history_flag = 'code_update';
		$sql.= "update teacher set ";
		$sql.= "  name = '$name', gwamok=$gwamok, tel = '$tel',loginid = '$loginid', password = '$password' ";
		$sql.= " where no = $code_no; ";

		$msg = '수정되었습니다.';

	}

	mysqli_query($conn, $sql);

}
else if($todo == 'delete_commit') {

		$history_flag = 'code_delete';
		$sql = "delete from teacher where no = $code_no; ";

		$msg = '삭제되었습니다.';
		mysqli_query($conn, $sql);

}


if($todo == 'insert_commit' || $todo == 'update_commit' || $todo == 'delete_commit') {

	?>

	<script language="JavaScript">

	opener.location.reload();
	window.close();

	</script>
	<?
	exit;
}

$todo = $todo.'_commit';
?>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.8.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="/school/common/style.css">
<script type="text/javascript" src="/school/common/javascript.jsc"></script>
<script language="JavaScript">
<!--
function do_save() {
	var f = document.form_edit;
	if(f.name.value == '') { f.name.focus(); return; }
	//show_loading();
	f.btn_save.disabled = true;
	f.submit();
}

function do_delete() {
	var f = document.form_edit;
	if ( !confirm("정말 삭제하시겠습니까?"))
	{
	 f.name.focus(); return;
	}
	//show_loading();
	f.todo.value='delete_commit';
	f.submit();
}

//-->
</script>

<style>
.icon_image {margin:3px;cursor:pointer;border:0;}
</style>
</head>

<body>

<form name="form_edit" action="<?=$self?>" method="post">
<input type="hidden" name="todo" value="<?=$todo?>">
<input type="hidden" name="code_no" value="<?=$code_no?>">

<?
if($code_no) {
	$sql = 'select * from teacher where no = '.$code_no;
	$result=mysqli_query($conn,$sql);
	$row = mysqli_fetch_array($result);
	$name = $row['name'];
	$gwamok = $row['gwamok'];
	$tel = $row['tel'];
	$loginid = $row['loginid'];
	$password = $row['password'];
}
?>

<table class="form" width="100%">

	<tr>
		<th width="120">이름</th>
		<td><input type="text" id="name" name="name" value="<?=db2textarea($name)?>" class="textbox" style="width:50%;font-weight:bold;" style='IME-MODE:active' onfocus="style_toggle(this,'textbox_red')" onblur="style_toggle(this,'textbox')"></td>
	</tr>
	<tr>
		<th width="120">과목</th>
		<td>
			<select name="gwamok" size="1" id="gwamok" class="selectinput">
				<?php
				if($code_no) {
					selectDBValues('code','parent_no','254','no','name',$gwamok);
				} else {
					selectDBValues('code','parent_no','254','no','name','');
				}
				?>
			</select>
		</td>
	</tr>
	<tr>
		<th width="120">전화번호</th>
		<td><input type="text" id="tel" name="tel" value="<?=$tel?>" class="textbox" style="width:50%;font-weight:bold;" style='IME-MODE:active' onfocus="style_toggle(this,'textbox_red')" onblur="style_toggle(this,'textbox')"></td>
	</tr>
	<tr>
		<th width="120">로그인ID</th>
		<td><input type="text" id="loginid" name="loginid" value="<?=$loginid?>" class="textbox" style="width:50%;font-weight:bold;" style='IME-MODE:active' onfocus="style_toggle(this,'textbox_red')" onblur="style_toggle(this,'textbox')"></td>
	</tr>
	<tr>
		<th width="120">비빌번호</th>
		<td><input type="text" id="password" name="password" value="<?=$password?>" class="textbox" style="width:50%;font-weight:bold;" style='IME-MODE:active' onfocus="style_toggle(this,'textbox_red')" onblur="style_toggle(this,'textbox')"></td>
	</tr>

</table>
<br>

<table border="0" cellpadding="3" cellspacing="0" width="100%">
<tr align="center">
	<td><input type="button" name="btn_save" value=" &nbsp; S A V E &nbsp; " onclick="do_save()" onmouseover="style_toggle(this,'button_orange')" onmouseout="style_toggle(this,'button_purple')" class="button_purple"> <!-- 저장하기 -->
		&nbsp;
		<?
			if($code_no){
		?>
		<input type="button" name="btn_save" value=" &nbsp; D E L E T E &nbsp; " onclick="do_delete()" onmouseover="style_toggle(this,'button_orange')" onmouseout="style_toggle(this,'button_purple')" class="button_purple"> <!-- 삭제하기 -->
			&nbsp;
			<?
				}
			?>
		<input type="button" name="btn_cancel" value=" C A N C E L " onclick="self.close()" onmouseover="style_toggle(this,'button_orange')" onmouseout="style_toggle(this,'button_purple')" class="button_purple"> <!-- 취소하기 -->
	</td>
</tr>
</table>

</form>

</body>
</html>
