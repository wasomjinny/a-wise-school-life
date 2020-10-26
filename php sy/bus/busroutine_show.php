<?
include_once($_SERVER['DOCUMENT_ROOT'].'/school/inc/session/session_check.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/paging.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');

$HTML_FULL_WIDTH = 1200;
$bs_no = isset($_POST["bs_no"]) ? $_POST["bs_no"] : $_GET["bs_no"];
$code_no = isset($_POST["code_no"]) ? $_POST["code_no"] : $_GET["code_no"];
$seq = isset($_POST["seq"]) ? $_POST["seq"] : $_GET["seq"];
$seq = intval($seq);
$kind = isset($_POST["kind"]) ? $_POST["kind"] : $_GET["kind"];

$reg_time = date('H:i');
if($kind == "1" || $kind == "2") {
	$sql = "select * from busroutine where bs_no = $bs_no order by seq";
	$result=mysqli_query($conn,$sql);
	$b_arr = date('H:i');
	$time_diff = 0;
	$time_sum = 0;
	while($r=mysqli_fetch_array($result)) {
		$no = $r["no"];
		$p_arr = $r["p_arrivaltime"];
		$iter_seq = $r["seq"];
		if($iter_seq == 1) {
			$b_arr = $p_arr;
		} else {
			$time_diff = (int)((strtotime($p_arr) - strtotime($b_arr))/60);
			$b_arr = $p_arr;
		}
		if($iter_seq < $seq){
			$sql_update = "update busroutine set is_on=3 where no = $no";
		} else if($iter_seq > $seq) {
			$time_sum += $time_diff;
			$e_arr = date("H:i", strtotime("+$time_sum minutes"));
			$sql_update = "update busroutine set is_on=0, e_arrivaltime = '$e_arr', remain_time=$time_sum where no = $no";
		} else {
			$time_sum =0;
			if($kind == "1"){
				$sql_update = "update busroutine set is_on=1, e_arrivaltime='$reg_time' where no = $no";
			} else {
				$sql_update = "update busroutine set is_on=2, e_arrivaltime='$reg_time' where no = $no";
			}
		}
		mysqli_query($conn, $sql_update);
	}
} else if($kind == "3") {
	$sql = "update busroutine set is_on = 0, e_arrivaltime=null, remain_time=0 where bs_no = $bs_no";
	mysqli_query($conn, $sql);
}

?>

<script type="text/javascript" src="https://code.jquery.com/jquery-1.8.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="/school/common/style.css">
<script type="text/javascript" src="/school/common/javascript.js"></script>
<script language="JavaScript">
	function win_close() {
		opener.location.reload();
		window.close();
	}

	function do_edit(todo,bs_no,code_no) {
		window.open("busroutine_detail_edit.php?todo="+todo+"&bs_no="+bs_no+"&code_no="+code_no, "busroutineedit", "toolbar=no,menubar=no,status=yes,scrollbars=yes,resizable=yes,width=600,height=480,left=300,top=100");
	}

	function update_arrival(bs_no,code_no,seq,kind) {
		location.href = "busroutine_show.php?bs_no="+bs_no+"&code_no="+code_no+"&seq="+seq+"&kind="+kind;
	}

	function initial(bs_no) {
		location.href = "busroutine_show.php?bs_no="+bs_no+"&kind=3";
	}
</script>
</HEAD>

<body>
	<?

	$sql = "SELECT a.*, b.name as bus_name  FROM busschedule a
	       left outer join code b on b.no = a.bus_no WHERE a.no=$bs_no";

	$result=mysqli_query($conn,$sql);
	$r=mysqli_fetch_array($result);
	$name = $r['name'];
	$bus_name = $r['bus_name'];
	$gubun_name = ($r['gubun']==0) ? '등교':'하교';
	$freq_no = $r['freq_no'];
	$starttime = $r['starttime'];
	$isuse_name = ($r['isuse']==0) ? '운영안함':'운영함';

	mysqli_free_result($result);

	?>


<div style="border-bottom:1px solid #ccc;padding-top:5px;margin:5px 0 10px 0;width:100%;">
<table border="0" cellpadding="2" cellspacing="1" width="100%">
<tr>
	<td><?=$name?>&nbsp;&nbsp;</td>
	<td align="right"><a href="javascript:initial(<?=$bs_no?>)">초기화</a>
		&nbsp;&nbsp;&nbsp;<a href="javascript:do_edit('insert',<?=$bs_no?>,'')">경로추가하기</a>
		&nbsp;&nbsp;&nbsp;<a href="javascript:window.close();">닫기</a>
	</td>
</tr>
</table>
</div>

<?
$sql_select = "	select a.*, b.name as bus_stop_name ";

$sql_from = " from busroutine a
							left outer join code b on b.no = a.bus_stop ";

$search_word = strtoupper($search_word);

$sql_where = " where bs_no=$bs_no ";

$sql_orderby = $orderby ? 'order by '.$orderby : 'order by a.seq ';

$sql =          $sql_select;
$sql.=          $sql_from;
$sql.=          $sql_where;
$sql.=          $sql_orderby;
$result=mysqli_query($conn,$sql);

?>

<table class="listnp mt5">
<tr>
	<th>수정</th> <!-- 기능 -->
	<th>No</th>
	<th>순서</th> <!-- 한국어 -->
	<th>정류정</th> <!-- 한국어 -->
	<th>예정도착시간</th>
	<th>실제도착시간</th>
	<th>도착여부</th>
	<th>설정</th>
	<th>설정</th>
</tr>
<?
if($result) {
	while($r=mysqli_fetch_array($result)) {
		$code_no = $r['no'];
		$seq = $r['seq'];
		$bus_stop_name = $r['bus_stop_name'];
		$p_arrivaltime = $r['p_arrivaltime'];
		$e_arrivaltime = $r['e_arrivaltime'];
		$is_on = $r['is_on'];
		switch ($is_on) {
			case 1:
				$is_on_txt = "도착";
				break;
			case 2:
				$is_on_txt = "출발";
				break;
			case 3:
				$is_on_txt = "지나감";
				break;
			default:
				$is_on_txt = "";
				break;
		}
?>
		<tr bgcolor="#ffffff" onmouseover="tr_over(this)" onmouseout="tr_out(this)" onclick="$(this).toggleClass('select_row');">
			<td align="center"><a href="javascript:do_edit('update',<?=$bs_no?>,<?=$code_no?>)">수정</a></td> <!-- 수정 -->
			<td align="center"><?=$code_no?></td>
			<td align="center"><?=$seq?></td>
			<td align="center"><?=$bus_stop_name?></td>
			<td align="center"><?=$p_arrivaltime?></td>
			<td align="center"><?=$e_arrivaltime?></td>
			<td align="center"><?=$is_on_txt?></td>
			<td align="center"><a href="javascript:update_arrival(<?=$bs_no?>,<?=$code_no?>,<?=$seq?>,'1')">도착</a></td>
			<td align="center"><a href="javascript:update_arrival(<?=$bs_no?>,<?=$code_no?>,<?=$seq?>,'2')">출발</a></td>
		</tr>
		<?
	}
}
?>
</table>
<br>

</BODY>
</HTML>
