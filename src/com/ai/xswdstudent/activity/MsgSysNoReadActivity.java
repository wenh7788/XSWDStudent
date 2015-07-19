package com.ai.xswdstudent.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.MsgSysAll_Adapter;
import com.ai.xswdstudent.adapter.MsgSysNoRead_Adapter;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MsgSysNoReadActivity extends BaseActivity{

	@ViewInject(R.id.listmsgsysnoread)
	private ListView listmsgsysnoread;
	
	
	//测试数据
	List<Map<String, Object>> listMsgSysNoReadData=new ArrayList<Map<String,Object>>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_msg_sysnoread);
		ViewUtils.inject(this); //xutils必须加的
		
		initView();
	}

	private void initView()
	{
		initMsgSysAllData();
		
		MsgSysNoRead_Adapter msgSysNoRead_Adapter=new MsgSysNoRead_Adapter(listMsgSysNoReadData,this);
		
		listmsgsysnoread.setAdapter(msgSysNoRead_Adapter);
		
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
		
		listMsgSysNoReadData.add(map1);
		listMsgSysNoReadData.add(map2);
		listMsgSysNoReadData.add(map3);
		listMsgSysNoReadData.add(map4);
		
	}

}
