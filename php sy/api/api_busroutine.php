<?php
/*
버스시간표를 표시하는데 사용되는 api
*/
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/function.php');
include_once($_SERVER['DOCUMENT_ROOT'].'/school/common/connect.php');


$bsno	 = request('bsno');  // 버스스케쥴번호 (bus schedule 번호)

//전달받은 값이 없거나 0일 경우에는 스케쥴번호를 1로 세
if (!$bsno || $bsno=="0"){
	$bsno = "1";
}


$response = array();
$response['no'] = '';
$response['name'] = '';
$response['ison'] = '';
$response['busstop'] = '';
$response['parr'] = '';

//선택한 버스스케쥴번호에 해당하는 노선 정보를 읽어옴.
$sql = "select a.*, b.name as bus_stop_name, c.name as name from busroutine a
				left outer join code b on b.no = a.bus_stop
				left outer join busschedule c on c.no = a.bs_no
				where a.bs_no=$bsno
				order by a.seq";

$result=mysqli_query($conn,$sql);

if(!$result){
	// 등록된 노선정보 없을 경우 no값을 202로 세팅하고 파일을 빠져나감
	$response['no'] = '202';
	$response['name'] = "해당 노선정보가 등록되어 있지 않습니다.";
	echo json_encode($response);
	exit;
} else {
	//등록된 노선정보가 있을 경우 no값을 200으로 세팅
	$response['no'] = '200';
	//쿼리된 노선정보를 $route_info에 배열로 저장
	$route_info = array();
	while($r = mysqli_fetch_array($result)){
		$no   = $r['no'];
		$bsno   = $r['bs_no'];
		$seq   = $r['seq'];
		$busstop = $r['bus_stop_name'];
		$parr = $r['p_arrivaltime'];
		$earr = $r['e_arrivaltime'];
		$remaintime = $r['remain_time'];
		$ison = $r['is_on'];
		array_push($route_info,
    array(
			'no'=>"".$no,
			'bsno'=>"".$bsno,
			'seq'=>"".$seq,
			'busstop'=>"".$busstop,
			'parr'=>"".$parr,
			'earr'=>"".$earr,
			'remaintime' =>"".$remaintime,
			'ison'=>"".$ison));
	}
	$response['route_info'] = $route_info;

	$bus_schedule = array();
	//현재 운영중인 버스스케쥴 전체목록을 읽어와서
	//$bus_schedule 배열에 저장
	$sql = "SELECT no,name FROM busschedule where isuse=1";
	$result=mysqli_query($conn,$sql);

	while($r = mysqli_fetch_array($result)){
		$no   = $r['no'];
		$name = $r['name'];
		array_push($bus_schedule,
    array(
			'no'=>"".$no,
			'name'=>"".$name));
	}

	$response['bus_schedule'] = $bus_schedule;
  //현재노선의 이름과 운행중인지를 읽어와서 $response에 저장
	$sql = "SELECT a.name, a.isdrive, b.name as driver_name, b.tel
					FROM busschedule a
					left outer join teacher b on b.bus_no = a.no
					where a.no=$bsno";
	$result=mysqli_query($conn,$sql);
	$r = mysqli_fetch_array($result);
	$response['name'] = $r['name'];
	$response['ison'] = $r['isdrive']; //0이면 운행안함, 1이면 운행중
	$response['busstop'] = $r['driver_name'];
	$response['parr'] = $r['tel'];
}

echo json_encode(null2blank($response));

?>
