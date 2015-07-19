package com.ai.xswdstudent.fragment;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.Classify1_Adapter;
import com.ai.xswdstudent.adapter.Classify2_Adapter;
import com.ai.xswdstudent.adapter.Classify3_Adapter;
import com.ai.xswdstudent.view.ArrowListView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ClassifyFragment extends Fragment{

	@ViewInject(R.id.listclassify1)
	private ArrowListView listclassify1;
	
	@ViewInject(R.id.listclassify2)
	private ListView listclassify2;
	
	@ViewInject(R.id.listclassify3)
	private ListView listclassify3;
	
	
	
	//分类1测试数据
	private List<Map<String, Integer>> listClassify1Data=new ArrayList<Map<String,Integer>>();
	//分类2测试数据
	private List<Map<String, Object>> listClassify2Data=new ArrayList<Map<String,Object>>();
	//分类3测试数据
	private List<Map<String, Object>> listClassify3Data=new ArrayList<Map<String,Object>>();
	
	//分类1测试adapter
	Classify1_Adapter classify1_Adapter;
	//分类2测试adapter
	Classify2_Adapter classify2_Adapter;	
	//分类3测试adapter
	Classify3_Adapter classify3_Adapter;	
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view=inflater.inflate(R.layout.fragment_classify, null);	
		ViewUtils.inject(this, view); //xutils必须加的
		return 	view;
	}



	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		initView();
	}

	//初始化视图
	public void initView()
	{
		
		listclassify1.setVisibility(View.VISIBLE);
		listclassify2.setVisibility(View.INVISIBLE);
		listclassify3.setVisibility(View.INVISIBLE);
		
		initClassify1Data();
		initClassify2Data();
		initClassify3Data();	
		
		classify1_Adapter=new Classify1_Adapter(listClassify1Data, getActivity());
//		classify2_Adapter=new Classify2_Adapter(listClassify2Data.get(0), getActivity());
//		classify3_Adapter=new Classify3_Adapter(listClassify3Data.get(0), getActivity());
//		
		listclassify1.setAdapter(classify1_Adapter);
//		listclassify2.setAdapter(classify2_Adapter);
//		listclassify3.setAdapter(classify3_Adapter);
	}
	
	//初始化分类1数据
	public void initClassify1Data()
	{
		Map<String, Integer> map1=new HashMap<String, Integer>();
		map1.put("学前", R.drawable.classify_xqian);

		Map<String, Integer> map2=new HashMap<String, Integer>();
		map2.put("小学", R.drawable.classify_xx);

		Map<String, Integer> map3=new HashMap<String, Integer>();
		map3.put("初中", R.drawable.classify_cz);
		
		Map<String, Integer> map4=new HashMap<String, Integer>();
		map4.put("高中", R.drawable.classify_gz);
		
		Map<String, Integer> map5=new HashMap<String, Integer>();
		map5.put("大学", R.drawable.classify_dx);
		
		Map<String, Integer> map6=new HashMap<String, Integer>();
		map6.put("艺术", R.drawable.classify_ys);
		
		Map<String, Integer> map7=new HashMap<String, Integer>();
		map7.put("兴趣", R.drawable.classify_xqian);
		
		Map<String, Integer> map8=new HashMap<String, Integer>();
		map8.put("语言", R.drawable.classify_yy);
		
		Map<String, Integer> map9=new HashMap<String, Integer>();
		map9.put("留学", R.drawable.classify_lx);
		
		Map<String, Integer> map10=new HashMap<String, Integer>();
		map10.put("管理", R.drawable.classify_gl);
		
		Map<String, Integer> map11=new HashMap<String, Integer>();
		map11.put("金融", R.drawable.classify_jr);
		
		Map<String, Integer> map12=new HashMap<String, Integer>();
		map12.put("公务员", R.drawable.classify_gwy);	
		
		
		listClassify1Data.add(map1);
		listClassify1Data.add(map2);
		listClassify1Data.add(map3);
		listClassify1Data.add(map4);
		listClassify1Data.add(map5);
		listClassify1Data.add(map6);
		listClassify1Data.add(map7);
		listClassify1Data.add(map8);
		listClassify1Data.add(map9);
		listClassify1Data.add(map10);
		listClassify1Data.add(map11);
		listClassify1Data.add(map12);
	}
	//初始化分类2数据
	public void initClassify2Data()
	{
		Map<String, Object> map1=new HashMap<String, Object>();
		map1.put("0", "学前数学");
		map1.put("1", "学前语文");
		map1.put("2", "学前英语");
		map1.put("3", "学前地理");
		map1.put("4", "学前政治");
		map1.put("5", "学前物理");		
		map1.put("6", "学前化学");
		map1.put("7", "学前历史");		
		map1.put("8", "学前生物");				
		
		Map<String, Object> map2=new HashMap<String, Object>();
		
		Map<String, Object> map3=new HashMap<String, Object>();
		map3.put("0", "初中数学");
		map3.put("1", "初中语文");
		map3.put("2", "初中英语");
		map3.put("3", "初中地理");
		map3.put("4", "初中政治");
		map3.put("5", "初中物理");		
		map3.put("6", "初中化学");
		map3.put("7", "初中历史");		
		map3.put("8", "初中生物");	

		Map<String, Object> map4=new HashMap<String, Object>();
		Map<String, Object> map5=new HashMap<String, Object>();
		Map<String, Object> map6=new HashMap<String, Object>();
		Map<String, Object> map7=new HashMap<String, Object>();
		Map<String, Object> map8=new HashMap<String, Object>();
		Map<String, Object> map9=new HashMap<String, Object>();
		Map<String, Object> map10=new HashMap<String, Object>();
		Map<String, Object> map11=new HashMap<String, Object>();
		Map<String, Object> map12=new HashMap<String, Object>();
		
		listClassify2Data.add(map1);
		listClassify2Data.add(map2);	
		listClassify2Data.add(map3);
		listClassify2Data.add(map4);
		listClassify2Data.add(map5);	
		listClassify2Data.add(map6);
		listClassify2Data.add(map7);
		listClassify2Data.add(map8);	
		listClassify2Data.add(map9);
		listClassify2Data.add(map10);
		listClassify2Data.add(map11);	
		listClassify2Data.add(map12);		
		
		
	}
	
	//初始化分类3数据
	public void initClassify3Data()
	{
		
		Map<String, Object> map1=new HashMap<String, Object>();
		map1.put("0", "初一数学");
		map1.put("1", "初二数学");		
		map1.put("2", "初三数学");
		map1.put("3", "初一数学");

		Map<String, Object> map2=new HashMap<String, Object>();
		map2.put("0", "初一语文");
		map2.put("1", "初二语文");		
		map2.put("2", "初三语文");
		map2.put("3", "初一语文");
		
		Map<String, Object> map3=new HashMap<String, Object>();
		Map<String, Object> map4=new HashMap<String, Object>();
		Map<String, Object> map5=new HashMap<String, Object>();
		Map<String, Object> map6=new HashMap<String, Object>();
		Map<String, Object> map7=new HashMap<String, Object>();
		Map<String, Object> map8=new HashMap<String, Object>();
		Map<String, Object> map9=new HashMap<String, Object>();
		Map<String, Object> map10=new HashMap<String, Object>();
		Map<String, Object> map11=new HashMap<String, Object>();
		Map<String, Object> map12=new HashMap<String, Object>();
		

		listClassify3Data.add(map1);
		listClassify3Data.add(map2);	
		listClassify3Data.add(map3);
		listClassify3Data.add(map4);
		listClassify3Data.add(map5);	
		listClassify3Data.add(map6);
		listClassify3Data.add(map7);
		listClassify3Data.add(map8);	
		listClassify3Data.add(map9);
		listClassify3Data.add(map10);
		listClassify3Data.add(map11);	
		listClassify3Data.add(map12);		
	}
	
	
	//分类1_itemclick
	@OnItemClick(R.id.listclassify1)  
    public void itemClick_listClassify1(AdapterView<?> parent, View view, int position,long id) {  
       
		if (listClassify2Data.get(position)!=null && listClassify2Data.get(position).size()>0) {
			
			classify2_Adapter=new Classify2_Adapter(listClassify2Data.get(position), getActivity());
			listclassify2.setAdapter(classify2_Adapter);
			
			listclassify2.setVisibility(View.VISIBLE);
			listclassify3.setVisibility(View.INVISIBLE);
		}
		else {
			listclassify2.setVisibility(View.INVISIBLE);
			listclassify3.setVisibility(View.INVISIBLE);
			Toast.makeText(getActivity(), "没有数据", Toast.LENGTH_SHORT).show();
		}

    } 
	//分类2_itemclick
	@OnItemClick(R.id.listclassify2)  
    public void itemClick_listClassify2(AdapterView<?> parent, View view, int position,long id) {  
	       
		if (listClassify3Data.get(position)!=null && listClassify3Data.get(position).size()>0) {
			
			classify3_Adapter=new Classify3_Adapter(listClassify3Data.get(position), getActivity());
			listclassify3.setAdapter(classify3_Adapter);
			
			listclassify3.setVisibility(View.VISIBLE);
		}
		else {
			listclassify3.setVisibility(View.INVISIBLE);
			Toast.makeText(getActivity(), "没有数据", Toast.LENGTH_SHORT).show();
		}

    } 
	//分类3_itemclick
	@OnItemClick(R.id.listclassify3)  
    public void itemClick_listClassify3(AdapterView<?> parent, View view, int position,long id) {  
	       
		Toast.makeText(getActivity(), "调整去课程界面：编号是_"+position+"", Toast.LENGTH_SHORT).show();
    } 	
}
