<?php
/*
기사님이 공지사항을 들록하는 api
*/
//공통으로 사용하는 함수들을 모아놓은 파일과 DB접속을 위한 파일
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');


	function send_notification ($tokens, $message,$title)
	{
		$url = 'https://fcm.googleapis.com/fcm/send';

		$msg = array(
    'body'   =>$message,
    'title'     => $title,
    'key1'  => 'val1'
		);
		$fields = array(
			 'registration_ids' => $tokens,
			 'notification' => $msg
			);

		$headers = array(
			'Authorization:key = AAAACsjO01I:APA91bHq0bvP0vUBLE1Tnh6SLq8UUkhdB3s4QxTGcotRbKH3Pfg2eoy1XfrJnDWgXqTR9fdgwmXJlfuqWNhxKNkzkAi09rmncvxHeXq46DBJt9D91hcaF8UTpLjafRNwhDxHo7btbXTT ',
			'Content-Type: application/json'
			);

	   $ch = curl_init();
       curl_setopt($ch, CURLOPT_URL, $url);
       curl_setopt($ch, CURLOPT_POST, true);
       curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
       curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
       curl_setopt ($ch, CURLOPT_SSL_VERIFYHOST, 0);
       curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
       curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($fields));
       $result = curl_exec($ch);
       if ($result === FALSE) {
           die('Curl failed: ' . curl_error($ch));
       }
       curl_close($ch);
       return $result;
	}

	$sql = " Select token From user_token";

	$result = mysqli_query($conn,$sql);
	$tokens = array();

	if(mysqli_num_rows($result) > 0 ){

		while ($row = mysqli_fetch_assoc($result)) {
			$tokens[] = $row["token"];
		}
	}

	mysqli_close($conn);
	$message = "버스가 출발했습니다.";
	$title = "버스출발 안내";
	$message_status = send_notification($tokens, $message,$title);
	echo $message_status;

?>
