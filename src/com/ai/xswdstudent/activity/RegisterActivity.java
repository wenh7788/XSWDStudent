package com.ai.xswdstudent.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class RegisterActivity  extends  BaseActivity
{
    
    
    @ViewInject(R.id.et_number)
    private EditText phone;
    
    @ViewInject(R.id.btn_register_first_submit)
    private Button btn_sentMess;
    
    private String mobile;
 
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_one);
        ViewUtils.inject(this); //xutils必加语句在      使用注解绑定控件的时候，一定记得在onCreate中调用
        setTitle("注册");
      
    }
    
    @OnClick(R.id.login_submit)
    public void btn_testClick(View v)
    
    {
        
        mobile = phone.getText().toString().trim();
      
        if (StringUtil.isEmpty(mobile))
        {
            showToast(getString(R.string.telphone_empty));
        }else {
            
            HttpUtils http = new HttpUtils();
            String url = "http://192.168.1.6/UserService.svc/GetPerson";
            RequestParams params = new RequestParams();
            params.addQueryStringParameter("phone", mobile);
            http.send(HttpMethod.GET,
                    url,
                    params,
                    new RequestCallBack<String>()
                    {
                        
                        @Override
                        public void onSuccess(ResponseInfo<String> responseInfo)
                        {
                           
                            Intent intent5 = new Intent();
                            intent5.putExtra("mobile1", mobile);
                            intent5.setClass(mContext,NextRegisterActivity
                                    .class);
                            startActivity(intent5);
                            finish();
                        }
                        
                        @Override
                        public void onFailure(HttpException error, String msg)
                        {
                            Toast.makeText(getApplicationContext(),
                                    "登陆失败" + msg,
                                    Toast.LENGTH_SHORT).show();
                        }
                        
                    });
            
            
            
            
        }
        
        
    }
 
}
