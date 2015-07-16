package com.ai.xswdstudent.fragment;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.activity.MyOrederActivity;
import com.ai.xswdstudent.activity.PersoncentActivity;
import com.ai.xswdstudent.activity.NextRegisterActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MineFragment extends Fragment
{
    //
    @ViewInject(R.id.tv_Persona_view)
    public  LinearLayout lyFamily;
    
    //我的订单 myorder_view
    
    @ViewInject(R.id.myorder_view)
    public  LinearLayout lyorder;
    @ViewInject(R.id.txtcity)
    private TextView txtcity;
    
//      @ViewInject(R.id.tv_famliy__view)
//       private  LinearLayout famliy;
      
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        
        View view = inflater.inflate(R.layout.fragment_mine, null);
        
        
        lyFamily = (LinearLayout) container.findViewById(R.id.tv_Persona_view);
        ViewUtils.inject(this, view); //xutils必须加的
        return view;
        
    }
    
//    private void bindListener()
//    {
//        // TODO Auto-generated method stub
//        lyFamily.setOnClickListener(new OnClickListener()
//        {
//            
//            @Override
//            public void onClick(View arg0)
//            {
//                Intent inten = new Intent();
//                inten.setClass(getActivity(), FamiliyActivity.class);
//                startActivity(inten);
//                
//            }
//        });
//        
//    }
    
    @OnClick(R.id.tv_Persona_view)
    public void onImgSearchClick(View v)
    {
        Toast.makeText(getActivity(), "点击搜索", Toast.LENGTH_SHORT).show();
        Intent inten = new Intent();
      inten.setClass(getActivity(), PersoncentActivity.class);
     startActivity(inten);
        
    }
    
    //我的订单
    @OnClick(R.id.myorder_view)
    public void onOrderClick(View v)
    {
        Toast.makeText(getActivity(), "我的订单", Toast.LENGTH_SHORT).show();
        Intent inten = new Intent();
      inten.setClass(getActivity(), MyOrederActivity.class);
     startActivity(inten);
        
    }
    
}
