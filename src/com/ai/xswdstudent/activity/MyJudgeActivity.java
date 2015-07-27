package com.ai.xswdstudent.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.Judge_Adapter;
import com.ai.xswdstudent.adapter.Msg_Adapter;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class MyJudgeActivity extends BaseActivity{

	
	
	@ViewInject(R.id.txttoteacher)
	private TextView txttoteacher;

	@ViewInject(R.id.txttoteacher_line)
	private TextView txttoteacher_line;
	
	@ViewInject(R.id.txttome)
	private TextView txttome;

	@ViewInject(R.id.txttome_line)
	private TextView txttome_line;
	
	@ViewInject(R.id.pager_judge)
	private ViewPager pager_judge;
	
	
	//存放我对老师和老师对我两个view
	private List<View> listJudgeView=new ArrayList<View>();
	
	//评价adapter
	private Judge_Adapter judge_Adapter;
	
	
	@SuppressWarnings("deprecation")
	LocalActivityManager manager=null;
	
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		System.out.println("MyJudgeActivity.class---我的评价");
		setContentView(R.layout.activity_myjudge);
		ViewUtils.inject(this); //xutils必须加的
		
		setTitle("我的评价");
		manager= new LocalActivityManager(this, true);
		manager.dispatchCreate(savedInstanceState);
		initJudgeViewPager();
		
	}

	
	private void initJudgeViewPager()
	{

		LayoutInflater mInflater =getLayoutInflater();
//		listMsgView.add(mInflater.inflate(R.layout.activity_msg_sysall, null));
//		listMsgView.add(mInflater.inflate(R.layout.activity_msg_sysnoread, null));

		Intent intent_toteacher = new Intent(this, JudgeToTeacherActivity.class);
		listJudgeView.add(getView("JudgeToTeacher", intent_toteacher));
		Intent intent_tome = new Intent(this, JudgeToMeActivity.class);
		listJudgeView.add(getView("JudgeToMe", intent_tome));
		
		//listMsgView.add(mInflater.inflate(R.layout.activity_msg_sysnoread, null));
		
//		listMsgView.add(getLocalActivityManager().startActivity("1", new Intent(Hdjl.this, Hdjl_cx.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)).getDecorView());
//		
//		listViews.add(getLocalActivityManager().startActivity("1", new Intent(Hdjl.this, Hdjl_cx.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)).getDecorView()); 
//		
		judge_Adapter=new Judge_Adapter(listJudgeView,this);
		pager_judge.setAdapter(judge_Adapter);
		pager_judge.setCurrentItem(0);
		pager_judge.setOnPageChangeListener(myPageChangeListener);
		
	}	
	
	private View getView(String id, Intent intent) {
		return manager.startActivity(id, intent).getDecorView();
	}
	
	//点击全部
	@OnClick(R.id.txttoteacher)
	public void onToTeacherClick(View v)
	{
		pager_judge.setCurrentItem(0);
		
		txttoteacher.setTextColor(Color.rgb(247, 136, 66));
		txttoteacher_line.setBackgroundColor(Color.rgb(247, 136, 66));
		
		txttome.setTextColor(Color.rgb(153, 153, 153));
		txttome_line.setBackgroundColor(Color.rgb(255, 255, 255));
	}
	
	
	//点击未读
	@OnClick(R.id.txttome)
	public void onToMeClick(View v)
	{
		pager_judge.setCurrentItem(1);
		
		txttoteacher.setTextColor(Color.rgb(153, 153, 153));
		txttoteacher_line.setBackgroundColor(Color.rgb(255, 255, 255));

		txttome.setTextColor(Color.rgb(247, 136, 66));
		txttome_line.setBackgroundColor(Color.rgb(247, 136, 66));
		
		
	}
		
	OnPageChangeListener myPageChangeListener=new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int arg0) {
		
			
			switch (arg0) {
			case 0:
				txttoteacher.setTextColor(Color.rgb(247, 136, 66));
				txttoteacher_line.setBackgroundColor(Color.rgb(247, 136, 66));
				
				txttome.setTextColor(Color.rgb(153, 153, 153));
				txttome_line.setBackgroundColor(Color.rgb(255, 255, 255));
				break;
			case 1:
				txttoteacher.setTextColor(Color.rgb(153, 153, 153));
				txttoteacher_line.setBackgroundColor(Color.rgb(255, 255, 255));
				
				txttome.setTextColor(Color.rgb(247, 136, 66));
				txttome_line.setBackgroundColor(Color.rgb(247, 136, 66));
				break;
			default:
				break;
			}
			
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
}
