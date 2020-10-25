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

	$name = $_POST['name'];
	$bus_no = intval($_POST['bus_no']);
	$gubun = intval($_POST['gubun']);
	$freq_no = intval($_POST['freq_no']);
	$starttime = $_POST['starttime'];
	$isuse = intval($_POST['isuse']);
	if($code_no == '') {

		$sql.= "insert into busschedule (name,bus_no,gubun,freq_no,starttime,isuse) ";
		$sql.= "values ('$name',$bus_no,$gubun,$freq_no,'$starttime',$isuse); ";

		$msg = '등록되었습니다.';

		$history_flag = 'code_insert';
	}
	else {

		$history_flag = 'code_update';
		$sql.= "update busschedule set ";
		$sql.= "  name='$name', bus_no = $bus_no, gubun = $gubun, freq_no = $freq_no, starttime='$starttime', isuse=$isuse ";
		$sql.= " where no = $code_no; ";

		$msg = '수정되었습니다.';

	}

	mysqli_query($conn, $sql);

}
else if($todo == 'delete_commit') {

		$history_flag = 'code_delete';
		$sql = "delete from busschedule where no = $code_no; ";

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
	$sql = 'select * from busschedule where no = '.$code_no;
	$result=mysqli_query($conn,$sql);
	$row = mysqli_fetch_array($result);
	$name = $row['name'];
	$bus_no = $row['bus_no'];
	$gubun = $row['gubun'];
	$freq_no = $row['$freq_no'];
	$starttime = $row['starttime'];
	$isuse = $row['isuse'];
}
?>

<table class="form" width="100%">

	<tr>
		<th width="120">경로명</th>
		<td><input type="text" id="name" name="name" value="<?=$name?>" class="textbox" style="width:50%;font-weight:bold;" style='IME-MODE:active' onfocus="style_toggle(this,'textbox_red')" onblur="style_toggle(this,'textbox')"></td>
	</tr>
	<tr>
		<th width="120">버스명</th>
		<td>
			<select name="bus_no" size="1" id="bus_no" class="selectinput">
				<?php
				if($code_no) {
					selectDBValues('code','parent_no','276','no','name',$bus_no);
				} else {
					selectDBValues('code','parent_no','276','no','name','');
				}
				?>
			</select>
		</td>
	</tr>
	<tr>
		<th width="120">구분</th>
		<td><label><input type="radio" name="gubun" value="0" <?if($gubun==0) echo 'checked'?>>등교</label>&nbsp;&nbsp;
		<input type="radio" name="gubun" value="1" <?if($gubun==1) echo 'checked'?>>하교</label></td>
	</tr>
	<tr>
	<th width="120">차수</th>
	<td>
		<select name="freq_no" size="1" id="freq_no" class="selectinput">
			<?php
			if($code_no) {
				selectValues(3, '차', $freq_no);
			} else {
				selectValues(3, '차', '');
			}
			?>
		</select>
	</td>
  </tr>
	<tr>
		<th width="120">출발시간</th>
		<td><input type="time" id="starttime" name="starttime" value="<?=$starttime?>" class="textbox" style="width:50%;font-weight:bold;" style='IME-MODE:active' onfocus="style_toggle(this,'textbox_red')" onblur="style_toggle(this,'textbox')"></td>
	</tr>
	<tr>
		<th width="120">운행여부</th>
		<td><label><input type="checkbox" name="isuse" value="1" <?if($isuse==1) echo 'checked'?>> 운행중일 경우는 체크하세요.</label></td>
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
