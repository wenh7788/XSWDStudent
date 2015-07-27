package com.ai.xswdstudent.activity.seting;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.activity.PersoncentActivity;
import com.ai.xswdstudent.baseactivity.BaseActivity;


public class ChangePwdZActivity extends BaseActivity
{
    
    private LinearLayout chagepwd ;
    
    private LinearLayout change_pay_pwd;
    
   
    
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayout());
        initViews();
    }
    
 
    public void initViews()
    {
      
        chagepwd = (LinearLayout) findViewById(R.id.ly_chagepwd);
        change_pay_pwd = (LinearLayout) findViewById(R.id.ly_change_pay_pwd);
        
        chagepwd.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View arg0)
            {
                Intent inten = new Intent();
                inten.setClass(ChangePwdZActivity.this, ModifyPasswordActivity.class);
               startActivity(inten);
                
            }
        });
        
        
        
        
        change_pay_pwd.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View arg0)
            {
                Intent inten = new Intent();
                inten.setClass(ChangePwdZActivity.this, ModifyPasswordActivity.class);
               startActivity(inten);
                  
                
            }
        });
        
        
      
    }
    
    
 
        
     
    

    
    
    
    
    public int getActivityLayout()
    {
        return R.layout.personcenter_one_pwd;
    }
    
}
