package com.smart.school.app.config;

import android.Manifest;
import android.os.Environment;
import android.text.InputType;

import java.text.SimpleDateFormat;
import java.util.Locale;

public interface iConfig {


	int APP_VERSION_PHONE = 1;        			// PHONE



	//==========================================================================================================

	String LOCAL_PATH = Environment.getDataDirectory().getAbsolutePath();            // SD CARD 데이타 디렉토리


	int CHILD_COUNT_2 									= 2;
	int CHILD_COUNT_5 									= 5;

	int JSON_SUCCESS 									= 200;
	int JSON_NO_MEMBER 									= 202;
	int JSON_PW_DIFFERENT 								= 203;

	String CODE_SUCCESS 								= "200";

	int TAG_MY_TOUR		 								= 0;
	int TAG_MY_FAVORITE_TOUR		 					= 1;
	int TAG_MY_FAVORITE_GOODS 							= 1;
	int TAG_MY_FAVORITE_SHOP 							= 2;
	int TAG_MY_COUPON									= 4;
	int TAG_CITY_SETTING 								= 3;
	int TAG_LANGUAGE_SETTING 							= 4;
	int TAG_PROFILE_EDIT 								= 7;
	int TAG_LOGOUT			 							= 11;
	int TAG_TOUR_DELETE									= 12;

	int TAG_PLAN_TOUR		 							= 0;
	int TAG_PRE_TOUR		 							= 1;

	int REQUEST_REGION 									= 0;
	int REQUEST_CATEGORY 								= 10;
	int REQUEST_FILTER 									= 20;
	int REQUEST_CITY 									= 30;
	int REQUEST_SHOPPING_TYPE 							= 40;
	int REQUEST_TOUR_FILTER 							= 50;
	int GPS_ENABLE_REQUEST_CODE							= 60;
	int REQUEST_COUNTRY_SEARCH 							= 70;
	int REQUEST_CURRENCY 								= 80;
	int REQUEST_TOUR_THEME 								= 90;
	int REQUEST_SHOP_SEARCH								= 100;
	int REQUEST_INSERT_IN_TOUR							= 110;
	int REQUEST_INSERT_IN_TOUR_SHOP						= 120;
	int REQUEST_INSERT_IN_TOUR_GOODS					= 130;
	int REQUEST_INSERT_IN_TOUR_GOODS2					= 140;
	int REQUEST_GOODS_FILTER							= 150;
	int REQUEST_SHOPPING_SPOT							= 160;
	int REQUEST_DIRECT_INPUT							= 170;
	int REQUEST_SELECT_SHOPPING_LIST					= 180;
	int REQUEST_INSERT_IN_TOUR_COUPON8					= 190;
	int REQUEST_INSERT_IN_TOUR_COUPON					= 200;
	int REQUEST_SELECT_TOUR								= 210;
	int REQUEST_SMS_CERTIFICATION						= 220;
	int REQUEST_SEARCH_BRAND							= 230;
	int REQUEST_BUY_SHOP								= 240;
	int REQUEST_BUY_PRICE_REG							= 250;
	int REQUEST_SHOP_LIST_BY_GOODS						= 260;
	int REQUEST_LINE_LOGIN								= 270;
	int REQUEST_ORDER_BY 								= 280;
	int REQUEST_SELECT_MEMBER 							= 290;
	int REQUEST_RECOMMEND_GOURMET_INFO 					= 291;
	int REQUEST_CHECK_SETTINGS							= 292;
	int PLAY_SERVICES_RESOLUTION_REQUEST 				= 9000;

	int PERMISSION_LOCATION_REQUEST    					= 0;
	int PERMISSION_CAMERA_REQUEST    					= 1;
	int PERMISSION_PHONE_REQUEST    					= 2;
	int PERMISSION_WRITE_EXTERNAL_STORAGE_REQUEST    	= 3;
	int PERMISSION_READ_PHONE_STATE_REQUEST    			= 4;

	int TYPE_FOOTER 									= 0;
	int TYPE_HEADER 									= 0;
	int VIEW_ITEM 										= 1;
	int TYPE_MENU_GROUP 								= 0;
	int TYPE_MENU_COURSE 								= 1;

	int TYPE_GOODS_LIST									= 0;
	int TYPE_GOODS_GRID									= 1;
	int TYPE_GOODS_GRID_2								= 2;
	int TYPE_GOODS_GRID_3								= 3;
	int TYPE_MAP										= 1;
	int TYPE_VIEW										= 4;
	int TYPE_FLOOR_MAP 									= 0;
	int TYPE_POINT 	    								= 1;
	int TYPE_EQUIP 	    								= 2;
	int TYPE_ITEM_LIST 	    							= 3;
	int TYPE_SHOP_LIST									= 100;
	int TYPE_COUPON_USE_SHOP_LIST						= 110;
	int TYPE_MALL_LIST									= 120;
	int TYPE_SHOP_INFO									= 130;
	int TYPE_MALL_INFO									= 140;
	int TYPE_CITY_HOME									= 150;
	int TYPE_DRUGSTORE_SHOP_LIST						= 160;
	int TYPE_THEME_SHOP_LIST							= 170;
	int TYPE_TOUR_INFO									= 180;
	int TYPE_SHOPPING_TIP_NOW							= 190;
	int TYPE_POI_EVALUATE_LIST							= 200;
	int TYPE_SHOPPING_TIP_CATEGORY						= 210;
	int TYPE_INPUT_GOODS_NAME							= 220;
	int TYPE_SELECT_SHOPPING_SPOT						= 230;
	int TYPE_COUPON_LIST								= 240;
	int TYPE_INSERT_TOUR_POPUP							= 250;
	int TYPE_SHOPPING_LIST								= 260;
	int TYPE_DIRECT_GOODS_NAME							= 270;
	int TYPE_DIRECT_SHOPPING_SPOT_NAME					= 280;
	int TYPE_SHOPPING_SPOT								= 290;
	int TYPE_POI_EVALUATE_UPDATE						= 300;
	int TYPE_SHOPPING_TIP_NOW_INFO						= 310;
	int TYPE_RECOMMEND_COUPON_INFO						= 320;
	int TYPE_SHOPPING_TIP_NOW_UPDATE					= 330;
	int TYPE_RESERVATION_AVAILABLE_GOODS_LIST			= 340;
	int TYPE_RESERVATION_SHOPPING_INFO					= 350;
	int TYPE_RESERVATION_SHOPPING_SELECT_TOUR			= 360;
	int TYPE_RESERVATION_SHOPPING_APPLY_INFO			= 370;
	int TYPE_SEARCH_BRAND_MALL_LIST						= 370;
	int TYPE_AREA_SHOP_LIST								= 380;
	int TYPE_MY_FAVOR_SHOP_LIST							= 390;
	int TYPE_BRAND_LIST									= 400;
	int TYPE_RECOMMEND_GOURMET_LIST						= 401;
	int TYPE_RT_MALL_LIST								= 402;
	int TYPE_REST_FILTER								= 403;
	int TYPE_ORDER_MENU_LIST							= 404;
	int TYPE_RECOMMEND_MUST_EAT							= 405;
	int TYPE_RECOMMEND_GOURMET_INFO						= 406;
	int TYPE_REST_MENU_LIST								= 407;
	int TYPE_REST_REVIEW_RATINGS_LIST					= 408;
	int TYPE_REST_REVIEW_RATINGS_UPDATE					= 409;

	//부속 POI
	int TYPE_PART										= 200;
	int TYPE_FLOOR										= 210;
	int TYPE_CATEGORY									= 220;
	int TYPE_INITIAL_SEARCH								= 230;
	int TYPE_EQUIP_LIST									= 240;
	int TYPE_PICK_CAMERA								= 300;
	int TYPE_PICK_ALBUM									= 310;
	int TYPE_SELECT_PHOTO								= 320;
	int TYPE_SEARCH_SHOP_IN_MALL						= 330;
	int TYPE_KEYWORD									= 340;

	int TYPE_GOODS_PRICE								= 0;
	int TYPE_TAX_PRICE									= 1;

	int TYPE_BUY_N 										= 10;
	int TYPE_BUY_Y										= 11;

	int TYPE_MALE										= 0;
	int TYPE_FEMALE										= 1;

	int TYPE_RESERVATION_STEP_1							= 0;
	int TYPE_RESERVATION_STEP_2							= 1;
	int TYPE_RESERVATION_STEP_3							= 2;
	int TYPE_RESERVATION_STEP_4							= 3;

	int TYPE_MAN     									= 0;
	int TYPE_WOMAN   									= 1;
	int TYPE_AGE     									= 2;

	int TYPE_STATISTICS_MAN 							= 0;
	int TYPE_STATISTICS_WOMAN 							= 1;
	int TYPE_STATISTICS_AGE 							= 2;

	int TYPE_PLAN_TOUR              					= 0;
	int TYPE_PRE_TOUR              						= 1;
	int TYPE_MY_SHOP              						= 2;
	int TYPE_MY_GOODS             						= 3;
	int TYPE_MY_COUPON            						= 4;
	int TYPE_RESERVATION_SHOPPING 						= 5;
	int TYPE_MY_RESTAURANT 								= 6;
	int TYPE_ORDER_MENU 								= 7;
	int TYPE_RESTAURANT_RESERVATION 					= 8;

	int TYPE_RELATION_GOODS								= 0;
	int TYPE_STATIC_BAR									= 1;

	int TYPE_GOURMET_INFO								= 0;
	int TYPE_GOURMET_MENU								= 1;
	int TYPE_GOURMET_REVIEW								= 2;

	int TYPE_ID           								= 0;
	int TYPE_PASSWORD     								= 1;
	int TYPE_EMAIL        								= 2;
	int TYPE_NAME         								= 3;

	int CATEGORY_ALL									= 0;

	int SORT_TYPE_1										= 0;
	int SORT_TYPE_2										= 1;
	int SORT_TYPE_3										= 2;
	int SORT_TYPE_4										= 3;

	int SORT_POPULARITY									= 0;
	int SORT_DISTANCE									= 1;

	int TAB_GOODS										= 0;
	int TAB_SHOP										= 1;
	int TAB_MALL										= 2;
	int TAB_BRAND										= 3;
	int TAB_GOURMET										= 2;

	int TAB_SHOPPING_LIST								= 0;
	int TAB_BUY_N_SHOPPING_LIST							= 1;
	int TAB_BUY_Y_SHOPPING_LIST							= 2;

	int CROP_CAMERA										= 1;
	int CROP_ALBUM 										= 2;
	int CROP_SAVE 										= 3;
	int PIC_CROP_SAVE 									= 4;
	int CAMERA_PIC_CROP_SAVE 							= 5;
	int CAMERA_CAPTURE 									= 10;
	int CAMERA_CAPTURE_OUTPUT 							= 11;
	int CAMERA_ROTATION 								= 20;
	int CURRENT_LOCATION 								= 21;

	int SELECT_CAMERA 									= 0;
	int SELECT_PIC 										= 1;
	int SELECT_PIC_REG 									= 2;

	int DISTANCE_100_METER 								= 0;
	int DISTANCE_300_METER 								= 1;
	int DISTANCE_500_METER 								= 2;
	int DISTANCE_1_KILOMETER 							= 3;

	int TYPE_SHOPPING_HOME								= 0;
	int TYPE_GOURMET_HOME								= 1;

	int TYPE_SELECT_ADULT_CNT							= 0;
	int TYPE_SELECT_CHILD_CNT							= 1;

	int TYPE_CAMERA										= 0;

	int TYPE_REST_RESERVATION_VISITED            		= 0; //방문완료
	int TYPE_REST_RESERVATION_NO_SHOW            		= 1; //노쇼

	int TAB_INITIAL_SEARCH  							= 0;
	int TAB_CATEGORY        							= 1;
	int TAB_FLOOR           							= 2;

	int TAB_CATEGORY2        							= 0;
	int TAB_INITIAL_SEARCH2  							= 1;

	int TAB_EN 											= 0;
	int TAB_JP 											= 1;
	int TAB_KR 											= 2;

	int TAB_MENU_GROUP									= 0;
	int TAB_REPRESENTATIVE_MENU							= 1;

	int TAB_BEST_MENU									= 0;
	int TAB_MENU_LIST									= 1;

	int TAB_MENU_COURSE									= 0;	//코스메뉴
	int TAB_MENU_FOOD 									= 1;	//음식
	int TAB_MENU_LIQUOR 								= 2;	//주류
	int TAB_MENU_DRINK 									= 3;	//음료

	int TAB_PLAN_RESERVATION 							= 0;
	int TAB_PRE_RESERVATION 							= 1;

	int TAB_TODAY_BUSINESS_HOUR 						= 0;
	int TAB_ONE_WEEK_BUSINESS_HOUR 						= 1;
	int TAB_CALENDAR_BUSINESS_HOUR 						= 2;

	int INPUT_TYPE_TEXT 								= InputType.TYPE_CLASS_TEXT;
	int INPUT_TYPE_PASSWORD 							= InputType.TYPE_TEXT_VARIATION_PASSWORD;
	int INPUT_TYPE_EMAIL 								= InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS;
	int INPUT_TYPE_NUMBER 								= InputType.TYPE_CLASS_NUMBER;

	String[] PERMISSIONS              					= {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE,Manifest.permission.CAMERA};
	String[] CAMERA_PERMISSIONS 						= {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
	String[] LOCATION_PERMISSIONS     					= {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
	//	String[] PHONE_PERMISSIONS        					= {Manifest.permission.READ_PHONE_STATE/*, Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS*/};
	String[] READ_PHONE_PERMISSIONS   					= {Manifest.permission.READ_PHONE_STATE};

	SimpleDateFormat SIMPLE_DATE_FORMAT 				= new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
	String PATTERN_DATE                                 = "yyyyMMdd";
	String PATTERN_DATE2                                = "yyyy.MM.dd";
	String PATTERN_YEAR                                 = "yyyy";
	String PATTERN_MONTH                                = "MM";
	String PATTERN_DAY_OF_MONTH                         = "dd";
	String PATTERN_DATE_TIME                            = "yyyyMMddHHmmss";
	String PATTERN_DATE_TIME2                           = "yyyyMMddHHmm";
	String PATTERN_TIME                                 = "HHmm";
	String PATTERN_HOUR                                 = "HH";
	String PATTERN_MINUTE                               = "mm";
	String PATTERN_SECOND                               = "ss";

	String GOOGLE_MAPS_STATIC_KEY						= "AIzaSyCiB58dTdPIeUEmWdpD70-KyZ-nqESip2U";
	String LANG_NAME_ENGLISH 							= "en";
	String LANG_NAME_JAPAN								= "jp";
	String LANG_NAME_JAPAN2								= "ja";
	String LANG_NAME_CN									= "cn";
	String LANG_NAME_TW									= "cn2";
	String LANG_NAME_TW2								= "tw";
	String LANG_NAME_KOREA								= "kr";
	String LANG_NAME_KOREA2								= "ko";
	String LANG_MALAYSIA								= "ms";
	String LANG_INDONESIAN								= "id";

	String LANG_NAME_ENGLISH3 							= "EN";
	String LANG_NAME_JAPAN3								= "JP";
	String LANG_NAME_CN3								= "CN";
	String LANG_NAME_TW3								= "CN2";
	String LANG_NAME_KOREA3								= "KR";

	String CODE_KOREA									= "52111";
	String CODE_JAPAN									= "52112";
	String CODE_SINGAPORE								= "53402";
	String CODE_CHINA 									= "53397";     	//중국
	String CODE_TAIWAN 									= "53426"; 		//대만(타이완)
	String CODE_THAILAND 								= "53569"; 		//태국
	String CODE_USA 									= "53414"; 		//미국

	String CODE_SEOUL									= "52113";
	String CODE_BUSAN									= "52114";
	String CODE_JEJU									= "52231";
	String CODE_SAPPORO									= "52471";
	String CODE_TOKYO									= "52133";
	String CODE_OSAKA									= "53395";
	String CODE_KYOTO									= "53711";
	String CODE_KOBE									= "55526";
	String CODE_FUKUOKA									= "52473";
	String CODE_NAGOYA									= "55529";

	String CODE_DON_QUIXOTE								= "405";
	String CODE_CHINESE_DRUGSTORE						= "402";
	String CODE_KOREAN_DRUGSTORE						= "333";
	String CODE_BRAND_DON_QUIXOTE						= "32";

	String CODE_MIN_MAX_PRICE							= "56228";	//최저~ 최고가(더보기,상세정보)
	String CODE_BASE_PRICE								= "56229";	//기준가격(더보기,상세정보)
	String CODE_SINGLE_PRICE							= "56230";	//단일가격(더보기,상세정보)
	String CODE_MIXED_PRICE								= "56231";	//혼합형(더보기,상세정보)
	String CODE_EMPTY_PRICE								= "56232";	//가격없음(더보기,상세정보)
	String CODE_BY_RECOMMENDATION						= "56248";	//추천순(더보기)
	String CODE_BY_POPULARITY							= "56233";	//인기순(더보기)
	String CODE_BY_PRICE								= "56234";	//가격순(더보기)
	String CODE_FILTER_CATEGORY							= "56235";	//카테고리(더보기)
	String CODE_FILTER_BRAND							= "56236";	//브랜드(더보기)
	String CODE_FILTER_TOUR_REG_GOODS					= "56237";	//여행등록상품(더보기)
	String CODE_SHOP_LIST								= "56227";	//숍리스트(상세정보)
	String CODE_SELL_SHOP_GROUP_BRAND					= "56226";	//판매숍그룹/브랜드(상세정보)
	String CODE_BY_RECOMMENDATION2						= "56238";	//추천순(상세정보)
	String CODE_BY_DISTANCE								= "56240";	//거리순(상세정보)
	String CODE_BY_POPULARITY2							= "56241";	//인기순(상세정보)
	String CODE_BY_PRICE2								= "56239";	//가격순(상세정보)
	String CODE_FILTER_DISTANCE							= "56242";	//거리(상세정보)
	String CODE_FILTER_REGION							= "56243";	//지역(상세정보)
	String CODE_FILTER_BRAND2							= "56245";	//브랜드(상세정보)
	String CODE_FILTER_SHOP_SERVICE						= "56244";	//숍서비스(상세정보)
	String CODE_FILTER_COUPON							= "56246";	//쿠폰(상세정보)
	String CODE_FILTER_TOUR_REG_SHOP					= "56247";	//여행등록숍(상세정보)
	String CODE_WIFI									= "56157"; 	//wifi
	String CODE_FOREIGNER_STEP							= "001";	//외국인스탭
	String CODE_EXCHANGE								= "54193";	//환전
	String CODE_BAGGAGE									= "54197";	//수화물보관
	String CODE_ATM										= "56152";	//ATM
	String CODE_TRAVEL_SELF_GOT							= "56306";  //득템상품 공유
	String CODE_NEW_GOODS_INFO							= "56309";
	String CODE_BUDGET_PER_PERSON						= "7968"; 	//1인당 예산
	String CODE_SMOKING						            = "7855"; 	//흡연
	String CODE_SMOKING_SECTION_INFO					= "57184"; 	//흡연부가정
	String CODE_ORDER_SPECIFICATION						= "57132"; 	//주문규정
	String CODE_MOBILE_PHONE_CHARGING					= "56989"; 	//핸드폰충전
	String CODE_MOBILE_PHONE_CABLE	    				= "57142"; 	//핸드케이블
	String CODE_OUTLET_INFO     	    				= "57141"; 	//콘센트정보
	String CODE_RESTROOM        	    				= "7863"; 	//화장실
	String CODE_CHILDREN        	    				= "7881"; 	//어린이동반
	String CODE_OUTFIT        	    				    = "7861"; 	//복장
	String CODE_SHOES        	    				    = "7857"; 	//신발
	String CODE_SERVICE_CHARGE        	    			= "7873"; 	//서비스요금
	String CODE_ROOM_CHARGE        	    				= "57127"; 	//개실사용
	String CODE_CORKAGE        	    				    = "57123"; 	//콜키지
	String CODE_MENUPAN_LANG        	    		    = "7882"; 	//메뉴판언어
	String CODE_MENUPAN_JP        	    		        = "7885"; 	//일본어
	String CODE_MENUPAN_KR        	    		        = "7883"; 	//한국어
	String CODE_MENUPAN_CN       	    		        = "7886"; 	//중국어간체
	String CODE_MENUPAN_CN2        	    		        = "7887"; 	//중국어번체
	String CODE_MENUPAN_EN        	    		        = "7884"; 	//영어
	String CODE_SPECIAL_MENU        	    		    = "7868"; 	//특별메뉴
	String CODE_COURSE_MENU        	    		        = "56537"; 	//코스메뉴
	String CODE_LUNCH_MENU        	    		        = "56538"; 	//런치메뉴
	String CODE_CHILDREN_MENU        	    		    = "56540"; 	//어린이 메뉴
	String CODE_NOMIHODAI_MENU        	    		    = "56539"; 	//노미호다이
	String CODE_NOMIHODAI2_MENU        	    		    = "57523"; 	//노미호다이(코스메뉴 주문시)
	String CODE_COUNTER        	    		            = "49962"; 	//카운터
	String CODE_TABLE       	    		            = "49960"; 	//테이블
	String CODE_ROOM        	    		            = "49963"; 	//개실
	String CODE_TERRACE        	    		            = "49964"; 	//테라스

	String CATEGORY_MD_NO_DRUGSTORE 					= "50230";

	String CATEGORY_LG_NO_GOURMET						= "4836";

	String CANAL_CITY_HAKATA							= "2966";

	String TYPE_SUNDAY									= "0";
	String TYPE_SATURDAY								= "6";

	String STATISTICS_QTY_10 							= "10";
	String STATISTICS_QTY_20 							= "20";
	String STATISTICS_QTY_30 							= "30";
	String STATISTICS_QTY_40 							= "40";
	String STATISTICS_QTY_50 							= "50";

	String BIC_CAMERA_COUPON_NO							= "124";
	/**
	 * Reservation Status
	 */
	String RESERVATION_WAITING							= "0";  //예약대기
	String RESERVATION_IN_PROGRESS						= "2";  //예약진행중
	String RESERVATION_DELETE							= "1";  //예약삭제
	String RESERVATION									= "10"; //예약신청완료
	String RESERVATION_COMPLETE            				= "20"; //예약확정
	/*String NO_STOCK									= "21"; //예약일부확정*/
	String NO_STOCK										= "22"; //예약불가
	String PURCHASE_COMPLETE							= "30"; //구매완료/방문완료
	String NO_SHOW										= "31"; //노쇼
	String RESERVATION_CANCEL							= "32"; //예약취소
	String COMPLETE_SETTLEMENT							= "40"; //정산완료


	/** Restaurant Reservation Status*/
	String REST_RESERVATION								= "10"; //예약신청완료
	String REST_IN_PROGRESS_RESERVATION					= "11"; //예약진행중
	String REST_RESERVATION_COMPLETE            		= "20"; //예약확정
	String REST_RESERVATION_CANCELLATION            	= "21"; //예약취소(예약신청후 예약확정안한상태에서 취소)
	String REST_RESERVATION_NO            				= "22"; //예약불가
	String REST_RESERVATION_VISITED            			= "30"; //방문완료
	String REST_RESERVATION_CANCEL            			= "31"; //예약신청취소(예약확정후 취)
	String REST_RESERVATION_NO_SHOW            			= "32"; //노쇼

	String TYPE_ALL_MENU	 							= "1";
	String TYPE_BEST_MENU 								= "2";

	String IS_TRUE 										= "1";
	String IS_FALSE 									= "0";

	String JERK                              			= "8677";

	String SENDER_ID 									= "147835156583";

	//RQT=> 리퀘스트, RT => 실시간
	String REQUEST_RESERVATION_CODE 					= "57041";
	String REAL_TIME_RESERVATION_CODE 					= "57151";

	String CURRENT_ORDER_DATE_STATUS 					= "1";
	String LAST_ORDER_DATE_STATUS						= "2";

	String[] strJp = {"あ", "か", "さ", "た", "な", "は", "ま", "や", "ら", "わ", "0~9"};
	String[] strEn = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0~9"};
	String[] strKr = {"ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ", "0~9"};
	String[] numberId = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

	String LOGIN_INFO									= "LoginInfo.txt";
	String CITY_INFO									= "CityInfo.txt";

	String MESSAGE_ERROR_LOGIN							= "Error - login!!";
	String MESSAGE_FAIL_LOGIN							= "login Fail!!";

	String TAG_MAIN	 									= "main";
	String TAG_LOGIN_SELECT								= "login_select";
	String TAG_LOGIN 									= "login";
	String TAG_SIGN_UP 									= "sign_up";
	String TAG_SNS_SIGN_UP 								= "sns_sign_up";
	String TAG_PW_FORGET								= "pw_forget";
	String TAG_BUY										= "buy";
	String TAG_GOODS_REGISTER							= "goods_register";
	String TAG_REGION_SELECT							= "region_select";
	String TAG_INTRO									= "intro";

	String CODE											= "CODE";
	String PROFILE_IMG_UPLOAD							= "PROFILE_IMG_UPLOAD";
	String PROFILE_UPDATE								= "PROFILE_UPDATE";

	String TAG_MALE										= "M";
	String TAG_FEMALE									= "F";

	String TYPE_HOUR									= "H";
	String TYPE_DAY										= "D";

	String POI_MENU_GROUP								= "pmenugroup";
	String POI_MENU_COURSE								= "pmenucourse";
	String POI_MENU_BANK								= "pmenubank";			//음식
	String POI_MENU_DRINK_BANK							= "pmenudrinkbank";		//음료
	String POI_MENU_LIQUOR_BANK							= "pmenuliquorbank";	//주류

	String MENU_GUBUN_FOOD								= "food";	//음식
	String MENU_GUBUN_DRINK								= "drink";	//음료
	String MENU_GUBUN_LIQUOR							= "liquor";	//주류

	/** Bundle and Intent String key */
	String KEY_NO										= "NO";
	String KEY_NAME										= "NAME";
	String KEY_TITLE									= "TITLE";
	String KEY_TYPE										= "TYPE";
	String KEY_SUB_TYPE									= "SUB_TYPE";
	String KEY_GO_TYPE									= "GO_TYPE";
	String KEY_GO_ACT									= "GO_ACT";
	String KEY_GUBUN 									= "GUBUN";
	String KEY_BACK_STACK								= "BACK_STACK";
	String KEY_TIP_CATEGORY_NO							= "TIP_CATEGORY_NO";
	String KEY_BRAND_NO									= "BRAND_NO";
	String KEY_BRAND_NAME								= "BRAND_NAME";
	String KEY_FILTER_SET								= "FILTER_SET";
	String KEY_PICK_NO									= "PICK_NO";
	String KEY_URL										= "URL";
	String KEY_IS_PART									= "IS_PART";
	String KEY_PART_NO									= "PART_NO";
	String KEY_FLOOR_NO									= "FLOOR_NO";
	String KEY_FLOOR_NAME								= "FLOOR_NAME";
	String KEY_SUB_NO									= "SUB_NO";
	String KEY_SUB_NAME									= "SUB_NAME";
	String KEY_HOUR										= "HOUR";
	String KEY_MINUTE									= "MINUTE";
	String KEY_TOUR_NO									= "TOUR_NO";
	String KEY_LAT										= "LAT";
	String KEY_LNG										= "LNG";
	String KEY_CITY_NO									= "CITY_NO";
	String KEY_BENEFIT									= "BENEFIT";
	String KEY_DE_NO									= "DE_NO";
	String KEY_DE_NAME									= "DE_NAME";
	String KEY_FLAG										= "FLAG";
	String KEY_KEYWORD									= "KEYWORD";
	String KEY_POI_NO									= "POI_NO";
	String KEY_POI_NAME									= "POI_NAME";
	String KEY_POI_LIST									= "POI_LIST";
	String KEY_TIP_NO									= "TIP_NO";
	String KEY_GOODS_NO									= "GOODS_NO";
	String KEY_GOODS_NAME								= "GOODS_NAME";
	String KEY_ORDER_BY									= "ORDER_BY";
	String KEY_YEAR										= "YEAR";
	String KEY_MONTH									= "MONTH";
	String KEY_DAY										= "DAY";
	String KEY_SD_START									= "SD_START";
	String KEY_SD_END									= "SD_END";
	String KEY_CATEGORY_NO								= "CATEGORY_NO";
	String KEY_CATEGORY_NAME							= "CATEGORY_NAME";
	String KEY_CATEGORY_MD_NO							= "CATEGORY_MD_NO";
	String KEY_CATEGORY_MD_NAME							= "CATEGORY_MD_NAME";
	String KEY_SHOP_FILTER_SET							= "SHOP_FILTER_SET";
	String KEY_RSV_NO									= "RSV_NO";
	String KEY_REGION_NO								= "REGION_NO";
	String KEY_SELECT									= "SELECT";
	String KEY_CAMERA_CROP								= "CAMERA_CROP";
	String KEY_CAMERA_CROP2								= "CAMERA_CROP2";
	String KEY_CURRENCY									= "CURRENCY";
	String KEY_CURRENCY_SYMBOL							= "CURRENCY_SYMBOL";
	String KEY_PRICE									= "PRICE";
	String KEY_TAX_FREE_PRICE							= "TAX_FREE_PRICE";
	String KEY_COUPON_NO								= "COUPON_NO";
	String KEY_TOUR_THEME_NO							= "TOUR_THEME_NO";
	String KEY_TOUR_THEME_NAME							= "TOUR_THEME_NAME";
	String KEY_SHOPPING_TYPE_NO							= "SHOPPING_TYPE_NO";
	String KEY_SHOPPING_TYPE_NAME						= "SHOPPING_TYPE_NAME";
	String KEY_CODE										= "CODE";
	String KEY_IS_WISH									= "IS_WISH";
	String KEY_ORDER_NO									= "ORDER_NO";
	String KEY_ORDER_DATE								= "ORDER_DATE";
	String KEY_BUSINESS_HOUR							= "BUSINESS_HOUR";
	String KEY_NAME_LOCAL								= "NAME_LOCAL";
	String KEY_RSV_END									= "RSv_END";
	String KEY_RSV_END_UNIT								= "RSV_END_UNIT";
	String KEY_HOLIDAY_NORMAL							= "HOLIDAY_NORMAL";
	String KEY_HOLIDAY_SPECIAL							= "HOLIDAY_SPECIAL";
	String KEY_BUSINESS_HOURS_ALL						= "BUSINESS_HOURS_ALL";
	String KEY_BUSINESS_HOURS_ALL_S						= "BUSINESS_HOURS_ALL_S";
	String KEY_RESERVATION_YN							= "RESERVATION_YN";
	String KEY_RESERVATION_METHOD						= "RESERVATION_METHOD";
	String KEY_VIDEO_ID						            = "VIDEO_ID";
	String KEY_REG_DATE						            = "REG_DATE";
	String KEY_MENU_NO									= "MENU_NO";
	String KEY_IS_JERK									= "IS_JERK";

	/** Bundle and Intent int key */
	String KEY_MODE										= "MODE";
	String KEY_PAGE_NO									= "PAGE_NO";
	String KEY_TOTAL_PAGE								= "TOTAL_PAGE";
	String KEY_TOTAL_COUNT								= "TOTAL_COUNT";
	String KEY_INDEX									= "INDEX";
	String KEY_STATUS									= "STATUS";
	String KEY_ACT_TYPE									= "ACT_TYPE";
	String KEY_REG_ID									= "RED_ID";

	/** Bundle and Intent boolean key*/
	String KEY_IS_START_DATE							= "IS_START_DATE";
	String KEY_IS_TRIP_REGISTER							= "IS_TRIP_REGISTER";

	/** Bundle and Intent Parcelable key */
	String KEY_SNS_INFO									= "SNS_INFO";
	String KEY_SELECT_SHOP								= "SELECT_SHOP";
	String KEY_SHOPPING_TIP_NOW							= "SHOPPING_TIP_NOW";
	String KEY_GOODS_FILTER								= "GOODS_FILTER";
	String KEY_POI_EVAL									= "POI_EVAL";
	String KEY_SET_LIST									= "SET_LIST";
	String KEY_TOUR_INFO								= "TOUR_INFO";
	String KEY_TOUR_FILTER								= "TOUR_FILTER";
	String KEY_RSV_INFO									= "RSV_INFO";
	String KEY_RSV_PICKUP_DATE							= "RSV_PICKUP_DATE";
	String KEY_SHOP_FILTER								= "SHOP_FILTER";
	String KEY_SHOP_FILTER2								= "SHOP_FILTER2";
	String KEY_SELECT_CONDITION							= "SELECT_CONDITION";
	String KEY_PIC_CROP									= "PIC_CROP";
	String KEY_BOARD_LIST								= "BOARD_LIST";
	String KEY_SERVICE_ICON								= "SERVICE_ICON";
	String KEY_COUPON_INFO 								= "COUPON_LIST";
	String KEY_COUPON_LIST 								= "COUPON_INFO";
	String KEY_SHOPPING_TIP_NOW_FILTER					= "SHOPPING_TIP_NOW_FILTER";
	String KEY_SHOP_INFO								= "SHOP_INFO";
	String KEY_SELECT_TOUR_SHOP							= "SELECT_TOUR_SHOP";
	String KEY_BRAND_ITEM								= "BRAND_ITEM";
	String KEY_SERVICE_LIST								= "SERVICE_LIST";
	String KEY_TABLE_LIST								= "TABLE_LIST";
	String KEY_RSV_DATE									= "RSV_DATE";
	String KEY_RSV_TIME									= "RSV_TIME";
	String KEY_RSV_TIME_1								= "RSV_TIME1";
	String KEY_RSV_TIME_2								= "RSV_TIME2";
	String KEY_RSV_TIME_3								= "RSV_TIME3";
	String KEY_RSV_ADULT								= "RSV_ADULT";
	String KEY_RSV_CHILD								= "RSV_CHILD";
	String KEY_RSV_MEMBER_MAX							= "RSV_MEMBER_MAX";
	String KEY_RSV_MEMBER_MIN							= "RSV_MEMBER_MIN";
	String KEY_RSV_REQUEST								= "RAV_REQUEST";
	String KEY_RSV_REQUEST_NO							= "RAV_REQUEST_NO";
	String KEY_RSV_REQUEST_NAME							= "RAV_REQUEST_NAME";
	String KEY_RSV_CATION								= "RSV_CATION";
	String KEY_RSV_DAY_OF_WEEK							= "DAY_OF_WEEK";
	String KEY_MENUPAN_INFO								= "MENUPAN_INFO";
	String KEY_LIQUOR_INFO								= "LIQUOR_INFO";
	String KEY_MENU_COUNTER								= "MENU_COUNTER";
	String KEY_USE_WIFI									= "USE_WIFI";
	String KEY_RECOMMEND_GOURMET_INFO					= "GOURMET_INFO";
	String KEY_NECESSARY_MENU_INFO						= "NECESSARY_MENU_INFO";
	String KEY_RSV_OPTION_START_DATE                    = "rsv_option_start_date";
	String KEY_RSV_OPTION_END_DATE                      = "rsv_option_end_date";
	String KEY_SNS_TYPE                     			= "sns_type";
	String KEY_SNS_ID                      				= "sns_id";
	String KEY_PHONE     			                 	= "phone";
	String KEY_USER_NAME                      			= "user_name";
	String KEY_IS_SUGGEST                      			= "is_suggest";
	String KEY_OLD_RSV_NO                      			= "old_rsv_no";
	String KEY_EAT_STIME                     			= "eat_stime";
	String KEY_EAT_ETIME                     			= "eat_etime";

	/** Bundle ParcelableArrayList key **/
	String KEY_PART_LIST								= "PART_LIST";
	String KEY_FLOOR_LIST								= "FLOOR_LIST";
	String KEY_FILE_URL									= "FILE_URL";
	String KEY_MALL_LIST								= "MALL_LIST";
	String KEY_CATEGORY_LIST							= "CATEGORY_LIST";
	String KEY_BRAND_LIST								= "BRAND_LIST";
	String KEY_SHOP_LIST								= "SHOP_LIST";
	String KEY_FILE_LIST								= "FILE_LIST";
	String KEY_MALL_INFO								= "MALL_INFO";
	String KEY_PHOTO_LIST								= "PHOTO_LIST";
	String KEY_CATEGORY									= "CATEGORY";
	String KEY_CATEGORY_MD_LIST							= "CATEGORY_MD_LIST";
	String KEY_REGION_LIST								= "REGION_LIST";
	String KEY_EQUIP_LIST								= "EQUIP_LIST";
	String KEY_GOODS_INFO								= "GOODS_LIST";
	String KEY_GOODS_LIST								= "GOODS_INFO";
	String KEY_PICTURE									= "PICTURE";
	String KEY_TIP_LIST									= "TIP_LIST";
	String KEY_EVAL_LIST								= "EVAL_LIST";
	String KEY_TIP_CATEGORY_LIST						= "TIP_CATEGORY_LIST";
	String KEY_SELECT_PICTURE							= "SELECT_PICTURE";
	String KEY_KEYWORD_LIST								= "KEYWORD_LIST";
	String KEY_STATIC_LIST								= "STATIC_LIST";
	String KEY_RAIL_LIST								= "RAIL_LIST";
	String KEY_BUSINESS_HOUR_WEEK						= "BUSINESS_HOUR_WEEK";
	String KEY_REST_COURSE_MENU_LIST					= "REST_COURSE_MENU_LIST";
	String KEY_REST_ORDER_CAUTION						= "REST_ORDER_CAUTION";
	String KEY_RECOMMEND_MUST_EAT						= "RECOMMEND_MUST_EAT";
	String KEY_RECOMMEND_REST_LIST						= "RECOMMEND_REST_LIST";
	String KEY_REST_MALL_LIST							= "REST_MALL_LIST";
	String KEY_REST_BRAND_LIST							= "REST_BRAND_LIST";

	/** dialog tag*/
	String DIALOG_TAG_SERVICE_INSPECTION				= "SERVICE_INSPECTION";
	String DIALOG_TAG_CAUTION							= "CAUTION";
	String DIALOG_TAG_CONFIRM							= "CONFIRM";
	String DIALOG_TAG_CART_DELETE						= "CART_DELETE";
	String DIALOG_TAG_LEAVE								= "LEAVE";
	String DIALOG_TAG_TEXT2								= "TEXT2";
	String DIALOG_TAG_MOVE_TOUR_INFO					= "MOVE_TOUR_INFO";
	String DIALOG_TAG_NOTICE							= "NOTICE";
	String DIALOG_TAG_PERMISSION						= "PERMISSION";
	String DIALOG_TAG_PERMISSION2						= "PERMISSION2";
	String DIALOG_TAG_PRICE_COMMENT						= "PRICE_COMMENT";
	String DIALOG_TAG_S_COMMENT							= "S_COMMENT";
	String DIALOG_TAG_DELETE							= "DELETE";
	String DIALOG_TAG_BRAND_DELETE						= "BRAND_DELETE";
	String DIALOG_TAG_TOUR_DELETE						= "TOUR_DELETE";
	String DIALOG_TAG_UPDATE							= "UPDATE";
	String DIALOG_TAG_WISH_GOODS						= "WISH_GOODS";
	String DIALOG_TAG_WISH_SHOP							= "WISH_SHOP";
	String DIALOG_TAG_WISH_COUPON						= "WISH_COUPON";
	String DIALOG_TAG_GOODS_CART						= "GOODS_CART";
	String DIALOG_TAG_COUNTRY_LIST						= "COUNTRY_LIST";
	String DIALOG_TAG_BIRTHDAY_LIST						= "BIRTHDAY_LIST";
	String DIALOG_TAG_LIST								= "LIST";
	String DIALOG_TAG_LIST2								= "LIST2";
	String DIALOG_TAG_PROFILE							= "PROFILE";
	String DIALOG_TAG_PASSWORD							= "PASSWORD";
	String DIALOG_TAG_SEX								= "SEX";
	String DIALOG_TAG_RADIO_BUTTON						= "RADIO_BUTTON";
	String DIALOG_TAG_ADULT_LIST						= "ADULT_LIST";
	String DIALOG_TAG_CHILD_LIST						= "CHILD_LIST";
	String DIALOG_TAG_CANCEL							= "CANCEL";
	String DIALOG_TAG_BACK								= "BACK";
	String DIALOG_TAG_RESERVATION						= "reservation";

	/** api param key*/
	String PARAM_KEY_NO_TOUR							= "no_tour";
	String PARAM_KEY_TOUR_NO							= "tour_no";
	String PARAM_KEY_USER_NO							= "user_no";
	String PARAM_KEY_GOODS_NO							= "goods_no";
	String PARAM_KEY_GOODS_NAME							= "goods_name";
	String PARAM_KEY_GOODS_NOTE							= "goods_note";
	String PARAM_KEY_REGION								= "region";
	String PARAM_KEY_SHOPPING_NO 						= "shopping_no";
	String PARAM_KEY_MODE								= "mode";
	String PARAM_KEY_POI_NO								= "poi_no";
	String PARAM_KEY_POI_NAME							= "poi_name";
	String PARAM_KEY_QUANTITY							= "quantity";
	String PARAM_KEY_PRICE_NO							= "price_no";
	String PARAM_KEY_PRICE								= "price";
	String PARAM_KEY_TAX_PRICE							= "tax_price";
	String PARAM_KEY_CURRENCY							= "currency";
	String PARAM_KEY_SYMBOL								= "symbol";
	String PARAM_KEY_LANG								= "lang";
	String PARAM_KEY_GUBUN								= "gubun";
	String PARAM_KEY_COUPON_NO							= "coupon_no";
	String PARAM_KEY_BRAND_NO							= "brand_no";
	String PARAM_KEY_VAL								= "val";
	String PARAM_KEY_CATEGORY_NO						= "category_no";
	String PARAM_KEY_REG_DATE							= "reg_date";
	String PARAM_KEY_TIP_NO								= "tip_no";
	String PARAM_KEY_USER_EMAIL							= "user_email";
	String PARAM_KEY_USER_PASSWORD						= "user_pwd";
	String PARAM_KEY_API_ID								= "api_id";
	String PARAM_KEY_API_SITE							= "api_site";
	String PARAM_KEY_LAT								= "lat";
	String PARAM_KEY_LNG								= "lng";
	String PARAM_KEY_MYPOS_X							= "mypos_x";
	String PARAM_KEY_MYPOS_Y							= "mypos_y";
	String PARAM_KEY_XPOS								= "xpos";
	String PARAM_KEY_YPOS								= "ypos";
	String PARAM_KEY_MB_OS								= "mb_os";
	String PARAM_KEY_NOHEAD 							= "nohead";
	String PARAM_KEY_OS									= "os";
	String PARAM_KEY_USER_ID							= "user_id";
	String PARAM_KEY_SEX								= "sex";
	String PARAM_KEY_BIRTHDAY							= "birthday";
	String PARAM_KEY_COUNTRY_NO							= "country_no";
	String PARAM_KEY_FLAG								= "flag";
	String PARAM_KEY_RSV_DATE							= "rsv_date";
	String PARAM_KEY_TAX_FREE_PRICE						= "tax_free_price";
	String PARAM_KEY_BUY_DATE							= "buy_date";
	String PARAM_KEY_NO									= "no";
	String PARAM_KEY_GOODS_SCORE						= "goods_score";
	String PARAM_KEY_CLERK_SCORE						= "clerk_score";
	String PARAM_KEY_INTERIOR_SCORE						= "interior_score";
	String PARAM_KEY_RSV_NO								= "rsv_no";
	String PARAM_KEY_SHOP_PRICE							= "shop_price";
	String PARAM_KEY_RSV_PRICE							= "rsv_price";
	String PARAM_KEY_TAX_RSV_PRICE						= "tax_rsv_price";
	String PARAM_KEY_URL_NO								= "url_no";
	String PARAM_KEY_REASON_NO							= "reason_no";
	String PARAM_KEY_REASON_TEXT						= "reason_text";
	String PARAM_KEY_T									= "t";
	String PARAM_KEY_ACTION								= "action";
	String PARAM_KEY_CK_USER_NO							= "ck_user_no";
	String PARAM_KEY_CK_CD_LANG							= "ck_cd_lang";
	String PARAM_KEY_NM_TOUR							= "nm_tour";
	String PARAM_KEY_SD_START							= "sd_start";
	String PARAM_KEY_SD_END								= "sd_end";
	String PARAM_KEY_NM_CITY							= "nm_city";
	String PARAM_KEY_TOUR_CITY							= "tour_city";
	String PARAM_KEY_TOUR_TYPE							= "tour_type";
	String PARAM_KEY_TOUR_KWD							= "tour_kwd";
	String PARAM_KEY_MN_PLAN							= "mn_plan";
	String PARAM_KEY_CURRENCY_CODE						= "curr_code";
	String PARAM_KEY_CD_CURRENCY						= "cd_curr";
	String PARAM_KEY_SHOP_TYPE							= "shop_type";
	String PARAM_KEY_SHOP_TYPE_NAME						= "shop_type_name";
	String PARAM_KEY_YN_SHOW							= "yn_show";
	String PARAM_KEY_FORM_DATE_ID						= "form_date_id";
	String PARAM_KEY_TEL_NO								= "tel_no";
	String PARAM_KEY_CERTI_NO							= "certi_no";
	String PARAM_KEY_VISIT_DATE							= "visit_date";
	String PARAM_KEY_VISIT_TIME							= "visit_time";
	String PARAM_KEY_PICK_NO							= "pick_no";
	String PARAM_KEY_MEMBER_NO							= "member_no";
	String PARAM_KEY_CITY_LANG							= "city_lang";
	String PARAM_KEY_PAGE								= "page";
	String PARAM_KEY_DISTANCE							= "distance";
	String PARAM_KEY_DE_NO								= "de_no";
	String PARAM_KEY_USE_TAX							= "use_tax";
	String PARAM_KEY_USE_CARD							= "use_card";
	String PARAM_KEY_USE_ALIPAY							= "use_alipay";
	String PARAM_KEY_USE_WECHATPAY						= "use_wechatpay";
	String PARAM_KEY_USE_UNIONPAY						= "use_unionpay";
	String PARAM_KEY_CATEGORY_MD_NO						= "category_md_no";
	String PARAM_KEY_ORDER_BY							= "orderby";
	String PARAM_KEY_COUPON_YN							= "coupon_yn";
	String PARAM_KEY_POI_LIST							= "poi_list";
	String PARAM_KEY_ID									= "id";
	String PARAM_KEY_SEND								= "send";
	String PARAM_KEY_EMAIL								= "email";
	String PARAM_KEY_NAME								= "name";
	String PARAM_KEY_RESOLUTION							= "resolution";
	String PARAM_KEY_REGION_NO							= "region_no";
	String PARAM_KEY_CITY_NO							= "city_no";
	String PARAM_KEY_PARENT_TYPE						= "parent_type";
	String PARAM_KEY_PARENT_NO							= "parent_no";
	String PARAM_KEY_KEY_LANG							= "key_lang";
	String PARAM_KEY_KEY								= "key";
	String PARAM_KEY_CATEGORY							= "category";
	String PARAM_KEY_SORT_TYPE							= "sort_type";
	String PARAM_KEY_PER_PAGE							= "per_page";
	String PARAM_KEY_ROOT_NAME							= "root_name";
	String PARAM_KEY_ROOT_LOCAL_NAME					= "root_local_name";
	String PARAM_KEY_ALL								= "all";
	String PARAM_KEY_PLAN								= "plan";
	String PARAM_KEY_IS_ALL								= "is_all";
	String PARAM_KEY_IS_FAVORITE						= "is_favo";
	String PARAM_KEY_FILE_NO							= "file_no";
	String PARAM_KEY_SUB_VIEW							= "sub_view";
	String PARAM_KEY_FLOOR_NO							= "floor_no";
	String PARAM_KEY_SUB_NO								= "sub_no";
	String PARAM_KEY_POI_GROUP_NO						= "poi_group_no";
	String PARAM_KEY_THEME_NO							= "theme_no";
	String PARAM_KEY_CODE_NO							= "code_no";
	String PARAM_KEY_SEARCH_KWD							= "search_kwd";
	String PARAM_KEY_RESERVE_PRICE						= "reserve_price";
	String PARAM_KEY_AMOUNT								= "amount";
	String PARAM_KEY_STATUS								= "status";
	String PARAM_KEY_BARCODE							= "barcode";
	String PARAM_KEY_DEVICE_TOKEN						= "device_token";
	String PARAM_KEY_DEVICE_FLAG						= "device_flag";
	String PARAM_KEY_UUID								= "uuid";
	String PARAM_KEY_USER_FLAG							= "user_flag";
	String PARAM_KEY_UP_FILE							= "upfile";
	String PARAM_KEY_USER_DATE							= "user_date";
	String PARAM_KEY_NARA_NO							= "nara_no";
	String PARAM_KEY_OWNER_NO							= "owner_no";
	String PARAM_KEY_OWNER_NAME							= "owner_name";
	String PARAM_KEY_POI_RESERVATION_CODE				= "poi_reservation_code";
	String PARAM_KEY_SM_NO								= "sm_no";
	String PARAM_KEY_CODE								= "code";
	String PARAM_KEY_MENU_PAN_NO						= "menupan_no";
	String PARAM_KEY_ORDER_NO							= "order_no";
	String PARAM_KEY_CURRENT_PW							= "current_pswd";
	String PARAM_KEY_NEW_PW								= "new_pswd";
	String PARAM_KEY_USE_WIFI							= "wifi";
	String PARAM_KEY_NO_SMOKE							= "smoke";
	String PARAM_KEY_LUNCH_MENU							= "lunch";
	String PARAM_KEY_PRIVATE_ROOM						= "private";
	String PARAM_KEY_KID								= "kid";
	String PARAM_KEY_CHARGE								= "charge";
	String PARAM_KEY_TAKEOUT							= "takeout";
	String PARAM_KEY_RSV_TIME							= "rsv_time";
	String PARAM_KEY_ADULT								= "adult";
	String PARAM_KEY_CHILD								= "child";
	String PARAM_KEY_USER_NAME							= "user_name";
	String PARAM_KEY_USER_PHONE							= "user_phone";
	String PARAM_KEY_RSV_REQUEST						= "rsv_request";
	String PARAM_KEY_MENU_GUBUN							= "menu_gubun";
	String PARAM_KEY_SNS_TYPE							= "sns_type";
	String PARAM_KEY_SNS_ID								= "sns_id";
	String PARAM_KEY_CANCEL_CODE						= "cancel_code";
	String PARAM_KEY_LIST_SCALE							= "list_scale";
	String PARAM_KEY_MENU_NO							= "menu_no";
	String PARAM_KEY_ACCESS_TOKEN						= "access_token";
	String PARAM_KEY_UID								= "uid";
	String PARAM_KEY_APPID								= "appid";
	String PARAM_KEY_SECRET								= "secret";
	String PARAM_KEY_GRANT_TYPE							= "grant_type";
	String PARAM_KEY_OPENID								= "openid";
	String PARAM_KEY_ORDER_ARR							= "order_arr";
	String PARAM_KEY_START_DATE							= "start_date";
	String PARAM_KEY_END_DATE							= "end_date";
	String PARAM_KEY_OLD_RSV_NO							= "old_rsv_no";
	String PARAM_KEY_EAT_START_TIME						= "eat_stime";
	String PARAM_KEY_EAT_END_TIME						= "eat_etime";

	String URL_WIFI_DOSIRAK								= "http://www.widemobile.com/?surf";

	/** Weibo, WeChat user infoRest api*/
	String URL_USER_SHOW								= "https://api.weibo.com/2/users/show.json?";
	String URL_WECHAT_ACCESS_TOKEN						= "https://api.weixin.qq.com/sns/oauth2/access_token?";
	String URL_WECHAT_USER_INFO							= "https://api.weixin.qq.com/sns/userinfo?";

	/** Line ID*/
	String CHANNEL_ID 									= "1594783393";

	String SERVER_URL                                  	= "kimokwoophp.godohosting.com/school";
	String SERVER_URL_REAL                             	= "http://" + SERVER_URL + "/api/";
	String SERVER_URL_REAL1                             = "http://" + SERVER_URL + "/api3/";
	String URL_MAIN_2 									= "http://api.travelomap.com";

	String URL_COUNTRYLIST	 							= "/data/app/smartmall/mypage/get_surf_countries.php?";
	String URL_SIGN_UP 									= "/data/app/surf/surf_user_save.php";
	String URL_FORGET_PASSWD 							= "/data/app/surf/forget_passwd.php?";
	String URL_SURF_IMAGE_UPLOAD						= "/data/app/surf/surf_profile_photo.php";
	String URL_CHANGE_PW 								= "/data/app/surf/pswd_update.php?";
	String URL_SURF_USER_UPDATE							= "/data/app/surf/surf_user_update.php";
	String Url_PUSH_DEVICE_REG							= "/data/app/surf/push/push_device_registration.php?";

	String URL_LOGIN 									= "mobile_login.php";
	String URL_LOGOUT 									= "mobile_logout.php";

	String URL_GET_CODE									= "/data/app/surf/code/get_codes.php?";
	String URL_COUNTRY_LIST	 							= "/data/app/smartmall/mypage/get_surf_countries.php?";
	String URL_SPECIAL_PICK								= "/data/app/smartmall/specialpick_list.php?";
	String URL_MUST_BUY_CATEGORY			 			= "/data/app/surf/surf_must_buy_cate.php?";
	String URL_SPECIAL_PICK_ITEM						= "/data/app/smartmall/specialpick_item_list.php?";
	String URL_BRAND_LIST								= "/data/app/smartmall/brand/brand_list.php?";
	String URL_MEMBER_LEAVE								= "/data/app/surf/surf_user_delete.php?";
	String URL_SURF_TOUR_SAVE 							= "/data/app/surf/surf_tour_save.php";
	String URL_SURF_CURRENCY							= "/data/app/surf/code/get_currency.php?";
	String URL_MENU_PAN_LIST							= "/data/app/smartmall/restaurant/menupan_list.php?";

	String URL_LOGIN2 									= "mobile_login.php";
	String URL_CITY										= "get_city_list.php";
	String URL_CITY_HOME								= "city_main.php?";
	String URL_GOURMET_HOME								= "gourmet_main.php?";
	String URL_MY_PAGE									= "get_mypage.php";
	String URL_GET_RECOMMEND_SHOP_LIST					= "get_recommend_shop_list.php?";
	String URL_GET_RECOMMEND_SHOP_INFO					= "get_recommend_shop_info.php?";
	String URL_GET_SHOP_INFO							= "get_shop_info.php?";
	String URL_GET_CITY_BEST							= "get_city_best.php?";
	String URL_GET_RELATION_LIST						= "get_goods_by_relation.php?";
	String URL_GET_SHOP_BY_GOODS						= "get_shoplist_by_goods.php?";
	String URL_GET_GOODS_BY_SHOP						= "get_goods_by_shop.php?";
	String URL_GET_PUBLIC_COUPON_LIST					= "get_public_couponlist.php?";
	String URL_GET_PUBLIC_COUPON_VIEW					= "get_public_couponview.php?";
	String URL_GET_PUBLIC_COUPON_SHOP_LIST				= "get_public_coupon_shoplist.php?";
	String URL_GET_PUBLIC_COUPON_SHOP_VIEW				= "get_public_couponview_shop.php?";
	String URL_GET_MY_TOUR								= "get_mytour.php?";
	String URL_GET_SHOPPING_TOUR_LIST					= "get_shopping_tourlist.php?";
	String URL_GET_USER_SHOP_LIST						= "get_user_shop_list.php?";
	String URL_GET_USER_GOODS_LIST						= "get_user_goods_list.php?";
	String URL_GET_BEST_ITEM_LIST						= "get_best_item_list.php?";
	String URL_GET_CITY_GOODS							= "get_city_goods.php?";
	String URL_GET_RECOMMEND_MALL_LIST					= "get_recommend_mall_list.php?";
	String URL_GET_RECOMMEND_MAll_INFO					= "get_recommend_mall_info.php?";
	String URL_GET_RECOMMEND_COUPON_VIEW				= "get_recommend_couponview.php?";
	String URL_GET_SURF_SHOPPING_TIP_NOW_SHOP_LIST		= "get_surf_shopping_tipnow_shoplist.php?";
	String URL_GET_SURF_SHOPPING_TIP_NOW_LIST			= "get_surf_shopping_tipnow_list.php?";
	String URL_GET_SURF_SHOPPING_TIP_NOW_INFO			= "get_surf_shopping_tipnow_info.php?";
	String URL_GET_SURF_SHOPPING_TIP_NOW_COMMENT		= "get_surf_shopping_tipnow_comment.php?";
	String URL_GET_MALL_FLOOR_LIST						= "get_mall_floor_list.php?";
	String URL_GET_MALL_FLOOR_MAP_VIEW					= "get_mall_floor_map_view.php?";
	String URL_GET_BRAND_LIST							= "get_brand_list.php?";
	String URL_GET_BRAND_SHOP_LIST						= "get_brand_shop_list.php?";
	String URL_GET_BRAND_SHOP_LIST2						= "get_brand_shop_list2.php?";
	String URL_GET_THEME_LIST							= "get_theme_list.php?";
	String URL_GET_THEME_SHOP_LIST						= "get_theme_shop_list.php?";
	String URL_GET_REGION_LIST							= "get_region_list.php?";
	String URL_GET_DRUG_STORE_LIST						= "get_drugstore_list.php?";
	String URL_GET_GOODS_BY_TOUR						= "get_goods_by_tour.php?";
	String URL_GET_SHOPPING_LIST_BY_TOUR				= "get_shoppinglist_by_tour.php?";
	String URL_GET_SHOP_BY_TOUR							= "get_shop_by_tour.php?";
	String URL_GET_SHOP_SEARCH							= "get_shop_search.php?";
	String URL_GET_SURF_POI_EVAL_LIST					= "get_surf_poi_eval_list.php?";
	String URL_SET_SURF_POI_EVAL_DELETE					= "set_surf_poi_eval_delete.php";
	String URL_GET_MY_TOUR_INFO							= "get_mytour_info.php?";
	String URL_GET_SHOP_LIST_BY_TOUR					= "get_shoplist_by_tour.php?";
	String URL_GET_POI_LIST_BY_TOUR						= "get_poilist_by_tour.php?";
	String URL_GET_SURF_USER_PUBLIC_COUPON_LIST			= "get_surf_user_public_couponlist.php?";
	String URL_GET_SHOPPING_RESERVATION_BRIDGE			= "get_shopping_reservation_bridge.php?";
	String URL_GET_SHOPPING_RESERVATION_GOODS_LIST		= "get_shopping_reservation_goods_list.php?";
	String URL_GET_SHOPPING_RESERVATION_LIST			= "get_shopping_reservation_list.php?";
	String URL_GET_SHOPPING_RESERVATION_GOODS_CART		= "get_shopping_reservation_goods_cart.php?";
	String URL_GET_SHOPPING_RESERVATION_VOUCHER			= "get_shopping_reservation_voucher.php?";
	String URL_GET_SHOPPING_RESERVATION_INFO			= "get_shopping_reservation_info.php?";
	String URL_GET_BARCODE_BRIDGE						= "get_barcode_bridge.php?";
	String URL_GET_SEARCH_RESULT						= "get_search_result.php?";
	String URL_GET_SMS_CERTIFICATION 					= "get_sms_certi.php?";
	String URL_GET_SMS_CERTIFICATION_NO 				= "get_sms_certi_no.php?";
	String URL_GET_TELEPHONE_API						= "get_telephone_api.php?";
	String URL_GET_SEARCH_BRAND_LIST					= "get_search_brand_list.php?";
	String URL_GET_SEARCH_BRAND_SHOP_LIST				= "get_brand_search_shop_list.php?";
	String URL_GET_SEARCH_BRAND_MALL_LIST				= "get_search_brand_mall_list.php?";
	String URL_GET_VERSION								= "get_version.php";
	String URL_GET_SHOPPING_RESERVATION_PICKUP_DATE		= "get_shopping_rserve_pickupdate_list.php?";
	String URL_GET_RESERVATION_STATUS_SERVICE			= "get_reservation_status_service.php?";
	String URL_GET_GOODS_INFO							= "get_goods_info.php?";
	String URL_GET_NOW_TOUR_LIST						= "get_now_tourlist.php?";
	String URL_GET_TOUR_GOODS_SHOP_LIST					= "get_tour_goods_shoplist.php";
	String URL_GET_RECOMMEND_GOURMET_LIST				= "get_recommend_gourmet_list.php";
	String URL_GET_RECOMMEND_GOURMET_INFO				= "get_recommend_gourmet_info2.php?";
	String URL_GET_RECOMMEND_GOURMET_INFO3				= "get_recommend_gourmet_info3.php?";
	String URL_GET_BRAND_FOOD_LIST						= "get_brand_food_list.php?";
	String URL_GET_MALL_REST_HOME						= "get_mall_rest_home.php?";
	String URL_GET_RECOMMEND_REST_MALL_LIST				= "get_recommend_rtmall_list.php";
	String URL_GET_RECOMMEND_REST_MALL_INFO				= "get_recommend_rtmall_info.php";
	String URL_GET_POI_MENU_PAN_LIST					= "get_poi_menupan_list.php?";
	String URL_GET_POI_MENU_PAN_LIST_GUBUN				= "get_poi_menupan_list_gubun.php?";
	String URL_GET_POI_MENU_PAN_LIST_GROUP				= "get_poi_menupan_list_group.php?";
	String URL_GET_POI_MENU_PAN_LIST_GROUP2				= "get_poi_menupan_list_group2.php?";
	String URL_GET_POI_REPRESENTATIVE_MENU				= "get_poi_representative_menu.php?";
	String URL_GET_SURF_USER_MENU_ORDER					= "get_surf_user_menu_order.php";
	String URL_GET_SURF_USER_MENU_ORDER_LIST			= "get_surf_user_morder_list.php";
	String URL_GET_SURF_MUST_EAT_MENU_LIST				= "get_surf_musteat_menu_list.php?";
	String URL_GET_SURF_MUST_EAT_LIST					= "get_surf_musteat_list.php?";
	String URL_GET_RECOMMEND_REST_DETAIL_SERVICE		= "get_recommend_rest_detail_service.php";
	String URL_GET_USER_REST_LIST						= "get_user_rest_list.php";
	String URL_GET_SURF_REST_RESERVATION_LIST			= "get_surf_rest_reservation_list.php";
	String URL_GET_SURF_RESERVATION_INFO				= "get_surf_rest_reservation_info.php";
	String URL_GET_POI_BEST_MENU_LIST					= "get_poi_best_menu_list.php";
	String URL_GET_SURF_REST_RESERVATION_TERMS			= "get_surf_rest_reservation_terms.php";
	String URL_GET_USER_MY_ORDER						= "get_user_myorder.php?";
	String URL_GET_SURF_REST_ORDER_CAUTION				= "get_surf_rest_order_caution.php?";
	String URL_GET_TELEPHONE_API2						= "get_telephone_api2.php?";
	String URL_GET_RECOMMEND_GOURMET_PHOTO_LIST			= "get_recommend_gourmet_photo_list.php";
	String URL_GET_POI_MENU_PAN_IMG 					= "get_poi_menupan_img.php?";
	String URL_GET_BUSINESS_HOUR						= "wave_info_businesshour3.php";

	String URL_SET_RESERVATION_SHOPPING_GOODS_PROC		= "set_reservation_shopping_goods_proc.php?";
	String URL_SET_SHOPPING_RESERVATION_AMOUNT_UPDATE	= "set_reservation_shopping_amount_update.php?";
	String URL_SET_RESERVATION_SHOPPING_MAKE_RNO		= "set_reservation_shopping_make_rno.php?";
	String URL_SET_TOUR_REG								= "set_tourreg.php";
	String URL_SET_DELETE								= "set_delete_tour.php?";
	String URL_SET_TOUR_SHOP							= "set_tour_shop.php?";
	String URL_SET_TOUR_GOODS							= "set_tour_item.php?";
	String URL_SET_TOUR_BRAND							= "set_tour_brand.php?";
	String URL_SET_SURF_USER_PUBLIC_COUPON_SAVE_DELETE 	= "set_surf_user_public_coupon_save_delete.php?";
	String URL_SET_SURF_SHOPPING_TIP_NOW_COMMENT_SAVE 	= "set_surf_shopping_tipnow_comment_save.php";
	String URL_SET_SURF_SHOPPING_TIP_NOW_NOTIFY_SAVE 	= "set_surf_shopping_tipnow_notify_save.php";
	String URL_SET_SHOPPING_TIP_NOW_LIKE				= "set_shopping_tipnow_like.php?";
	String URL_SET_SHOPPING_TIP_FILE_DEL				= "set_surf_shopping_tipnow_file_del.php?";
	String URL_SET_SURF_SHOPPING_TIP_NOW_DELETE			= "set_surf_shopping_tipnow_delete.php?";
	String URL_SET_SURF_SHOPPING_TIP_NOW_SAVE			= "set_surf_shopping_tipnow_save.php";
	String URL_SET_SURF_SHOPPING_TIP_COMMENT_DELETE		= "set_surf_shopping_tipnow_comment_delete.php";
	String URL_SET_PRICE_REPORT							= "set_price_report.php";
	String URL_SET_SURF_POI_EVAL_SAVE					= "set_surf_poi_eval_save.php";
	String URL_SET_SURF_POI_EVAL_FILE_DEL				= "set_surf_poi_eval_file_del.php?";
	String URL_SET_SURF_USER_TOUR_GOODS_SAVE			= "set_surf_user_tour_goods_save.php";
	String URL_SET_SURF_USER_TOUR_GOODS_UPDATE			= "set_surf_user_tour_goods_update.php";
	String URL_SET_SURF_USER_TOUR_GOODS_DELETE			= "set_surf_user_tour_goods_delete.php";
	String URL_SET_SURF_USER_TOUR_FILE_DELETE			= "set_surf_user_tour_goods_file_del.php";
	String URL_SET_SURF_RESERVATION_STATUS_10			= "set_surf_reservation_status_10.php";
	String URL_SET_SURF_RESERVATION_STATUS_CANCEL		= "set_surf_reservation_status_cancel.php";
	String URL_SET_SURF_RESERVATION_STATUS_DELETE		= "set_surf_reservation_status_delete.php";
	String URL_SET_RESERVATION_SHOPPING_UPDATE_RNO		= "set_reservation_shopping_update_rno.php";
	String URL_SET_SURF_USER_MENU_ORDER					= "set_surf_user_menu_order.php";
	String URL_SET_SURF_USER_MENU_UPDATE				= "set_surf_user_menu_update.php";
	String URL_SET_SURF_USER_MENU_DELETE				= "set_surf_user_menu_delete.php";
	String URL_SET_SURF_USER_MENU_AMOUNT				= "set_surf_user_menu_amount.php";
	String URL_SET_REST_RESERVATION_PROC				= "set_rest_reservation_proc.php";
	String URL_SET_REST_RESERVATION_CANCEL 				= "set_surf_rest_reservation_cancel.php";
	String URL_GET_GOURMET_LIST 						= "get_gourmet_lst.php";
	String URL_GET_REST_INFO							= "get_rest_info.php";


	String URL_GET_BUS_ROUTE_INFO						= "api_busroutine.php";
	String URL_GET_BULLETIN_LIST						= "api_getbulletinlist.php";
	String URL_GET_FOOD_LIST							= "api_getfoodlist.php";
	String URL_GET_RECOMMEND_FOOD						= "api_getrecommendfoodlist.php";
	String URL_GET_MY_INFO								= "api_getmyinfo.php";
	String URL_UPDATE_MY_INFO							= "api_updatemyinfo.php";
	String URL_UPDATE_MENU_REVIEW						= "api_updatemenureview.php";
	String URL_UPDATE_RECOMMEND_REVIEW					= "api_updaterecommendreview.php";
	String URL_ADD_RECOMMEND_FOOD						= "api_addrecommendfood.php";
	String USER_NO										= "user_no";


}

