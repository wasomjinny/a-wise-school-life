<?
include_once($_SERVER['DOCUMENT_ROOT'].'/school/inc/session/session_check.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/paging.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');

$page = isset($_POST['page']) ? $_POST['page'] : $_GET['page'];
$page = ($page) ? $page : 1;

$list_scale = isset($_POST['list_scale']) ? $_POST['list_scale'] : $_GET['list_scale'];

if(!$list_scale) $list_scale = 100;
$page_scale = 10;

$orderby = isset($_POST['orderby']) ? $_POST['orderby'] : $_GET['orderby'];

$search_word = isset($_POST['search_word']) ? $_POST['search_word'] : $_GET['search_word'];

?>
<link rel="stylesheet" src="/school/api/jquery/jquery-ui-1.8.7.custom/development-bundle/themes/ui-lightness/jquery-ui-1.8.7.custom.css" type="text/css">
<!--script type="text/javascript" src="/api/jquery/jquery-1.6.min.js"></script-->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/school/api/jquery/jquery-ui-1.8.7.custom/development-bundle/ui/jquery-ui-1.8.7.custom.js"></script>
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
	win_open("student_edit.php?todo="+todo+"&code_no="+code_no,"materialedit",600,480);
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

<table border="0" cellpadding="0" cellspacing="0" width="90%">
	<tr>
		<td><span class="header">학생 목록</span></td> <!-- 결과 -->
		<td>
			<input type="text" name="search_word" value="<?=$search_word?>" placeholder="이름 또는 No를 입력하세요.">
			&nbsp; &nbsp;

			<input type="button" value="검색" onclick="do_search()" class="button_purple" onmouseover="style_toggle(this,'button_orange')" onmouseout="style_toggle(this,'button_purple')">
			&nbsp; &nbsp;
			<input type="button" value="등록하기" onclick="do_edit('insert','')" class="button_red" onmouseover="style_toggle(this,'button_orange')" onmouseout="style_toggle(this,'button_red')"> <!-- 등록하기 -->
		</td>
		<td align="right">
			출력갯수 <!-- 출력갯수 -->
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

$sql_select = "	select a.* ";

$sql_from = " from student a ";

$search_word = strtoupper($search_word);

$sql_where = " where 1=1 ";

if($search_word) {
	$sql_where .= " and (concat(a.no) like '%$search_word%' or UPPER(a.name) like '%$search_word%')	";
}

$sql_orderby = $orderby ? 'order by '.$orderby : 'order by a.name ';

$sql = 'select count(*) as count '.$sql_from.$sql_where;

$result=mysqli_query($conn,$sql);

$row = mysqli_fetch_array($result);


$total = $row['count'];

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
	<th><input type="checkbox" name="check_all" value="1" onclick="toggle_checkbox(this.form['code_no[]'])"></th>
	<th>수정</th> <!-- 기능 -->
	<th>No <a href="javascript:do_sort('a.no')">▲</a></th>
	<th>이름 <a href="javascript:do_sort('a.name')">▲</a></th>
	<th>학년 <a href="javascript:do_sort('a.grade')">▲</a></th>
	<th>반 <a href="javascript:do_sort('a.ban')">▲</a></th>
	<th>번호 <a href="javascript:do_sort('a.std_no')">▲</a></th>
	<th>전화번호</th>
	<th>로그인ID</th>
	<th>패스워드</th>
</tr>
<?
if($result) {
	while($r=mysqli_fetch_array($result)) {
		$code_no = $r['no'];
		$name = db2html($r['name']);
		$grade = $r['grade'];
		$ban = $r['ban'];
		$std_no = $r['std_no'];
		$tel = $r['tel'];
		$loginid = $r['loginid'];
		$password = $r['password'];
		?>
		<tr bgcolor="#ffffff" onmouseover="tr_over(this)" onmouseout="tr_out(this)" onclick="$(this).toggleClass('select_row');">
			<td><input type="checkbox" name="code_no[]" value="<?=$code_no?>"></td>
			<td align="center"><a href="javascript:do_edit('update',<?=$code_no?>)">수정</a></td> <!-- 수정 -->
			<td align="center"><?=$code_no?></td>
			<td align="center"><?=$name?></td>
			<td align="center"><?=$grade?></td>
			<td align="center"><?=$ban?></td>
			<td align="center"><?=$std_no?></td>
			<td align="center"><?=$tel?></td>
			<td align="center"><?=$loginid?></td>
			<td align="center"><?=$password?></td>
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
