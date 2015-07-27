package com.ai.xswdstudent.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.JudgeTeacher_Me_Adapter.ViewHolder;
import com.lidroid.xutils.ViewUtils;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class TDetailsCourse_Adapter extends BaseAdapter{

	List<Map<String, Object>> listDetailsCourseData=new ArrayList<Map<String,Object>>();
	private Context mContext;
	private LayoutInflater mInflater;
	ViewHolder holder=null;
	
	
	
	public TDetailsCourse_Adapter(
			List<Map<String, Object>> listDetailsCourseData, Context mContext) {
		super();
		this.listDetailsCourseData = listDetailsCourseData;
		this.mContext = mContext;
		this.mInflater=LayoutInflater.from(mContext);
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listDetailsCourseData.size()*4;
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
			converView=mInflater.inflate(R.layout.item_tdetailscourse, null);

			holder.txtcourse=(TextView) converView.findViewById(R.id.txtcourse);		
			converView.setTag(holder);
		}else {
			holder=(ViewHolder) converView.getTag();
		}
		

		if (position % 7 ==0)
		{
			switch (position / 7) {
			case 0:
				holder.txtcourse.setText(listDetailsCourseData.get(0).get("day").toString());
				holder.txtcourse.setBackgroundColor(Color.rgb(72, 176, 239));
				holder.txtcourse.setTextColor(Color.rgb(255, 255, 255));
				break;
			case 1:
				holder.txtcourse.setText(listDetailsCourseData.get(0).get("sw").toString());
				break;
			case 2:
				holder.txtcourse.setText(listDetailsCourseData.get(0).get("xw").toString());	
				break;
			case 3:
				holder.txtcourse.setText(listDetailsCourseData.get(0).get("ws").toString());
			default:
				break;
			}
		}
		if (position % 7 ==1)
		{
			switch (position / 7) {
			case 0:
				holder.txtcourse.setText(listDetailsCourseData.get(1).get("day").toString());
				holder.txtcourse.setBackgroundColor(Color.rgb(101,188,241));
				holder.txtcourse.setTextColor(Color.rgb(255, 255, 255));
				break;
			case 1:
				holder.txtcourse.setText(listDetailsCourseData.get(1).get("sw").toString());
				break;
			case 2:
				holder.txtcourse.setText(listDetailsCourseData.get(1).get("xw").toString());	
				break;
			case 3:
				holder.txtcourse.setText(listDetailsCourseData.get(1).get("ws").toString());
			default:
				break;
			}
		}	
		if (position % 7 ==2)
		{
			switch (position / 7) {
			case 0:
				holder.txtcourse.setText(listDetailsCourseData.get(2).get("day").toString());
				holder.txtcourse.setBackgroundColor(Color.rgb(72, 176, 239));
				holder.txtcourse.setTextColor(Color.rgb(255, 255, 255));
				break;
			case 1:
				holder.txtcourse.setText(listDetailsCourseData.get(2).get("sw").toString());
				break;
			case 2:
				holder.txtcourse.setText(listDetailsCourseData.get(2).get("xw").toString());	
				break;
			case 3:
				holder.txtcourse.setText(listDetailsCourseData.get(2).get("ws").toString());
			default:
				break;
			}
		}
		
		if (position % 7 ==3)
		{
			switch (position / 7) {
			case 0:
				holder.txtcourse.setText(listDetailsCourseData.get(3).get("day").toString());
				holder.txtcourse.setBackgroundColor(Color.rgb(101,188,241));
				holder.txtcourse.setTextColor(Color.rgb(255, 255, 255));
				break;
			case 1:
				holder.txtcourse.setText(listDetailsCourseData.get(3).get("sw").toString());
				break;
			case 2:
				holder.txtcourse.setText(listDetailsCourseData.get(3).get("xw").toString());	
				break;
			case 3:
				holder.txtcourse.setText(listDetailsCourseData.get(3).get("ws").toString());
			default:
				break;
			}
		}
		if (position % 7 ==4)
		{
			switch (position / 7) {
			case 0:
				holder.txtcourse.setText(listDetailsCourseData.get(4).get("day").toString());
				holder.txtcourse.setBackgroundColor(Color.rgb(72, 176, 239));
				holder.txtcourse.setTextColor(Color.rgb(255, 255, 255));
				break;
			case 1:
				holder.txtcourse.setText(listDetailsCourseData.get(4).get("sw").toString());
				break;
			case 2:
				holder.txtcourse.setText(listDetailsCourseData.get(4).get("xw").toString());	
				break;
			case 3:
				holder.txtcourse.setText(listDetailsCourseData.get(4).get("ws").toString());
			default:
				break;
			}
		}
		
		if (position % 7 ==5)
		{
			switch (position / 7) {
			case 0:
				holder.txtcourse.setText(listDetailsCourseData.get(5).get("day").toString());
				holder.txtcourse.setBackgroundColor(Color.rgb(101,188,241));
				holder.txtcourse.setTextColor(Color.rgb(255, 255, 255));
				break;
			case 1:
				holder.txtcourse.setText(listDetailsCourseData.get(5).get("sw").toString());
				break;
			case 2:
				holder.txtcourse.setText(listDetailsCourseData.get(5).get("xw").toString());	
				break;
			case 3:
				holder.txtcourse.setText(listDetailsCourseData.get(5).get("ws").toString());
			default:
				break;
			}
		}
		if (position % 7 ==6)
		{
			switch (position / 7) {
			case 0:
				holder.txtcourse.setText(listDetailsCourseData.get(6).get("day").toString());
				holder.txtcourse.setBackgroundColor(Color.rgb(72, 176, 239));
				holder.txtcourse.setTextColor(Color.rgb(255, 255, 255));
				break;
			case 1:
				holder.txtcourse.setText(listDetailsCourseData.get(6).get("sw").toString());

				break;
			case 2:
				holder.txtcourse.setText(listDetailsCourseData.get(6).get("xw").toString());	
				break;
			case 3:
				holder.txtcourse.setText(listDetailsCourseData.get(6).get("ws").toString());
			default:
				break;
			}
		}

		
		
		return converView;
		
	}
	
	public final class ViewHolder
	{
		TextView txtcourse;
	}
}
