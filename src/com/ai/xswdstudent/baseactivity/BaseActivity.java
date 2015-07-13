package com.ai.xswdstudent.baseactivity;


import com.ai.xswdstudent.view.CommonView;
import com.lidroid.xutils.ViewUtils;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class BaseActivity extends Activity{

	//¹«¹²view
	CommonView commonView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}
	
	private CommonView getCommonView()
	{
		if(commonView == null)
		{
			commonView=new CommonView(this);
		}
		return commonView;
	}
	

	public void setTitle(String str)
	{
		getCommonView().initBaseTopMid().setText(str);
	}
	
}
