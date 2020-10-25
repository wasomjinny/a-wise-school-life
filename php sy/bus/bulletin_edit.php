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


	$title = $_POST['title'];
	$content = $_POST['content'];
	$reg_date = $_POST['reg_date'];

	if($code_no == '') {
		$sql.= "insert into bulletin (title,content,reg_date) ";
		$sql.= "values ('$title','$content','$reg_date'); ";

		$msg = '등록되었습니다.';

		$history_flag = 'code_insert';
	}
	else {

		$history_flag = 'code_update';
		$sql.= "update bulletin set ";
		$sql.= "  title = '$title', content='$content', reg_date='$reg_date' ";
		$sql.= " where no = $code_no; ";

		$msg = '수정되었습니다.';
	}

	mysqli_query($conn, $sql);

}
else if($todo == 'delete_commit') {
	//----------------
	// 코드 삭제하기
	//----------------

		$history_flag = 'code_delete';
		$sql = "delete from bulletin where no = $code_no; ";

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
	$sql = 'select * from bulletin where no = '.$code_no;
	$result=mysqli_query($conn,$sql);
	$row = mysqli_fetch_array($result);
	$title = $row['title'];
	$content = $row['content'];
	$reg_date = $row['reg_date'];
}
?>

<table class="form" width="100%">

	<tr>
		<th width="120">제목</th>
		<td><input type="text" id="title" name="title" value="<?=$title?>" class="textbox" style="width:100%;font-weight:bold;" style='IME-MODE:active' onfocus="style_toggle(this,'textbox_red')" onblur="style_toggle(this,'textbox')"></td>
	</tr>
	<tr>
		<th width="120">내용</th>
		<td><textarea name="content" style="width:100%;" style='IME-MODE:active' rows="5" id="content"><?=$content?></textarea></td>
	</tr>
	<tr>
		<th width="120">등록일</th>
		<td><input type="date" id="reg_date" name="reg_date" value="<?=$reg_date?>" class="textbox" style="width:50%;font-weight:bold;" style='IME-MODE:active' onfocus="style_toggle(this,'textbox_red')" onblur="style_toggle(this,'textbox')"></td>
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
