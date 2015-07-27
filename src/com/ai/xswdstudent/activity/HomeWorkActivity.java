package com.ai.xswdstudent.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.Classify2_Adapter;
import com.ai.xswdstudent.adapter.HomeWork_Adapter;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

public class HomeWorkActivity extends BaseActivity{

    @ViewInject(R.id.txtbase_top_left)
    private TextView txtbase_top_left;
    
    @ViewInject(R.id.listhomework)	
    private ListView listhomework;
	
    @ViewInject(R.id.llayoutcourse)	
    private ListView llayoutcourse;
    
    List<Map<String, Object>> listHomeWorkData=new ArrayList<Map<String,Object>>();
    

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		System.out.println("HomeWorkActivity---��ҵ����");
		setContentView(R.layout.activity_homework);
		ViewUtils.inject(this); //xutils����ӵ�
		
		setTitle("��ҵ����");
		setRightTitle("�ҵ�����");
		setRightBackGround(R.drawable.txt_top_right_tjzy_selector);
		initView();
	}

	private void initView()
	{
		initListHomeWorkData();
		
		HomeWork_Adapter homework_adapter=new HomeWork_Adapter(listHomeWorkData,this,listhomework);
		
		listhomework.setAdapter(homework_adapter);
	}
	
	private void initListHomeWorkData()
	{

		Map<String, Object> map1= new HashMap<String,Object>();
		Map<Integer, Object> picMap1=new HashMap<Integer, Object>();
		
		picMap1.put(0, "https://www.baidu.com/img/bd_logo1.png");
		picMap1.put(1, "https://www.baidu.com/img/bd_logo1.png");

		
		map1.put("imghead", "https://www.baidu.com/img/bd_logo1.png");
		map1.put("username", "�ɷ�1");
		map1.put("grade", "���ж��꼶");
		map1.put("time", "2015-07-19 11:55");
		map1.put("questionname", "����Ӣ��ģ�⿼������");
		map1.put("questiondetail", "һ��6���⣬����һ��Сʱ��ɵġ���ʦ�ǰ��ҿ��´���ʲô���⣿");
		map1.put("questionpic", picMap1);
		map1.put("answercount", "����5λ��ʦ�ش����������");
		
		
		
		Map<String, Object> map2= new HashMap<String,Object>();
		Map<Integer, Object> picMap2=new HashMap<Integer, Object>();
		
		picMap2.put(0, "https://www.baidu.com/img/bd_logo1.png");
		picMap2.put(1, "https://www.baidu.com/img/bd_logo1.png");
		picMap2.put(2, "https://www.baidu.com/img/bd_logo1.png");
		picMap2.put(3, "https://www.baidu.com/img/bd_logo1.png");

		
		map2.put("imghead", "https://www.baidu.com/img/bd_logo1.png");
		map2.put("username", "�ɷ�2");
		map2.put("grade", "���ж��꼶");
		map2.put("time", "2015-07-19 11:55");
		map2.put("questionname", "����Ӣ��ģ�⿼������");
		map2.put("questiondetail", "һ��6���⣬����һ��Сʱ��ɵġ���ʦ�ǰ��ҿ��´���ʲô���⣿");
		map2.put("questionpic", picMap2);
		map2.put("answercount", "����5λ��ʦ�ش����������");	
		
		Map<String, Object> map3= new HashMap<String,Object>();
		Map<Integer, Object> picMap3=new HashMap<Integer, Object>();
		
		map3.put("imghead", "https://www.baidu.com/img/bd_logo1.png");
		map3.put("username", "�ɷ�3");
		map3.put("grade", "���ж��꼶");
		map3.put("time", "2015-07-19 11:55");
		map3.put("questionname", "����Ӣ��ģ�⿼������");
		map3.put("questiondetail", "һ��6���⣬����һ��Сʱ��ɵġ���ʦ�ǰ��ҿ��´���ʲô���⣿");
		map3.put("questionpic", picMap3);
		map3.put("answercount", "����5λ��ʦ�ش����������");		
		
		Map<String, Object> map4= new HashMap<String,Object>();
		Map<Integer, Object> picMap4=new HashMap<Integer, Object>();
		
		picMap4.put(0, "https://www.baidu.com/img/bd_logo1.png");
		picMap4.put(1, "https://www.baidu.com/img/bd_logo1.png");
		picMap4.put(2, "https://www.baidu.com/img/bd_logo1.png");
		picMap4.put(3, "https://www.baidu.com/img/bd_logo1.png");

		map4.put("imghead", "https://www.baidu.com/img/bd_logo1.png");
		map4.put("username", "�ɷ�4");
		map4.put("grade", "���ж��꼶");
		map4.put("time", "2015-07-19 11:55");
		map4.put("questionname", "����Ӣ��ģ�⿼������");
		map4.put("questiondetail", "һ��6���⣬����һ��Сʱ��ɵġ���ʦ�ǰ��ҿ��´���ʲô���⣿");
		map4.put("questionpic", picMap4);
		map4.put("answercount", "����5λ��ʦ�ش����������");	
		
		
		listHomeWorkData.add(map1);
		listHomeWorkData.add(map2);
		listHomeWorkData.add(map3);
		listHomeWorkData.add(map4);
		
	}
	
	@OnItemClick(R.id.listhomework)  
    public void itemClick_listHomeWork(AdapterView<?> parent, View view, int position,long id) {  
       
		//�ǵô��ݲ���������homeworkid
		Intent intent =new Intent(this,HomeWorkDetailsActivity.class);
		startActivity(intent);
		
		
//		if (listClassify2Data.get(position)!=null && listClassify2Data.get(position).size()>0) {
//			
//			classify2_Adapter=new Classify2_Adapter(listClassify2Data.get(position), getActivity());
//			listclassify2.setAdapter(classify2_Adapter);
//			
//			listclassify2.setVisibility(View.VISIBLE);
//			listclassify3.setVisibility(View.INVISIBLE);
//		}
//		else {
//			listclassify2.setVisibility(View.INVISIBLE);
//			listclassify3.setVisibility(View.INVISIBLE);
//			Toast.makeText(getActivity(), "û������", Toast.LENGTH_SHORT).show();
//		}

    } 
	
	
    @OnClick(R.id.txtbase_top_left)
    public void onBaseTopLeft(View v)
    {
        finish();
    }	
    @OnClick(R.id.txtbase_top_right)
    public void onBaseTopRight(View v)
    {
    	Intent intent=new Intent(this,HomeWorkOfMineActivity.class);
    	startActivity(intent);
        Toast.makeText(this, "��ת���ҵ�����ҳ��", Toast.LENGTH_SHORT).show();
    }	
    
    @OnClick(R.id.llayoutcourse)
    public void onLLayoutCourseClick(View v)
    {
    	
    	Intent intent=new Intent(this,CourseWheelActivity.class);
    	startActivity(intent);
    }
    
    
}
