<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.0 Transitional//EN">
<html>
	<head>
<title>메뉴</title>
<meta name="Robots" content="noindex">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.8.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="/school/common/style.css">
<script type="text/javascript" src="/school/common/javascript.jsc"></script>

<iframe name=hiddenfrm id=hiddenfrm width=0 height=0></iframe>

<script language="JavaScript">
<!--
function go(url) {
//	top.frame_main.show_loading();
	top.frame_main.location.href = url;
}

function ChangeSelect(sel) {
	var trigger = sel.options[sel.selectedIndex].value;
	var selArray = trigger.split("-");
	top.frame_menu.location.href =selArray[0];
	top.frame_main.location.href =selArray[1];
}

function win_open(url) {
	window.open(url+"?flag=poi", "search", "width=1000, height=700, scrollbars=yes, resizable=yes");
}
//-->
</script>
</head>

<body class="left_frame">
<form>
<div class="left_frame_menu">
	<select name="menu" size="1" id="menu" class="selectinput" onchange="ChangeSelect(this);">
		<option value="/school/menu/food_menu.php-/school/food/foodmenu_list.php">급식리뷰</option>
		<option value="/school/menu/bus_menu.php-/school/bus/busroutine_list.php">버스시간표</option>
		<option value="/school/menu/code_menu.php-/school/code/code_list.php" selected>코드관리</option>
	</select>
</div>
</form>
<br />
<div onclick="go('/school/code/code_list.php')" class="left_menu_out" onmouseover="style_toggle(this,'left_menu_over')" onmouseout="style_toggle(this,'left_menu_out')">코드목록</div> <!-- 등록하기 -->
<div onclick="go('/school/code/teacher_list.php')" class="left_menu_out" onmouseover="style_toggle(this,'left_menu_over')" onmouseout="style_toggle(this,'left_menu_out')">선생님목록</div> <!-- 등록하기 -->
<div onclick="go('/school/code/student_list.php')" class="left_menu_out" onmouseover="style_toggle(this,'left_menu_over')" onmouseout="style_toggle(this,'left_menu_out')">학생목록</div> <!-- 등록하기 -->
<div onclick="go('/school/logout.php')" class="left_menu_out" onmouseover="style_toggle(this,'left_menu_over')" onmouseout="style_toggle(this,'left_menu_out')">로그아웃</div> <!-- 등록하기 -->

</body>
</html>
