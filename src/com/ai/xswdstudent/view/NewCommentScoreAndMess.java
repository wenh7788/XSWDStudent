package com.ai.xswdstudent.view;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.HistoryCommentMessListAdapter;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.ai.xswdstudent.model.SubjectItem;



public class NewCommentScoreAndMess extends BaseActivity
{
    
    ListView lv;
    
    /**
     * 上下�?
     */
    private Context mContext;
    
    /**
     * 自定�?历史评语ExpandableListAdapter
     */
    
    private HistoryCommentMessListAdapter mAdapter;
    
    /**
     * 成绩集合
     * */
    ArrayList<SubjectItem> histroyscorelist = new ArrayList<SubjectItem>();
    
    ImageView back;
    
    TextView title;
    
    // myAdapter m = new myAdapter();
    /**
     * 显示科目的滑动控�?
     * */
    int i = 0;
    
    //grade_comment_expand_children_item
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_mess_layout);
        initViews();
        innitData();
    }
    
    private void innitData()
    {
        SubjectItem s = new SubjectItem();
        s.score = 17.5;
        s.scoreLevel = "c";
        s.teacherComments = "考的不错";
        SubjectItem s1 = new SubjectItem();
        s1.score = 17.5;
        s1.scoreLevel = "c";
        s1.teacherComments = "考的不错";
        SubjectItem s2 = new SubjectItem();
        s2.score = 17.5;
        s2.scoreLevel = "c";
        s2.teacherComments = "考的不错";
        histroyscorelist.add(s);
        histroyscorelist.add(s1);
        histroyscorelist.add(s2);
        
    }
    
    public void initViews()
    {
        mContext = NewCommentScoreAndMess.this;
        lv = (ListView) findViewById(R.id.lv_score_mess);
        mAdapter = new HistoryCommentMessListAdapter(
                NewCommentScoreAndMess.this, histroyscorelist);
        lv.setAdapter(mAdapter);
        
    }
    
 
    

}
