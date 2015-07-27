package com.ai.xswdstudent.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.MsgSysAll_Adapter;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MsgSysAllActivity extends BaseActivity{

	@ViewInject(R.id.listmsgsysall)
	private ListView listmsgsysall;
	
	
	//测试数据
	List<Map<String, Object>> listMsgSysAllData=new ArrayList<Map<String,Object>>();
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_msg_sysall);

		ViewUtils.inject(this); //xutils必须加的
		initView();
		System.out.println("MsgSysAllActivity.class----??-????");
	}

	
	private void initView()
	{
		initMsgSysAllData();
		
		MsgSysAll_Adapter msgSysAll_Adapter=new MsgSysAll_Adapter(listMsgSysAllData,this);
		
		listmsgsysall.setAdapter(msgSysAll_Adapter);
		
	}
	
	//全部消息初始化
	private void initMsgSysAllData()
	{
		
		Map<String, Object> map1=new HashMap<String, Object>();
		map1.put("msgtype", "????");
		map1.put("msgtime", "2015-07-18");
		map1.put("msgcontent", "??,????,????,????,????,????,????,????,????,??");
		map1.put("dotype", "???");
		
		Map<String, Object> map2=new HashMap<String, Object>();
		map2.put("msgtype", "????");
		map2.put("msgtime", "2015-07-18");
		map2.put("msgcontent", "??,????,????,????,????,????,????,????,????,??");
		map2.put("dotype", "???");
		
		Map<String, Object> map3=new HashMap<String, Object>();
		map3.put("msgtype", "????");
		map3.put("msgtime", "2015-07-18");
		map3.put("msgcontent", "??,????,????,????,????,????,????,????,????,??");
		map3.put("dotype", "");
		
		Map<String, Object> map4=new HashMap<String, Object>();
		map4.put("msgtype", "????");
		map4.put("msgtime", "2015-07-18");
		map4.put("msgcontent", "??,????,????,????,????,????,????,????,????,??");
		map4.put("dotype", "???");
		
		listMsgSysAllData.add(map1);
		listMsgSysAllData.add(map2);
		listMsgSysAllData.add(map3);
		listMsgSysAllData.add(map4);
		
	}
	@OnItemClick(R.id.listmsgsysall)  
    public void itemClick_listMsgSysAll(AdapterView<?> parent, View view, int position,long id) {  
       
		//记得传递参数，类似homeworkid
		Intent intent =new Intent(this,MsgDetailsActivity.class);
		startActivity(intent);
	}
}
