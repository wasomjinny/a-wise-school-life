package com.smart.school.app.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

/**스크롤 막는 ViewPager*/
public class CustomViewPager extends ViewPager{

	private boolean enabled;
	
	public CustomViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.enabled = false;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		try {
			if(this.enabled){
				return super.onTouchEvent(arg0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		if(this.enabled){
			return super.onInterceptTouchEvent(arg0);
		}
		return false;
	}

	public void setPagingEnabled() { //이 메소드를 이용해서 스크롤을 풀어주고
		this.enabled = true;
	}

	public void setPagingDisabled() { //이 메소드를 이용해서 스크롤을 막아줍니다.
		this.enabled = false;
	}	
}
