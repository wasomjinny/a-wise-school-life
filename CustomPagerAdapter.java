package com.smart.school.school.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.smart.school.R;
import com.smart.school.adapter.item.IntroItem;

import java.util.List;

/**
 * Created by art on 2017-03-28.
 */

public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    private int RES_ID_LAYOUT;
    private List<IntroItem> mList;
    private String mType;

    private RequestManager mRequestManager;

    public CustomPagerAdapter(Context context, int res, List<IntroItem> arr, RequestManager requestManager){
        mContext = context;
        RES_ID_LAYOUT = res;
        mList = arr;
        mRequestManager = requestManager;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = View.inflate(mContext, RES_ID_LAYOUT, null);

        ImageView mIv_Bg = view.findViewById(R.id.iv_intro_bg);
        TextView mTv_Msg = view.findViewById(R.id.iv_intro_msg);

        IntroItem item = mList.get(position);
        if(item != null) {

            mRequestManager.load(item.getnImg())
                    .override(480, 860)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(mIv_Bg);

            mTv_Msg.setText(item.getStrMsg());
        }

        container.addView(view, 0);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override
    public void destroyItem(@NonNull View pager, int position, @NonNull Object view) {
        ((ViewPager) pager).removeView((View) view);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) { }

    @Override
    public void finishUpdate(@NonNull View container) { }

    @Override
    public void startUpdate(@NonNull View container) {}

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}