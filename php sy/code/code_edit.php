<?
include_once($_SERVER['DOCUMENT_ROOT'].'/school/inc/session/session_check.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');

$todo = isset($_POST['todo']) ? $_POST['todo'] : $_GET['todo'];
$parent_no = isset($_POST['parent_no']) ? $_POST['parent_no'] : $_GET['parent_no'];
$code_no = isset($_POST['code_no']) ? $_POST['code_no'] : $_GET['code_no'];

$msg = '';
$err = '';


if($todo == 'insert_commit' || $todo == 'update_commit') {

	$name = trim($_POST['name']);
	$name = stripslashes($name);
	$name = str_replace('"','&quot;',$name);
	$name = str_replace("'",'&#039;',$name);
	$name = str_replace('<','&lt;',$name);
	$name = str_replace('>','&gt;',$name);

	$sort = intval($_POST['sort']);
	$description = $_POST['description'];

	if($code_no == '') {

		$sql.= "insert into code (parent_no, name, sort, description) ";
		$sql.= "values ($parent_no, '$name', $sort, '$description'); ";

		$msg = '등록되었습니다.';

		$history_flag = 'code_insert';
	}
	else {

		$history_flag = 'code_update';
		$sql.= "update code set ";
		$sql.= "  name = '$name', ";
		$sql.= "  sort =  $sort, ";
		$sql.= "  description =  '$description' ";
		$sql.= " where ";
		$sql.= "  no = $code_no; ";

		$msg = '수정되었습니다.';

	}

	mysqli_query($conn, $sql);

}


if($todo == 'insert_commit' || $todo == 'update_commit') {

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
	f.parent_no.value = "<?=$parent_no?>";
	f.submit();
}

function icon_show() {
	var f = document.form_edit;
	f.todo.value = "";
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
<input type="hidden" name="parent_no" value="<?=$parent_no?>">
<input type="hidden" name="code_no" value="<?=$code_no?>">

<?
if($code_no) {
	$sql = 'select * from code where no = '.$code_no;
	$result=mysqli_query($conn,$sql);
	$row = mysqli_fetch_array($result);
	$name = $row['name'];
	$sort = $row['sort'];
	$description = $row['description'];
}
?>

<table class="form" width="100%">
<tr>
	<th width="120">정렬 번호</th>
	<td><input type="text" name="sort" value="<?=$sort?>" size="3" maxlength="3" class="textbox_center" onfocus="style_toggle(this,'textbox_center_red')" onblur="style_toggle(this,'textbox_center')"></td>
</tr>

<tr>
	<th width="120">코드이름 <font color="red">*</font></th>
	<td><input type="text" id="korea" name="name" value="<?=db2textarea($name)?>" class="textbox" style="width:80%;font-weight:bold;" style='IME-MODE:active' onfocus="style_toggle(this,'textbox_red')" onblur="style_toggle(this,'textbox')"></td>
</tr>
<tr>
	<th width="120">설명</th>
	<td><textarea name="description" style="width:100%;" style='IME-MODE:active' rows="3" id="description"><?=$description?></textarea></td>
</tr>
</table>
<br>

<table border="0" cellpadding="3" cellspacing="0" width="100%">
<tr align="center">
	<td><input type="button" name="btn_save" value=" &nbsp; S A V E &nbsp; " onclick="do_save()" onmouseover="style_toggle(this,'button_orange')" onmouseout="style_toggle(this,'button_purple')" class="button_purple"> <!-- 저장하기 -->
		&nbsp;
		<input type="button" name="btn_cancel" value=" C A N C E L " onclick="self.close()" onmouseover="style_toggle(this,'button_orange')" onmouseout="style_toggle(this,'button_purple')" class="button_purple"> <!-- 취소하기 -->
	</td>
</tr>
</table>

</form>

</body>
</html>
