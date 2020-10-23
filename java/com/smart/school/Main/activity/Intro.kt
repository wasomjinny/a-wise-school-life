package com.smart.school.Main.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.smart.school.R
import com.smart.school.adapter.item.IntroItem
import com.smart.school.app.config.iConfig
import com.smart.school.login.Login
import com.smart.school.school.adapter.CustomPagerAdapter
import java.util.*

class Intro : BaseActivity(), OnPageChangeListener, View.OnClickListener {
    private var mViewPager //화면에 4개의 페이지를 스크롤 할 수 있도록 하는데 사용
            : ViewPager? = null
    private val mIv_Dot = arrayOfNulls<ImageView>(4)
    private var mArrImg: ArrayList<IntroItem>? = null
    private var mArrRes: ArrayList<IntArray>? = null
    private var mRequestManager: RequestManager? = null
    private val strId = arrayOfNulls<String>(4)
    private val nId_Iv = intArrayOf(R.id.iv_intro_dot_1, R.id.iv_intro_dot_2, R.id.iv_intro_dot_3, R.id.iv_intro_dot_4)
    private val nId_Img = intArrayOf(R.drawable.step03_01, R.drawable.step03_02, R.drawable.step03_03, R.drawable.step02_04)
    private val nId_Img2 = intArrayOf(R.drawable.step03_01, R.drawable.step03_02, R.drawable.step03_03, R.drawable.step02_04)
    private val nId_Img3 = intArrayOf(R.drawable.step03_01, R.drawable.step03_02, R.drawable.step03_03, R.drawable.step02_04)
    private val nId_Img4 = intArrayOf(R.drawable.step03_01, R.drawable.step03_02, R.drawable.step03_03, R.drawable.step02_04)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        if (config.activities == null) { //현재 열려있는 Activity가 비어있다면
            config.setActivities() //Activity ArrayList를 생성하고
            config.activities.add(this@Intro) //intro 액티비티를 ArrayList에 추가
        } else {
            config.activities.add(this@Intro)
        }
        initView()
    }

    private fun initView() {
        mRequestManager = Glide.with(this) //그림을 띄우게 하는 용
        mViewPager = findViewById(R.id.viewpager)
        findViewById<View>(R.id.btn_intro_login).setOnClickListener(this) //로그인 버튼을 클릭하면
        for (i in nId_Iv.indices) {
            mIv_Dot[i] = findViewById(nId_Iv[i])
        }
        mIv_Dot[0]!!.setBackgroundResource(R.drawable.dot_select) //처음 화면을 들어가면 첫번째 Dot가 선택되로록
        setContent()
        mViewPager!!.addOnPageChangeListener(this)
    }

    private fun setContent() {
        val imgId = (Math.random() * 4).toInt() //0,1,2,3중 랜덤으로 정해짐
        mArrRes = ArrayList() //내용물이 정수의 배열인 ArrayList
        mArrRes!!.add(nId_Img) //사진묶음 1
        mArrRes!!.add(nId_Img2)
        mArrRes!!.add(nId_Img3)
        mArrRes!!.add(nId_Img4)
        strId[0] = "학교생활에서 꼭 필요한 기능만 모았어요." //각 페이지별로 나타날 문구
        strId[1] = "코로나19에 학교생활 많이 힘드시죠."
        strId[2] = "여러분의 학교생활을 즐겁게 만들어 드릴께요."
        strId[3] = "슬기로운 학교생활과 함께하세요."
        mArrImg = ArrayList()
        for (i in 0..3) {
            val item = IntroItem(mArrRes!![imgId][i], strId[i]) //사진과 문구 ArrayList 만듬
            mArrImg!!.add(item)
        }
        initList(mArrImg!!)
    }

    private fun initList(arr: ArrayList<IntroItem>) {
        if (arr.size > 0) {
            val mAdapter = CustomPagerAdapter(this@Intro, R.layout.row_intro, arr, mRequestManager)
            mViewPager!!.adapter = mAdapter //Adapter를 만들어 ViewPager실행
            mViewPager!!.offscreenPageLimit = 1
        }
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
    //페이지가 선택되면 점이 빨간색으로 바뀌게
    override fun onPageSelected(position: Int) {
        for (i in nId_Iv.indices) {
            mIv_Dot[i]!!.setBackgroundResource(R.drawable.dot_normal)
        }
        mIv_Dot[position]!!.setBackgroundResource(R.drawable.dot_select)
    }

    override fun onPageScrollStateChanged(state: Int) {}
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_intro_login -> {
                //로그민 버튼을 클릭했을 때
                val intent = Intent(this@Intro, Login::class.java) //login 자바파일로 링크
                intent.putExtra(iConfig.KEY_TYPE, iConfig.TAG_LOGIN)
                intent.putExtra(iConfig.KEY_GO_ACT, iConfig.TAG_REGION_SELECT)
                startActivity(intent)
            }
        }
    }

    override fun onDestroy() { //        unregisterReceiver();
        super.onDestroy()
    }
}