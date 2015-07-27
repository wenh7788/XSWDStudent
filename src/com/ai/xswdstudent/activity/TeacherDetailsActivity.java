package com.ai.xswdstudent.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.Judge_Adapter;
import com.ai.xswdstudent.adapter.TeacherDetails_Adapter;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class TeacherDetailsActivity extends BaseActivity{

	@ViewInject(R.id.pager_teacherdetails)
	private ViewPager pager_teacherdetails;
	
	@ViewInject(R.id.txttzx_top)
	private TextView txttzx_top;
	
	@ViewInject(R.id.txttsc_top)
	private TextView txttsc_top;
	
	@ViewInject(R.id.txtfx_top)
	private TextView txtfx_top;	
	
	
	@ViewInject(R.id.txtjj)
	private TextView txtjj;	
	@ViewInject(R.id.txtjj_line)
	private TextView txtjj_line;	
	
	@ViewInject(R.id.txtkc)
	private TextView txtkc;	
	@ViewInject(R.id.txtkc_line)
	private TextView txtkc_line;	
	
	@ViewInject(R.id.txtpj)
	private TextView txtpj;	
	@ViewInject(R.id.txtpj_line)
	private TextView txtpj_line;	
	
	
	//教师详情adapter
	private TeacherDetails_Adapter teacherDetails_Adapter;
	
	//存放简介和课程和评价三个view
	private List<View> listTeacherDetailsView=new ArrayList<View>();
	
	@SuppressWarnings("deprecation")
	LocalActivityManager manager=null;
	
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		System.out.println("TeacherDetailsActivity---老师详情");
		setContentView(R.layout.activity_teacherdetails);
		ViewUtils.inject(this); //xutils必须加的
		
		manager= new LocalActivityManager(this, true);
		manager.dispatchCreate(savedInstanceState);

		
		initView();
		
	}
	
	public void initView()
	{
		
		//应该造头部的数据，到时候看接口文档吧
		
		initTeacherDetailsViewPager();
	}

	
	private void initTeacherDetailsViewPager()
	{
		LayoutInflater mInflater =getLayoutInflater();

		Intent intent_introduce = new Intent(this, TeacherDetailsIntroduceActivity.class);
		listTeacherDetailsView.add(getView("TeacherDetailsIntroduce", intent_introduce));
		Intent intent_incourse = new Intent(this, TeacherDetailsCourseActivity.class);
		listTeacherDetailsView.add(getView("TeacherDetailsCourse", intent_incourse));
		Intent intent_judge = new Intent(this, TeacherDetailsJudgeActivity.class);
		listTeacherDetailsView.add(getView("TeacherDetailsJudge", intent_judge));
		
		teacherDetails_Adapter=new TeacherDetails_Adapter(listTeacherDetailsView,this);
		pager_teacherdetails.setAdapter(teacherDetails_Adapter);
		pager_teacherdetails.setCurrentItem(0);
		pager_teacherdetails.setOnPageChangeListener(myPageChangeListener);
	
	}
	
	private View getView(String id, Intent intent) {
		return manager.startActivity(id, intent).getDecorView();
	}

	//咨询
	@OnClick(R.id.txttzx_top)
	public void onTZX_TopClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "点击咨询", Toast.LENGTH_SHORT).show();
	}
	//收藏
	@OnClick(R.id.txttsc_top)	
	public void onTSC_TopClick(View v)
	{
		Toast.makeText(this, "点击收藏", Toast.LENGTH_SHORT).show();
	}
	//分享
	@OnClick(R.id.txtfx_top)
	public void onTFX_Click(View v)
	{
		Toast.makeText(this, "点击分享", Toast.LENGTH_SHORT).show();
	}
	
	//点击简介
	@OnClick(R.id.txtjj)
	public void onJJClick(View v)
	{
		pager_teacherdetails.setCurrentItem(0);
		
		Drawable drawable;
		txtjj.setTextColor(Color.rgb(247, 136, 66));
		txtjj_line.setBackgroundColor(Color.rgb(247, 136, 66));
		
		drawable=getResources().getDrawable(R.drawable.tjj_sel);  
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
		txtjj.setCompoundDrawables(drawable,null,null,null);

		
		txtkc.setTextColor(Color.rgb(228, 228, 228));
		txtkc_line.setBackgroundColor(Color.rgb(255, 255, 255));
	
		drawable=getResources().getDrawable(R.drawable.tkc_nor);  
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
		txtkc.setCompoundDrawables(drawable,null,null,null);

		
		
		txtpj.setTextColor(Color.rgb(228, 228, 228));
		txtpj_line.setBackgroundColor(Color.rgb(255, 255, 255));
	
		drawable=getResources().getDrawable(R.drawable.tpj_nor);  
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
		txtpj.setCompoundDrawables(drawable,null,null,null);

	}
	
	
	//点击课程
	@OnClick(R.id.txtkc)
	public void onKCClick(View v)
	{
		pager_teacherdetails.setCurrentItem(1);
		
		Drawable drawable;
		txtjj.setTextColor(Color.rgb(228, 228, 228));
		txtjj_line.setBackgroundColor(Color.rgb(255, 255, 255));
		
		drawable=getResources().getDrawable(R.drawable.tjj_nor);  
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
		txtjj.setCompoundDrawables(drawable,null,null,null);

		
		txtkc.setTextColor(Color.rgb(247, 136, 66));
		txtkc_line.setBackgroundColor(Color.rgb(247, 136, 66));
	
		drawable=getResources().getDrawable(R.drawable.tkc_sel);  
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
		txtkc.setCompoundDrawables(drawable,null,null,null);

		
		
		txtpj.setTextColor(Color.rgb(228, 228, 228));
		txtpj_line.setBackgroundColor(Color.rgb(255, 255, 255));
	
		drawable=getResources().getDrawable(R.drawable.tpj_nor);  
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
		txtpj.setCompoundDrawables(drawable,null,null,null);

	}
	
	//点击课程
	@OnClick(R.id.txtpj)
	public void onPJClick(View v)
	{
		pager_teacherdetails.setCurrentItem(2);
		
		Drawable drawable;
		txtjj.setTextColor(Color.rgb(228, 228, 228));
		txtjj_line.setBackgroundColor(Color.rgb(255, 255, 255));
		
		drawable=getResources().getDrawable(R.drawable.tjj_nor);  
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
		txtjj.setCompoundDrawables(drawable,null,null,null);

		txtkc.setTextColor(Color.rgb(228,228,228));
		txtkc_line.setBackgroundColor(Color.rgb(255,255,255));
	
		drawable=getResources().getDrawable(R.drawable.tkc_nor);  
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
		txtkc.setCompoundDrawables(drawable,null,null,null);

		txtpj.setTextColor(Color.rgb(247, 136, 66));
		txtpj_line.setBackgroundColor(Color.rgb(247, 136, 66));
	
		drawable=getResources().getDrawable(R.drawable.tpj_sel);  
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
		txtpj.setCompoundDrawables(drawable,null,null,null);
	
	}
	OnPageChangeListener myPageChangeListener=new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int arg0) {
			Drawable drawable;
			
			switch (arg0) {
			case 0:
				txtjj.setTextColor(Color.rgb(247, 136, 66));
				txtjj_line.setBackgroundColor(Color.rgb(247, 136, 66));
				
				drawable=getResources().getDrawable(R.drawable.tjj_sel);  
				drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
				txtjj.setCompoundDrawables(drawable,null,null,null);

				
				txtkc.setTextColor(Color.rgb(228, 228, 228));
				txtkc_line.setBackgroundColor(Color.rgb(255, 255, 255));
			
				drawable=getResources().getDrawable(R.drawable.tkc_nor);  
				drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
				txtkc.setCompoundDrawables(drawable,null,null,null);

				txtpj.setTextColor(Color.rgb(228, 228, 228));
				txtpj_line.setBackgroundColor(Color.rgb(255, 255, 255));
			
				drawable=getResources().getDrawable(R.drawable.tpj_nor);  
				drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
				txtpj.setCompoundDrawables(drawable,null,null,null);

				break;
			case 1:
				txtjj.setTextColor(Color.rgb(228, 228, 228));
				txtjj_line.setBackgroundColor(Color.rgb(255, 255, 255));
				
				drawable=getResources().getDrawable(R.drawable.tjj_nor);  
				drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
				txtjj.setCompoundDrawables(drawable,null,null,null);

				
				txtkc.setTextColor(Color.rgb(247, 136, 66));
				txtkc_line.setBackgroundColor(Color.rgb(247, 136, 66));
			
				drawable=getResources().getDrawable(R.drawable.tkc_sel);  
				drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
				txtkc.setCompoundDrawables(drawable,null,null,null);

				txtpj.setTextColor(Color.rgb(228, 228, 228));
				txtpj_line.setBackgroundColor(Color.rgb(255, 255, 255));
			
				drawable=getResources().getDrawable(R.drawable.tpj_nor);  
				drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
				txtpj.setCompoundDrawables(drawable,null,null,null);
				break;
			case 2:
				txtjj.setTextColor(Color.rgb(228, 228, 228));
				txtjj_line.setBackgroundColor(Color.rgb(255, 255, 255));
				
				drawable=getResources().getDrawable(R.drawable.tjj_nor);  
				drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
				txtjj.setCompoundDrawables(drawable,null,null,null);

				txtkc.setTextColor(Color.rgb(228,228,228));
				txtkc_line.setBackgroundColor(Color.rgb(255,255,255));
			
				drawable=getResources().getDrawable(R.drawable.tkc_nor);  
				drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
				txtkc.setCompoundDrawables(drawable,null,null,null);

				txtpj.setTextColor(Color.rgb(247, 136, 66));
				txtpj_line.setBackgroundColor(Color.rgb(247, 136, 66));
			
				drawable=getResources().getDrawable(R.drawable.tpj_sel);  
				drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
				txtpj.setCompoundDrawables(drawable,null,null,null);
			
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
