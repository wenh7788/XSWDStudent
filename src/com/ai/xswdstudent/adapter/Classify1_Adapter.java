package com.ai.xswdstudent.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.Classify2_Adapter.ViewHolder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Classify1_Adapter extends BaseAdapter{

	private List<Map<String, Integer>> listClassify1Data;
	private Context mContext;
	private LayoutInflater mInflater;
	ViewHolder holder=null;
	
	
	public Classify1_Adapter(List<Map<String, Integer>> listClassify1Data,
			Context mContext) {
		super();
		this.listClassify1Data = listClassify1Data;
		this.mContext = mContext;
		this.mInflater=LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listClassify1Data.size();
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
			converView=mInflater.inflate(R.layout.item_classify1, null);
			holder.txtClassify1=(TextView) converView.findViewById(R.id.txtclassify1);
			converView.setTag(holder);
		}else {
			holder=(ViewHolder) converView.getTag();
		}
		//这边直接将listitem赋值给对应的字段
		
		Map<String, Integer> map=new HashMap<String, Integer>();
		map=listClassify1Data.get(position);
		
		String strkey="";
		int ivalue=0;
		
		for (String key : map.keySet()) {  
			strkey=key;
			ivalue=map.get(key);
		}  
		
		holder.txtClassify1.setText(strkey);
		
		Drawable drawable=mContext.getResources().getDrawable(ivalue);  
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());  
		holder.txtClassify1.setCompoundDrawables(drawable,null,null,null);
		
		return converView;
	}
	
	public final class ViewHolder
	{
		public TextView txtClassify1;
	}
}
