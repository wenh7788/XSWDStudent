package com.ai.xswdstudent.fragment;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.activity.CitySelectActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFragment extends Fragment{

	@ViewInject(R.id.imgsearch)
	private ImageView imgsearch;
	@ViewInject(R.id.txtcity)
	private TextView txtcity;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_home, null);	
		ViewUtils.inject(this, view); //xutils必须加的
		return 	view;
		
	}

	@OnClick(R.id.imgsearch)
	public void onImgSearchClick(View v)
	{
		Toast.makeText(getActivity(), "点击搜索", Toast.LENGTH_SHORT).show();
	}
	
	@OnClick(R.id.txtcity)
	public void onTxtCityClick(View v)
	{
		Toast.makeText(getActivity(), "选择城市", Toast.LENGTH_SHORT).show();
		Intent intent=new Intent(getActivity(),CitySelectActivity.class);
		startActivity(intent);
	}
}
