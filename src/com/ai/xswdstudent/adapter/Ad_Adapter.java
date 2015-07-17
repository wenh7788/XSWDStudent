package com.ai.xswdstudent.adapter;

import java.util.List;
import com.viewpagerindicator.IconPagerAdapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;

public class Ad_Adapter extends PagerAdapter implements IconPagerAdapter{

	
	private List<ImageView> listAdView;
	private Context mContext;
	
	public Ad_Adapter(List<ImageView> listAdView, Context mContext) {
		super();
		this.listAdView = listAdView;
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listAdView.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(listAdView.get(position));// É¾³ýÒ³¿¨
	}

	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {

		
		View view=listAdView.get(position);
		
		LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		view.setLayoutParams(params);
		container.addView(view,0);
		return view;
	}

	@Override
	public int getIconResId(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

}
