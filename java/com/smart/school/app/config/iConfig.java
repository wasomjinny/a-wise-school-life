package com.smart.school.app.config;

import android.text.InputType;

public interface iConfig {
	

	//==========================================================================================================


	int CHILD_COUNT_2 									= 2;
	int CHILD_COUNT_5 									= 5;

	int JSON_SUCCESS 									= 200;


	int REQUEST_CHECK_SETTINGS							= 292;



	int INPUT_TYPE_TEXT 								= InputType.TYPE_CLASS_TEXT;
	int INPUT_TYPE_PASSWORD 							= InputType.TYPE_TEXT_VARIATION_PASSWORD;


	String TAG_MAIN	 									= "main";
	String TAG_LOGIN 									= "login";
	String TAG_REGION_SELECT							= "region_select";


	String KEY_TYPE										= "TYPE";
	String KEY_GO_ACT									= "GO_ACT";

	String KEY_LAT										= "LAT";
	String KEY_LNG = "LNG";


	String DIALOG_TAG_LIST								= "LIST";


	/** api param key*/

	String SERVER_URL                                  	= "kimokwoophp.godohosting.com/school";
	String SERVER_URL_REAL                             	= "http://" + SERVER_URL + "/api/";
	String SERVER_URL_REAL1                             = "https://fcm.googleapis.com/";


	String URL_LOGIN 									= "mobile_login.php";

	String URL_LOGIN2 									= "mobile_login.php";

	String URL_GET_VERSION								= "get_version.php";

	String URL_GET_BUS_ROUTE_INFO						= "api_busroutine.php";
	String URL_GET_BULLETIN_LIST						= "api_getbulletinlist.php";
	String URL_GET_FOOD_LIST							= "api_getfoodlist.php";
	String URL_GET_RECOMMEND_FOOD						= "api_getrecommendfoodlist.php";
	String URL_GET_FOOD_RANKING							= "api_getfoodranking.php";
	String URL_GET_MY_INFO								= "api_getmyinfo.php";
	String URL_UPDATE_MY_INFO							= "api_updatemyinfo.php";
	String URL_UPDATE_MENU_REVIEW						= "api_updatemenureview.php";
	String URL_UPDATE_RECOMMEND_REVIEW					= "api_updaterecommendreview.php";
	String URL_UPDATE_BUS_CONTROL						= "api_updatebuscontrol.php";
	String URL_ADD_RECOMMEND_FOOD						= "api_addrecommendfood.php";
	String URL_ADD_BULLETIN								= "api_addbulletin.php";
	String USER_NO										= "user_no";


}

