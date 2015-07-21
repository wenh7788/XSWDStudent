package com.ai.xswdstudent.view;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.adapter.CollectionListNoAdapter;
import com.ai.xswdstudent.adapter.NewTecherCommentListAdapter;
import com.ai.xswdstudent.model.ExamItem;



public class CollectionNoPageView extends LinearLayout
{
    
    private ListView mListView;
    
    /**
     * Context上下�?
     */
    private Context mContext;
    
    private Button btnchange;
    
    private CollectionListNoAdapter mAdapter;
   // private Myadapter  TimeAdapter;
    
    /**
     * 组集�?
     */
    private ArrayList<ExamItem> mList = new ArrayList<ExamItem>();
    
    /**
     * GroupPosition 选中的组的位�?
     */
    
    private int position = -1;
    
    private TextView mGradeText;
    
    public CollectionNoPageView(Context context)
    {
        super(context);
        init(context);
        setDate();
    }
    
    private void init(Context context)
    {
        mContext = context;
        inflate(context, R.layout.grade_comment_pager_view, this);
        mGradeText = (TextView) findViewById(R.id.grade_count_grade_text);
        
        mListView = (ListView) findViewById(R.id.grade_coment_listView);
        mAdapter = new CollectionListNoAdapter(mContext, mList);
        mListView.setAdapter(mAdapter);
  
        
        mListView.setOnItemClickListener(new OnItemClickListener()
        {
            
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int postion, long id)
            {
//                
//                Intent i = new Intent(mContext, NewCommentScoreAndMess.class);
//                
//                mContext.startActivity(i);
                showToast("�����"+postion+"��Ŀ");
                
            }
        });
        
    }
    
   
    
    public void setDate()
    {
        
        ExamItem m = new ExamItem();
        m.examinationName = "������";
        m.semester = "2";
        mList.add(m);
        ExamItem m1 = new ExamItem();
        m1.examinationName = "����";
        m1.semester = "2";
        mList.add(m1);
        ExamItem m2 = new ExamItem();
        m2.examinationName = "����";
        m2.semester = "2";
        mList.add(m2);
        mAdapter.setList(mList);
        
    }
    
    /**
     * 发�?接口请求 <�?��话功能简�? <功能详细描述> [参数说明]
     * 
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类�?�?方法、类#成员]
     */
    //    public void sendRequest() {
    //        Map<String, String> param = HttpRequestUtil
    //                .getCommonParams("examinationList");
    //        HttpRequestUtil.sendHttpPostCommonRequest(mContext,
    //                HttpAddressProperties.SERVICE_URL, param,
    //                GradeCountExamResp.class, handler);
    //    }
    
    private void showToast(String str)
    {
        if (null != mContext)
        {
            Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
        }
    }
    
}
