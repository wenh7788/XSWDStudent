package com.ai.xswdstudent.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.Wallet_Adapter;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class WalletActivity extends BaseActivity{

    @ViewInject(R.id.txtbase_top_left)
    private TextView txtbase_top_left;
    
    @ViewInject(R.id.listacct)	
    private ListView listacct;
	
    List<Map<String, Object>> listAcctData=new ArrayList<Map<String,Object>>();
    
	Wallet_Adapter waller_adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_wallet);
		
		ViewUtils.inject(this); //xutils必须加的
		setTitle("我的钱包");
		initView();
		
		
	}

	private void initView()
	{
		initAcctData();
		
		waller_adapter=new Wallet_Adapter(listAcctData,this);
		listacct.setAdapter(waller_adapter);
		
		
		
	}
	
	private void initAcctData()
	{
		Map<String, Object> map1= new HashMap<String,Object>();
		
		map1.put("flag", "0");
		map1.put("money", "200");
		map1.put("time", "2015-07-25 20:57");
		
		Map<String, Object> map2= new HashMap<String,Object>();
		
		map2.put("flag", "1");
		map2.put("money", "200");
		map2.put("time", "2015-07-25 20:57");
		
		Map<String, Object> map3= new HashMap<String,Object>();
		
		map3.put("flag", "0");
		map3.put("money", "200");
		map3.put("time", "2015-07-25 20:57");		
		
		
		Map<String, Object> map4= new HashMap<String,Object>();
		
		map4.put("flag", "1");
		map4.put("money", "200");
		map4.put("time", "2015-07-25 20:57");
		
		Map<String, Object> map5= new HashMap<String,Object>();
		
		map5.put("flag", "1");
		map5.put("money", "200");
		map5.put("time", "2015-07-25 20:57");

		Map<String, Object> map6= new HashMap<String,Object>();
		
		map6.put("flag", "1");
		map6.put("money", "200");
		map6.put("time", "2015-07-25 20:57");		
		
		
		listAcctData.add(map1);
		listAcctData.add(map2);
		listAcctData.add(map3);
		listAcctData.add(map4);
		listAcctData.add(map5);
		listAcctData.add(map6);	
		
	}
	
    @OnClick(R.id.txtbase_top_left)
    public void onBaseTopLeft(View v)
    {
        finish();
    }		
}
