package com.ai.xswdstudent.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.Classify1_Adapter.ViewHolder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MsgSysNoRead_Adapter extends BaseAdapter{

	
	List<Map<String, Object>> listMsgSysNoReadData;
	private Context mContext;
	private LayoutInflater mInflater;
	ViewHolder holder=null;
	
	public MsgSysNoRead_Adapter(List<Map<String, Object>> listMsgSysNoReadData,
			Context mContext) {
		super();
		this.listMsgSysNoReadData = listMsgSysNoReadData;
		this.mContext = mContext;
		this.mInflater=LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listMsgSysNoReadData.size();
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
			converView=mInflater.inflate(R.layout.item_msgsysnoread, null);
			holder.txtmsgtitle=(TextView) converView.findViewById(R.id.txtmsgtitle);
			holder.txtmsgtime=(TextView) converView.findViewById(R.id.txtmsgtime);
			holder.txtmsgcontent=(TextView) converView.findViewById(R.id.txtmsgcontent);
			holder.txtgo=(TextView) converView.findViewById(R.id.txtgo);
			converView.setTag(holder);
		}else {
			holder=(ViewHolder) converView.getTag();
		}
		//���ֱ�ӽ�listitem��ֵ����Ӧ���ֶ�
		
		
		Map<String, Object> map=new HashMap<String, Object>();
		map=listMsgSysNoReadData.get(position);
	
		holder.txtmsgtitle.setText(listMsgSysNoReadData.get(position).get("msgtype").toString());
		holder.txtmsgtime.setText(listMsgSysNoReadData.get(position).get("msgtime").toString());
		holder.txtmsgcontent.setText(listMsgSysNoReadData.get(position).get("msgcontent").toString());
		
		if (("").equals(listMsgSysNoReadData.get(position).get("dotype").toString()))
		{
			holder.txtgo.setVisibility(View.INVISIBLE);
		}
		else {
			holder.txtgo.setVisibility(View.VISIBLE);
			holder.txtgo.setText(listMsgSysNoReadData.get(position).get("dotype").toString());
			holder.txtgo.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(mContext, "���", Toast.LENGTH_SHORT).show();
				}
			});
		}
		

		return converView;
	}

	
	public final class ViewHolder
	{
		public TextView txtmsgtitle;
		public TextView txtmsgtime;
		public TextView txtmsgcontent;
		public TextView txtgo;
	}
}
