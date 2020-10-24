<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.0 Transitional//EN">
<html>
<head>
<title>메뉴</title>
<meta name="Robots" content="noindex">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link rel="stylesheet" src="/fuk/api/jquery/jquery-ui-1.8.7.custom/development-bundle/themes/ui-lightness/jquery-ui-1.8.7.custom.css" type="text/css">
<!--script type="text/javascript" src="/api/jquery/jquery-1.6.min.js"></script-->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/school/api/jquery/jquery-ui-1.8.7.custom/development-bundle/ui/jquery-ui-1.8.7.custom.js"></script>
<link type="text/css" rel="stylesheet" href="/school/common/style.css">
<script type="text/javascript" src="/school/common/javascript.jsc"></script>

<iframe name=hiddenfrm id=hiddenfrm width=0 height=0></iframe>

<script language="JavaScript">
<!--
function go(url1,url2) {
//	top.frame_main.show_loading();
	top.frame_menu.location.href = url1;
	top.frame_main.location.href = url2;
}

function win_open(url) {
	window.open(url+"?flag=poi", "search", "width=1000, height=700, scrollbars=yes, resizable=yes");
}
//-->
</script>
</head>

<body class="left_frame">

<div class="left_frame_title">선택메뉴</div>
<br />
<div onclick="go('/school/menu/food_menu.php','/school/food/foodmenu_list.php')" class="left_menu_out" onmouseover="style_toggle(this,'left_menu_over')" onmouseout="style_toggle(this,'left_menu_out')">급식리뷰</div>
<div onclick="go('/school/menu/news_menu.php','/school/news/news_list.php')" class="left_menu_out"  onmouseover="style_toggle(this,'left_menu_over')" onmouseout="style_toggle(this,'left_menu_out')">버스시간표</div>
<div onclick="go('/school/menu/code_menu.php','/school/code/code_list.php')" class="left_menu_out" onmouseover="style_toggle(this,'left_menu_over')" onmouseout="style_toggle(this,'left_menu_out')">코드관리</div>
</body>
</html>
