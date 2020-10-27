package com.smart.school.Main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.smart.school.R;
import com.smart.school.app.config.Config;
import com.smart.school.school.SchoolMain;

/**
 * Loading
 */
public class Loading extends AppCompatActivity{

    private Handler     mHandler;
    private Config      config = Config.getInstance();  //singleton 생성

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_loading);

        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mHandler.removeCallbacks(mRunnable);
        if(mHandler != null) {
            mHandler.removeMessages(0);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void initView(){
        //비행기를 무한대로 돌리기
        FrameLayout mFl_Intro = findViewById(R.id.fl_intro);

        Animation rotation = AnimationUtils.loadAnimation(this, R.anim.anime_rotation);
        rotation.setRepeatCount(Animation.INFINITE);
        mFl_Intro.startAnimation(rotation);
        //intro 화면으로 가기
        goIntro();

    }

    private void goIntro(){
        Runnable mRunnable = new Runnable(){

            @Override
            public void run() {
                if (config.isLoginCheck(Loading.this)) {  //로그인이 되어 있으면
                    Intent intent = new Intent(Loading.this, SchoolMain.class);  //스쿨메인으로 이동
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();

                } else {
                    Intent intent = new Intent(Loading.this, Intro.class);  //intro로 이동
                    startActivity(intent);
                    finish();
                }
            }
        };
        mHandler = new Handler();
        mHandler.postDelayed(mRunnable, 3000); //3초 딜레이 후 mRunnable 실행하기
    }

}
