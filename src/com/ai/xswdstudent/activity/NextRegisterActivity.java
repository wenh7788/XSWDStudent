package com.ai.xswdstudent.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ai.xswdstudent.R;
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

public class NextRegisterActivity extends BaseActivity
{
    
    @ViewInject(R.id.et_register_vertification)
    //��֤����տ�
    private EditText YZNuber;
    
    @ViewInject(R.id.et_register_password)
    //����
    private EditText Pssword;
    //������֤�뵹��ʱ
    @ViewInject(R.id.btn_register_vertification)
    private Button btn_sendMess;
    
    @ViewInject(R.id.btn_register_next)
    private Button btn_reg;
    
    private String mobile;
    
    private String yzm;
    
    private String pwd;
    
    private TimeCount  time;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_two);
        ViewUtils.inject(this); //xutils�ؼ������      ʹ��ע��󶨿ؼ���ʱ��һ���ǵ���onCreate�е���
        time = new TimeCount(60000, 1000);
        setTitle("ע��");
        
    }
    
    //������֤��
    @OnClick(R.id.btn_register_vertification)
    private void btn_sendMess(){
        time.start();
       
    }
    
    //��ȡ����ʱ
    
    class TimeCount extends CountDownTimer {
        
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
 
        @Override
        public void onTick(long millisUntilFinished) {
            btn_sendMess.setBackgroundColor(Color.WHITE);
            btn_sendMess.setClickable(false);
            btn_sendMess.setText(millisUntilFinished / 1000 + "�������·���");
        }
 
        @Override
        public void onFinish() {
            btn_sendMess.setText("���»�ȡ��֤��");
            btn_sendMess.setClickable(true);
            btn_sendMess.setBackgroundColor(Color.BLACK);  //Color.parseColor(#4EB84A)
 
        }
    }
    
    @OnClick(R.id.btn_register_next)
    public void btn_RegClick(View v)
    {
        
        yzm = YZNuber.getText().toString().trim();
        pwd = Pssword.getText().toString().trim();
        mobile = getIntent().getStringExtra("mobile1");
        
        if (StringUtil.isEmpty(mobile))
        {
            showToast(getString(R.string.telphone_empty));
        }
        else if (StringUtil.isEmpty(pwd))
        {
            showToast(getString(R.string.ysh_password_empty));
        }
        
        else
        {
            
            HttpUtils http = new HttpUtils();
            String url = "http://192.168.1.6/UserService.svc/GetPerson";
            RequestParams params = new RequestParams();
            params.addQueryStringParameter("phone", mobile);
            params.addQueryStringParameter("yzm", yzm);
            params.addQueryStringParameter("pwd", pwd);
            http.send(HttpMethod.GET,
                    url,
                    params,
                    new RequestCallBack<String>()
                    {
                        
                        @Override
                        public void onSuccess(ResponseInfo<String> responseInfo)
                        {
                            
                            Intent intent5 = new Intent();
                            intent5.setClass(mContext, LoginActivity.class);
                            startActivity(intent5);
                            finish();
                        }
                        
                        @Override
                        public void onFailure(HttpException error, String msg)
                        {
                            Toast.makeText(getApplicationContext(),
                                    "��½ʧ��" + msg,
                                    Toast.LENGTH_SHORT).show();
                        }
                        
                    });
            
        }
        
    }
    
}
