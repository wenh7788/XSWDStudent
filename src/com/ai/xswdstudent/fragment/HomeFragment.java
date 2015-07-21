package com.ai.xswdstudent.fragment;

import java.util.ArrayList;
import java.util.List;










import com.ai.xswdstudent.R;
import com.ai.xswdstudent.activity.CitySelectActivity;
import com.ai.xswdstudent.activity.KcThcherFenleiActivity;
import com.ai.xswdstudent.activity.TcherActivity;
import com.ai.xswdstudent.activity.HomeWorkActivity;
import com.ai.xswdstudent.adapter.Ad_Adapter;
import com.ai.xswdstudent.util.LruImageCache;
import com.ai.xswdstudent.util.QRImageUtil;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.viewpagerindicator.CirclePageIndicator;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;

public class HomeFragment extends Fragment{

	private View rootView; //缓存fragment view
	
	@ViewInject(R.id.imgsearch)
	private ImageView imgsearch;
	@ViewInject(R.id.txtcity)
	private TextView txtcity;
	
	@ViewInject(R.id.pager_ad)
	private ViewPager pager_ad;
	@ViewInject(R.id.indicator_ad)
	private CirclePageIndicator indicator_ad;
	
	@ViewInject(R.id.btnscan)
	private Button btnscan;
	
	@ViewInject(R.id.btnhomework)
	private Button btnhomework;
	
	
	   @ViewInject(R.id.btntjls)
    private Button btn_techer;  //µã»÷ÀÏÊ¦ÈÎ¿Î
	   

       @ViewInject(R.id.btntjkc)
    private Button btn_jkc;  //µã»÷ÀÏÊ¦ÈÎ¿Î

	//´æ·Å´ÓÔ¶³Ì»ñµÃ¹ã¸æÍ¼Æ¬
	private List<ImageView> listAdView=new ArrayList<ImageView>();
	//广告图片adapter
	private Ad_Adapter ad_Adapter;
	
	//测试数据_后面删除
	private List<String> listImagepath;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		if (rootView ==null) {
			rootView=inflater.inflate(R.layout.fragment_home, null);	
		}
		
		ViewGroup parentGroup=(ViewGroup) rootView.getParent();
		if (parentGroup != null) {
			parentGroup.removeView(rootView);
		}
		
		
//		View view=inflater.inflate(R.layout.fragment_home, null);	
//		ViewUtils.inject(this, view); //xutils必须加的


		ViewUtils.inject(this, rootView); //xutils必须加的
		return 	rootView;
		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		


		initViewPager();

		//这句是生产二维码的：先暂时写在这里，其实后面是需要动态生成某个人的二维码链接的（我的-个人信息）。
		//imgsearch.setImageBitmap(QRImageUtil.createQRImage("http://www.baidu.com/"));
	}

	@Override
	public void onStart() {

		super.onStart();
		

	}

	
	private void initViewPager() {
		//以后要删除
		listImagepath=new ArrayList<String>();
		listImagepath.add("https://www.baidu.com/img/bd_logo1.png");
		listImagepath.add("https://www.baidu.com/img/bd_logo1.png");
		listImagepath.add("https://www.baidu.com/img/bd_logo1.png");
		listImagepath.add("https://www.baidu.com/img/bd_logo1.png");
		listImagepath.add("https://www.baidu.com/img/bd_logo1.png");
		listImagepath.add("https://www.baidu.com/img/bd_logo1.png");
		
		BitmapUtils utils = new BitmapUtils(getActivity()); 

		ImageView imgView;
		for (int i = 0; i < listImagepath.size(); i++) {
			imgView=new ImageView(getActivity());
			utils.display(imgView, listImagepath.get(i).toString());
			listAdView.add(imgView);
		}
		
		ad_Adapter=new Ad_Adapter(listAdView, getActivity());
		pager_ad.setAdapter(ad_Adapter);
		indicator_ad.setViewPager(pager_ad);
	}
	
	@OnClick(R.id.imgsearch)
	public void onImgSearchClick(View v)
	{
		Toast.makeText(getActivity(), "点击搜索", Toast.LENGTH_SHORT).show();
	}
	
	@OnClick(R.id.btntjls)
    public void oncherClick(View v)
    {
        Toast.makeText(getActivity(), "µã»÷ÀÏÊ¦", Toast.LENGTH_SHORT).show();
        
        Intent intent=new Intent(getActivity(),TcherActivity.class);
        startActivity(intent);
    }
	
	@OnClick(R.id.txtcity)
	public void onTxtCityClick(View v)
	{
		Toast.makeText(getActivity(), "选择城市", Toast.LENGTH_SHORT).show();
		Intent intent=new Intent(getActivity(),CitySelectActivity.class);
		startActivity(intent);
	}
	  //Ñ¡Ôñ¿Î³Ì
	
	   @OnClick(R.id.btntjkc)
	    public void ontClick(View v)
	    {
	        Toast.makeText(getActivity(), "Ñ¡Ôñ¿Î³ÌÀÏÊ¦", Toast.LENGTH_SHORT).show();
	        Intent intent=new Intent(getActivity(),KcThcherFenleiActivity.class);
	        startActivity(intent);
	    }
	
	//扫描上课
	@OnClick(R.id.btnscan)
	public void onBtnScanClick(View v)
	{
		
		btnscan.setTextColor(Color.rgb(247, 134, 66));
		btnhomework.setTextColor(Color.rgb(68, 68, 68));
		
		Drawable drawable;
		drawable=getActivity().getResources().getDrawable(R.drawable.smsk_sel);  
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
		btnscan.setCompoundDrawables(drawable,null,null,null);
		
		drawable=getActivity().getResources().getDrawable(R.drawable.zysq_nor);  
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
		btnhomework.setCompoundDrawables(drawable,null,null,null);
		
		
		
		
	}
	//作业神器
	@OnClick(R.id.btnhomework)
	public void onBtnHomeWorkClick(View v)
	{
		
		btnscan.setTextColor(Color.rgb(68, 68, 68));
		btnhomework.setTextColor(Color.rgb(247, 134, 66));
		
		Drawable drawable;
		drawable=getActivity().getResources().getDrawable(R.drawable.smsk_nor);  
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
		btnscan.setCompoundDrawables(drawable,null,null,null);
		
		drawable=getActivity().getResources().getDrawable(R.drawable.zysq_sel);  
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
		btnhomework.setCompoundDrawables(drawable,null,null,null);
	
		//跳转到作业神器页面
		
		Intent intent=new Intent(getActivity(),HomeWorkActivity.class);
		startActivity(intent);
	}

}
