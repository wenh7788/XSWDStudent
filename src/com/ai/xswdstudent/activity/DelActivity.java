package com.ai.xswdstudent.activity;

import com.ai.xswdstudent.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class DelActivity extends Activity{

	
    @ViewInject(R.id.txttitle)	
    private TextView txttitle;  
	
    @ViewInject(R.id.txtcontent)	
    private TextView txtcontent; 

    @ViewInject(R.id.txtdel)	
    private TextView txtdel; 
    
    @ViewInject(R.id.txtcancle)	
    private TextView txtcancle; 
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_del);
	    getWindow().setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);//需要添加的语句  
		ViewUtils.inject(this); //xutils必须加的
		
		
		initView();
	}

	private void initView()
	{
		Intent intent=getIntent();
		
		String strflag=intent.getStringExtra("flag");		
		String strtitle=intent.getStringExtra("title");
		String strcontent=intent.getStringExtra("content");
		
		txttitle.setText(strtitle);
		txtcontent.setText(strcontent);
		
	}
	
    @OnClick(R.id.txtcancle)
    public void onTxtCancleClick(View v)
    {
        finish();
    }	
	
    @OnClick(R.id.txtdel)
    public void onTxtDelClick(View v)
    {
    	Toast.makeText(this, "调用接口", Toast.LENGTH_SHORT).show();
    }
    
}
