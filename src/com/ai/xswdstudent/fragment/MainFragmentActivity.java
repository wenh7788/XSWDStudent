package com.ai.xswdstudent.fragment;

import com.ai.xswdstudent.R;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

public class MainFragmentActivity extends FragmentActivity {

	//����FragmentTabHost����
	private FragmentTabHost mTabHost;
	//����һ������
	private LayoutInflater layoutInflater;
	
	
	//�������������Fragment����
	private Class fragmentArray[] = {HomeFragment.class,MsgFragment.class,ClassifyFragment.class,MineFragment.class};
	
	//������������Ű�ťͼƬ
	private int mImageViewArray[] = {R.drawable.home_tab,R.drawable.msg_tab,
									 R.drawable.classify_tab,R.drawable.mine_tab};
	
	//Tabѡ�������
	private String mTextviewArray[] = {"��ҳ", "��Ϣ", "����", "�ҵ�"};

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragmentactivity_main);
		
		initView();
	}

	
	//��ʼ���齨
	private void initView()
	{
		//ʵ�������ֶ���
		layoutInflater = LayoutInflater.from(this);
				
		//ʵ����TabHost���󣬵õ�TabHost
		mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.maincontent);	
		
		//�õ�fragment�ĸ���
		int count = fragmentArray.length;	
				
		for(int i = 0; i < count; i++){	
			//Ϊÿһ��Tab��ť����ͼ�ꡢ���ֺ�����
			TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
			//��Tab��ť��ӽ�Tabѡ���
			mTabHost.addTab(tabSpec, fragmentArray[i], null);
			//����Tab��ť�ı���
			mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
			//mTabHost.getTabWidget().getChildAt(i).setBackgroundColor(R.drawable.selector_tab_background);
		}
	}
	
	
	/**
	 * ��Tab��ť����ͼ�������
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
