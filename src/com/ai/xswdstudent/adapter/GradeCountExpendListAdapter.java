package com.ai.xswdstudent.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.model.order;
import com.ai.xswdstudent.util.ListUtil;


public class GradeCountExpendListAdapter extends BaseAdapter

{
    
    private ArrayList<order> mList;
    
    
    private LayoutInflater mInflater;
    
    private Context mContext;
    
    class ViewChildrenHolder
    {
        /**
         * 学科
         */
        private TextView mNameText;
        
        /**
         * 学科成绩
         */
        private TextView mScoreText;
    }
    
    class ViewGroupHolder
    {
        /**
         * 时间
         */
        TextView mTimeText;
        
        /**
         * 名称
         */
        TextView mNameText;
        
        /**
         * 箭头
         */
        ImageView mArrowImage;
    }
    
    public GradeCountExpendListAdapter(Context context, ArrayList<order> list)
    {
        this.mContext = context;
        this.mList = list;
        mInflater = LayoutInflater.from(context);
    }
    
    public void setList(ArrayList<order> list)
    {
        if (!ListUtil.isEmpty(list))
        {
            this.mList = list;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount()
    {
        // TODO Auto-generated method stub
        return mList.size();
    }

    @Override
    public Object getItem(int position)
    {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup arg2)
    {
        
        ViewGroupHolder holder = null;
        
        if (null == convertView)
        {
            holder = new ViewGroupHolder();
            //grade_comment_expand_children_item.xml
            convertView = mInflater.inflate(R.layout.myorder_listview_item,
                    null);
            
            holder.mTimeText = (TextView) convertView.findViewById(R.id.txt_start_class_style);
            holder.mNameText = (TextView) convertView.findViewById(R.id.txt_start_class_address);  
            holder.mNameText = (TextView) convertView.findViewById(R.id.txt_start_class_time_one);
            
            convertView.setTag(holder);
        }
        else
        {
            
            holder = (ViewGroupHolder) convertView.getTag();
        }
        
        if (null == mList)
        {
            return convertView;
        }
        order item = mList.get(position);
        if (null != item)
        {
            holder.mTimeText.setText(item.fangshi + "");
            holder.mNameText.setText(item.time);
            holder.mNameText.setText(item.add);
            
        }
          
        
        
        return convertView;
    }
    
   
}
