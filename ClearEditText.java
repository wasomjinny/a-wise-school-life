package com.smart.school.app.widget;


import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.smart.school.R;
import com.smart.school.util.helper.KeyboardHelper;


public class ClearEditText extends RelativeLayout implements OnClickListener{

	public LayoutInflater inflater = null;
	public EditText edit_text;
	public Button btn_clear;

	public boolean isDetail = false;

	public ClearEditText(Context context) {
		super(context);
		initViews();
	}

	public ClearEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		initViews();
	}

	public ClearEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initViews();
	}

	private void initViews() {

		inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.clearable_edit_text, this, true);
		edit_text = (EditText) findViewById(R.id.clearable_edit);
		btn_clear = findViewById(R.id.clearable_button_clear);

		edit_text.setTag(getId());
		btn_clear.setTag(getId());

		btn_clear.setVisibility(RelativeLayout.INVISIBLE);
		showHideClearButton();
//		edit_text.setOnEditorActionListener(this);
	}

	public void setClickable(boolean isClick){
		edit_text.setClickable(isClick);
		edit_text.setEnabled(isClick);
		edit_text.setHint("");
	}

	public void showHideClearButton() {

		edit_text.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if(!isDetail){
					if (s.length() > 0)
						btn_clear.setVisibility(RelativeLayout.VISIBLE);
					else
						btn_clear.setVisibility(RelativeLayout.INVISIBLE);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});
	}

	public void textClear(){
		edit_text.setText("");
	}

	//도움말 삭제 뷰
	public void layoutGone(LinearLayout layout){

		edit_text.setText("");

		if(layout != null){
			layout.setVisibility(View.GONE);
		}

	}

	public void EditTextBackground(int res){

		edit_text.setBackgroundResource(res);

	}

	public Editable getText() {
		Editable text = edit_text.getText();
		return text;
	}

	public void setMaxLength(EditText et, int maxLength){
		InputFilter[] FilterArray = new InputFilter[1];
		FilterArray[0] = new InputFilter.LengthFilter(maxLength);
		et.setFilters(FilterArray);
	}

	public void buttonClear(boolean isDetail){
		btn_clear.setVisibility(View.GONE);
		this.isDetail = isDetail;
	}

	public void setLayoutParams(int width, int height){
		edit_text.setLayoutParams(new LayoutParams(width, height));
	}

	/**
	 * EditText의 String값 return
	 * @return
	 */
	public String edittextGetText(){
		return edit_text.getText().toString();
	}

	public int getLength(){
		return edittextGetText().length();
	}

	/**
	 * clear 버튼 클릭 이벤트
	 */
	public void setClearEditText(){
		btn_clear.setOnClickListener(this);
	}

	/**
	 *
	 * @param nAction ImeOptions 셋팅
	 */
	public void setIME_ACTION(int nAction){
		edit_text.setImeOptions(nAction);
	}

	/**
	 *
	 * @param hint EditText 힌트
	 */
	public void setHint(String hint){
		edit_text.setHint(hint);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		textClear();
	}

	public void hideKeyboard(Activity act){
		KeyboardHelper.hideKeyboard(act, edit_text);
	}
}