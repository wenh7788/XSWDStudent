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
	
	
	//��������
	List<Map<String, Object>> listMsgSysAllData=new ArrayList<Map<String,Object>>();
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_msg_sysall);

		ViewUtils.inject(this); //xutils����ӵ�
		initView();

	}

	
	private void initView()
	{
		initMsgSysAllData();
		
		MsgSysAll_Adapter msgSysAll_Adapter=new MsgSysAll_Adapter(listMsgSysAllData,this);
		
		listmsgsysall.setAdapter(msgSysAll_Adapter);
		
	}
	
	//ȫ����Ϣ��ʼ��
	private void initMsgSysAllData()
	{
		
		Map<String, Object> map1=new HashMap<String, Object>();
		map1.put("msgtype", "ϵͳ��Ϣ");
		map1.put("msgtime", "2015-07-18");
		map1.put("msgcontent", "��ã�������ã�������ã�������ã�������ã�������ã�������ã�������ã�������ã�����");
		map1.put("dotype", "ȥ����");
		
		Map<String, Object> map2=new HashMap<String, Object>();
		map2.put("msgtype", "ϵͳ��Ϣ");
		map2.put("msgtime", "2015-07-18");
		map2.put("msgcontent", "��ã�������ã�������ã�������ã�������ã�������ã�������ã�������ã�������ã�����");
		map2.put("dotype", "ȥ֧��");
		
		Map<String, Object> map3=new HashMap<String, Object>();
		map3.put("msgtype", "ϵͳ��Ϣ");
		map3.put("msgtime", "2015-07-18");
		map3.put("msgcontent", "��ã�������ã�������ã�������ã�������ã�������ã�������ã�������ã�������ã�����");
		map3.put("dotype", "");
		
		Map<String, Object> map4=new HashMap<String, Object>();
		map4.put("msgtype", "ϵͳ��Ϣ");
		map4.put("msgtime", "2015-07-18");
		map4.put("msgcontent", "��ã�������ã�������ã�������ã�������ã�������ã�������ã�������ã�������ã�����");
		map4.put("dotype", "ȥ����");
		
		listMsgSysAllData.add(map1);
		listMsgSysAllData.add(map2);
		listMsgSysAllData.add(map3);
		listMsgSysAllData.add(map4);
		
	}

}
