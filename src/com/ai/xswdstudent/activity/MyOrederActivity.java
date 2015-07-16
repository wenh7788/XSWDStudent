package com.ai.xswdstudent.activity;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.orederAdapter;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.ai.xswdstudent.model.order;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class MyOrederActivity  extends  BaseActivity
{
    
    
    
    /**
     * 上下文
     */
    private Context mContext;
    
    /**
     * 自定义 历史评语ExpandableListAdapter
     */
    
    private  orederAdapter mAdapter;
    
    /**
     * 集合
     * */
    ArrayList<order> histroyscorelist = new ArrayList<order>();
    
   
    
   int i = 0;
//    @ViewInject(R.id.my_name)
//    private LinearLayout  upName;
//    
//   
    private ListView  listOrder;
    @ViewInject(R.id.common_title_center_text)
    private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder);
        ViewUtils.inject(this); //xutils必加语句在      使用注解绑定控件的时候，一定记得在onCreate中调用
       // setTitle("家庭资料");
        title.setText("我的订单");
        innitData();
        initview();
      
    }
    
    
    private void initview()
    {
        
        listOrder = (ListView) findViewById(R.id.mplistview);
        mAdapter = new orederAdapter(
                MyOrederActivity.this, histroyscorelist);
        listOrder.setAdapter(mAdapter);
    }


    private void innitData()
    {
        order s = new order();
        s.fangshi = "老师上门";
        s.add = "南京雨花台区能仁里";
        s.time = "2015-07-05";
        order s1 = new order();
        s1.fangshi = "老师上门";
        s1.add = "南京雨花台区南京南";
        s1.time = "2015-07-05";
        order s2 = new order();
        s2.fangshi = "老师上门";
        s2.add = "南京雨花台区中华门";
        s2.time = "2015-07-05";
        histroyscorelist.add(s);
        histroyscorelist.add(s1);
        histroyscorelist.add(s2);
        
    }
    
    
    
//    @OnClick(R.id.mplistview)
//    public void onImgSearchClick(View v)
//    {
//        Toast.makeText(this, "我的订单", Toast.LENGTH_SHORT).show();
//      
//    }
//    
//  
//      
//    
//    @OnClick(R.id.my_sex)
//    public void onImgClick(View v)
//    {
//        Toast.makeText(this, "修改性别", Toast.LENGTH_SHORT).show();
//        Intent inten = new Intent();
//      inten.setClass(this, PersoncentUpdateNameActivity.class);
//     startActivity(inten);
//        
//    }
 
}
