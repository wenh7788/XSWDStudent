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

	//����view
	CommonView commonView;
	
    protected Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//��ӵ�Activity����

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
     * ��ʾToast��ʾ��Ϣ
     * @param message
     * @see [�ࡢ��#��������#��Ա]
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

        //����Activity&�Ӽ������Ƴ�

        AppManager.getInstance().finishActivity(this);

    }
	
}
