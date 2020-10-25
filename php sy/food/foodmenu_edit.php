<?
include_once($_SERVER['DOCUMENT_ROOT'].'/school/inc/session/session_check.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');

$todo = isset($_POST['todo']) ? $_POST['todo'] : $_GET['todo'];
$code_no = isset($_POST['code_no']) ? $_POST['code_no'] : $_GET['code_no'];
$menudate = isset($_POST['menudate']) ? $_POST['menudate'] : $_GET['menudate'];

$msg = '';
$err = '';

if($todo == 'insert_commit' || $todo == 'update_commit') {
	//----------------------
	// 코드 등록, 수정하기
	//----------------------
	//echo '<pre>'.print_r($_POST,true).'</pre>';exit;

	$menudate = $_POST['menudate'];
	$lunchdinner = intval($_POST['lunchdinner']);
	$food_no = intval($_POST['food_no']);
	$sort = intval($_POST['sort']);
	if($code_no == '') {

		$sql.= "insert into foodmenu (menudate,lunchdinner,food_no,sort) ";
		$sql.= "values ('$menudate',$lunchdinner,$food_no,$sort); ";

		$msg = '등록되었습니다.';

		$history_flag = 'code_insert';
	}
	else {

		$history_flag = 'code_update';
		$sql.= "update foodmenu set ";
		$sql.= "  menudate='$menudate', lunchdinner = $lunchdinner, food_no = $food_no, sort = $sort ";
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
		$sql = "delete from foodmenu where no = $code_no; ";

		$msg = '삭제되었습니다.';
		mysqli_query($conn, $sql);

}


if($todo == 'insert_commit' || $todo == 'update_commit' || $todo == 'delete_commit') {
	//---------------------------
	// 코드 리소스 파일 만들기
	//---------------------------
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
	$sql = 'select * from foodmenu where no = '.$code_no;
	$result=mysqli_query($conn,$sql);
	$row = mysqli_fetch_array($result);
	$menudate = $row['menudate'];
	$lunchdinner = $row['lunchdinner'];
	$food_no = $row['food_no'];
	$sort = $row['sort'];
}
?>

<table class="form" width="100%">

	<tr>
		<th width="120">일자</th>
		<td><input type="date" id="menudate" name="menudate" value="<?=$menudate?>" class="textbox" style="width:50%;font-weight:bold;" style='IME-MODE:active' onfocus="style_toggle(this,'textbox_red')" onblur="style_toggle(this,'textbox')"></td>
	</tr>
	<tr>
		<th width="120">점심/저녁</th>
		<td><label><input type="radio" name="lunchdinner" value="0" <?if($lunchdinner==0) echo 'checked'?>>점심</label>&nbsp;&nbsp;
		<input type="radio" name="lunchdinner" value="1" <?if($lunchdinner==1) echo 'checked'?>>저녁</label></td>
	</tr>
	<tr>
		<th width="120">메뉴명</th>
		<td>
			<select name="food_no" size="1" id="food_no" class="selectinput">
				<?php
				if($code_no) {
					selectDBValuesName('food','1','1','no','name',$food_no);
				} else {
					selectDBValuesName('food','1','1','no','name','');
				}
				?>
			</select>
		</td>
	</tr>
	<tr>
		<th width="120">정렬</th>
		<td><input type="number" id="sort" name="sort" value="<?=$sort?>" class="textbox" style="width:50%;font-weight:bold;" style='IME-MODE:active' onfocus="style_toggle(this,'textbox_red')" onblur="style_toggle(this,'textbox')"></td>
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
