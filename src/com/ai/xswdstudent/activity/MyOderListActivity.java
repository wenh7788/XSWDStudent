package com.ai.xswdstudent.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.ai.xswdstudent.ui.TabPagerAdapter;
import com.ai.xswdstudent.view.AllorederPageView;
import com.ai.xswdstudent.view.NewTechserCommentPageView;
import com.ai.xswdstudent.widget.TabPageIndicator;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class MyOderListActivity extends BaseActivity
{
    
    private String[] titleArray = { "全部","进行中", "待付款" ,"待评价"};
    
    //private int[] resArray = { R.drawable.wx_contacts_class_selector,
    //        R.drawable.wx_contacts_collect_selector };
    
    
    /**
     * viewPager
     */
    private ViewPager mViewPager;
    
    //private Context mcontext;
    
    /**
     * 页卡集合
     */
    private List<View> mViews;
    
    @ViewInject(R.id.common_title_center_text)
    private TextView commontitle;
    
    /**
     * 页卡标题
     */
    private TabPageIndicator mTabPageIndicator;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wx_grade_activity);
        ViewUtils.inject(this); //xutils必加语句在      使用注解绑定控件的时候，一定记得在onCreate中调用
        initViews();
        initViewPager();
      //  setTitle("我的订单");
        commontitle.setText("我的订单");
        
    }
    
    

    public void initViews()
    {
        mViewPager = (ViewPager) findViewById(R.id.grade_viewpager);
        mTabPageIndicator = (TabPageIndicator) findViewById(R.id.grade_title_indicator);
    }
    
    public void onDestroyView()
    {
        super.onDestroy();
        if (null != mViews)
        {
            mViews.clear();
            mViews = null;
        }
    }
    
    
    
    
    /**
     * 初始化栏目
     * <一句话功能简述>
     * <功能详细描述> [参数说明]
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    private void initViewPager()
    {
        for (int i = 0; i < titleArray.length; i++)
        {
            if (null == mViews)
            {
                mViews = new ArrayList<View>();
            }
              if (i == 0)
              {
            
                  AllorederPageView pagerView = new AllorederPageView(
                          MyOderListActivity.this);
             // pagerView.sendRequest();
             mViews.add(pagerView);
             }
                     else if (i == 1)
                   {
                         NewTechserCommentPageView pagerView = new NewTechserCommentPageView(
                                 MyOderListActivity.this);
                            //pagerView.sendRequest();
                            mViews.add(pagerView);
                        }
                        else if (i == 2)
                        {
                            NewTechserCommentPageView pagerView = new NewTechserCommentPageView(
                                    MyOderListActivity.this);
                            //pagerView.sendRequest();
                            mViews.add(pagerView);
                        }else if (i==3){
                            NewTechserCommentPageView pagerView = new NewTechserCommentPageView(
                                    MyOderListActivity.this);
                            //pagerView.sendRequest();
                            mViews.add(pagerView);
                            
                        }
        }
        mViewPager.setAdapter(new TabPagerAdapter(mViews, titleArray));
        mTabPageIndicator.setViewPager(mViewPager);
        mViewPager.setCurrentItem(0);
        mViewPager.setOnPageChangeListener(new OnPageChangeListener()
        {
            @Override
            public void onPageSelected(int position)
            {
                if (titleArray.length > position)
                {
                    View view = mViews.get(position);
                }
                mTabPageIndicator.setCurrentItem(position);
            }
            
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2)
            {
                
            }
            
            @Override
            public void onPageScrollStateChanged(int arg0)
            {
            }
        });
    }
}
