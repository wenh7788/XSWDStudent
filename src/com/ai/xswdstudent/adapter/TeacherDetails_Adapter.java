package com.ai.xswdstudent.adapter;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;

public class TeacherDetails_Adapter extends PagerAdapter{

	private List<View> listTeacherDetailsView;
	private Context mContext;
	
	
	
	public TeacherDetails_Adapter(List<View> listTeacherDetailsView,
			Context mContext) {
		super();
		this.listTeacherDetailsView = listTeacherDetailsView;
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listTeacherDetailsView.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(listTeacherDetailsView.get(position));// É¾³ýÒ³¿¨
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		
		View view=listTeacherDetailsView.get(position);
		
		LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		view.setLayoutParams(params);
		container.addView(view,0);
		return view;
		}
	
	
}
