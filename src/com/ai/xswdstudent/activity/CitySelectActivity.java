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
		ViewUtils.inject(this); //xutils必加语句在      使用注解绑定控件的时候，一定记得在onCreate中调用
		setTitle("切换城市");
		
		
		initView();
	}

	public void initView()
	{
		//@ViewInject(R.id.)
	   
	}
	
	@OnClick(R.id.txtbase_top_left)
	public void onBaseTopLeft(View v) {
		finish();
	}
}
