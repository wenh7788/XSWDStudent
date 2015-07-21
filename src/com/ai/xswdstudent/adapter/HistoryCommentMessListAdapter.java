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
import com.ai.xswdstudent.model.SubjectItem;
import com.ai.xswdstudent.util.ListUtil;




public class HistoryCommentMessListAdapter extends BaseAdapter
{
    
    private ArrayList<SubjectItem> mList = new ArrayList<SubjectItem>();
    
    private Context mContext;
    
    private LayoutInflater mInflater;
    
    class ViewGroupHolder
    {
        /**
         * 分数
         */
        TextView mscore;
        
        /**
         * 等级
         */
        TextView mleve;
        
        /**
         * 时间
         */
        TextView mMess;
    }
    
    @Override
    public int getCount()
    {
        return mList.size();
    }
    
    public HistoryCommentMessListAdapter(Context context,
            ArrayList<SubjectItem> mList)
    {
        super();
        this.mContext = context;
        this.mList = mList;
        mInflater = LayoutInflater.from(context);
    }
    
    public void setList(ArrayList<SubjectItem> list)
    {
        if (!ListUtil.isEmpty(list))
        {
            this.mList = list;
            //  notifyDataSetChanged();
        }
        else
        {
            
            Toast.makeText(mContext, "ccc", Toast.LENGTH_SHORT).show();
        }
    }
    
    //    
    //    public  void setDate(ArrayList<ExamItem> list){
    //        
    //        
    //        if (!ListUtil.isEmpty(list))
    //          {
    //            
    //            list=new ArrayList<ExamItem>();
    //            ExamItem  m=new ExamItem();
    //            m.examinationId="hello";
    //            ExamItem  m1=new ExamItem();
    //            m.examinationId="hello2";
    //            list.add(m);
    //            list.add(m1);
    //              this.mList = list;
    //             // notifyDataSetChanged();
    //          }else {
    //              
    //              Toast.makeText(mContext, "返回数据为空！！�?, Toast.LENGTH_SHORT).show();
    //          }
    //          
    //    }
    
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
            //grade_comment_expand_children_item.xml
            convertView = mInflater.inflate(R.layout.grade_comment_expand_children_item,
                    null);
            
            holder.mscore = (TextView) convertView.findViewById(R.id.tv_score);
            holder.mleve = (TextView) convertView.findViewById(R.id.tv_leve);
            holder.mMess = (TextView) convertView.findViewById(R.id.tv_mteacherComments);
            
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
        SubjectItem item = mList.get(position);
        if (null != item)
        {
            holder.mscore.setText(item.score + "");
            holder.mleve.setText(item.scoreLevel);
            holder.mMess.setText(item.teacherComments);
            
        }
        
        return convertView;
    }
    
}
