package com.smart.school.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;

public class NetworkUtils {
	private static CustomLog log = new CustomLog();

	// 현재 네트워크 상태 상수
	public static final int NETWORK_STATE_NONE = 0;
	public static final int NETWORK_STATE_4G = 1;
	public static final int NETWORK_STATE_3G = 2;
	public static final int NETWORK_STATE_WIFI = 3;

	public final static String TAG = NetworkUtils.class.getSimpleName();

	/** 현재 접속된 네트워크 상태 */
	private static int isCurrentNetworkState;

	public static int getCurrentNetworkState() {
		return isCurrentNetworkState;
	}

	/**
	 * @breif whether it connected 4g or not
	 * @param context
	 * @return
	 */
	public static boolean is4gConnected(Context context) {
		ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		// 4G 를 사용하는지 확인힌다.

		boolean is4g = false;
		NetworkInfo networkInfo = connectivity.getNetworkInfo(ConnectivityManager.TYPE_WIMAX);
		if(networkInfo != null){
			is4g = networkInfo.isConnectedOrConnecting();
		}
		return is4g;
	}

	/**
	 * @breif whether it connected 3g or not
	 * @param context
	 * @return
	 */
	public static boolean is3gConnected(Context context) {
		ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		// 3G 를 사용하는지 확인힌다. 
		boolean is3g = connectivity.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
		return is3g;
	}
	
	/**
	 * @breif WIFI 를 사용하는지 확인한다.
	 * @param context
	 * @return
	 */
	public static boolean isWifiConnected(Context context) {
		ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		// WIFI 를 사용하는지 확인힌다. 
		boolean isWifi = connectivity.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
		return isWifi;
	}

	/**
	 * @breif whether it connected 3g or wifi
	 * @param context
	 * @return
	 */
	public static boolean isConnected(Context context) {
		ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo net4g = connectivity.getNetworkInfo(ConnectivityManager.TYPE_WIMAX);
		NetworkInfo net3g = connectivity.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		NetworkInfo netWifi = connectivity.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

		NetworkInfo info = connectivity.getActiveNetworkInfo();

		if (info == null) {
			// NOT CONNECTED
			isCurrentNetworkState = NETWORK_STATE_NONE;
			return false;
		} else {
			switch (info.getType()) {
				// 현재 접속된 네트워크가3G 망일때
			case ConnectivityManager.TYPE_WIMAX:
				if (net4g.isConnected())
					isCurrentNetworkState = NETWORK_STATE_4G;
				break;
			// 현재 접속된 네트워크가3G 망일때
			case ConnectivityManager.TYPE_MOBILE:
				if (net3g.isConnected())
					isCurrentNetworkState = NETWORK_STATE_3G;
				break;
			// 현재 접속된 네트워크가 wifi일 때
			case ConnectivityManager.TYPE_WIFI:
				if (netWifi.isConnected())
					isCurrentNetworkState = NETWORK_STATE_WIFI;
				break;
			}
			return true;
		}
	}

	/**
	 * @breif wifi, 데이터 네트워크 사용할수 있는지 체크
	 * @param context
	 * @return
	 */
	public static boolean isNetworkAvailable(Context context) {
		boolean isAvailable = false;
		CustomLog.v(TAG, "mContext=========="+context);
		if(NetworkUtils.isWifiConnected(context)){
			isAvailable =  true;
		}
		else if(NetworkUtils.is3gConnected(context)) {
			isAvailable =  true;
		}
		else if(NetworkUtils.is4gConnected(context)) {
			isAvailable =  true;
		}
		return isAvailable;
	}
	
	static public boolean isNetworkConnected(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		try {
			return ni.isConnectedOrConnecting();
		} catch (NullPointerException e) {
			return false;
		}
	}

	public static String getWiFiInfo(Context context){
		String speed = "";
		WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		speed = wifiInfo.getLinkSpeed() + WifiInfo.FREQUENCY_UNITS;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			speed = wifiInfo.getFrequency() + WifiInfo.FREQUENCY_UNITS;
		}
		return speed;
	}

	public static String getWiFiRSSI(Context context) {
		String message = "";
		WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		int rssi = wifiInfo.getRssi();

//		RF 수신률 양호 : - 30 ~ - 80
//		RF 수신률 불안정 : - 80 ~ -90
//		RF 수신률 불량 : - 90 이하
		/*if(rssi <= -30 && rssi >= -80){
			message = "Wifi 신호세기가 강합니다.";
		}else */
		if (rssi < -80 && rssi >= -90) {
			message = "Wifi 신호세기가 약합니다.";
		} else if (rssi < -90) {
			message = "Wifi 신호세기가 불량합니다.";
		}
		if (message.length() > 0)
			return message;
		else
			return null;
	}

	public static int getNetworkInfo(Context context){
		int speed = 0;
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = cm.getActiveNetworkInfo();
		networkInfo.getState();
		return 0;
	}

	public static String getNetworkLinkSppend(Context context){
		ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = connectivity.getActiveNetworkInfo();
		NetworkInfo net4g = connectivity.getNetworkInfo(ConnectivityManager.TYPE_WIMAX);
		NetworkInfo net3g = connectivity.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		NetworkInfo netWifi = connectivity.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

		String nLinkSpeed = "";

		if (info != null) {
			switch (info.getType()) {
				// 현재 접속된 네트워크가3G 망일때
				case ConnectivityManager.TYPE_WIMAX:
					if (net4g.isConnected())
					break;
				// 현재 접속된 네트워크가3G 망일때
				case ConnectivityManager.TYPE_MOBILE:
					if (net3g.isConnected())

					break;
				// 현재 접속된 네트워크가 wifi일 때
				case ConnectivityManager.TYPE_WIFI:
					if (netWifi.isConnected()) {
						nLinkSpeed = getWiFiRSSI(context);
						return nLinkSpeed;
					}
					break;
			}
		}
		return null;
	}
}
