package com.ai.xswdstudent.adapter;

import java.util.List;
import java.util.Map;

import com.ai.xswdstudent.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Classify3_Adapter extends BaseAdapter{

	private Map<String, Object> mapClassify3Data;
	private Context mContext;
	private LayoutInflater mInflater;
	ViewHolder holder=null;
	
	
	public Classify3_Adapter(Map<String, Object> mapClassify3Data,
			Context mContext) {
		super();
		this.mapClassify3Data = mapClassify3Data;
		this.mContext = mContext;
		this.mInflater=LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mapClassify3Data.size();
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
			converView=mInflater.inflate(R.layout.item_classify3, null);
			holder.txtClassify3=(TextView) converView.findViewById(R.id.txtclassify3);
			converView.setTag(holder);
		}else {
			holder=(ViewHolder) converView.getTag();
		}
		//这边直接将listitem赋值给对应的字段
		holder.txtClassify3.setText(mapClassify3Data.get(String.valueOf(position)).toString());

		Drawable drawable=mContext.getResources().getDrawable(R.drawable.jiantougren);  
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
		holder.txtClassify3.setCompoundDrawables(null,null,drawable,null);

		return converView;
	}

	
	public final class ViewHolder
	{
		public TextView txtClassify3; 
	}
}
