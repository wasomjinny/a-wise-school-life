package com.smart.school.app.config;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

import com.smart.school.school.item.LoginItem;
import com.smart.school.util.helper.CSharedPreferencesHelper;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Locale;

public class Config {
	private static volatile Config _theInstance;

	/*private final String TEST_LAT = "35.677067";
	private final String TEST_LNG = "139.7373586";*/

	private String strLang = "kr";

	private Location location;

	private ArrayList<LoginItem> mArrLoginInfo = null;


	private ArrayList<Activity> activities;

	public static Config getInstance() {
		if (_theInstance == null) {
			_theInstance = new Config();
		}
		return _theInstance;
	}

	public boolean checkGpsService(Context ctx) {
		LocationManager locationManager = (LocationManager) ctx.getSystemService(Context.LOCATION_SERVICE);
		return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
	}

	public void setActivities() {
		activities = new ArrayList<>();
	}

	public ArrayList<Activity> getActivities() {
		return activities;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location paramLocation) {
		this.location = paramLocation;
	}

	public void setLoginInfo(Context ctx, ArrayList<LoginItem> items) {
		this.mArrLoginInfo = items;
		CSharedPreferencesHelper.setValueLogin(ctx, "Login_Info", mArrLoginInfo);
	}


	public LoginItem getLoginInfo(Context ctx) {
		return getLoginInfo(ctx, 0);
	}


	public void removeLoginInfo(Context ctx) {
		CSharedPreferencesHelper.removeValueLoginInfo(ctx, "Login_Info");
	}

	public LoginItem getLoginInfo(Context ctx, int index) {
		mArrLoginInfo = new ArrayList<>();
		try {
			mArrLoginInfo = CSharedPreferencesHelper.getValueLogin(ctx, "Login_Info");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		if (mArrLoginInfo.isEmpty()) {
			return null;
		}

		return mArrLoginInfo.get(index);
	}

	public void setLoginCheck(Context ctx, boolean value) {
		CSharedPreferencesHelper.setValue(ctx, "LOGIN", "CHECK_LOGIN", value);

		if (!value) {
			CSharedPreferencesHelper.removeValueLoginInfo(ctx, "Login_Info");
		}
	}

	public boolean isLoginCheck(Context ctx) {
		return CSharedPreferencesHelper.getValue(ctx, "LOGIN", "CHECK_LOGIN", false);
	}

	public void removeLoginCheck(Context ctx) {
		CSharedPreferencesHelper.removeValue(ctx, "LOGIN", "CHECK_LOGIN");
	}

	public void setCityNo(Context ctx, String region_no) {
		CSharedPreferencesHelper.setValue(ctx, "SURF", "REGION", region_no);
	}

	public String getCityNo(Context ctx) {
		return CSharedPreferencesHelper.getValue(ctx, "SURF", "REGION", "");
	}

	public void setLangPos(Context ctx, int langPos) {
		CSharedPreferencesHelper.setValue(ctx, "LANG", "LANG_POS", langPos);
	}

	public int getLangPos(Context ctx) {
		return CSharedPreferencesHelper.getValue(ctx, "LANG", "LANG_POS", -1);
	}



	public String getLat(Context ctx) throws NullPointerException {
		return CSharedPreferencesHelper.getValue(ctx, "SURF", iConfig.KEY_LAT, "");
//		return String.valueOf(33.590664);
	}

	public String getLng(Context ctx) throws NullPointerException {
		return CSharedPreferencesHelper.getValue(ctx, "SURF", iConfig.KEY_LNG, "");
//		return String.valueOf(130.398924);
	}


	public void setLang(Activity activity, String lang) {

		if (strLang != null && !strLang.equals(lang)) {

			if (lang.equals(iConfig.LANG_NAME_KOREA2)) {
				lang = iConfig.LANG_NAME_KOREA;
			} else if (lang.equals(iConfig.LANG_NAME_JAPAN2)) {
				lang = iConfig.LANG_NAME_JAPAN;
			}
			CSharedPreferencesHelper.setValue(activity, "SURF", "LANGUAGE", lang);

			strLang = lang;
			setLanguageConfiguration(activity, lang);
		}
	}

	@SuppressLint("NewApi")
	private void setLanguageConfiguration(Activity activity, String lang) {

		Locale locale = null;
		switch (lang) {
			case iConfig.LANG_NAME_ENGLISH: {
				locale = Locale.ENGLISH;
				break;
				
			}
			

			case iConfig.LANG_NAME_JAPAN:
			case iConfig.LANG_NAME_JAPAN2: {
				locale = Locale.JAPANESE;
				break;
			}
			

			case iConfig.LANG_NAME_KOREA:
			case iConfig.LANG_NAME_KOREA2: {
				locale = Locale.KOREA;
				break;
			
			}
			

			case iConfig.LANG_NAME_CN: {
				locale = Locale.CHINA;
				break;
			}
			

			case iConfig.LANG_NAME_TW: {
				locale = Locale.TAIWAN;
				break;
			}
			default:
				locale = Locale.KOREA;
				break
		}

		Resources activityRes = activity.getBaseContext().getResources();
		Configuration activityConf = activityRes.getConfiguration();
		activityConf.setLocale(locale);
		activityRes.updateConfiguration(activityConf, activityRes.getDisplayMetrics());

		Log.e("comm", "locales : " + activityConf.getLocales());

		//TODO
		// targetSdkVersion 27 이라 activity.createConfigurationContext(activityConf) 적용할 수 있음
		// targetSdkVersion 28 부터는 android.content.Context.createConfigurationContext(configuration) 적용 가능
		/*activity.createConfigurationContext(activityConf);
		Log.d("comm", "" + activity.getBaseContext());
		activity.getBaseContext().createConfigurationContext(activityConf);*/
	}


	public String getLanguage(Context ctx) {

		if (strLang == null) {
			Locale locale = ctx.getResources().getConfiguration().locale;
			String strLanguage = locale.getLanguage();
			strLang = CSharedPreferencesHelper.getValue(ctx, "SURF", "LANGUAGE", strLanguage);
		}
		return strLang;
	}

	public String getCityLang(Context context) {
		String cityLang = "";
		String cityNo = CSharedPreferencesHelper.getValue(context, "SURF", "NARA_NO", "");
		if (cityNo.equals(iConfig.CODE_KOREA)) {
			cityLang = iConfig.LANG_NAME_KOREA3;
		} else if (cityNo.equals(iConfig.CODE_JAPAN)) {
			cityLang = iConfig.LANG_NAME_JAPAN3;
		}
		return cityLang;
	}
}
