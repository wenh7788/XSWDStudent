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

public class HomeWork_Adapter extends BaseAdapter{

	private List<Map<String, Object>> listHomeWorkData;
	private Context mContext;
	private LayoutInflater mInflater;
	ViewHolder holder=null;
	private BitmapUtils bitmapUtils; 
	private BitmapDisplayConfig bigPicDisplayConfig;  
	
	public HomeWork_Adapter(List<Map<String, Object>> listHomeWorkData,
			Context mContext,ListView listView) {
		super();
		this.listHomeWorkData = listHomeWorkData;
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
		return listHomeWorkData.size();
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
			converView=mInflater.inflate(R.layout.item_homework, null);
			ViewUtils.inject(holder, converView);
			
			holder.imghead=(ImageView)converView.findViewById(R.id.imghead);
			holder.txtusername=(TextView) converView.findViewById(R.id.txtusername);
			holder.txtgrade=(TextView) converView.findViewById(R.id.txtgrade);
			holder.txttime=(TextView) converView.findViewById(R.id.txttime);
			holder.txtquestionname=(TextView) converView.findViewById(R.id.txtquestionname);
			holder.txtquestiondetail=(TextView) converView.findViewById(R.id.txtquestiondetail);
			holder.imgquestionpic1=(ImageView) converView.findViewById(R.id.imgquestionpic1);
			holder.imgquestionpic2=(ImageView) converView.findViewById(R.id.imgquestionpic2);
			holder.imgquestionpic3=(ImageView) converView.findViewById(R.id.imgquestionpic3);
			holder.imgquestionpic4=(ImageView) converView.findViewById(R.id.imgquestionpic4);
			holder.txtanswercount=(TextView) converView.findViewById(R.id.txtanswercount);			
			converView.setTag(holder);
		}else {
			holder=(ViewHolder) converView.getTag();
		}
		
		bitmapUtils.display(holder.imghead,listHomeWorkData.get(position).get("imghead").toString(),bigPicDisplayConfig); 
		
		holder.txtusername.setText(listHomeWorkData.get(position).get("username").toString());
		holder.txtgrade.setText(listHomeWorkData.get(position).get("grade").toString());
		holder.txttime.setText(listHomeWorkData.get(position).get("time").toString());
		holder.txtquestionname.setText(listHomeWorkData.get(position).get("questionname").toString());
		holder.txtquestiondetail.setText(listHomeWorkData.get(position).get("questiondetail").toString());
		holder.txtanswercount.setText(listHomeWorkData.get(position).get("answercount").toString());
	
		
		holder.imgquestionpic1.setVisibility(View.GONE);
		holder.imgquestionpic2.setVisibility(View.GONE);
		holder.imgquestionpic3.setVisibility(View.GONE);
		holder.imgquestionpic4.setVisibility(View.GONE);
		
		
		Map<Integer, Object> map=(Map<Integer, Object>) listHomeWorkData.get(position).get("questionpic");
		
		
		for (Integer key : map.keySet()) {  
			
			
			System.out.println(position+"_____"+key+"____"+map.get(key).toString());
			
			switch (key) {
			case 0:
				holder.imgquestionpic1.setVisibility(View.VISIBLE);
				bitmapUtils.display(holder.imgquestionpic1,map.get(key).toString(),bigPicDisplayConfig); 
				
				break;
			case 1:
				holder.imgquestionpic2.setVisibility(View.VISIBLE);
				bitmapUtils.display(holder.imgquestionpic2,map.get(key).toString(),bigPicDisplayConfig); 
				
				break;
			case 2:
				holder.imgquestionpic3.setVisibility(View.VISIBLE);
				bitmapUtils.display(holder.imgquestionpic3,map.get(key).toString(),bigPicDisplayConfig); 
				
				break;
			case 3:
				holder.imgquestionpic4.setVisibility(View.VISIBLE);
				bitmapUtils.display(holder.imgquestionpic4,map.get(key).toString(),bigPicDisplayConfig); 
		
				break;
				
			default:
				holder.imgquestionpic1.setVisibility(View.GONE);
				holder.imgquestionpic2.setVisibility(View.GONE);
				holder.imgquestionpic3.setVisibility(View.GONE);
				holder.imgquestionpic4.setVisibility(View.GONE);
		
				break;
			}			
		}  
		
		return converView;
	}
	
	public final class ViewHolder
	{
		ImageView imghead;
		TextView txtusername;
		TextView txtgrade;
		TextView txttime;
		TextView txtquestionname;
		TextView txtquestiondetail;
		ImageView imgquestionpic1;
		ImageView imgquestionpic2;
		ImageView imgquestionpic3;
		ImageView imgquestionpic4;
		TextView txtanswercount;
	}
}
