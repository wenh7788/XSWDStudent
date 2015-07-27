package com.ai.xswdstudent.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.activity.seting.PersoncentUpdateNameActivity;
import com.ai.xswdstudent.activity.seting.UpdateSexActivity;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.ai.xswdstudent.fragment.MainFragmentActivity;
import com.ai.xswdstudent.global.GlobalConstant;
import com.ai.xswdstudent.xsaplication.SharedPreferencesUtil;
import com.ai.xswdstudent.xsaplication.StringUtil;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class PersoncentActivity  extends  BaseActivity
{
    
    @ViewInject(R.id.my_name)
    private LinearLayout  upName;
    
   
    @ViewInject(R.id.my_sex)
    private LinearLayout  upSex;
    @ViewInject(R.id.common_title_center_text)
    private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personcenter);
        ViewUtils.inject(this); //xutils�ؼ������      ʹ��ע��󶨿ؼ���ʱ��һ���ǵ���onCreate�е���
       // setTitle("��ͥ����");
        title.setText("��������");
        
         
      
    }
    
    
    
    
    @OnClick(R.id.my_name)
    public void onImgSearchClick(View v)
    {
        Toast.makeText(this, "�޸�����", Toast.LENGTH_SHORT).show();
        Intent inten = new Intent();
      inten.setClass(this, PersoncentUpdateNameActivity.class);
     startActivity(inten);
        
    }
    
    
    
  
      
    
    @OnClick(R.id.my_sex)
    public void onImgClick(View v)
    {
        Toast.makeText(this, "�޸��Ա�", Toast.LENGTH_SHORT).show();
        Intent inten = new Intent();
      inten.setClass(this, UpdateSexActivity.class);
     startActivity(inten);
        
    }
 
}
