<?php
/*
기사님이 버스의 도착과 출발 정보를 등록하는데 사용하는 api
*/
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');

$bs_no = request('bs_no');
$seq = intval(request('seq'));
$kind = request('kind');

$reg_time = date('H:i');
//도착(1) 또는 춯발(2)버튼을 누르면 싷행
if($kind == "1" || $kind == "2") {
	$sql = "select * from busroutine where bs_no = $bs_no order by seq";
	$result=mysqli_query($conn,$sql);
	$b_arr = date('H:i');
	$time_diff = 0; //정거장간의 도착시간 간격을 저장
	$time_sum = 0; //시간간격의 합을 저장
	while($r=mysqli_fetch_array($result)) {
		$no = $r["no"];
		$p_arr = $r["p_arrivaltime"];
		$iter_seq = $r["seq"];
		if($iter_seq == 1) { //첫번째 정류장이면
			$b_arr = $p_arr;
		} else {
			// 나머지 정류장이면 앞의 정류장간의 예정 도착시간의 차를 구하고
			// $b_arr값을 현재의 정류장의 값으로 교체
			$time_diff = (int)((strtotime($p_arr) - strtotime($b_arr))/60);
			$b_arr = $p_arr;
		}
		if($iter_seq < $seq){
			// 선택된 정류장보다 앞의 정류장일 경우 is_on값을 지나감(3)으로
			$sql_update = "update busroutine set is_on=3 where no = $no";
		} else if($iter_seq > $seq) {
			// 선택된 정류장보다 뒤의 정류장일 경우 is_on값을 도착전(0)으로
			// 예정 도착시간과 남은 시간 정보를 업데이트
			$time_sum += $time_diff;
			$e_arr = date("H:i", strtotime("+$time_sum minutes"));
			$sql_update = "update busroutine set is_on=0, e_arrivaltime = '$e_arr',
										remain_time=$time_sum where no = $no";
		} else {
			//선택된 정류장일 경우
			$time_sum =0;
			if($kind == "1"){
				//도착버튼을 누른경우 is_on값을 도착(1)로, 예정시간을 현재시간으로
				$sql_update = "update busroutine set is_on=1,
											e_arrivaltime='$reg_time' where no = $no";
			} else {
				//도착버튼을 누른경우 is_on값을 출발(2)로, 예정시간을 현재시간으로
				$sql_update = "update busroutine set is_on=2,
				 							e_arrivaltime='$reg_time' where no = $no";
			}
		}
		$retval = mysqli_query($conn, $sql_update);
	}

//운행시작 버튼을 누르면 도착시간과 남은시간 초기화
} else if($kind == "3") {
	$sql = "update busroutine set is_on = 0, e_arrivaltime=null, remain_time=0
					where bs_no = $bs_no";
	mysqli_query($conn, $sql);
	$sql = "update busschedule set isdrive = 1 where no = $bs_no";
	$retval = mysqli_query($conn, $sql);

	$seq=1;
	$sql = "select * from busroutine where bs_no = $bs_no order by seq";
	$result=mysqli_query($conn,$sql);
	$b_arr = date('H:i');
	$time_diff = 0; //정거장간의 도착시간 간격을 저장
	$time_sum = 0; //시간간격의 합을 저장
	while($r=mysqli_fetch_array($result)) {
		$no = $r["no"];
		$p_arr = $r["p_arrivaltime"];
		$iter_seq = $r["seq"];
		if($iter_seq == 1) { //첫번째 정류장이면
			$b_arr = $p_arr;
		} else {
			// 나머지 정류장이면 앞의 정류장간의 예정 도착시간의 차를 구하고
			// $b_arr값을 현재의 정류장의 값으로 교체
			$time_diff = (int)((strtotime($p_arr) - strtotime($b_arr))/60);
			$b_arr = $p_arr;
		}
		if($iter_seq < $seq){
			// 선택된 정류장보다 앞의 정류장일 경우 is_on값을 지나감(3)으로
			$sql_update = "update busroutine set is_on=3 where no = $no";
		} else if($iter_seq > $seq) {
			// 선택된 정류장보다 뒤의 정류장일 경우 is_on값을 도착전(0)으로
			// 예정 도착시간과 남은 시간 정보를 업데이트
			$time_sum += $time_diff;
			$e_arr = date("H:i", strtotime("+$time_sum minutes"));
			$sql_update = "update busroutine set is_on=0, e_arrivaltime = '$e_arr',
										remain_time=$time_sum where no = $no";
		} else {
			//선택된 정류장일 경우
			$time_sum =0;
			//도착버튼을 누른경우 is_on값을 도착(1)로, 예정시간을 현재시간으로
			$sql_update = "update busroutine set is_on=1,
										e_arrivaltime='$reg_time' where no = $no";

		}
		$retval = mysqli_query($conn, $sql_update);
	}

//운행종료 버튼을 누르면 도착시간과 남은시간 초기화
} else if($kind == "4") {
	$sql = "update busschedule set isdrive = 0 where no = $bs_no";
	$retval = mysqli_query($conn, $sql);
}

if($retval){
	$response['value'] = '1';
	$response['message'] = '정상적으로 저장되었습니다.';
} else {
	$response['value'] = '0';
	$response['message'] = '저장중에 오류가 발생하였습니다.';
}

echo json_encode(null2blank($response));

?>
