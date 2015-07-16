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
     * ������
     */
    private Context mContext;
    
    /**
     * �Զ��� ��ʷ����ExpandableListAdapter
     */
    
    private  orederAdapter mAdapter;
    
    /**
     * ����
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
        ViewUtils.inject(this); //xutils�ؼ������      ʹ��ע��󶨿ؼ���ʱ��һ���ǵ���onCreate�е���
       // setTitle("��ͥ����");
        title.setText("�ҵĶ���");
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
        s.fangshi = "��ʦ����";
        s.add = "�Ͼ��껨̨��������";
        s.time = "2015-07-05";
        order s1 = new order();
        s1.fangshi = "��ʦ����";
        s1.add = "�Ͼ��껨̨���Ͼ���";
        s1.time = "2015-07-05";
        order s2 = new order();
        s2.fangshi = "��ʦ����";
        s2.add = "�Ͼ��껨̨���л���";
        s2.time = "2015-07-05";
        histroyscorelist.add(s);
        histroyscorelist.add(s1);
        histroyscorelist.add(s2);
        
    }
    
    
    
//    @OnClick(R.id.mplistview)
//    public void onImgSearchClick(View v)
//    {
//        Toast.makeText(this, "�ҵĶ���", Toast.LENGTH_SHORT).show();
//      
//    }
//    
//  
//      
//    
//    @OnClick(R.id.my_sex)
//    public void onImgClick(View v)
//    {
//        Toast.makeText(this, "�޸��Ա�", Toast.LENGTH_SHORT).show();
//        Intent inten = new Intent();
//      inten.setClass(this, PersoncentUpdateNameActivity.class);
//     startActivity(inten);
//        
//    }
 
}
