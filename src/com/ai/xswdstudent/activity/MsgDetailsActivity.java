package com.ai.xswdstudent.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class MsgDetailsActivity extends BaseActivity{

    @ViewInject(R.id.txtbase_top_left)
    private TextView txtbase_top_left;
    @ViewInject(R.id.txtbase_top_right)
    private TextView txtbase_top_right;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_msgdetails);
		ViewUtils.inject(this); //xutils必须加的
		
		setTitle("消息详情");
		
		setRightTitle("",R.drawable.top_right_del);
		setRightBackGround(R.drawable.txt_top_right_tjzy_selector);
		
		initView();
		System.out.println("MsgDetailsActivity.class----消息详情");
	
	}

	private void initView()
	{
		
	}
	
   @OnClick(R.id.txtbase_top_left)
    public void onBaseTopLeft(View v)
    {
        finish();
    }	
    @OnClick(R.id.txtbase_top_right)
    public void onBaseTopRight(View v)
    {
        Toast.makeText(this, "点击删除", Toast.LENGTH_SHORT).show();
        
        Intent intent=new Intent(this,DelActivity.class);
        
        intent.putExtra("flag", "HomeWorkDetailsActivity");
        intent.putExtra("title", "提示");
        intent.putExtra("content", "你确定要删除此条消息吗？");
        
        startActivity(intent);
        
    }	
	
}
