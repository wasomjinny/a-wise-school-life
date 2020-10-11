package com.smart.school.school.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.smart.school.Main.activity.OnFragmentClickListener;
import com.smart.school.Main.activity.OnFragmentReplaceListener;
import com.smart.school.R;
import com.smart.school.app.config.iConfig;
import com.smart.school.app.widget.ClearEditText;
import com.smart.school.util.helper.ToastHelper;

/**
 * Created by art on 2016-04-21.
 */
public class LoginFragment extends BaseFragment implements OnFragmentReplaceListener, View.OnClickListener{

    private final int       TAG_EMAIL     = 0;
    private final int       TAG_PASSWORD  = 1;
    private final int       TAG_SITEPASSWORD = 2;

    private ClearEditText   mCet_Email;
    private ClearEditText   mCet_Pw;
    private RadioGroup rg_gubun;
    private RadioButton rb_gubun1, rb_gubun2;
    private String gubun = "1";

    private OnFragmentClickListener mListener;

    private AppCompatActivity mAct;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_login, container, false);

        mCet_Email  = view.findViewById(R.id.clearedittext_login_email);
        mCet_Pw     = view.findViewById(R.id.clearedittext_login_pw);
        rg_gubun = view.findViewById(R.id.rg_gubun);
        rb_gubun1 = view.findViewById(R.id.rb_gubun1);
        rb_gubun2 = view.findViewById(R.id.rb_gubun2);

        view.findViewById(R.id.fl_login_back).setOnClickListener(this);
        view.findViewById(R.id.tv_login_pw_forget).setOnClickListener(this);  //추후 사용을 위해 숨김처리
        view.findViewById(R.id.tv_login_sign_up).setOnClickListener(this);  //추후 사용을 위해 숨김처리
        view.findViewById(R.id.btn_login_confirm).setOnClickListener(this);

        attrEditText(mCet_Email.edit_text, "ID", iConfig.INPUT_TYPE_TEXT | iConfig.INPUT_TYPE_EMAIL);
        attrEditText(mCet_Pw.edit_text, "비밀번호", iConfig.INPUT_TYPE_TEXT | iConfig.INPUT_TYPE_PASSWORD);

        mCet_Email.btn_clear.setTag(TAG_EMAIL);
        mCet_Pw.btn_clear.setTag(TAG_PASSWORD);


        mCet_Email.edit_text.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        mCet_Pw.edit_text.setImeOptions(EditorInfo.IME_ACTION_NEXT);

        rg_gubun.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.rb_gubun1){
                    gubun="1";  //학생이 선택되면 1로 새팅

                } else {
                    gubun="2";  //선생으로 선택되면 2로 세팅

                }

            }
        });

        mCet_Email.btn_clear.setOnClickListener(this);  //지우는 버튼 클릭
        mCet_Pw.btn_clear.setOnClickListener(this);

        return view;
    }

    private void attrEditText(EditText et, String hint, int inputType){
        et.setTextSize(14f);
        et.setTextColor(mAct.getResources().getColor(R.color.color_323232));
        et.setHint(hint);
        et.setBackgroundColor(Color.TRANSPARENT);
        et.setInputType(inputType);
        et.setGravity(Gravity.CENTER_VERTICAL);

        mCet_Email.btn_clear.setTag(TAG_EMAIL);
    }

    private void setLogin(){
        if(TextUtils.isEmpty(mCet_Email.edittextGetText())){
            ToastHelper.showToast(mAct, getString(R.string.s1));
            return;
        }

        if(TextUtils.isEmpty(mCet_Pw.edittextGetText())){
            ToastHelper.showToast(mAct, getString(R.string.s2));
            return;
        }


        String[] str = new String[3];
        str[0] = mCet_Email.edittextGetText();
        str[1] = mCet_Pw.edittextGetText();
        str[2] = gubun;
        mListener.onFragmentClick(R.id.btn_login_confirm, str);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof AppCompatActivity){
            mAct = (AppCompatActivity)context;
        }
        if (context instanceof OnFragmentClickListener){
            mListener = (OnFragmentClickListener)context;
        }
    }

    @Override
    public void onFragmentReplace(String tag) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_login_sign_up:
            {
                mListener.onFragmentClick(R.id.tv_login_sign_up);
            }
            break;

            case R.id.tv_login_pw_forget:
            {
                mListener.onFragmentClick(R.id.tv_login_pw_forget);
            }
            break;

            case R.id.clearable_button_clear:
            {
                int val = (Integer)v.getTag();
                switch (val){
                    case TAG_EMAIL:
                    {
                        mCet_Email.textClear();
                    }
                    break;

                    case TAG_PASSWORD:
                    {
                        mCet_Pw.textClear();
                    }
                    break;

                }
            }
            break;

            case R.id.fl_login_back:
            {
                mAct.finish();
            }
            break;

            case R.id.btn_login_confirm:
            {
                setLogin();
            }
            break;
        }
    }
}