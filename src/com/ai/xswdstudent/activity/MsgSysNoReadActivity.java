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
	
	
	//��������
	List<Map<String, Object>> listMsgSysNoReadData=new ArrayList<Map<String,Object>>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_msg_sysnoread);
		ViewUtils.inject(this); //xutils����ӵ�
		
		initView();
	}

	private void initView()
	{
		initMsgSysAllData();
		
		MsgSysNoRead_Adapter msgSysNoRead_Adapter=new MsgSysNoRead_Adapter(listMsgSysNoReadData,this);
		
		listmsgsysnoread.setAdapter(msgSysNoRead_Adapter);
		
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
		
		listMsgSysNoReadData.add(map1);
		listMsgSysNoReadData.add(map2);
		listMsgSysNoReadData.add(map3);
		listMsgSysNoReadData.add(map4);
		
	}

}
