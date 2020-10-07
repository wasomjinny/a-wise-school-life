<script type="text/javascript">
//<![CDATA[//location.href//]]>
</script>
<? //php 구문

require_once('common/school_config.php');

?>
<!DOCTYPE HTML PUBLIC "-//W3C//Dtd HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<title>슬기로운 학교생활 로그인
</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="common/style.css">
<script language="javascript" src="common/javascript.jsc"></script>

<script language="JavaScript">
<!--
if(top.location != self.location) top.location = self.location;

function do_login(f) {
	if(f.user_id.value == "") { f.user_id.focus(); return; }
	if(f.user_pw.value == "") { f.user_pw.focus(); return; }

	var user_id = f.user_id.value.substr(0,9);
	// if (user_id!='interpark')
	// {
	// 	if(f.site_pw.value == "") { f.site_pw.focus(); return false; }
	// }

}
//-->
</script>
</HEAD>

<BODY style="border:0">
<center>
<br><br><br><br><br><br>

<table border="0" cellpadding="2" cellspacing="5" width="500" bgcolor="#BBBBBB">
<tr bgcolor="#ffffff" align="center">
    <td>
    <br><br><br><h1>슬기로운 학교생활 관리자 로그인</h1>
    <br><br><br>
    <form name="form1" action="login_ok.php" method="post" onsubmit="return do_login(this)">
    <table border="0" cellpadding="3" cellspacing="0" align="center">

    <tr>
        <td align="right">Admin ID</td>
        <td><input type="text" name="member_id" size="24" class="textbox" ></td>
    </tr>
    <tr>
        <td align="right">Admin Password</td>
        <td><input type="password" name="password" size="24" class="textbox" ></td>
    </tr>
    <tr>
        <td>&nbsp;</td>
        <td><input type="submit" name="btn_submit" value="LOGIN" onmouseover="style_toggle(this,'button_orange')" onmouseout="style_toggle(this,'button_purple')" class="button_purple"></td>
    </tr>
    </table>
    <br><br><br><br>
    </form>
    </td>
</tr>
</table>
</center>
</body>
</HTML>
