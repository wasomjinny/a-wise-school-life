<?
include_once($_SERVER['DOCUMENT_ROOT'].'/school/inc/session/session_check.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/paging.php'); //페이지 나누고 싶을 때 포함
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');


//7 ~ 15라인은 페이지를 나눌때 항상 포함
$page = isset($_POST['page']) ? $_POST['page'] : $_GET['page'];
$page = ($page) ? $page : 1;

$list_scale = isset($_POST['list_scale']) ? $_POST['list_scale'] : $_GET['list_scale'];

if(!$list_scale) $list_scale = 100;
$page_scale = 10;

$orderby = isset($_POST['orderby']) ? $_POST['orderby'] : $_GET['orderby'];  //정렬

$search_word = isset($_POST['search_word']) ? $_POST['search_word'] : $_GET['search_word'];  //검색어

?>
<head>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.8.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="/school/common/style.css">
<script type="text/javascript" src="/school/common/javascript.jsc"></script>
<script language="JavaScript">
<!--

function do_sort(orderby) {
	//show_loading();
	var f = document.form_edit;
	f.orderby.value = orderby;
	f.submit();
}

function do_edit(todo,code_no) {
	win_open("bulletin_edit.php?todo="+todo+"&code_no="+code_no,"bulletinedit",600,480);
}

function do_search() {
	//show_loading();
	var f = document.form_edit;
	//f.page.value = 1;
	f.submit();
}

//-->
</script>
</head>

<body>

<form name="form_edit" action="<?=$self?>" method="post">
<input type="hidden" name="todo" value="">
<input type="hidden" name="page" value="<?=$page?>" />
<input type="hidden" name="orderby" value="<?=$orderby?>" />
<input type="hidden" name="code_list" value="">

<table border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td><span class="header">공지사항 목록</span></td> <!-- 결과 -->
		<td>&nbsp; &nbsp;&nbsp; &nbsp;
			<input type="text" name="search_word" value="<?=$search_word?>" placeholder="이름 또는 No를 입력하세요.">
			&nbsp; &nbsp;
			<input type="button" value="검색" onclick="do_search()" class="button_purple" onmouseover="style_toggle(this,'button_orange')" onmouseout="style_toggle(this,'button_purple')">
			&nbsp; &nbsp;
			<input type="button" value="등록하기" onclick="do_edit('insert','')" class="button_red" onmouseover="style_toggle(this,'button_orange')" onmouseout="style_toggle(this,'button_red')"> <!-- 등록하기 -->
			&nbsp;&nbsp;페이지당 개수&nbsp;
			<select name="list_scale" onchange="list_scale_on_change(this)">
			<option value="10" <?if($list_scale == 10) echo 'selected';?>>10</option>
			<option value="20" <?if($list_scale == 20) echo 'selected';?>>20</option>
			<option value="30" <?if($list_scale == 30) echo 'selected';?>>30</option>
			<option value="50" <?if($list_scale == 50) echo 'selected';?>>50</option>
			<option value="100" <?if($list_scale == 100) echo 'selected';?>>100</option>
			<option value="200" <?if($list_scale == 200) echo 'selected';?>>200</option>
			<option value="500" <?if($list_scale == 500) echo 'selected';?>>500</option>
			<option value="1000" <?if($list_scale == 1000) echo 'selected';?>>1,000</option>
			<option value="10000" <?if($list_scale == 10000) echo 'selected';?>><?=$arr_lang['38']?></option> <!-- 전체 -->
			</select>
		</td>
	</tr>
</table>

<?

$sql_select = "	select * ";

$sql_from = " from bulletin ";

$search_word = strtoupper($search_word);  //대문자 변환

$sql_where = " where 1=1 ";

if($search_word) {  //검색어가 있을 경우
	$sql_where .= " and (concat(no) like '%$search_word%' or UPPER(title) like '%$search_word%'
									or UPPER(content) like '%$search_word%')	";
}

//where 1=1 and cancat(no) like '%배추%' and UPPER(name) like '%배추%'

$sql_orderby = $orderby ? 'order by '.$orderby : 'order by reg_date desc ';


//107 ~ 113까지는 검색된 레코드의 개수를 쿼리해 온다.
$sql = 'select count(*) as count '.$sql_from.$sql_where;

$result=mysqli_query($conn,$sql);

$row = mysqli_fetch_array($result);

$total = $row['count'];

//116 ~ 120, 126 페이지 기능
$page_total = (($total % $list_scale) == 0) ? (int)($total / $list_scale) : (int)($total / $list_scale) + 1;
$start_num  = ($page-1) * $list_scale;
if($page == 1) {
	$start_num = ($start_num == 0) ? 0 : $start_num;
}

$sql =          $sql_select;
$sql.=          $sql_from;
$sql.=          $sql_where;
$sql.=          $sql_orderby;
$sql.= ' LIMIT '.$start_num.','.$list_scale;
$result=mysqli_query($conn,$sql);

?>
<div class="mt5 line"></div>

<table border="0" cellpadding="0" cellspacing="0">
<tr>
	<td><span class="b">결과: <?=number_format($total)?></span></td> <!-- 결과 -->
	<td width="30">&nbsp;</td>
	<td><? paging($total, $list_scale, $page_scale, $page); ?></td>
</tr>
</table>

<table class="listnp mt5">
<tr>
	<th>수정</th> <!-- 기능 -->
	<th>No <a href="javascript:do_sort('no')">▲</a></th>
	<th>제목 <a href="javascript:do_sort('title')">▲</a></th>
	<th>내용 </th>
	<th>등록일 <a href="javascript:do_sort('reg_date')">▲</a> <a href="javascript:do_sort('reg_date desc')">▼</a></th>
</tr>

<?
if($result) {  //레코드가 있다면
	while($r=mysqli_fetch_array($result)) {
		$code_no = $r['no'];
		$title = $r['title'];
		$content = $r['content'];
		$reg_date = $r['reg_date'];
		?>
		<tr bgcolor="#ffffff" onmouseover="tr_over(this)" onmouseout="tr_out(this)" onclick="$(this).toggleClass('select_row');">
			<td align="center"><a href="javascript:do_edit('update',<?=$code_no?>)">수정</a></td> <!-- 수정 -->
			<td align="center"><?=$code_no?></td>
			<td align="center"><?=$title?></td>
			<td align="center"><?=$content?></td>
			<td align="center"><?=$reg_date?></td>
		</tr>
		<?
	}
}
?>
</table>
<br>


<table border="0" cellpadding="0" cellspacing="0">
<tr>

	<td width="50">&nbsp;</td>
	<td>페이지 이동</td> <!-- 페이지 이동 -->
	<td>&nbsp;</td>
	<td><? paging($total, $list_scale, $page_scale, $page); ?></td>
</tr>
</table>

</form>
<br>


</body>
</html>
