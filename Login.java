package com.smart.school.login;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.smart.school.Main.activity.BaseActivity;
import com.smart.school.Main.activity.OnFragmentClickListener;
import com.smart.school.Main.activity.OnFragmentReplaceListener;
import com.smart.school.R;
import com.smart.school.app.config.iConfig;
import com.smart.school.dialog.CDialog;
import com.smart.school.dialog.CDialogReturnItem;
import com.smart.school.school.SchoolMain;
import com.smart.school.school.fragment.LoginFragment;
import com.smart.school.school.item.LoginItem;
import com.smart.school.school.item.LoginResponse;
import com.smart.school.util.NetworkUtils;
import com.smart.school.util.helper.ToastHelper;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends BaseActivity implements OnFragmentReplaceListener, CDialog.CDialogListener, OnFragmentClickListener{

    private ArrayList<LoginItem>        mArrLogin;

    private String 						strEmail		= "";
    private String 						strPw		    = "";
    private String                      strSitePw       = "";
    private String						strTag  		= iConfig.TAG_LOGIN;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.color_ff7200));
        }
        setContentView(R.layout.activity_login);

        if(config.getActivities() == null){
            config.setActivities();
            config.getActivities().add(Login.this);
        }else {
            config.getActivities().add(Login.this);
        }

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            strTag          = bundle.getString(iConfig.KEY_TYPE);
        }

        initView();
    }

    private void initView(){

        changeFragment(strTag);
    }

    private void changeFragment(String tag){
        switch (tag){

            case iConfig.TAG_LOGIN:
            {
                LoginFragment mLoginFragment = new LoginFragment();
                setTransaction(mLoginFragment, tag);
            }
            break;

        }
    }

    private void loadLogin(String id, String pw, String sitePw){


        if(NetworkUtils.isConnected(this)) {
            HashMap<String, String> loginMap = new HashMap<>();
            loginMap.put("user_id", id);  //id
            loginMap.put("user_pwd", pw); //pw
            loginMap.put("site_pswd", sitePw);  //학생인지, 선생인지 라디오 버튼 값

            Call<LoginResponse> call = apiService.login(loginMap);  //mobile_login.php파일을 실행하여 결과를 가져온다.
            Log.d("comm", "" + call.request());
            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                    mArrLogin = new ArrayList<>();
                    config.removeLoginInfo(Login.this);  //기존 로그인 정보를 버린다.
                    config.removeLoginCheck(Login.this);  //기존 로그인 체트 정보를 버린다.

                    if (response.isSuccessful()) {
                        LoginResponse loginResponse = response.body();
                        if(loginResponse != null) {
                            mArrLogin.add(loginResponse.getResult());

                            if (loginResponse.getCode() == iConfig.JSON_SUCCESS) {
                                config.setLoginInfo(Login.this, mArrLogin);  //세로운 로그인 정보를 저장한다.
                                config.setLoginCheck(Login.this, true);  //로그인 체크를 true로 설정

                                ToastHelper.showToast(Login.this, getString(R.string.s16));
                                goActivity();  //로그인에 성공하면 goActivity()로 이동
                            } else {
                                ToastHelper.showToast(Login.this, loginResponse.getMessage());
                            }
                        }
                    }
                }

                @Override
                public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                    t.printStackTrace();
                }
            });
        }else{
            Toast.makeText(this, getString(R.string.s17), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    private void deleteActivity(){  //config에 싸여있는 엑티비티 목록을 지운다.
        for (int i = 0; i < config.getActivities().size(); i++) {
            config.getActivities().get(i).finish();
        }
    }

    private void goActivity(){
        Intent intent = new Intent(Login.this, SchoolMain.class);
        startActivity(intent);
        deleteActivity();
    }

    @Override
    public void onFragmentClick(int id) {

    }

    @Override
    public void onFragmentClick(int id, String... str) {
        switch (id){
            case R.id.btn_login_confirm:
            {
                strEmail = str[0];
                strPw = str[1];
                strSitePw = str[2];
                loadLogin(strEmail, strPw, strSitePw);
            }
            break;

        }
    }

    @Override
    public void onFragmentClick(int id, int pos) {

    }

    @Override
    public void onFragmentClick(String id, String str) {

    }

    @Override
    public void onFragmentClick(int id, Object object) {

    }


    @Override
    public void onFragmentReplace(String tag) {
        strTag = tag;
        switch (tag){

            case iConfig.TAG_LOGIN:
            {
                changeFragment(tag);
            }
            break;

            default:
                finish();
        }
    }


    @Override
    public void onFragmentClick(int id, int pos, Object object) {

    }


    @Override
    public void onDialogClick(DialogFragment dialog) {
        CDialogReturnItem item = ((CDialog)dialog).getReturn();

        switch (item.getFlag()) {

            case FLAG_TEXT:
            {
            }
            break;
        }
    }

    @Override
    public void onBackPressed() {

        switch (strTag) {
            case iConfig.TAG_LOGIN: {
                finish();
            }
            break;
        }

    }
}
