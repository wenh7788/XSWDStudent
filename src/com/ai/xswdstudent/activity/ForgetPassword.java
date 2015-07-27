package com.ai.xswdstudent.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.activity.login.LoginActivity;
import com.ai.xswdstudent.baseactivity.BaseActivity;
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

public class ForgetPassword extends BaseActivity
{
    @ViewInject(R.id.et_forget_username)
    private EditText usernamee;
    
    @ViewInject(R.id.et_forget_vertification)
    private EditText useryznumber;
    
    @ViewInject(R.id.et_old_password)
    private EditText useroldpwd;
    
    @ViewInject(R.id.et_new_password)
    private EditText usernewpwd;
    
    @ViewInject(R.id.btn_forget_password_ok)
    private Button btn_changepwd;
    
    private String username;
    
    private String usernewpsword;
    
    private String useroldpassword;
    
    private String yznumber;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);
        ViewUtils.inject(this); //xutils必加语句在      使用注解绑定控件的时候，一定记得在onCreate中调用
        setTitle("忘记密码");
        
    }
    
    @OnClick(R.id.btn_forget_password_ok)
    public void btn_changepwdClick(View v)
    
    {
        
        username = usernamee.getText().toString().trim();
        usernewpsword = usernewpwd.getText().toString().trim();
        useroldpassword = useroldpwd.getText().toString().trim();
        yznumber = useryznumber.getText().toString().trim();
        
        if (StringUtil.isEmpty(username))
        {
            showToast(getString(R.string.username_empty));
        }
        else if (StringUtil.isEmpty(usernewpsword))
        {
            showToast(getString(R.string.ysh_password_empty));
        }
        else if (StringUtil.isEmpty(yznumber))
        {
            showToast(getString(R.string.yz_empty));
            
        }
        else
        {
            
            HttpUtils http = new HttpUtils();
            String url = "http://192.168.1.6/UserService.svc/GetPerson";
            RequestParams params = new RequestParams();
            params.addQueryStringParameter("usernewpsword", usernewpsword);
            params.addQueryStringParameter("useroldpassword", useroldpassword);
            params.addQueryStringParameter("yznumber", yznumber);
            http.send(HttpMethod.GET,
                    url,
                    params,
                    new RequestCallBack<String>()
                    {
                        
                        @Override
                        public void onSuccess(ResponseInfo<String> responseInfo)
                        {
                            
                            Intent intent5 = new Intent();
                            intent5.setClass(mContext,
                                    LoginActivity.class);
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
