<?

//define('LIST_SCALE', '10');
define('PAGE_SCALE', '10');

define('PAGE_SKIN', "
SELECT *
FROM (
    SELECT ROWNUM AS RNUM, B.* 
    FROM ( %s ) B
    )
WHERE RNUM >= %s AND rnum < (%s + %s)
");

define('CNT_SKIN', "SELECT COUNT(*) AS CNT FROM  %s");
define('DEL_SKIN', "DELETE FROM (%s);");


function paging($total,$scale,$pagescale,$pn) {

	$cutpage_num = (int) ceil($total/$scale);
	$now_num     = (int) ceil($pn/$pagescale);
	$start_num   = (int) ($now_num - 1) * $pagescale;
	$end_num     = (int) $now_num * $pagescale;
	$next_num    = (int) $end_num + 1;
	$prev_num    = (int) $start_num;

	echo '<table border="0" cellpadding="0" cellspacing="0"><tr>';
	if($now_num > 1) {
		echo '<td class="paging_off" onmouseover="td_over(this)" onmouseout="td_out(this)" onclick="go_list(1)">Start</td><td>&nbsp;</td>';
		echo '<td class="paging_off" onmouseover="td_over(this)" onmouseout="td_out(this)" onclick="go_list('.$prev_num.')">Previous ('.$pagescale.')</td><td>&nbsp;</td>';
	}

	for($i=$start_num+1; $i<=$end_num && $i<=$cutpage_num; $i++) {
		if($i == $pn) {
			echo '<td class="paging_on">'.$i.'</td><td>&nbsp;</td>';
		}
		else {
			echo '<td class="paging_off" onmouseover="td_over(this)" onmouseout="td_out(this)" onclick="go_list('.$i.')">'.$i.'</td><td>&nbsp;</td>';
		}
	}
	if($end_num < $cutpage_num) {
		echo '<td class="paging_off" onmouseover="td_over(this)" onmouseout="td_out(this)" onclick="go_list('.$next_num.')">Next ('.$pagescale.')</td><td>&nbsp;</td>';
		echo '<td class="paging_off" onmouseover="td_over(this)" onmouseout="td_out(this)" onclick="go_list('.$cutpage_num.')">End</td>';
	}
	echo '</tr></table>';
}


function paging1($total,$scale,$pagescale,$pn,$func='gogo') {

    $cutpage_num = (int) ceil($total/$scale);
    $now_num     = (int) ceil($pn/$pagescale);
    $start_num   = (int) ($now_num - 1) * $pagescale;
    $end_num     = (int) $now_num * $pagescale;
    $next_num    = (int) $end_num + 1;
    $prev_num    = (int) $start_num;

    echo '<div style="width:100%;maring:5px;padding:5px;"><table border="0" cellpadding="0" cellspacing="0" style="margin:0 auto"><tr>';
    if($now_num > 1) {
        echo '<td class="paging_off" onmouseover="td_over(this)" onmouseout="td_out(this)" onclick="'.$func.'(1)">Start</td><td>&nbsp;</td>';
        echo '<td class="paging_off" onmouseover="td_over(this)" onmouseout="td_out(this)" onclick="'.$func.'('.$prev_num.')">Previous ('.$pagescale.')</td><td>&nbsp;</td>';
    }

    for($i=$start_num+1; $i<=$end_num && $i<=$cutpage_num; $i++) {
        if($i == $pn) {
            echo '<td class="paging_on">'.$i.'</td><td>&nbsp;</td>';
        }
        else {
            echo '<td class="paging_off" onmouseover="td_over(this)" onmouseout="td_out(this)" onclick="'.$func.'('.$i.')">'.$i.'</td><td>&nbsp;</td>';
        }
    }
    if($end_num < $cutpage_num) {
        echo '<td class="paging_off" onmouseover="td_over(this)" onmouseout="td_out(this)" onclick="'.$func.'('.$next_num.')">Next ('.$pagescale.')</td><td>&nbsp;</td>';
        echo '<td class="paging_off" onmouseover="td_over(this)" onmouseout="td_out(this)" onclick="'.$func.'('.$cutpage_num.')">End</td>';
    }
    echo '</tr></table></div>';
}
?>