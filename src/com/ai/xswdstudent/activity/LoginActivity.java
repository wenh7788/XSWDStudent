package com.ai.xswdstudent.activity;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.ai.xswdstudent.model.UserItem;
import com.ai.xswdstudent.xsaplication.XSApplication;

public class LoginActivity extends BaseActivity 
{
    
    
    /**
     * 忘记密码
     */
    private TextView forgetPwdText;
    
    /**
     * 手机号输入框
     */
    private EditText telphoneEditText = null;
    
    /**
     * 密码输入框
     */
    private EditText passwordEditText = null;
    
    /**
     * 记住密码checkBox
     */
    private LinearLayout checkBoxLayout = null;
    
    /**
     * 登录按钮
     */
    private LinearLayout loginButton = null;
    
    /***
     * 注册按钮
     */
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
    private UserItem loginUserItem = XSApplication.getInstance().loginUserItem;
    
    private ImageView mImageView;
    
    
}
