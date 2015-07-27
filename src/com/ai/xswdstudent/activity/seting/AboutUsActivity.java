package com.ai.xswdstudent.activity.seting;
import android.os.Bundle;
import android.widget.TextView;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.baseactivity.BaseActivity;


public class AboutUsActivity extends BaseActivity
{
    
    private TextView aboutTextview = null;
    
    private TextView mVersionView;
    
   
    
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayout());
        initViews();
       
    }
    
    public void initViews()
    {
      
        aboutTextview = (TextView) findViewById(R.id.about_textview);
        mVersionView = (TextView) findViewById(R.id.about_version_text);
        
      
    }
    

    
    
    
    public int getActivityLayout()
    {
        return R.layout.ysh_aboutus_activity;
    }
    
}
