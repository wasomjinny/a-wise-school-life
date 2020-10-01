<?
include_once($_SERVER['DOCUMENT_ROOT'].'/school/inc/session/session_check.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/inc/connect.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/fuk_config.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');

$todo = isset($_POST['todo']) ? $_POST['todo'] : $_GET['todo'];
$bs_no = isset($_POST['bs_no']) ? $_POST['bs_no'] : $_GET['bs_no'];
$code_no = isset($_POST['code_no']) ? $_POST['code_no'] : $_GET['code_no'];

$msg = '';
$err = '';
function selectDBValues($tableName,$field,$code,$optionValue,$optionName,$selected){
	global $conn;
	$sql='select * from '.$tableName;
	if($field !=''){
			$sql .= ' where '.$field .'= '.$code;
			$sql .= ' order by sort';
	}
	$result1=mysqli_query($conn,$sql);

	while ($row1=mysqli_fetch_array($result1)) {

		if ($row1[$optionValue] == $selected) {
			$html = '<option value="'.$row1[$optionValue].'"  selected>'.$row1[$optionName].'</option>';
		} else {
			$html = '<option value="'.$row1[$optionValue].'"  >'.$row1[$optionName].'</option>';
		}

		echo $html;
	}
}

function selectValues($endno,$attachtext,$selected){
	$i = 1;
	while ($i<=$endno) {

		if ($i == $selected) {
			$html = '<option value="'.$i.'"  selected>'.$i.$attachtext.'</option>';
		} else {
			$html = '<option value="'.$i.'"  >'.$i.$attachtext.'</option>';
		}

		echo $html;
		$i++;
	}
}

if($todo == 'insert_commit' || $todo == 'update_commit') {
	//----------------------
	// 코드 등록, 수정하기
	//----------------------
	//echo '<pre>'.print_r($_POST,true).'</pre>';exit;

	$bs_no = $_POST['bs_no'];
	$seq = intval($_POST['seq']);
	$bus_stop = intval($_POST['bus_stop']);
	$p_arrivaltime = $_POST['p_arrivaltime'];
	if($code_no == '') {
		if($dup_code_count > 0) {
			$err = "처리 취소 : 코드명 중복";
		}
		else {

			$sql.= "insert into busroutine (bs_no,seq,bus_stop,p_arrivaltime) ";
			$sql.= "values ($bs_no,$seq,$bus_stop,'$p_arrivaltime'); ";

			$msg = '등록되었습니다.';

			$history_flag = 'code_insert';
		}
	}
	else {
		if($dup_code_count > 0) {
			$err = "처리 취소 : 코드명 중복";
		}
		else {
			$history_flag = 'code_update';
			$sql.= "update busroutine set ";
			$sql.= "  seq = $seq, bus_stop = $bus_stop, p_arrivaltime = '$p_arrivaltime' ";
			$sql.= " where no = $code_no; ";

			$msg = '수정되었습니다.';
		}
	}

	mysqli_query($conn, $sql);

	// history_log2($history_flag, $code_no, '');
}
else if($todo == 'delete_commit') {
	//----------------
	// 코드 삭제하기
	//----------------

		$history_flag = 'code_delete';
		$sql = "delete from busroutine where no = $code_no; ";

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
<link rel="stylesheet" src="/school/api/jquery/jquery-ui-1.8.7.custom/development-bundle/themes/ui-lightness/jquery-ui-1.8.7.custom.css" type="text/css">
<!--script type="text/javascript" src="/api/jquery/jquery-1.6.min.js"></script-->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/school/api/jquery/jquery-ui-1.8.7.custom/development-bundle/ui/jquery-ui-1.8.7.custom.js"></script>
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
<input type="hidden" name="bs_no" value="<?=$bs_no?>">

<?
if($code_no) {
	$sql = 'select * from busroutine where no = '.$code_no;
	$result=mysqli_query($conn,$sql);
	$row = mysqli_fetch_array($result);
	$seq = $row['seq'];
	$bus_stop = $row['bus_stop'];
	$p_arrivaltime = $row['p_arrivaltime'];
}
?>

<table class="form" width="100%">

	<tr>
		<th width="120">순서</th>
		<td><input type="number" id="seq" name="seq" value="<?=$seq?>" class="textbox" style="width:20%;font-weight:bold;" style='IME-MODE:active' onfocus="style_toggle(this,'textbox_red')" onblur="style_toggle(this,'textbox')"></td>
	</tr>
	<tr>
		<th width="120">정류소</th>
		<td>
			<select name="bus_stop" size="1" id="bus_stop" class="selectinput">
				<?php
				if($code_no) {
					selectDBValues('code','parent_no','277','no','name',$bus_stop);
				} else {
					selectDBValues('code','parent_no','277','no','name','');
				}
				?>
			</select>
		</td>
	</tr>
	<tr>
		<th width="120">예상도착시간</th>
		<td><input type="time" id="p_arrivaltime" name="p_arrivaltime" value="<?=$p_arrivaltime?>" class="textbox" style="width:50%;font-weight:bold;" style='IME-MODE:active' onfocus="style_toggle(this,'textbox_red')" onblur="style_toggle(this,'textbox')"></td>
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
