package com.ai.xswdstudent.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.activity.AboutUsActivity;
import com.ai.xswdstudent.activity.BakeContentActivity;
import com.ai.xswdstudent.activity.CollectionActivity;
import com.ai.xswdstudent.activity.MyOderListActivity;
import com.ai.xswdstudent.activity.MyOrederActivity;
import com.ai.xswdstudent.activity.PersoncentActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class MineFragment extends Fragment  implements OnClickListener
{
    //
    
    private ProgressDialog progressDialog = null;
    
    /**
     * 閫氱煡鏇存柊涓嬭浇杩涘害鏉＄殑鏍囪瘑
     */
    public static final int UPDATE_PROGRESSBAR = 1001;
    
    @ViewInject(R.id.tv_Persona_view)
    public  LinearLayout lyFamily;
    
    //鎴戠殑璁㈠崟 myorder_view
    
    @ViewInject(R.id.myorder_view)
    public  LinearLayout lyorder;
    @ViewInject(R.id.txtcity)
    private TextView txtcity;
    
//      @ViewInject(R.id.tv_famliy__view)
//       private  LinearLayout famliy;
    
    //妫�鏌ョ増鏈洿鏂�
    @ViewInject(R.id.my_jianchangenxin_ly)
    public  LinearLayout jianchaupdate;
    
    
    @ViewInject(R.id.my_guanyuwomen_ly)
    public  LinearLayout guanyu;
    //鏀惰棌
    @ViewInject(R.id.my_shouchang_ly)
    public  LinearLayout shouchang;
    
    
    
    //鍙嶉
    @ViewInject(R.id.my_yijianfankui_ly)
    public  LinearLayout fankui;
    
    
    
    
    
    
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        
        View view = inflater.inflate(R.layout.fragment_mine, null);
        
        
        lyFamily = (LinearLayout) container.findViewById(R.id.tv_Persona_view);
        ViewUtils.inject(this, view); //xutils蹇呴』鍔犵殑
        bindListener();
        return view;
        
    }
    
private void bindListener()
    {
    guanyu.setOnClickListener(this);
    jianchaupdate.setOnClickListener(this);
    shouchang.setOnClickListener(this);
    fankui.setOnClickListener(this);
        
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
        Toast.makeText(getActivity(), "鐐瑰嚮鎼滅储", Toast.LENGTH_SHORT).show();
        Intent inten = new Intent();
      inten.setClass(getActivity(), PersoncentActivity.class);
     startActivity(inten);
        
    }
    
    //鎴戠殑璁㈠崟
    @OnClick(R.id.myorder_view)
    public void onOrderClick(View v)
    {
        Toast.makeText(getActivity(), "鎴戠殑璁㈠崟", Toast.LENGTH_SHORT).show();
        Intent inten = new Intent();
      inten.setClass(getActivity(), MyOderListActivity.class);
     startActivity(inten);
        
    }

    @Override
    public void onClick(View v)
    {
        
        
        
        if (v == jianchaupdate)
        {
            
               
            Toast.makeText(getActivity(), "妫�娴嬬増鏈洿鏂�", Toast.LENGTH_SHORT).show();
        }
        else if (v == guanyu)
        {
            
            Toast.makeText(getActivity(), "鍏充簬鎴戜滑", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(), AboutUsActivity.class);
            startActivity(intent);
        }else if(v==shouchang){
            Toast.makeText(getActivity(), "鏀惰棌", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(), CollectionActivity.class);
            startActivity(intent);
            
        }else if(v==fankui){
            Toast.makeText(getActivity(), "鍙嶉", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(), BakeContentActivity.class);
            startActivity(intent);
            
        }
    }
    
}
