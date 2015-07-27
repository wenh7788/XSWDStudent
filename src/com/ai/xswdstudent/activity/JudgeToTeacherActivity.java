package com.ai.xswdstudent.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.JudgeTeacher_Me_Adapter;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class JudgeToTeacherActivity extends BaseActivity{

	
	@ViewInject(R.id.listjudgetoteacher)
	private ListView listjudgetoteacher;
	
	List<Map<String, Object>> listJudgeToTeacherData=new ArrayList<Map<String,Object>>();
	
	JudgeTeacher_Me_Adapter judgeteacher_me_adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_judgetoteacher);
		ViewUtils.inject(this); //xutils必须加的
		
		initView();
	}

	
	
	
	private void initView()
	{
		initJudgeToTeacherData();
		
		judgeteacher_me_adapter=new JudgeTeacher_Me_Adapter(listJudgeToTeacherData,this,listjudgetoteacher);
		listjudgetoteacher.setAdapter(judgeteacher_me_adapter);
	}
	
	public void initJudgeToTeacherData()
	{
		Map<String, Object> map1=new HashMap<String, Object>();
		map1.put("imghead", "https://www.baidu.com/img/bd_logo1.png");
		map1.put("username", "飞飞1");
		map1.put("classname", "初中疯狂英语");
		map1.put("price", "总价：￥200");
		map1.put("content", "表现的非常好！");
		map1.put("score", "3");
		map1.put("time", "2015-07-22 23:21");
		
		Map<String, Object> map2=new HashMap<String, Object>();
		map2.put("imghead", "https://www.baidu.com/img/bd_logo1.png");
		map2.put("username", "飞飞1");
		map2.put("classname", "初中疯狂英语");
		map2.put("price", "总价：￥200");
		map2.put("content", "表现的非常好！");
		map2.put("score", "1");
		map2.put("time", "2015-07-22 23:21");
		
		Map<String, Object> map3=new HashMap<String, Object>();
		map3.put("imghead", "https://www.baidu.com/img/bd_logo1.png");
		map3.put("username", "飞飞1");
		map3.put("classname", "初中疯狂英语");
		map3.put("price", "总价：￥200");
		map3.put("content", "表现的非常好！");
		map3.put("score", "1");
		map3.put("time", "2015-07-22 23:21");
		
		listJudgeToTeacherData.add(map1);
		listJudgeToTeacherData.add(map2);
		listJudgeToTeacherData.add(map3);
		
	}
}
