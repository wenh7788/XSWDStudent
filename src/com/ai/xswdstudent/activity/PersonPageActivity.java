package com.ai.xswdstudent.activity;
import android.os.Bundle;
import android.widget.TextView;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.baseactivity.BaseActivity;


public class PersonPageActivity extends BaseActivity
{
    
    
    //¸öÈËÖ÷Ò³
 
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayout());
        initViews();
        
       
    }
    
    public void initViews()
    {
      
       
      
    }
    

    
    
    
    public int getActivityLayout()
    {
        return R.layout.student_comment;
    }
    
}
