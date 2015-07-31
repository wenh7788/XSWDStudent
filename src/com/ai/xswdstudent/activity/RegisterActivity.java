package com.ai.xswdstudent.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        ViewUtils.inject(this); //xutils�ؼ������      ʹ��ע��󶨿ؼ���ʱ��һ���ǵ���onCreate�е���
        //setTitle("ע��");
      
    }
    
    @OnClick(R.id.btn_register_first_submit)
    public void btn_testClick(View v)
    
    {
        Toast.makeText(this,
                "发送验证啊",
                 Toast.LENGTH_SHORT).show();
        
        mobile = phone.getText().toString().trim();
      
        if (StringUtil.isEmpty(mobile))
        {
            showToast(getString(R.string.telphone_empty));
        }else {
            
            HttpUtils http = new HttpUtils();
            String url = "http://59.175.144.98:8080/msxxw/webservice/rest/UserRTS/registerByUsername";
            RequestParams params = new RequestParams();
            params.addQueryStringParameter("userName", mobile);
            http.send(HttpMethod.POST,
                    url,
                    params,
                    new RequestCallBack<String>()
                    {
                        
                        @Override
                        public void onSuccess(ResponseInfo<String> responseInfo)
                        {
                            
                            
                            
//                            Toast.makeText(RegisterActivity.this,
//                                   "reply: " + responseInfo.result,
//                                    Toast.LENGTH_SHORT).show();
                            Log.d("regit", responseInfo.result);

                            Intent intent5 = new Intent();
                            intent5.putExtra("mobile1", mobile);
                            intent5.setClass(RegisterActivity.this,NextRegisterActivity
                                    .class);
                            startActivity(intent5);
                            finish();
                        }
                        
                        @Override
                        public void onFailure(HttpException error, String msg)
                        {
                            Toast.makeText(getApplicationContext(),
                                    "错误信息" + msg,
                                    Toast.LENGTH_SHORT).show();
                        }
                        
                    });
            
            
            
            
        }
        
        
    }
 
}
