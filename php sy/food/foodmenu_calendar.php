<?
include_once($_SERVER['DOCUMENT_ROOT'].'/school/inc/session/session_check.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/paging.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');

// GET으로 넘겨 받은 year값이 있다면 넘겨 받은걸 year변수에 적용하고 없다면 현재 년도
	$year = isset($_GET['year']) ? $_GET['year'] : date('Y');
	// GET으로 넘겨 받은 month값이 있다면 넘겨 받은걸 month변수에 적용하고 없다면 현재 월
	$month = isset($_GET['month']) ? $_GET['month'] : date('m');
?>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>식단 켈렌더</title>

</head>
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

function do_edit(todo,code_no,menudate) {
	win_open("foodmenu_edit.php?todo="+todo+"&code_no="+code_no+"&menudate="+menudate,"materialedit",600,480);
}

function show_range(code_no) {
	window.open("test_show.php?code_no="+code_no, "showtest", "toolbar=no,menubar=no,status=yes,scrollbars=yes,resizable=yes,width=500,height=500,left=750,top=100");
}

function do_delete(parent_no) {
		var code_list = get_code_list();

		if(code_list) {
			win_open("test_edit.php?todo=delete_commit&parent_no="+parent_no+"&code_no="+code_list,"codeedit",600,480);
		}
}

function do_search() {
	//show_loading();
	var f = document.form_edit;
	//f.page.value = 1;
	f.submit();
}

//-->
</script>

<body>
<!--#include virtual="/intranet/intramenu/manage_menu.asp"-->
<table border="0" cellpadding="0" cellspacing="0" width="80%">
	<tr>
		<td align="center">
			<?php
				$date = "$year-$month-01"; // 현재 날짜
				$time = strtotime($date); // 현재 날짜의 타임스탬프
				$start_week = date('w', $time); // 1. 시작 요일
				$total_day = date('t', $time); // 2. 현재 달의 총 날짜
				$total_week = ceil(($total_day + $start_week) / 7);  // 3. 현재 달의 총 주차
			?>
			<!-- 현재가 1월이라 이전 달이 작년 12월인경우 -->
			<?php if ($month == 1): ?>
				<!-- 작년 12월 -->
				<a href="foodmenu_calendar.php?year=<?=$year-1?>&month=12">이전 달</a>
			<?php else: ?>
				<!-- 이번 년 이전 월 -->
				<a href="foodmenu_calendar.php?year=<?=$year?>&month=<?=$month-1?>">이전 달</a>
			<?php endif ?>
			<?php echo "&nbsp;&nbsp;&nbsp;" ?>
			<?php echo "$year 년 $month 월" ?>
			<?php echo "&nbsp;&nbsp;&nbsp;" ?>
			<!-- 현재가 12월이라 다음 달이 내년 1월인경우 -->
			<?php if ($month == 12): ?>
				<!-- 내년 1월 -->
				<a href="foodmenu_calendar.php?year=<?=$year+1?>&month=1">다음 달</a>
			<?php else: ?>
				<!-- 이번 년 다음 월 -->
				<a href="foodmenu_calendar.php?year=<?=$year?>&month=<?=$month+1?>">다음 달</a>
			<?php endif ?>
		</td>
	</tr>
</table>
<div class="mt5 line"></div>
<table border="1" cellpadding="0" cellspacing="0" width="100%">
	<tr>
		<th width="5%">일</th>
		<th width="18%">월</th>
		<th width="18%">화</th>
		<th width="18%">수</th>
		<th width="18%">목</th>
		<th width="18%">금</th>
		<th width="5%">토</th>
	</tr>

	<!-- 총 주차를 반복합니다. -->
	<?php for ($n = 1, $i = 0; $i < $total_week; $i++): ?>
		<tr>
			<!-- 1일부터 7일 (한 주) -->
			<?php for ($k = 0; $k < 7; $k++): ?>
				<td valign="top" style="margin-left:5px;margin-top:5px;">
					<!-- 시작 요일부터 마지막 날짜까지만 날짜를 보여주도록 -->
					<? if ( ($n > 1 || $k >= $start_week) && ($total_day >= $n) ) {
						$menudate = $year."-".$month."-".$n;
						?>
						<!-- 현재 날짜를 보여주고 1씩 더해줌 -->
						<font size=4><?=$n?></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:do_edit('insert','','<?=$menudate?>')">식단등록</a><br>
						<?
						$sql = "	select a.no,b.name as food_name from foodmenu a
											left outer join food b on b.no = a.food_no
											where a.menudate= '$menudate' and lunchdinner=0";
						$result=mysqli_query($conn,$sql);
						if($result){
							while($r=mysqli_fetch_array($result)) {
						?>
								&nbsp;&nbsp;<a href="javascript:do_edit('update','<?=$r['no']?>','<?=$menudate?>')"><?=$r['food_name']?></a><br>

						<?
							}
						}
						$n++;
					 }?>
				</td>
			<?php endfor; ?>
		</tr>
	<?php endfor; ?>
</table>
</body>
</html>
