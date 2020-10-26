package com.smart.school.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import com.smart.school.Main.activity.BaseActivity
import com.smart.school.R
import com.smart.school.app.config.iConfig
import com.smart.school.school.SchoolMain
import com.smart.school.school.item.LoginItem
import com.smart.school.school.item.LoginResponse
import com.smart.school.util.BackPressCloseHandler
import com.smart.school.util.NetworkUtils
import com.smart.school.util.helper.ToastHelper
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class Login : BaseActivity() , Callback<LoginResponse>{
    private val TAG_ID = 0
    private val TAG_PASSWORD = 1
    private var gubun = "1"
    private var mArrLogin: ArrayList<LoginItem>? = null
    private var strId = ""
    private var strPw = ""
    private var strSitePw = ""
    var backPressCloseHandler: BackPressCloseHandler? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        if (config.activities == null) {
            config.setActivities()
            config.activities.add(this@Login)
        } else {
            config.activities.add(this@Login)
        }

        attrEditText(et_id.edit_text, "ID", iConfig.INPUT_TYPE_TEXT)
        attrEditText(et_pw.edit_text, "비밀번호", iConfig.INPUT_TYPE_TEXT or iConfig.INPUT_TYPE_PASSWORD)
        et_id.btn_clear.tag = TAG_ID
        et_pw.btn_clear.tag = TAG_PASSWORD
        et_id.edit_text.imeOptions = EditorInfo.IME_ACTION_NEXT
        et_pw.edit_text.imeOptions = EditorInfo.IME_ACTION_NEXT
        rg_gubun.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            gubun = if (i == R.id.rb_gubun1) {
                "1" //학생이 선택되면 1로 새팅
            } else {
                "2" //선생으로 선택되면 2로 세팅
            }
        })
        //취소아이콘을 클릭했을 때
        et_id.btn_clear.setOnClickListener{et_id.textClear()}
        et_pw.btn_clear.setOnClickListener{et_pw.textClear()}
        ll_login_back.setOnClickListener {
            finish()
        }
        btn_login.setOnClickListener {
            setLogin()
        }
        backPressCloseHandler = BackPressCloseHandler(this)
    }

    private fun setLogin() {
        if (TextUtils.isEmpty(et_id.edittextGetText())) {
            ToastHelper.showToast(this, getString(R.string.s1))
            return
        }
        if (TextUtils.isEmpty(et_pw.edittextGetText())) {
            ToastHelper.showToast(this, getString(R.string.s2))
            return
        }
        strId = et_id.edittextGetText()
        strPw = et_pw.edittextGetText()
        strSitePw = gubun
        loadLogin(strId, strPw,strSitePw)
    }

    private fun loadLogin(id: String, pw: String, sitePw: String) {
        progressbar.visibility = View.VISIBLE  //진행상태바 표시
        if (NetworkUtils.isConnected(this)) {
            Log.d("signal", "id: " + id +",pw:"+pw+", gubun: "+sitePw)
            val call : Call<LoginResponse> = apiService.login(id, pw, sitePw)
            call.enqueue(this)
            Log.d("comm", "request " + call.request())
        }else{
            ToastHelper.showToast(this, getString(R.string.s17))
        }//mobile_login.php파일을 실행하여 결과를 가져온다.
    }

    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
        t.printStackTrace()
    }
    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
        mArrLogin = ArrayList()
        config.removeLoginInfo(this@Login) //기존 로그인 정보를 버린다.
        config.removeLoginCheck(this@Login) //기존 로그인 체트 정보를 버린다.
        Log.d("success", "실행됨")
        if (response.isSuccessful) {
            val loginResponse = response.body()
            if (loginResponse != null) {
                mArrLogin!!.add(loginResponse.getResult())
                if (loginResponse.getCode() == iConfig.JSON_SUCCESS) {
                    progressbar.visibility = View.GONE //진행상태바 감춤
                    config.setLoginInfo(this@Login, mArrLogin) //새로운 로그인 정보를 저장한다.
                    config.setLoginCheck(this@Login, true) //로그인 체크를 true로 설정
                    Toast.makeText(this@Login, getString(R.string.s16), Toast.LENGTH_SHORT).show()
                    goActivity() //로그인에 성공하면 goActivity()로 이동
                } else {
                    progressbar.visibility = View.GONE //진행상태바 감춤
                    Toast.makeText(this@Login, loginResponse.getMessage(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    public override fun onStart() {
        super.onStart()
    }

    public override fun onStop() {
        super.onStop()
    }

    public override fun onResume() {
        super.onResume()
    }

    public override fun onPause() {
        super.onPause()
    }

    public override fun onDestroy() {
        super.onDestroy()
    }

    private fun deleteActivity() { //config에 싸여있는 엑티비티 목록을 지운다.
        for (i in config.activities.indices) {
            config.activities[i].finish()
        }
    }

    private fun goActivity() {
        val intent = Intent(this@Login, SchoolMain::class.java)
        startActivity(intent)
        deleteActivity()
    }



    override fun onBackPressed() {
        backPressCloseHandler!!.onBackPressed()
    }

    //사용자정의 editText 사용하기
    private fun attrEditText(et: EditText, hint: String, inputType: Int) {
        et.textSize = 14f
        et.setTextColor(this.resources.getColor(R.color.color_323232))
        et.hint = hint
        et.setBackgroundColor(Color.TRANSPARENT)
        et.inputType = inputType
        et.gravity = Gravity.CENTER_VERTICAL
        et_id.btn_clear.tag = TAG_ID
    }
}