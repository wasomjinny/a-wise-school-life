<?
include_once($_SERVER['DOCUMENT_ROOT'].'/school/inc/session/session_check.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/paging.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');

$parent_no = isset($_POST['parent_no']) ? $_POST['parent_no'] : $_GET['parent_no'];
$parent_no = $parent_no ? $parent_no : 0;

$page = isset($_POST['page']) ? $_POST['page'] : $_GET['page'];
$page = ($page) ? $page : 1;

$list_scale = isset($_POST['list_scale']) ? $_POST['list_scale'] : $_GET['list_scale'];

if(!$list_scale) $list_scale = 100;
$page_scale = 10;

$orderby = isset($_POST['orderby']) ? $_POST['orderby'] : $_GET['orderby'];

$search_word_select = isset($_POST['search_word_select']) ? $_POST['search_word_select'] : $_GET['search_word_select'];

$search_word = isset($_POST['search_word']) ? $_POST['search_word'] : $_GET['search_word'];

?>

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


function do_edit(todo,parent_no,code_no) {
	win_open("code_edit.php?todo="+todo+"&parent_no="+parent_no+"&code_no="+code_no,"codeedit",600,480);
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
<input type="hidden" name="parent_no" value="<?=$parent_no?>">
<input type="hidden" name="orderby" value="<?=$orderby?>" />
<input type="hidden" name="code_list" value="">
<span class="header">코드관리</span> &nbsp; &nbsp; <!-- 코드 관리 -->
<img src="/school/img/folder_up.gif" border="0">&nbsp;
<?


$parent_no_up = $parent_no;

if($parent_no_up == 0) {
	echo 'Home';
}
else {
	?>
	<a href="<?=$self?>?parent_no=0">Home</a> &gt;
	<?
	while($parent_no_up > 0) {
		$sql = "
			select no, parent_no, name
			from code
			where no = $parent_no_up
			order by no
			";

		$result=mysqli_query($conn,$sql);
		$row = mysqli_fetch_array($result);

		$current_no = $row['no'];
		$parent_no_up = $row['parent_no'];
		$parent_name = $row['name'];

		$str = '<a href="'.$self.'?parent_no='.$current_no.'">'.$parent_name.'</a> &gt; '.$str;
	}
	echo str_replace(' &gt; ^','',$str.'^');
}
?>
&nbsp; &nbsp;
<input type="button" value="등록하기" onclick="do_edit('insert',<?=$parent_no?>,'')" class="button_purple" onmouseover="style_toggle(this,'button_orange')" onmouseout="style_toggle(this,'button_purple')"> <!-- 등록하기 -->
&nbsp; &nbsp;
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
&nbsp; &nbsp; &nbsp;
<select name="search_word_select"> <!--  onchange="list_scale_on_change(this)" -->
<option value="search_all" <?if($search_word_select == 'search_all') echo 'selected';?>>코드번호+코드이름</option> <!-- 전체  -->
<option value="search_no" <?if($search_word_select == 'search_no') echo 'selected';?>>코드번호</option>
<option value="search_name" <?if($search_word_select == 'search_name') echo 'selected';?>>코드이름</option>
</select>
<input type="text" name="search_word" value="<?=$search_word?>">
<input type="button" value="검색" onclick="do_search()" class="button_purple" onmouseover="style_toggle(this,'button_orange')" onmouseout="style_toggle(this,'button_purple')">

<?

//---------------------
// 코드 목록 불러오기
//---------------------
$sql_select = "	select a.*, (select count(*) from code where parent_no=a.no) as son_cnt ";

$sql_from = " from code a ";
$search_word = strtoupper($search_word);

//---------------------------------------------------------------
// 코드번호 검색
//---------------------------------------------------------------
if($search_word_select == 'search_no' && $search_word){
	$sql_where = " where (concat(a.no) like '%$search_word%' ) ";
}
//---------------------------------------------------------------
// 코드이름 검색
//---------------------------------------------------------------
elseif($search_word_select == 'search_name' && $search_word){
	$sql_where = " where (UPPER(a.name) like '%$search_word%')	";
}
//---------------------------------------------------------------
// 코드번호+이름 검색
//---------------------------------------------------------------
elseif($search_word_select == 'search_all' && $search_word) {
	$sql_where = " where (concat(a.no) like '%$search_word%' or UPPER(a.name) like '%$search_word%')	";
}
else {
	$sql_where = " where a.parent_no= $parent_no ";
}


$sql_orderby = $orderby ? 'order by '.$orderby : 'order by a.sort ';

$sql = 'select count(*) as count '.$sql_from.$sql_where;

$result=mysqli_query($conn,$sql);
$row = mysqli_fetch_array($result);


//if($_SESSION['USER_ID'] == 'k9024246') echo '<pre>sql : '.$sql_select.$sql_from.$sql_where.'</pre>';


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
	<th>정렬 <a href="javascript:do_sort('a.sort')">▲</a></th> <!-- 정렬 -->
	<th>이름 <a href="javascript:do_sort('a.name')">▲</a></th> <!-- 한국어 -->
	<th>부모코드 </th> <!-- 영어 -->
	<th>설명</th>
</tr>
<?
if($result) {
	while($r=mysqli_fetch_array($result)) {
		$code_no = $r['no'];
		$current_parent_no = $r['parent_no'];
		$name = db2html($r['name']);
		$sort = $r['sort'];
		$son_cnt = $r['son_cnt'];
		$description = $r['description'];
		?>
		<tr bgcolor="#ffffff" onmouseover="tr_over(this)" onmouseout="tr_out(this)" onclick="$(this).toggleClass('select_row');">
		<td><input type="checkbox" name="code_no[]" value="<?=$code_no?>"></td>
		<td align="center"><a href="javascript:do_edit('update',<?=$current_parent_no?>,<?=$code_no?>)">수정</a></td> <!-- 수정 -->
		<td align="center"><?=$code_no?></td><!--일련번호-->
		<td align="center"><?=$sort?></td><!--정렬번호-->
		<td>
			<?
			if($step) {
				?>
				<?=$step?> <?=$name?> (<?=$son_cnt?>)
				<?
			}
			else {
				?>
				<a href="code_list.php?parent_no=<?=$code_no?>"><?=$name?></a> (<?=$son_cnt?>)<!--한국어-->
				<?
			}
		?>
		</td>
		<td align="center"><?=$current_parent_no?></td>
		<td align="center"><?=$description?></td>

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
