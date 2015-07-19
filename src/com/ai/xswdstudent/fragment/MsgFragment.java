package com.ai.xswdstudent.fragment;

import java.util.ArrayList;
import java.util.List;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.activity.MsgSysAllActivity;
import com.ai.xswdstudent.activity.MsgSysNoReadActivity;
import com.ai.xswdstudent.adapter.Msg_Adapter;
import com.ai.xswdstudent.view.TabFragmentHost;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

public class MsgFragment extends Fragment{

	@ViewInject(R.id.txtsysmsgall)
	private TextView txtsysmsgall;
	
	@ViewInject(R.id.txtsysmsgnoread)
	private TextView txtsysmsgnoread;
	
	@ViewInject(R.id.pager_msg)
	private ViewPager pager_msg;
	
	//存放全部和未读两个view
	private List<View> listMsgView=new ArrayList<View>();
	
	//消息adapter
	private Msg_Adapter msg_Adapter;
	
	
	 @SuppressWarnings("deprecation")
	LocalActivityManager manager=null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view=inflater.inflate(R.layout.fragment_msg, null);
		ViewUtils.inject(this, view); //xutils必须加的
		
		return view;
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		manager= new LocalActivityManager(getActivity(), true);
		manager.dispatchCreate(savedInstanceState);
		initMsgViewPager();
	}


	@SuppressWarnings("deprecation")
	private void initMsgViewPager()
	{

		LayoutInflater mInflater = getActivity().getLayoutInflater();
//		listMsgView.add(mInflater.inflate(R.layout.activity_msg_sysall, null));
//		listMsgView.add(mInflater.inflate(R.layout.activity_msg_sysnoread, null));

		Intent intent_sysall = new Intent(getActivity(), MsgSysAllActivity.class);
		listMsgView.add(getView("MsgSysAllActivity", intent_sysall));
		Intent intent_noread = new Intent(getActivity(), MsgSysNoReadActivity.class);
		listMsgView.add(getView("MsgSysNoReadActivity", intent_noread));
		
		//listMsgView.add(mInflater.inflate(R.layout.activity_msg_sysnoread, null));
		
//		listMsgView.add(getLocalActivityManager().startActivity("1", new Intent(Hdjl.this, Hdjl_cx.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)).getDecorView());
//		
//		listViews.add(getLocalActivityManager().startActivity("1", new Intent(Hdjl.this, Hdjl_cx.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)).getDecorView()); 
//		
		msg_Adapter=new Msg_Adapter(listMsgView,getActivity());
		pager_msg.setAdapter(msg_Adapter);
		pager_msg.setCurrentItem(0);
		pager_msg.setOnPageChangeListener(myPageChangeListener);
		
	}
	private View getView(String id, Intent intent) {
		return manager.startActivity(id, intent).getDecorView();
	}
	
	//点击全部
	@OnClick(R.id.txtsysmsgall)
	public void onSysMsgAllClick(View v)
	{
		pager_msg.setCurrentItem(0);
	}
	
	
	//点击未读
	@OnClick(R.id.txtsysmsgnoread)
	public void onSysMsgNoRead(View v)
	{
		pager_msg.setCurrentItem(1);
	}
	
	//pageView 改变监听
	
	OnPageChangeListener myPageChangeListener=new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int arg0) {
			Drawable drawable;
			switch (arg0) {
			case 0:
				txtsysmsgall.setTextColor(Color.WHITE);
				txtsysmsgnoread.setTextColor(Color.rgb(174, 227, 253));  
				

				drawable=getActivity().getResources().getDrawable(R.drawable.msg_point_sel);  
				drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
				txtsysmsgall.setCompoundDrawables(drawable,null,null,null);
				
				drawable=getActivity().getResources().getDrawable(R.drawable.msg_point_nor);  
				drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
				txtsysmsgnoread.setCompoundDrawables(drawable,null,null,null);
				
				break;
			case 1:
				txtsysmsgall.setTextColor(Color.rgb(174, 227, 253));
				txtsysmsgnoread.setTextColor(Color.WHITE);
				
				drawable=getActivity().getResources().getDrawable(R.drawable.msg_point_sel);  
				drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
				txtsysmsgnoread.setCompoundDrawables(drawable,null,null,null);
				
				drawable=getActivity().getResources().getDrawable(R.drawable.msg_point_nor);  
				drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
				txtsysmsgall.setCompoundDrawables(drawable,null,null,null);

				
				break;
			default:
				break;
			}
			
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}
	};
	
}
