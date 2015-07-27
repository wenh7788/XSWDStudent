package com.ai.xswdstudent.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.TDetailsCourse_Adapter;
import com.ai.xswdstudent.adapter.TDetailsJudge_Adapter;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class TeacherDetailsCourseActivity extends BaseActivity{

	@ViewInject(R.id.gvcourse)
	private GridView gvcourse;
	
	@ViewInject(R.id.listcourse)
	private ListView listcourse;
	
	
	
	
	List<Map<String, Object>> listDetailsCourseData=new ArrayList<Map<String,Object>>();
	
	TDetailsCourse_Adapter tdetailscourse_adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacherdetailscourse);
	
		ViewUtils.inject(this); //xutils����ӵ�
		
		initView();
	}

	private void initView()
	{
		initDetailsCourseData();
		
		tdetailscourse_adapter=new TDetailsCourse_Adapter(listDetailsCourseData,this);
		
		
		gvcourse.setAdapter(tdetailscourse_adapter);
	}
	
	
	private void initDetailsCourseData()
	{
		Map<String, Object> map1=new HashMap<String, Object>();
		
		map1.put("day", "��һ");
		map1.put("sw", "��");
		map1.put("xw", "��");
		map1.put("ws", "��");

		
		Map<String, Object> map2=new HashMap<String, Object>();
		map2.put("day", "�ܶ�");
		map2.put("sw", "��");
		map2.put("xw", "��");
		map2.put("ws", "��");		

		Map<String, Object> map3=new HashMap<String, Object>();
		map3.put("day", "����");
		map3.put("sw", "��");
		map3.put("xw", "��");
		map3.put("ws", "��");		
		
		Map<String, Object> map4=new HashMap<String, Object>();
		map4.put("day", "����");
		map4.put("sw", "��");
		map4.put("xw", "��");
		map4.put("ws", "��");		
		
		Map<String, Object> map5=new HashMap<String, Object>();
		map5.put("day", "����");
		map5.put("sw", "��");
		map5.put("xw", "��");
		map5.put("ws", "��");		
		
		Map<String, Object> map6=new HashMap<String, Object>();
		map6.put("day", "����");
		map6.put("sw", "��");
		map6.put("xw", "��");
		map6.put("ws", "��");		
		
		Map<String, Object> map7=new HashMap<String, Object>();
		map7.put("day", "����");
		map7.put("sw", "��");
		map7.put("xw", "��");
		map7.put("ws", "��");		
		
		
		
		
		listDetailsCourseData.add(map1);
		listDetailsCourseData.add(map2);
		listDetailsCourseData.add(map3);
		listDetailsCourseData.add(map4);
		listDetailsCourseData.add(map5);
		listDetailsCourseData.add(map6);
		listDetailsCourseData.add(map7);
		
	}
}
