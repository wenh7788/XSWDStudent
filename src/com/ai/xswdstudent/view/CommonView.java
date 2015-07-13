package com.ai.xswdstudent.view;


import com.ai.xswdstudent.R;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CommonView {

	private Activity mActivity;
	
	TextView txtbase_top_left;
	TextView txtbase_top_mid;
	TextView txtbase_top_right;
	
	
	public CommonView(Activity activity)
	{
		super();
		mActivity=activity;
	}
	
	public TextView initBaseTopLeft()
	{
		if(null == mActivity)
		{
			return null;
		}
		View view=mActivity.findViewById(R.id.base_top);
		LinearLayout llayout=(LinearLayout) view.findViewById(R.id.llayoutbase_top_left);
		txtbase_top_left=(TextView) llayout.findViewById(R.id.txtbase_top_left);
		return txtbase_top_left;
		
	}
	
	public TextView initBaseTopMid()
	{
		if(null == mActivity)
		{
			return null;
		}
		View view=mActivity.findViewById(R.id.base_top);
		txtbase_top_mid=(TextView) view.findViewById(R.id.txtbase_top_mid);
		return txtbase_top_mid;
		
	}
	
	public TextView initBaseTopRight()
	{
		if(null == mActivity)
		{
			return null;
		}
		View view=mActivity.findViewById(R.id.base_top);
		txtbase_top_right=(TextView) view.findViewById(R.id.txtbase_top_right);
		return txtbase_top_right;
		
	}
	
	public void setBaseTopMidTitle(String str)
	{
		txtbase_top_mid.setText(str);
	}
	
}
