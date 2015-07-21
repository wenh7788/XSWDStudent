package com.ai.xswdstudent.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.model.ExamItem;
import com.ai.xswdstudent.util.ListUtil;



public class AllOrderListAdapter extends BaseAdapter
{
    
    /**
     * 考试集合
     */
    private ArrayList<ExamItem> mList=new ArrayList<ExamItem>();
    
    /**
     * 上下�?
     */
    private Context mContext;
    
    /**
     * 布局加载
     */
    private LayoutInflater mInflater;
    
    
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
         * 时间
         */
        TextView mtime;
    }
    
    
    @Override
    public int getCount()
    {
        return mList.size();
    }
    
    public AllOrderListAdapter(Context context,ArrayList<ExamItem> mList)
    {
        super();
        this.mContext=context;
        this.mList = mList;
        mInflater = LayoutInflater.from(context);
    }
    
    
    public void setList(ArrayList<ExamItem> list)
    {
        if (!ListUtil.isEmpty(list))
        {
            this.mList = list;
          //  notifyDataSetChanged();
        }else {
            
            Toast.makeText(mContext, "sssss", Toast.LENGTH_SHORT).show();
        }
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
    public View getView(int position, View convertView, ViewGroup parent)
    {
        
        ViewGroupHolder holder = null;
        
        if (null == convertView)
        {
            holder = new ViewGroupHolder();
//            convertView = mInflater.inflate(R.layout.my_dangqi_teacher_listview_item,
//                    null);
//      
//            holder.mtime = (TextView) convertView.findViewById(R.id.txt_teacher_name);
            
            convertView = mInflater.inflate(R.layout.myorder_listview_item,
                    null);
            
            holder.mtime = (TextView) convertView.findViewById(R.id.txt_start_class_style);
            holder.mNameText = (TextView) convertView.findViewById(R.id.txt_start_class_address);  
            holder.mTimeText = (TextView) convertView.findViewById(R.id.txt_start_class_time_one); 
            
            
            convertView.setTag(holder);
        }else {
            
            holder = (ViewGroupHolder) convertView.getTag();
        }
        
        if (null == mList)
        {
            return convertView;
        }
        ExamItem item = mList.get(position);
        if (null != item)
        {
            holder.mtime.setText(item.examinationName);
            
           
        }
      
    
        
//        
//        ViewGroupHolder holder = null; 
//        convertView = mInflater.inflate(R.layout.grade_count_expand_group_item,
//              null);
//      
//      holder.mTimeText = (TextView) convertView.findViewById(R.id.grade_count_expand_group_item_time);
//      holder.mNameText = (TextView) convertView.findViewById(R.id.grade_count_expand_group_item_name);
//      holder.mtime = (TextView) convertView.findViewById(R.id.grade_count_time);
//        
//      holder.mNameText.setText(Util.checkNull("期中考试"));
//    holder.mtime.setText(Util.checkNull("7.1-7.3"));
        
        return convertView;
    }
    
}
