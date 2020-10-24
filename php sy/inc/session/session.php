<?php
// 세션 파일을 저장할 경로 설정. 설정하지 않으면 php.ini에 기본 경로에 저장.
ini_set('session.save_path',$_SERVER['DOCUMENT_ROOT']."/school/inc/session");
// 세션 ID를 저장한 쿠키의 유효 시간 설정. 설정하지 않거나 0으로 설정하면 브라우저가 종료되면 쿠키는 파기. (초 단위)
ini_set("session.cache_expire", 3600);
ini_set("session.gc_maxlifetime", 3600);  // 세션 만료시간을 한시간으로 설정
session_start();
?>
