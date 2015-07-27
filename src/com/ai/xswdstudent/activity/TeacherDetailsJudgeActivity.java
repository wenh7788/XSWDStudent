package com.ai.xswdstudent.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.widget.ListView;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.TDetailsJudge_Adapter;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class TeacherDetailsJudgeActivity extends BaseActivity{

	@ViewInject(R.id.listjudge)
	private ListView listjudge;
	
	
	private TDetailsJudge_Adapter tdetailsjudge_adapter;
	
	List<Map<String, Object>> listDetailsJudgeData=new ArrayList<Map<String,Object>>();
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacherdetailsjudge);
		ViewUtils.inject(this); //xutils±ÿ–Îº”µƒ
		
		initView();
	}
	
	private void initView()
	{
		initDetailsJudgeData();
		
		tdetailsjudge_adapter=new TDetailsJudge_Adapter(listDetailsJudgeData,this,listjudge);
		
		listjudge.setAdapter(tdetailsjudge_adapter);
	}
	
	private void initDetailsJudgeData()
	{
		Map<String, Object> map1=new HashMap<String, Object>();
		
		map1.put("imghead", "https://www.baidu.com/img/bd_logo1.png");
		map1.put("username", "∑…∑…");
		map1.put("time", "2015-07-23 21:55");
		map1.put("content", "’‚¿Ô–¥∆¿”Ô");
		
		Map<String, Object> map2=new HashMap<String, Object>();		
		map2.put("imghead", "https://www.baidu.com/img/bd_logo1.png");
		map2.put("username", "∑…∑…");
		map2.put("time", "2015-07-23 21:55");
		map2.put("content", "’‚¿Ô–¥∆¿”Ô");
		
		Map<String, Object> map3=new HashMap<String, Object>();
		map3.put("imghead", "https://www.baidu.com/img/bd_logo1.png");
		map3.put("username", "∑…∑…");
		map3.put("time", "2015-07-23 21:55");
		map3.put("content", "’‚¿Ô–¥∆¿”Ô");
		
		Map<String, Object> map4=new HashMap<String, Object>();
		map4.put("imghead", "https://www.baidu.com/img/bd_logo1.png");
		map4.put("username", "∑…∑…");
		map4.put("time", "2015-07-23 21:55");
		map4.put("content", "’‚¿Ô–¥∆¿”Ô");
		
		Map<String, Object> map5=new HashMap<String, Object>();
		map5.put("imghead", "https://www.baidu.com/img/bd_logo1.png");
		map5.put("username", "∑…∑…");
		map5.put("time", "2015-07-23 21:55");
		map5.put("content", "’‚¿Ô–¥∆¿”Ô");
		
		
		listDetailsJudgeData.add(map1);
		listDetailsJudgeData.add(map2);
		listDetailsJudgeData.add(map3);
		listDetailsJudgeData.add(map4);	
		listDetailsJudgeData.add(map5);
		
	}

}
