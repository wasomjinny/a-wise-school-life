package com.smart.school.Main.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.smart.school.R
import com.smart.school.app.config.Config
import com.smart.school.school.SchoolMain

/**
 * Loading
 */
class Loading : AppCompatActivity() {
    private var mHandler: Handler? = null
    private val config = Config.getInstance() //singleton 생성
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        initView()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        //        mHandler.removeCallbacks(mRunnable);
        if (mHandler != null) {
            mHandler!!.removeMessages(0)
        }
    }

    override fun onStart() {
        super.onStart()
    }

    private fun initView() { //비행기를 무한대로 돌리기
        val mFl_Intro = findViewById<FrameLayout>(R.id.fl_intro)
        val rotation = AnimationUtils.loadAnimation(this, R.anim.anime_rotation)
        rotation.repeatCount = Animation.INFINITE
        mFl_Intro.startAnimation(rotation)
        //intro 화면으로 가기
        goIntro()
    }

    private fun goIntro() {
        val mRunnable = Runnable {
            if (config.isLoginCheck(this@Loading)) { //로그인이 되어 있으면
                val intent = Intent(this@Loading, SchoolMain::class.java) //스쿨메인으로 이동
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this@Loading, Intro::class.java) //intro로 이동
                startActivity(intent)
                finish()
            }
        }
        mHandler = Handler()
        mHandler!!.postDelayed(mRunnable, 5000) //3초 딜레이 후 mRunnable 실행하기
    }
}