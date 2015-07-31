package com.ai.xswdstudent.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.activity.RegisterActivity;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.ai.xswdstudent.fragment.MainFragmentActivity;
import com.ai.xswdstudent.global.GlobalConstant;
import com.ai.xswdstudent.util.StringUtil;
import com.ai.xswdstudent.xsaplication.SharedPreferencesUtil;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class LoginActivity extends BaseActivity
{
    
    /**
     * 忘记密码
     */
    private TextView forgetPwdText;
    
    /**
     * 手机号输入框
     */
    
    @ViewInject(R.id.login_telphone_edittext)
    private EditText telphoneEditText;
    
    /**
     * 密码输入框
     */
    
    @ViewInject(R.id.login_password_edittext)
    private EditText passwordEditText = null;
    
    /**
     * 记住密码checkBox
     */
    
    private LinearLayout checkBoxLayout = null;
    
    /**
     * 登录按钮
     */
    @ViewInject(R.id.login_submit)
    private LinearLayout loginButton = null;
    
    /***
     * 注册按钮
     */
    @ViewInject(R.id.register_submit)
    private LinearLayout registerSubmit = null;
    
    /**
     * 记住密码选择框
     */
    private CheckBox rememberCheckBox = null;
    
    /**
     * 手机号
     */
    private String telphone = "";
    
    /**
     * 密码
     */
    private String password = "";
    
    /**
     * 登录用户
     */
   // private UserItem loginUserItem = XSApplication.getInstance().loginUserItem;
    
    private ImageView mImageView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wx_login_activity);
        ViewUtils.inject(this); //xutils必加语句在      使用注解绑定控件的时候，一定记得在onCreate中调用
      //  setTitle("");
       // initData();
    }
    
//    private void initData()
//    {
//        telphoneEditText.setText(SharedPreferencesUtil.getSharedPreferences(mContext,
//                GlobalConstant.UserInfoPreference.TELPHONE,
//                ""));
//        passwordEditText.setText(SharedPreferencesUtil.getSharedPreferences(mContext,
//                GlobalConstant.UserInfoPreference.PASSWORD,
//                ""));
//        rememberCheckBox.setChecked(SharedPreferencesUtil.getSharedPreferences(mContext,
//                GlobalConstant.REMEMBER_PASSWORD,
//                false));
//    }
    
 

    
    @OnClick(R.id.login_submit)
    public void btn_testClick(View v)
    
    {
        
        telphone = telphoneEditText.getText().toString().trim();
        password = passwordEditText.getText().toString().trim();
        if (StringUtil.isEmpty(telphone))
        {
            showToast(getString(R.string.ysh_telphone_empty));
        }
        
        else if (StringUtil.isEmpty(password))
        {
            showToast(getString(R.string.ysh_password_empty));
        }
        else
        {
            HttpUtils http = new HttpUtils();
            String url = "http://59.175.144.98:8080/msxxw/webservice/rest/UserRTS/login";
            RequestParams params = new RequestParams();
            params.addQueryStringParameter("userName", telphone);
            params.addQueryStringParameter("password", password);
            
            http.send(HttpMethod.POST,
                    url,
                    params,
                    new RequestCallBack<String>()
                    {
                        
                        @Override
                        public void onSuccess(ResponseInfo<String> responseInfo)
                        {
                            //                          UserItem userInfo=JSON.parseObject(responseInfo.result,UserItem.class); 
                            //                          Toast.makeText(getApplicationContext(), "请求结果：" + userInfo.phone, Toast.LENGTH_SHORT).show(); 
                            
//                            SharedPreferencesUtil.saveSharedPreferences(mContext,
//                                    GlobalConstant.REMEMBER_PASSWORD,
//                                    rememberCheckBox.isChecked());
                            Intent intent5 = new Intent();
                            intent5.setClass(LoginActivity.this,
                                    MainFragmentActivity.class);
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
    
    
    
    
    
    @OnClick(R.id.register_submit)
    public void btn_regClick(View v){
        
        Intent intent1 = new Intent(this, RegisterActivity.class);
        startActivity(intent1);
        
        
    }
    
    
   
}
