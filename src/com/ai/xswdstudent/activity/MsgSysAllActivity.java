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

import android.os.Bundle;
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
		map1.put("msgtype", "系统消息");
		map1.put("msgtime", "2015-07-18");
		map1.put("msgcontent", "你好，张三你好，张三你好，张三你好，张三你好，张三你好，张三你好，张三你好，张三你好，张三");
		map1.put("dotype", "去看看");
		
		Map<String, Object> map2=new HashMap<String, Object>();
		map2.put("msgtype", "系统消息");
		map2.put("msgtime", "2015-07-18");
		map2.put("msgcontent", "你好，张三你好，张三你好，张三你好，张三你好，张三你好，张三你好，张三你好，张三你好，张三");
		map2.put("dotype", "去支付");
		
		Map<String, Object> map3=new HashMap<String, Object>();
		map3.put("msgtype", "系统消息");
		map3.put("msgtime", "2015-07-18");
		map3.put("msgcontent", "你好，张三你好，张三你好，张三你好，张三你好，张三你好，张三你好，张三你好，张三你好，张三");
		map3.put("dotype", "");
		
		Map<String, Object> map4=new HashMap<String, Object>();
		map4.put("msgtype", "系统消息");
		map4.put("msgtime", "2015-07-18");
		map4.put("msgcontent", "你好，张三你好，张三你好，张三你好，张三你好，张三你好，张三你好，张三你好，张三你好，张三");
		map4.put("dotype", "去看看");
		
		listMsgSysAllData.add(map1);
		listMsgSysAllData.add(map2);
		listMsgSysAllData.add(map3);
		listMsgSysAllData.add(map4);
		
	}

}
