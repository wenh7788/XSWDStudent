package com.ai.xswdstudent.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ai.xswdstudent.R;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.bitmap.BitmapCommonUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.PauseOnScrollListener;

import android.R.integer;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class HomeWorkDetails_Adapter extends BaseAdapter{

	private List<Map<String, Object>> listHomeWorkDetailsData;
	private Context mContext;
	private LayoutInflater mInflater;
	ViewHolder holder=null;
	private BitmapUtils bitmapUtils; 
	private BitmapDisplayConfig bigPicDisplayConfig;  
	
	public HomeWorkDetails_Adapter(List<Map<String, Object>> listHomeWorkDetailsData,
			Context mContext,ListView listView) {
		super();
		this.listHomeWorkDetailsData = listHomeWorkDetailsData;
		this.mContext = mContext;
		this.mInflater=LayoutInflater.from(mContext);
		
		bitmapUtils = new BitmapUtils(this.mContext); 
		//bitmapUtils.configDefaultLoadFailedImage(R.drawable.defaulticon); 

		bigPicDisplayConfig = new BitmapDisplayConfig(); 
		
		bigPicDisplayConfig.setLoadingDrawable(mContext.getResources().getDrawable(R.drawable.defaulticon));  
		bigPicDisplayConfig.setLoadFailedDrawable(mContext.getResources().getDrawable(R.drawable.msg_point));  
		
		
		// bigPicDisplayConfig.setShowOriginal(true); // 显示原始图片,不压缩, 尽量不要使用, 
		// 图片太大时容易OOM。 
		bigPicDisplayConfig.setBitmapConfig(Bitmap.Config.RGB_565); 
		bigPicDisplayConfig.setBitmapMaxSize(BitmapCommonUtils.getScreenSize(mContext)); 
		listView.setOnScrollListener(new PauseOnScrollListener(bitmapUtils, false, true)); 
	
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listHomeWorkDetailsData.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View converView, ViewGroup parent) {
		if (converView == null) {
			holder=new ViewHolder();
			converView=mInflater.inflate(R.layout.item_homeworkdetails, null);
			ViewUtils.inject(holder, converView);
			
			holder.imghead_teacher=(ImageView)converView.findViewById(R.id.imghead_teacher);
			holder.txtusername_teacher=(TextView) converView.findViewById(R.id.txtusername_teacher);
			holder.txtauth_teacher=(TextView) converView.findViewById(R.id.txtauth_teacher);
			holder.txtworkage_teacher=(TextView) converView.findViewById(R.id.txtworkage_teacher);
			holder.txttime_teacher=(TextView) converView.findViewById(R.id.txttime_teacher);
			holder.txtanswer_teacher=(TextView) converView.findViewById(R.id.txtanswer_teacher);		
			converView.setTag(holder);
		}else {
			holder=(ViewHolder) converView.getTag();
		}
		
		bitmapUtils.display(holder.imghead_teacher,listHomeWorkDetailsData.get(position).get("imghead_tea").toString(),bigPicDisplayConfig); 
		
		holder.txtusername_teacher.setText(listHomeWorkDetailsData.get(position).get("username_tea").toString());
		holder.txtauth_teacher.setText(listHomeWorkDetailsData.get(position).get("renz_tea").toString());
		holder.txtworkage_teacher.setText(listHomeWorkDetailsData.get(position).get("age_tea").toString());
		holder.txttime_teacher.setText(listHomeWorkDetailsData.get(position).get("time_tea").toString());
		holder.txtanswer_teacher.setText(listHomeWorkDetailsData.get(position).get("answer_tea").toString());

		return converView;
	}
	
	public final class ViewHolder
	{
		ImageView imghead_teacher;
		TextView txtusername_teacher;
		TextView txtauth_teacher;
		TextView txtworkage_teacher;
		TextView txttime_teacher;
		TextView txtanswer_teacher;
	}
}
