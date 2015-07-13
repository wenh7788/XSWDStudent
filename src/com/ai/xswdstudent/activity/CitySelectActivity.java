package com.ai.xswdstudent.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;


public class CitySelectActivity extends BaseActivity{

	 @ViewInject(R.id.txtbase_top_left)
     private TextView txtbase_top_left;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cityselect);
		ViewUtils.inject(this); //xutils必加语句
		setTitle("切换城市");
		
		
		initView();
	}

	public void initView()
	{
		
	}
	
	@OnClick(R.id.txtbase_top_left)
	public void onBaseTopLeft(View v) {
		finish();
	}
}
