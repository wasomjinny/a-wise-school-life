package com.smart.school.app.config;

import android.app.Activity;
import android.content.Context;

import com.smart.school.school.item.LoginItem;
import com.smart.school.util.helper.CSharedPreferencesHelper;

import org.json.JSONException;

import java.util.ArrayList;

public class Config {
	private static volatile Config _theInstance;

	//로그인정보
	private ArrayList<LoginItem> mArrLoginInfo = null;


	private ArrayList<Activity> activities;

	//인스턴스 생성(싱글톤)
	public static Config getInstance() {
		if (_theInstance == null) {
			_theInstance = new Config();
		}
		return _theInstance;
	}


	public void setActivities() {
		activities = new ArrayList<>();
	}

	public ArrayList<Activity> getActivities() {
		return activities;
	}

	//로그인 정보 세팅
	public void setLoginInfo(Context ctx, ArrayList<LoginItem> items) {
		this.mArrLoginInfo = items;
		//시용자 정의 SharedPreferences
		CSharedPreferencesHelper.setValueLogin(ctx, "Login_Info", mArrLoginInfo);
	}

	//로그인 정보 추출해냄
	public LoginItem getLoginInfo(Context ctx) {
		return getLoginInfo(ctx, 0);
	}

	//로그인 정보 삭제(로그아웃을 실행했을 때
	public void removeLoginInfo(Context ctx) {
		CSharedPreferencesHelper.removeValueLoginInfo(ctx, "Login_Info");
	}

	//로그인 정보 추출해냄(오버로딩)
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

	//로그인 상태로 세팅
	public void setLoginCheck(Context ctx, boolean value) {
		CSharedPreferencesHelper.setValue(ctx, "LOGIN", "CHECK_LOGIN", value);

		if (!value) {
			CSharedPreferencesHelper.removeValueLoginInfo(ctx, "Login_Info");
		}
	}

	//로그인이 되어 있는지 검사
	public boolean isLoginCheck(Context ctx) {
		return CSharedPreferencesHelper.getValue(ctx, "LOGIN", "CHECK_LOGIN", false);
	}

	//로그인 상태 해제
	public void removeLoginCheck(Context ctx) {
		CSharedPreferencesHelper.removeValue(ctx, "LOGIN", "CHECK_LOGIN");
	}

}
