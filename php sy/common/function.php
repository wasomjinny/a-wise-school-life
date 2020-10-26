<?

function time_format($time_text) {
	$result_text = $time_text;

	if(strlen($time_text) == 3) {
		$result_text = "0".$time_text;
	}

	if(strlen($result_text) == 4){
		$result_text = substr($result_text,0,2).":".substr($result_text,2,2);
	}
	return $result_text;
}


function str_to_mobile( $s ){
	$s = db2html($s);
	$s = str_replace('<P>','',$s);
	$s = str_replace('</P>','',$s);
	$s = str_replace("</NOBR>","",$s);
	$s = str_replace("<NOBR>","",$s);
	return $s;
}

function str_to_database( $s ){
	$s = trim($s);
	$s = stripslashes($s);
	$s = str_replace('"','&quot;',$s);
	$s = str_replace("'",'&#039;',$s);
	$s = str_replace('<','&lt;',$s);
	$s = str_replace('>','&gt;',$s);
	return $s;
}


function DayOfYear($Year){
    if (($Year % 4) == 0) {
      if (($Year % 400) == 0) {
        if (($Year % 100) == 0) return 366;
        else return 365;
      } else return 366;
    } else return 365;
}

function DayOfMonth($Year, $Month){
    switch ($Month) {
      case 1 :
      case 3 :
      case 5 :
      case 7 :
      case 8 :
      case 9 :
      case 10 :
      case 12 :
        return 31;
        break;

      case 4 :
      case 6 :
      case 11 :
        return 30;
        break;

      case 2 :
        if (DayOfYear($Year) == 365) return 28;
        else return 29;
        break;
    }
}


function isChecked( $s, $chk ){
	if ( $s == $chk ) return "checked"; else return "";
}

function isSelected( $s, $chk ){
	if ( $s == $chk ) return "selected"; else return "";
}

function Redirect($url, $time=0){
    echo "<META HTTP-EQUIV=REFRESH CONTENT=\"$time; URL=$url\">";
    exit;
}

function ChkNum($s){
	if ($s) { return str_replace(',','',$s); } else { return 0; };
}

function clear_zero($s){
	if ($s == "0") return ""; else return $s;
}


//------------------------------
// GET, POST 파라미터 가져오기
//------------------------------
function request($name) {
	if (is_array($_POST[$name])) {
		return check_sql($_POST[$name]);
	}
	elseif (is_array($_GET[$name])) {
		return $_GET[$name];
	}
	else {
		return isset($_POST[$name]) ? trim(check_sql($_POST[$name])) : (isset($_GET[$name]) ? trim($_GET[$name]) : false);
	}
}


function br2nl($str) {
   return  preg_replace('/<br\\s*?\/??>/i', '', $str);
}

function strcut($str,$len=42,$suffix='...') { //긴 문자열 ...으로 처리

	$str = strip_tags($str);
	return (iconv_strlen($str)>$len) ? iconv_substr($str,0,$len,'UTF-8').$suffix : $str;
}

function cutstring_kr($str,$len,$suffix='...') {
  if($len < 1 || $len >= strlen($str) ) return $str;
  $klen=$len - 1;
  while($klen>0 && ord($str[$klen]) & 0x80) $klen--;
  return substr($str,0,$len -((($len + $klen)& 1)^ 1)). $suffix;
}

function calc_date($d,$diff,$format='Ymd') { // calc_date('20071212','-1 day','Ymd');
	if(strlen($d) >= 8) {
		$y = substr($d,0,4);
		$m = substr($d,4,2);
		$d = substr($d,6,2);
		$n = mktime(0,0,0, $m, $d, $y);
		//echo$diff;exit;
		return date($format, strtotime($diff, $n));
	}
	else {
		return $d;
	}
}

function get_date($deli=null,$d=null) {
	if($deli) {
		if($d) {
			return substr($d,0,4).$deli.substr($d,4,2).$deli.substr($d,6,2);
		}
		else {
			return date('Y'.$deli.'m'.$deli.'d');
		}
	}
	else {
		return date('Ymd');
	}
}

function get_date_hs($deli=null,$d=null) {
	if($deli) {
		if($d) {
			return substr($d,0,4).$deli.substr($d,4,2).$deli.substr($d,6,2).$deli.substr($d,8,2).$deli.substr($d,10,2);
		}
		else {
			return date('Y'.$deli.'m'.$deli.'d'.$deli.'H'.$deli.'m'.$deli.'s');
		}
	}
	else {
		return date('YmdHis');
	}
}
function get_long_date($d) {
	if ($d) {
		return substr($d,0,4).'-'.$deli.substr($d,4,2).'-'.$deli.substr($d,6,2).' '.$deli.substr($d,8,2).':'.$deli.substr($d,10,2).':'.$deli.substr($d,12,2);
	}
	else {
		return '';
	}
}
function get_date_serial() {
	return date('YmdHis');
}

function get_time() {
	$mm = (int)date('i') + 3;
	$mm = ($mm > 59) ? $mm - 60 : $mm;
	$mm = ($mm < 10) ? '0'.$mm : $mm;
	return $mm;
}
//-----------------
// 요일 이름 리턴
//-----------------
function get_day_name($day) {
	$kr_day = array('일', '월', '화', '수', '목', '금', '토' );
	return $kr_day[ date('w', str_to_date($day)) ];
}


function get_day_name_kr($i,$long_string=false) { // 1 = 월요일, 7 = 일요일 (ISO-8601)

	$day_name = array( '월', '화', '수', '목', '금', '토', '일');


	if($i==0) {//일요일처리 getdate에서는 0으로 리턴
		$i	=	7;
	}
	//echo$i.":".$day_name[$i-1];
	return $day_name[$i-1];
}

//---------------------------------
// 요일 문자열로 이름 문자열 리턴
//---------------------------------
function get_day_no_name($days) {
	$str = '';
	$len = strlen($days);
	for($i=0; $i<$len; $i++) {
		$day_no = substr($days,$i,1);
		     if($day_no == '1') $str.= '월';
		else if($day_no == '2') $str.= '화';
		else if($day_no == '3') $str.= '수';
		else if($day_no == '4') $str.= '목';
		else if($day_no == '5') $str.= '금';
		else if($day_no == '6') $str.= '토';
		else if($day_no == '7') $str.= '일';
	}
	return $str;
}
//-----------------------------
// 요일 번호로 날짜 색깔 리턴
//-----------------------------
function get_day_no_color($i) {
	$s = 'black';
	if($i == 6) $s = 'blue';
	elseif($i == 7) $s = 'red';
	return $s;
}

function str_to_date($day) {
	if(strlen($day) == 8) {
		return mktime(0,0,0, (int)substr($day,4,2), (int)substr($day,6,2), (int)substr($day,0,4));
	}
	else {
		if($day) {
			$aDay = explode(substr($day, strlen($day)-3, 1), $day);
			return mktime( 0,0,0, (int)$aDay[1], (int)$aDay[2], (int)$aDay[0] );
		}
	}
}
function get_week_no_of_the_month($timestamp) { // $timestamp = mktime(0,0,0,12,20,2007);
	$w = date('w', mktime(0,0,0, date('n',$timestamp), 1, date('Y',$timestamp)));
	return ceil(($w + date('j',$timestamp) - 1) / 7);
}
function str_to_number($s=''){
	$s = str_replace(' ','',trim($s));
	return $s ? intval(str_replace(',','',$s)) : 0;
}
function date_to_str($d='') {

	if($d) {
		$w = get_week_num(substr($d,0,8));
		if(strlen($d) == 14 || strlen($d) == 12) {

			return substr($d,0,4).'.'.substr($d,4,2).'.'.substr($d,6,2).' ('.get_day_name_lang($w).') '.substr($d,8,2).':'.substr($d,10,2);
		}
		else {
			return substr($d,0,4).'.'.substr($d,4,2).'.'.substr($d,6,2).' ('.get_day_name_lang($w).')';
		}
	}
	else {
		return $d;
	}
}

function date_to_str_kr($d='') {

	if($d) {
		$w = get_week_num(substr($d,0,8));
		if(strlen($d) == 14 || strlen($d) == 12) {

			return substr($d,0,4).'.'.substr($d,4,2).'.'.substr($d,6,2).' ('.get_day_name_kr($w).') '.substr($d,8,2).':'.substr($d,10,2);
		}
		else {
			return substr($d,0,4).'.'.substr($d,4,2).'.'.substr($d,6,2).' ('.get_day_name_kr($w).')';
		}
	}
	else {
		return $d;
	}
}


//}} end date_to_str_lang

//-------------------------------------------------------
// 둘 날짜간에 며칠이 차이나는지 일수로 리턴
// 예) get_date_diff(date('Ymdhis'), '20111231010101');
//-------------------------------------------------------
function get_date_diff($to, $from) {
	$to1 = str_replace('.','',str_replace('-','',$to));
	$from1 = str_replace('.','',str_replace('-','',$from));
	return intval((strtotime($to1) - strtotime($from1)) / 86400);
}
function get_date_diff_str($to, $from) {
	$d1 = (strlen($to) == 8 || strlen($to) == 14) ? substr($to,0,8) : $to;
	$d2 = (strlen($from) == 8 || strlen($from) == 14) ? substr($from,0,8) : $from;
	$cnt = get_date_diff($d1, $d2);
	return $cnt.'박 '.($cnt+1).'일';
}
// function date_add($givendate,$day=0,$mth=0,$yr=0) { // 2011-01-31
// 	$cd = strtotime($givendate);
// 	$newdate = date('Y-m-d', mktime(date('h',$cd), date('i',$cd), date('s',$cd), date('m',$cd)+$mth, date('d',$cd)+$day, date('Y',$cd)+$yr));
// 	return $newdate;
// }
function db2money($n,$if_zero='') {
	$s = '';
	if($n) {
		$s = number_format($n,2,'.',',');
		$s = str_replace('.00','',$s);
	}
	if(!$s) $s = $if_zero;
	return $s;
}
function money2db($s) {
	return floatval(str_replace(',','',$s));
}
function mobile2html($mobile) {
	global $img_mobile;
	return ($mobile) ? '<a href="javascript:popup_sms(\'\',\''.$mobile.'\')">'.$img_mobile.' '.$mobile.'</a>' : $mobile;
}
function email2html($email) {
	global $img_email;
	return ($email) ? $img_email.' <a href="javascript:popup_email(\'\',\''.$email.'\')">'.$email.'</a>' : $email;
}
function homepage2html($homepage,$show_text=false,$len=0) {
	global $img_homepage;
	if($show_text) {
		$text = $img_homepage.' ';
		$text.= $len ? substr($homepage,0,$len).'...' : $homepage;
	}
	else {
		$text = $img_homepage;
	}
	return $homepage ? '<a href="'.$homepage.'" target="_blank" title="'.$homepage.'">'.$text.'</a>' : $homepage;
}
function html2db($s) { // input[text] to varchar2
	if($s) {
		$s = trim($s);
		if($s == '<P>&nbsp;</P>') {
			$s = '';
		}
		else {
			$s = stripslashes(htmlspecialchars($s,ENT_QUOTES)); // <b>a'b"c</b> ---> &lt;b&gt;a'b&quot;c&lt;/b&gt;
			$s = str_replace("'","''",$s);
		}
	}
	return $s;
}
function html2clob($s) { // save to clob
	$s2 = strtolower(trim($s));
	if($s2 == '<p>&nbsp;</p>' || $s2 == '<p style="text-align: left;">&nbsp;</p>' || $s2 == '<p style=\"text-align: left;\">&nbsp;</p>' || $s2 == '&lt;p style=\"text-align: left;\"&gt;&amp;nbsp;&lt;/p&gt;') $s = '';
	if($s) {
		$s = htmlspecialchars($s,ENT_NOQUOTES);
		$s = str_ireplace('a href=','a target="_blank" href=',$s);
	}
	return $s;
}
function db2html($s) {
	$s = str_replace('&#039;', '\'',$s);
	return stripslashes(htmlspecialchars_decode($s));
}
function clob2html($s) { // clob to textarea for editing.
	return stripslashes($s);
}
function clob2textarea($s) {
	return htmlspecialchars($s);
}
function str2db($s) { // a'b"<b>c</b> => a'b&quot;c
	$s = stripslashes(strip_tags(trim($s)));
	$s = str_replace('"',"&quot;",$s);
	$s = str_replace("'","''",$s);
	return $s;
}
/*
function htmltag2db($s) { // <b>a'b"c</b> = &lt;b&gt;a'b&quot;c&lt;/b&gt;
	$s = stripslashes(htmlspecialchars(trim($s)));
	$s = str_replace('"',"&quot;",$s);
	$s = str_replace("'","''",$s);
	return $s;
}
*/
function textarea2db($s) { // to varchar2 or to clob
	$s = stripslashes(htmlspecialchars(trim($s)));  // <b>a'b"c</b> = &lt;b&gt;a'b&quot;c&lt;/b&gt;
	$s = str_replace('"',"&quot;",$s);
	$s = str_replace("''","",$s);
	//$s = str_replace("'","''",$s);
	$s = str_replace('  ','&nbsp;&nbsp;',$s);
	$s = nl2br($s);
	return $s;
}
function db2textarea($s) {
	if($s) {
		$s = strip_tags(stripslashes($s));
		$s = str_replace('<br>','',$s);
		$s = str_replace('<BR>','',$s);
		$s = str_replace('<br />','',$s);
		$s = str_replace('<BR />','',$s);
	}
	return $s;
}
function db_to_str($s) { // DEPRECATED
		if($s) {
		//$s = str_replace("\n",'<br>',$s);
		$s = str_replace('  ','&nbsp;&nbsp;',$s);
		$s = str_replace("''","'",$s);
		$s = str_replace("\'","'",$s);
		$s = str_replace('\"','"',$s);
		$s = str_replace('<P>&nbsp;</P>','',$s);
	}
	return $s;
}
function db_to_textarea($s) { // DEPRECATED
	if($s) {
		$s = str_replace("\'","'",$s);
		$s = str_replace('\"','"',$s);
	}
	return $s;
}
function str_to_db($s) { // DEPRECATED
	if($s) {
		$s = trim($s);
		$s = htmlspecialchars($s,ENT_NOQUOTES);
		$s = str_replace("'","''",$s);
	}
	return $s;
}
function html_to_db($s) { // DEPRECATED
	if($s) {
		$s = str_replace("'","''",$s);
		$s = str_replace('<PRE>','',$s);
		$s = str_replace('</PRE>','',$s);
		$s = str_replace('<P>&nbsp;</P>','',$s);
		$s = str_replace('<P>','',$s);
		$s = str_replace('</P>','<BR>',$s);
	}
	return $s;
}

function file_read($file_full_name) {
	$str = '';
	if(file_exists($file_full_name)) {
		$fd = fopen($file_full_name, 'r');
		if(filesize($file_full_name) > 0) {
			$str = fread($fd, filesize($file_full_name));
		}
		fclose ($fd);
	}
	return $str;
}
function file_write($file_full_name, $str) {
	$fp = fopen($file_full_name,'w');
	fwrite($fp, $str);
	fclose($fp);
}
function file_delete($file_full_name) {
	if(file_exists(addslashes($file_full_name))) @unlink(addslashes($file_full_name));
}

function array_to_select_option($array, $selected=null) {
	$selected = $selected.'';
	if($array) {
		foreach($array as $key => $val) {
			echo '<option value='.$key;
			echo ($key == $selected) ? ' selected' : '';
			echo '>'.$val.'</option>';
		}
	}

}

function array_to_radio($array, $radio_name, $checked=null, $view_row=5) {
	if($array) {
		//$view_row = 5;
		$s_table ="<table class='view'><tr valign='absmiddle'>";
		$e_table = "</tr></table>";

		$s_td = "<td>";
		$e_td = "</td>";

		echo $s_table;
		$k=1;
		foreach($array as $key => $val) {
			echo '<td><label  style="cursor:hand"><input type=radio name="'.$radio_name.'" value='.$key;
			echo ($key == $checked) ? ' checked' : '';
			echo '>'.$val."</label></td>";
			if($k%$view_row==0) echo"</tr><tr>";
			$k++;
		}

		echo $e_table;
	}

}

function array_to_checkbox($array, $checkbox_name, $val=null,$deli=':',$key_val='',$view_row=7) {
	$arr = explode($deli,$val);
	$count = count($arr);
	if($array) {

		$s_table ="<table class='view'><tr valign='absmiddle'>";
		$e_table = "</tr></table>";

		$s_td = "<td>";
		$e_td = "</td>";

		echo $s_table;
		$k=1;
		foreach($array as $key => $val) {
			if($key_val) $key = $key_val;
			echo '<td><label style="cursor:hand"><input type=checkbox name="'.$checkbox_name.'" value="'.$key.'"';
			for($i=0; $i<$count; $i++) {
				echo ($key == $arr[$i]) ? ' checked' : '';
			}
			echo '>'.$val."</label></td>";
			if($k%$view_row==0) echo"</tr><tr>";
			$k++;
		}

		echo $e_table;

	}

}

function array_to_checkbox2($array, $checkbox_name, $val=null,$deli=':', $option) {
	$arr = explode($deli,$val);
	$count = count($arr);
	if($array) {
		foreach($array as $key => $val) {
			echo '<div style="float:left; margin:0 5px 0 0;"><input type=checkbox name="'.$checkbox_name.'" value='.$key;
			for($i=0; $i<$count; $i++) {
				echo ($key == $arr[$i]) ? ' checked' : '';
			}
			echo ' '.$option.'>'.$val.'</div>';
		}
	}

}


/**
 * JSON 출력 시 키값이 null인 경우 ""으로 대체하기
 *
 * @param array $array
 */
function null2blank($array) {
	if (is_array($array)) {
		foreach($array as $key=>$val) {
			if(is_array($val)) {
				$array[$key] = null2blank($val);
			}
			else {
				$array[$key] = $val.'';
			}
		}
	}
	else {
		$array = $array.'';
	}
	return $array;
}


function str_count($str){
	$kChar = 0;
	$str = str_replace('<P>','',$str);
	$str = str_replace('</P>','',$str);
	$str = str_replace('&nbsp;','',$str);
	for( $i = 0 ; $i < strlen($str) ;$i++){
		$lastChar = ord($str[$i]);
		if($lastChar >= 127){
			$i= $i+2;
		}
		$kChar++;
	}

	return $kChar;
}

function error_msg($msg,$action) {
	echo "<script>\r\n";
	echo "alert('$msg');\r\n";
	echo "$action;\r\n";
	echo "</script>";
}


function alert($msg)
{
    echo "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">";
    echo "<script type='text/javascript'>";
    echo "alert('$msg');";
    echo "</script>";
    exit;
}


function alert_back($msg)
{
	echo "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">";
	echo "<script type='text/javascript'>";
	echo "alert('$msg');";
	echo "history.back();";
	echo "</script>";
	exit;
}

function alert_replace($msg, $url)
{
	echo "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">";
	echo "<script type='text/javascript'>";
	echo "alert('$msg');";
	echo "location.replace('$url')";
	echo "</script>";
	exit;
}

function alert_close($msg)
{
	echo "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">";
	echo "<script type='text/javascript'>";
	echo "alert('$msg');";
	echo "window.close()";
	echo "</script>";
	exit;
}


function replace($url)
{
	echo "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">";
	echo "<script type='text/javascript'>";
	echo "location.replace('$url')";
	echo "</script>";
	exit;
}

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

function selectDBValuesName($tableName,$field,$code,$optionValue,$optionName,$selected){
	global $conn;
	$sql='select * from '.$tableName;
	if($field !=''){
			$sql .= ' where '.$field .'= '.$code;
			$sql .= ' order by name';
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

?>
