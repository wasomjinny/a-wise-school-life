package com.smart.school.Main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.smart.school.R;
import com.smart.school.adapter.item.IntroItem;
import com.smart.school.app.config.iConfig;
import com.smart.school.login.Login;
import com.smart.school.school.adapter.CustomPagerAdapter;
import com.smart.school.school.item.LoginItem;

import java.util.ArrayList;

public class Intro extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener{

    private ViewPager            mViewPager;  //화면에 4개의 페이지를 스크롤 할 수 있도록 하는데 사용
    //private View                 mView_Progressbar;
    private constant int numberOfItem = 4;
    private ImageView[] mIv_Dot = new ImageView[numberOfItem];

    private ArrayList<LoginItem> mArrLogin;
    private ArrayList<IntroItem> mArrImg;
    private ArrayList<int[]>     mArrRes;

    private RequestManager      mRequestManager;

    private String[] strId = new String[numberOfItem];

    private int[] nId_Iv = {R.id.iv_intro_dot_1, R.id.iv_intro_dot_2, R.id.iv_intro_dot_3, R.id.iv_intro_dot_4};
    private int[] nId_Img = {R.drawable.step03_01, R.drawable.step03_02, R.drawable.step03_03, R.drawable.step02_04};
    private int[] nId_Img2 = {R.drawable.step03_01, R.drawable.step03_02, R.drawable.step03_03, R.drawable.step02_04};
    private int[] nId_Img3 = {R.drawable.step03_01, R.drawable.step03_02, R.drawable.step03_03, R.drawable.step02_04};
    private int[] nId_Img4 = {R.drawable.step03_01, R.drawable.step03_02, R.drawable.step03_03, R.drawable.step02_04};
   



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_intro);

        if (config.getActivities() == null) {  //현재 열려있는 Activity가 비어있다면
            config.setActivities();  //Activity ArrayList를 생성하고
            config.getActivities().add(Intro.this);  //intro 액티비티를 ArrayList에 추가
        }else {
            config.getActivities().add(Intro.this);
        }


        initView();

    }

    private void initView() {


        mRequestManager     = Glide.with(this);

        mViewPager          = findViewById(R.id.viewpager);
        //mView_Progressbar   = findViewById(R.id.view_progressbar);

        findViewById(R.id.btn_intro_login).setOnClickListener(this); //로그인 버튼을 클릭하면

        for (int i = 0; i < nId_Iv.length; i++) {
            mIv_Dot[i] = findViewById(nId_Iv[i]);
        }
        mIv_Dot[0].setBackgroundResource(R.drawable.dot_select); //처음 화면을 들어가면 첫번째 Dot가 선택되로록

        setContent();

        mViewPager.addOnPageChangeListener(this);
    }

    private void setContent(){
        int imgId = (int) (Math.random() * 4);  //0,1,2,3중 랜덤으로 정해짐

        mArrRes = new ArrayList<>();   //내용물이 정수의 배열인 ArrayList
        mArrRes.add(nId_Img);  //사진묶음 1
        mArrRes.add(nId_Img2);
        mArrRes.add(nId_Img3);
        mArrRes.add(nId_Img4);

        strId[0] =  "학교생활에서 꼭 필요한 기능만 모았어요.";  //각 페이지별로 나타날 문구
        strId[1] =  "코로나19에 학교생활 많이 힘드시죠.";
        strId[2] =  "여러분의 학교생활을 즐겁게 만들어 드릴께요.";
        strId[3] =  "슬기로운 학교생활과 함께하세요.";

        mArrImg = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            IntroItem item = new IntroItem(mArrRes.get(imgId)[i],  strId[i]);  //사진과 문구 ArrayList 만듬
            mArrImg.add(item);
        }
        initList(mArrImg);
    }

    private void initList(ArrayList<IntroItem> arr) {
        if(arr.size() > 0) {
            CustomPagerAdapter mAdapter = new CustomPagerAdapter(Intro.this, R.layout.row_intro, arr, mRequestManager);
            mViewPager.setAdapter(mAdapter);  //Adapter를 만들어 ViewPager실행
            mViewPager.setOffscreenPageLimit(1);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < nId_Iv.length; i++) {
            mIv_Dot[i].setBackgroundResource(R.drawable.dot_normal);
        }
        mIv_Dot[position].setBackgroundResource(R.drawable.dot_select);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_intro_login: {  //로그민 버튼을 클릭했을 때
                Intent intent = new Intent(Intro.this, Login.class);  //login 자바파일로 링크
                intent.putExtra(iConfig.KEY_TYPE, iConfig.TAG_LOGIN);
                intent.putExtra(iConfig.KEY_GO_ACT, iConfig.TAG_REGION_SELECT);
                startActivity(intent);
            }
            break;

        }
    }

    @Override
    protected void onDestroy() {
//        unregisterReceiver();
        super.onDestroy();
    }

}
