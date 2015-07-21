package com.ai.xswdstudent.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.HomeWork_Adapter;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

public class HomeWorkOfMineActivity extends BaseActivity{

	
    @ViewInject(R.id.txtbase_top_left)
    private TextView txtbase_top_left;
    @ViewInject(R.id.txtbase_top_right)
    private TextView txtbase_top_right;
		
    	
    @ViewInject(R.id.listhomework)	
    private ListView listhomework;
	
    List<Map<String, Object>> listHomeWorkData=new ArrayList<Map<String,Object>>();
    
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		System.out.println("HomeWorkOfMineActivity---我的提问");		
		setContentView(R.layout.activity_homeworkofmine);
		
		ViewUtils.inject(this); //xutils必须加的
		
		setTitle("我的提问");
		setRightTitle("提问");
		setRightBackGround(R.drawable.txt_top_right_tjzy_selector);
		initView();
		
		
	}

	private void initView()
	{
		initListHomeWorkData();
		
		HomeWork_Adapter homework_adapter=new HomeWork_Adapter(listHomeWorkData,this,listhomework);
		
		listhomework.setAdapter(homework_adapter);
		
	}
	private void initListHomeWorkData()
	{

		Map<String, Object> map1= new HashMap<String,Object>();
		Map<Integer, Object> picMap1=new HashMap<Integer, Object>();
		
		picMap1.put(0, "https://www.baidu.com/img/bd_logo1.png");
		picMap1.put(1, "https://www.baidu.com/img/bd_logo1.png");

		
		map1.put("imghead", "https://www.baidu.com/img/bd_logo1.png");
		map1.put("username", "飞飞1");
		map1.put("grade", "初中二年级");
		map1.put("time", "2015-07-19 11:55");
		map1.put("questionname", "初二英语模拟考题批改");
		map1.put("questiondetail", "一共6大题，花了一个小时完成的。老师们帮我看下存在什么问题？");
		map1.put("questionpic", picMap1);
		map1.put("answercount", "已有5位老师回答了你的问题");
		
		
		
		Map<String, Object> map2= new HashMap<String,Object>();
		Map<Integer, Object> picMap2=new HashMap<Integer, Object>();
		
		picMap2.put(0, "https://www.baidu.com/img/bd_logo1.png");
		picMap2.put(1, "https://www.baidu.com/img/bd_logo1.png");
		picMap2.put(2, "https://www.baidu.com/img/bd_logo1.png");
		picMap2.put(3, "https://www.baidu.com/img/bd_logo1.png");

		
		map2.put("imghead", "https://www.baidu.com/img/bd_logo1.png");
		map2.put("username", "飞飞2");
		map2.put("grade", "初中二年级");
		map2.put("time", "2015-07-19 11:55");
		map2.put("questionname", "初二英语模拟考题批改");
		map2.put("questiondetail", "一共6大题，花了一个小时完成的。老师们帮我看下存在什么问题？");
		map2.put("questionpic", picMap2);
		map2.put("answercount", "已有5位老师回答了你的问题");	
		
		Map<String, Object> map3= new HashMap<String,Object>();
		Map<Integer, Object> picMap3=new HashMap<Integer, Object>();
		
		map3.put("imghead", "https://www.baidu.com/img/bd_logo1.png");
		map3.put("username", "飞飞3");
		map3.put("grade", "初中二年级");
		map3.put("time", "2015-07-19 11:55");
		map3.put("questionname", "初二英语模拟考题批改");
		map3.put("questiondetail", "一共6大题，花了一个小时完成的。老师们帮我看下存在什么问题？");
		map3.put("questionpic", picMap3);
		map3.put("answercount", "已有5位老师回答了你的问题");		
		
		Map<String, Object> map4= new HashMap<String,Object>();
		Map<Integer, Object> picMap4=new HashMap<Integer, Object>();
		
		picMap4.put(0, "https://www.baidu.com/img/bd_logo1.png");
		picMap4.put(1, "https://www.baidu.com/img/bd_logo1.png");
		picMap4.put(2, "https://www.baidu.com/img/bd_logo1.png");
		picMap4.put(3, "https://www.baidu.com/img/bd_logo1.png");

		map4.put("imghead", "https://www.baidu.com/img/bd_logo1.png");
		map4.put("username", "飞飞4");
		map4.put("grade", "初中二年级");
		map4.put("time", "2015-07-19 11:55");
		map4.put("questionname", "初二英语模拟考题批改");
		map4.put("questiondetail", "一共6大题，花了一个小时完成的。老师们帮我看下存在什么问题？");
		map4.put("questionpic", picMap4);
		map4.put("answercount", "已有5位老师回答了你的问题");	
		
		
		listHomeWorkData.add(map1);
		listHomeWorkData.add(map2);
		listHomeWorkData.add(map3);
		listHomeWorkData.add(map4);
		
	}	
	
	@OnItemClick(R.id.listhomework)  
    public void itemClick_listHomeWork(AdapterView<?> parent, View view, int position,long id) {  
		//记得传递参数，类似homeworkid
		Intent intent =new Intent(this,HomeWorkDetailsActivity.class);
		startActivity(intent);
    } 	
	
	
    @OnClick(R.id.txtbase_top_left)
    public void onBaseTopLeft(View v)
    {
        finish();
    }	
    @OnClick(R.id.txtbase_top_right)
    public void onBaseTopRight(View v)
    {
        Toast.makeText(this, "跳转到提问页面", Toast.LENGTH_SHORT).show();
    }
}
