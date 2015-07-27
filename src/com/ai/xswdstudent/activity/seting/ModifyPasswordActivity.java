/*
 * 文 件 名:  ModifyPasswordActivity.java
 * 描    述:   修改密码页面
 */
package com.ai.xswdstudent.activity.seting;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.ai.xswdstudent.R;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.ai.xswdstudent.util.ProgressUtil;

/**
 * 修改密码页面
 * 
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ModifyPasswordActivity extends BaseActivity implements
        OnClickListener
{
    
    private EditText newPasswordEditText = null;
    
    private EditText  oldPasswordEdiText =null;
    
    private EditText  nextPassword=null;
    
    private Button submitButton = null;
    
    private String password;
    private String oldpassword;
    private String netpwd;
    
//    private NetHandler handler = new NetHandler(false)
//    {
//        
//        @Override
//        public void onResponse()
//        {
//            super.onResponse();
//            submitButton.setEnabled(true);
//        }
//        
//        @Override
//        public void onSuccess(String errMsg, Message msg)
//        {
//            // 修改密码成功后，删除首选项中保存的旧密码，并跳转到登录页面
////            SharedPreferences preferences = getSharedPreferences(GlobalConstant.UserInfoPreference.PREFERENCE_NAME,
////                    MODE_PRIVATE);
////            SharedPreferences.Editor editor = preferences.edit();
////            editor.putString(GlobalConstant.UserInfoPreference.PASSWORD, "");
////            editor.commit();
//            //取密码的shared和重置的不一致。导致登录密码获取值有问题。现将密码统一保存到shared中
//            SharedPreferencesUtil.saveSharedPreferences(mContext, GlobalConstant.UserInfoPreference.PASSWORD, password);
//            
//            Intent intent = new Intent(ModifyPasswordActivity.this,
//                    LoginActivity.class);
//            startActivity(intent);
//            finish();
//        }
//        
//        @Override
//        public void onFailed(String errCode, String errMsg, Message msg)
//        {
//            showToast(errMsg);
//        }
//    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayout());
        initViews();
      //  bindListener();
    }
    
    public void initViews()
    {
//        CommonTitleUtil.initCommonTitle(this,
//                getResources().getString(R.string.ysh_change_password),
//                null,
//                false,
//                true);
     
        newPasswordEditText = (EditText) findViewById(R.id.new_password_edittext);
        oldPasswordEdiText=(EditText) findViewById(R.id.modify_password_oldpwd);
        nextPassword=(EditText) findViewById(R.id.new_next_password_edittext);
        
        submitButton = (Button) findViewById(R.id.upate);
    }
    
    public void bindListener()
    {
        submitButton.setOnClickListener(this);
    }
    
    public int getActivityLayout()
    {
        return R.layout.updatepserson_pay_pasword;
    }
    
    @Override
    public void onClick(View v)
    {
        if (v == submitButton)
        {
            password = newPasswordEditText.getText().toString().trim();
            oldpassword= oldPasswordEdiText.getText().toString().trim();
            netpwd=nextPassword.getText().toString().trim();
            
            if (TextUtils.isEmpty(newPasswordEditText.getText()))
            {
                showToast("密码为空");
                return;
            }
            
            
            if (TextUtils.isEmpty(oldPasswordEdiText.getText()))
            {
                showToast("旧密码为空");
                return;
            }
            
            
            if (!netpwd.equals(password)) {
            	
            	 showToast("两次密码不一致");
                 return;
				
			}
            
                        if (password.length() < 6 || password.length() > 16)
                        {
                            showToast("密码不正确");
                            return;
                        }
            ProgressUtil.showProgressDialog(this,
                    "修改成功！");
            submitButton.setEnabled(false);
//            Map<String, String> param = HttpRequestUtil.getCommonParams("updatePassword");
//            param.put("newPassword", SecurityUtil.MD5(password));
//            param.put("oldPassword", SecurityUtil.MD5(oldpassword));
//            
//            HttpRequestUtil.sendHttpPostCommonRequest(mContext,
//                    HttpAddressProperties.MODIFY_PASSWORD_URL,
//                    param,
//                    CommonResp.class,
//                    handler);
        }
    }
}
