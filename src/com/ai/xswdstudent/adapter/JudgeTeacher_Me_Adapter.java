package com.ai.xswdstudent.adapter;

import java.util.List;
import java.util.Map;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.HomeWork_Adapter.ViewHolder;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.bitmap.BitmapCommonUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.PauseOnScrollListener;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class JudgeTeacher_Me_Adapter extends BaseAdapter{

	
	private List<Map<String, Object>> listJudgeToTeacherData;
	private Context mContext;
	private LayoutInflater mInflater;
	ViewHolder holder=null;
	private BitmapUtils bitmapUtils; 
	private BitmapDisplayConfig bigPicDisplayConfig;  
	
	
	
	public JudgeTeacher_Me_Adapter(
			List<Map<String, Object>> listJudgeToTeacherData, Context mContext,ListView listView) {
		super();
		this.listJudgeToTeacherData = listJudgeToTeacherData;
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
		return listJudgeToTeacherData.size();
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
			converView=mInflater.inflate(R.layout.item_judge, null);
			ViewUtils.inject(holder, converView);
			
			holder.imghead=(ImageView)converView.findViewById(R.id.imghead);
			holder.txtusername=(TextView) converView.findViewById(R.id.txtusername);
			holder.txtclassname=(TextView) converView.findViewById(R.id.txtclassname);
			holder.txtprice=(TextView) converView.findViewById(R.id.txtprice);
			holder.txtjudgecontent=(TextView) converView.findViewById(R.id.txtjudgecontent);
			holder.rbarjudge=(RatingBar) converView.findViewById(R.id.rbarjudge);
			holder.txttime=(TextView) converView.findViewById(R.id.txttime);		
			converView.setTag(holder);
		}else {
			holder=(ViewHolder) converView.getTag();
		}
		
		bitmapUtils.display(holder.imghead,listJudgeToTeacherData.get(position).get("imghead").toString(),bigPicDisplayConfig); 
		
		holder.txtusername.setText(listJudgeToTeacherData.get(position).get("username").toString());
		holder.txtclassname.setText(listJudgeToTeacherData.get(position).get("classname").toString());
		holder.txtprice.setText(listJudgeToTeacherData.get(position).get("price").toString());
		holder.txtjudgecontent.setText(listJudgeToTeacherData.get(position).get("content").toString());
		holder.rbarjudge.setProgress(Integer.valueOf(listJudgeToTeacherData.get(position).get("score").toString()));
		holder.txttime.setText(listJudgeToTeacherData.get(position).get("time").toString());

		
		
		
		return converView;
	}

	public final class ViewHolder
	{
		ImageView imghead;
		TextView txtusername;
		TextView txtclassname;
		TextView txtprice;
		TextView txtjudgecontent;
		RatingBar rbarjudge;
		TextView txttime;
	}
	
}
