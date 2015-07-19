package com.ai.xswdstudent.adapter;

import java.util.Map;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.Classify3_Adapter.ViewHolder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Classify2_Adapter extends BaseAdapter{

	
	private Map<String, Object> mapClassify2Data;
	private Context mContext;
	private LayoutInflater mInflater;
	ViewHolder holder=null;
	
	
	
	public Classify2_Adapter(Map<String, Object> mapClassify2Data,
			Context mContext) {
		super();
		this.mapClassify2Data = mapClassify2Data;
		this.mContext = mContext;
		this.mInflater=LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mapClassify2Data.size();
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
			converView=mInflater.inflate(R.layout.item_classify2, null);
			holder.txtClassify2=(TextView) converView.findViewById(R.id.txtclassify2);
			converView.setTag(holder);
		}else {
			holder=(ViewHolder) converView.getTag();
		}
		//这边直接将listitem赋值给对应的字段
		holder.txtClassify2.setText(mapClassify2Data.get(String.valueOf(position)).toString());
		return converView;
	}
	
	public final class ViewHolder
	{
		public TextView txtClassify2; 
	}
}
