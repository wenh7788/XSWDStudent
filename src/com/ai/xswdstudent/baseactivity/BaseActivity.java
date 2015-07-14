package com.ai.xswdstudent.baseactivity;


import com.ai.xswdstudent.view.CommonView;
import com.lidroid.xutils.ViewUtils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
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
	
}
