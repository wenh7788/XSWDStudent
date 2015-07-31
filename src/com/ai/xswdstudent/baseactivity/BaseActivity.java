package com.ai.xswdstudent.baseactivity;


import com.ai.xswdstudent.R;
import com.ai.xswdstudent.view.CommonView;
import com.lidroid.xutils.ViewUtils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

public class BaseActivity extends Activity{

	//公共view
	CommonView commonView;
	
    protected Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//添加到Activity集合

        AppManager.getInstance().addActivity(BaseActivity.this);

	}
	
	private CommonView getCommonView()
	{
		if(commonView == null)
		{
			commonView=new CommonView(this);
		}
		return commonView;
	}
	
    /**
     * 显示Toast提示信息
     * @param message
     * @see [类、类#方法、类#成员]
     */
    public void showToast(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    
	

	public void setTitle(String str)
	{
		getCommonView().initBaseTopMid().setText(str);
	}

	public void setRightTitle(String str)
	{
		getCommonView().initBaseTopRight().setText(str);
	}
	
	public void setRightTitle(String str,int iRes)
	{
		getCommonView().initBaseTopRight().setText(str);
		getCommonView().initBaseTopRight().setPadding(35, 5, 5,0);
		Drawable drawable=getResources().getDrawable(iRes);  
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
		getCommonView().initBaseTopRight().setCompoundDrawables(drawable,null,null,null);
	
		
	}
	
	
	public void setRightBackGround(int iRes)
	{
		getCommonView().initBaseTopRight().setBackgroundResource(iRes);
	}
	
	
	@Override

    protected void onDestroy() {

        super.onDestroy();

        //结束Activity&从集合中移除

        AppManager.getInstance().finishActivity(this);

    }
	
}
