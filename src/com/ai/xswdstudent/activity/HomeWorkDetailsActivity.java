package com.ai.xswdstudent.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.HomeWorkDetails_Adapter;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.bitmap.BitmapCommonUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class HomeWorkDetailsActivity extends BaseActivity{

    @ViewInject(R.id.txtbase_top_left)
    private TextView txtbase_top_left;
    @ViewInject(R.id.txtbase_top_right)
    private TextView txtbase_top_right;
    
    List<Map<String, Object>> listHomeWorDetailsData=new ArrayList<Map<String,Object>>();
    
    @ViewInject(R.id.listhomeworkdetails)	
    private ListView listhomeworkdetails;
	
    @ViewInject(R.id.imghead)	
    private ImageView imghead;    
    
    @ViewInject(R.id.txtusername)	
    private TextView txtusername;    

    @ViewInject(R.id.txtgrade)	
    private TextView txtgrade;    
        
    @ViewInject(R.id.txttime)	
    private TextView txttime;    

    @ViewInject(R.id.txtquestionname)	
    private TextView txtquestionname;    
     
    @ViewInject(R.id.txtquestiondetail)	
    private TextView txtquestiondetail;    

    @ViewInject(R.id.imgquestionpic1)	
    private ImageView imgquestionpic1;    
     
    @ViewInject(R.id.imgquestionpic2)	
    private ImageView imgquestionpic2;  
    
    @ViewInject(R.id.imgquestionpic3)	
    private ImageView imgquestionpic3;  
    
    @ViewInject(R.id.imgquestionpic4)	
    private ImageView imgquestionpic4;      
    
	private BitmapUtils bitmapUtils; 
	private BitmapDisplayConfig bigPicDisplayConfig;
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_homeworkdetails);
		ViewUtils.inject(this); //xutils必须加的
		
		setTitle("详情");
		
		setRightTitle("",R.drawable.top_right_del);
		setRightBackGround(R.drawable.txt_top_right_tjzy_selector);
		
		initView();
		System.out.println("HomeWorkDetailsActivity.class----作业神器-作业详情");
	
	}
	
	private void initView()
	{
		initHomeWorkDetailsData();
		
		bitmapUtils = new BitmapUtils(this); 
		bigPicDisplayConfig = new BitmapDisplayConfig(); 
		bigPicDisplayConfig.setLoadingDrawable(getResources().getDrawable(R.drawable.defaulticon));  
		bigPicDisplayConfig.setLoadFailedDrawable(getResources().getDrawable(R.drawable.msg_point));  
		bigPicDisplayConfig.setBitmapConfig(Bitmap.Config.RGB_565); 
		bigPicDisplayConfig.setBitmapMaxSize(BitmapCommonUtils.getScreenSize(mContext)); 
		
		bitmapUtils.display(imghead,listHomeWorDetailsData.get(0).get("imghead").toString(),bigPicDisplayConfig); 
		txtusername.setText(listHomeWorDetailsData.get(0).get("username").toString());
		txtgrade.setText(listHomeWorDetailsData.get(0).get("grade").toString());
		txttime.setText(listHomeWorDetailsData.get(0).get("time").toString());
		txtquestionname.setText(listHomeWorDetailsData.get(0).get("questionname").toString());
		txtquestiondetail.setText(listHomeWorDetailsData.get(0).get("questiondetail").toString());

		imgquestionpic1.setVisibility(View.GONE);
		imgquestionpic2.setVisibility(View.GONE);
		imgquestionpic3.setVisibility(View.GONE);
		imgquestionpic4.setVisibility(View.GONE);
		
		Map<Integer, Object> map=(Map<Integer, Object>) listHomeWorDetailsData.get(0).get("questionpic");
			
		for (Integer key : map.keySet()) {  	
			System.out.println("_____"+key+"____"+map.get(key).toString());
			
			switch (key) {
			case 0:
				imgquestionpic1.setVisibility(View.VISIBLE);
				bitmapUtils.display(imgquestionpic1,map.get(key).toString(),bigPicDisplayConfig); 
				
				break;
			case 1:
				imgquestionpic2.setVisibility(View.VISIBLE);
				bitmapUtils.display(imgquestionpic2,map.get(key).toString(),bigPicDisplayConfig); 
				
				break;
			case 2:
				imgquestionpic3.setVisibility(View.VISIBLE);
				bitmapUtils.display(imgquestionpic3,map.get(key).toString(),bigPicDisplayConfig); 
				
				break;
			case 3:
				imgquestionpic4.setVisibility(View.VISIBLE);
				bitmapUtils.display(imgquestionpic4,map.get(key).toString(),bigPicDisplayConfig); 
		
				break;
				
			default:
				imgquestionpic1.setVisibility(View.GONE);
				imgquestionpic2.setVisibility(View.GONE);
				imgquestionpic3.setVisibility(View.GONE);
				imgquestionpic4.setVisibility(View.GONE);
				break;
			}			
		}  

		HomeWorkDetails_Adapter homewordetails_adapter=new HomeWorkDetails_Adapter((List<Map<String, Object>>) listHomeWorDetailsData.get(0).get("answerteachers"),this,listhomeworkdetails);
		
		
		listhomeworkdetails.setAdapter(homewordetails_adapter);
		
	}
	

	private void initHomeWorkDetailsData()
	{

		Map<String, Object> map1= new HashMap<String,Object>();
		Map<Integer, Object> picMap1=new HashMap<Integer, Object>();

		
		
		picMap1.put(0, "https://www.baidu.com/img/bd_logo1.png");
		picMap1.put(1, "https://www.baidu.com/img/bd_logo1.png");

		Map<String, Object> teaMap1=new HashMap<String, Object>();		
		teaMap1.put("imghead_tea", "https://www.baidu.com/img/bd_logo1.png");
		teaMap1.put("username_tea", "温晓敏1");
		teaMap1.put("renz_tea", "3项认证");
		teaMap1.put("age_tea", "4年教龄");
		teaMap1.put("time_tea", "2015-07-20 21：03");
		teaMap1.put("answer_tea", "这里放问题答案");

		Map<String, Object> teaMap2=new HashMap<String, Object>();		
		teaMap2.put("imghead_tea", "https://www.baidu.com/img/bd_logo1.png");
		teaMap2.put("username_tea", "温晓敏2");
		teaMap2.put("renz_tea", "3项认证");
		teaMap2.put("age_tea", "4年教龄");
		teaMap2.put("time_tea", "2015-07-20 21：03");
		teaMap2.put("answer_tea", "这里放问题答案");
		
		
		List<Map<String, Object>> listTeacherData= new ArrayList<Map<String,Object>>();
		listTeacherData.add(teaMap1);
		listTeacherData.add(teaMap2);
		
		
		map1.put("imghead", "https://www.baidu.com/img/bd_logo1.png");
		map1.put("username", "飞飞1");
		map1.put("grade", "初中二年级");
		map1.put("time", "2015-07-19 11:55");
		map1.put("questionname", "初二英语模拟考题批改");
		map1.put("questiondetail", "一共6大题，花了一个小时完成的。老师们帮我看下存在什么问题？");
		map1.put("questionpic", picMap1);
		map1.put("answercount", "已有5位老师回答了你的问题");
		map1.put("answerteachers", listTeacherData);
		
		listHomeWorDetailsData.add(map1);	
	}
	
    @OnClick(R.id.txtbase_top_left)
    public void onBaseTopLeft(View v)
    {
        finish();
    }	
    @OnClick(R.id.txtbase_top_right)
    public void onBaseTopRight(View v)
    {
        Toast.makeText(this, "点击删除", Toast.LENGTH_SHORT).show();
        
        Intent intent=new Intent(this,DelActivity.class);
        
        intent.putExtra("flag", "HomeWorkDetailsActivity");
        intent.putExtra("title", "提示");
        intent.putExtra("content", "你确定要删除此条提问吗？");
        
        startActivity(intent);
        
    }
}
