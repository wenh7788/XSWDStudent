package com.ai.xswdstudent.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.MsgSysAll_Adapter.ViewHolder;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Wallet_Adapter extends BaseAdapter{

	List<Map<String, Object>> listAcctData;
	private Context mContext;
	private LayoutInflater mInflater;
	ViewHolder holder=null;
	
	
	
	public Wallet_Adapter(List<Map<String, Object>> listAcctData,
			Context mContext) {
		super();
		this.listAcctData = listAcctData;
		this.mContext = mContext;
		this.mInflater=LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listAcctData.size();
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
			converView=mInflater.inflate(R.layout.item_acct, null);
			holder.txtkk=(TextView) converView.findViewById(R.id.txtkk);
			holder.txtkktime=(TextView) converView.findViewById(R.id.txtkktime);
			holder.txtcz=(TextView) converView.findViewById(R.id.txtcz);
			holder.txtcztime=(TextView) converView.findViewById(R.id.txtcztime);
			holder.txtpoint=(TextView) converView.findViewById(R.id.txtpoint);
			holder.llayoutleft=(LinearLayout) converView.findViewById(R.id.llayoutleft);
			holder.llayoutright=(LinearLayout) converView.findViewById(R.id.llayoutright);
			
			converView.setTag(holder);
		}else {
			holder=(ViewHolder) converView.getTag();
		}
		
	
		if (listAcctData.get(position).get("flag").toString().equals("0")) //¿Û¿î
		{
			holder.llayoutleft.setVisibility(View.VISIBLE);
			holder.llayoutright.setVisibility(View.INVISIBLE);
			
			holder.txtkk.setText(listAcctData.get(position).get("money").toString());
			holder.txtkktime.setText(listAcctData.get(position).get("time").toString());		
			holder.txtpoint.setBackgroundColor(Color.rgb(247,134,66));
		}
		else //³äÖµ
		{
			holder.llayoutleft.setVisibility(View.INVISIBLE);
			holder.llayoutright.setVisibility(View.VISIBLE);
			
			holder.txtcz.setText(listAcctData.get(position).get("money").toString());
			holder.txtcztime.setText(listAcctData.get(position).get("time").toString());		
			holder.txtpoint.setBackgroundColor(Color.rgb(71, 179, 243));
	
			
		}		
		return converView;
	}

	public final class ViewHolder
	{
		public TextView txtkk;
		public TextView txtkktime;
		public TextView txtcz;
		public TextView txtcztime;
		public TextView txtpoint;
		public LinearLayout llayoutleft;
		public LinearLayout llayoutright;
		
	}	
	
	
}
