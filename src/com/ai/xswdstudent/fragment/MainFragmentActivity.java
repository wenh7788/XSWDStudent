package com.ai.xswdstudent.fragment;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.view.TabFragmentHost;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

public class MainFragmentActivity extends FragmentActivity {

	//定义FragmentTabHost对象
	private TabFragmentHost mTabHost;
	//定义一个布局
	private LayoutInflater layoutInflater;
	
	
	//定义数组来存放Fragment界面
	private Class fragmentArray[] = {HomeFragment.class,MsgFragment.class,ClassifyFragment.class,MineFragment.class};
	
	//定义数组来存放按钮图片
	private int mImageViewArray[] = {R.drawable.home_tab,R.drawable.msg_tab,
									 R.drawable.classify_tab,R.drawable.mine_tab};
	
	//Tab选项卡的文字
	private String mTextviewArray[] = {"首页", "消息", "分类", "我的"};

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragmentactivity_main);
		
		initView();
	}

	
	//初始化组建
	private void initView()
	{
		//实例化布局对象
		layoutInflater = LayoutInflater.from(this);
				
		//实例化TabHost对象，得到TabHost
		mTabHost = (TabFragmentHost)findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.maincontent);	
		
		//得到fragment的个数
		int count = fragmentArray.length;	
				
		for(int i = 0; i < count; i++){	
			//为每一个Tab按钮设置图标、文字和内容
			TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
			//将Tab按钮添加进Tab选项卡中
			mTabHost.addTab(tabSpec, fragmentArray[i], null);
			//设置Tab按钮的背景
			mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
			//mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);

		}
	}
	
	
	/**
	 * 给Tab按钮设置图标和文字
	 */
	private View getTabItemView(int index){
		View view = layoutInflater.inflate(R.layout.tab_item_view, null);
		
		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mImageViewArray[index]);
		TextView textView = (TextView) view.findViewById(R.id.textview);		
		textView.setText(mTextviewArray[index]);
	
		return view;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
