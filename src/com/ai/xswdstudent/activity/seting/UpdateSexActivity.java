package com.ai.xswdstudent.activity.seting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ai.xswdstudent.R;
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

public class UpdateSexActivity  extends  BaseActivity
{
    
    @ViewInject(R.id.common_title_center_text)
    private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatepserson_sex);
        ViewUtils.inject(this); //xutils�ؼ������      ʹ��ע��󶨿ؼ���ʱ��һ���ǵ���onCreate�е���
       // setTitle("��ͥ����");
        title.setText("�޸��Ա�");
        
         
      
    }
    
  
        
 
}
