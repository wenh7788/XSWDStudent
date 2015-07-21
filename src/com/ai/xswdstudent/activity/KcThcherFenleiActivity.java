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

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.ai.xswdstudent.ui.TabPagerAdapter;
import com.ai.xswdstudent.view.NewTechserCommentPageView;
import com.ai.xswdstudent.widget.TabPageIndicator;
import com.lidroid.xutils.ViewUtils;

public class KcThcherFenleiActivity extends BaseActivity
{
    
    private String[] titleArray = { "老师", "课程" };
    
    private int[] resArray = { R.drawable.wx_contacts_class_selector,
           R.drawable.wx_contacts_kecheng_selector };
    
    
    /**
     * viewPager
     */
    private ViewPager mViewPager;
    
    //private Context mcontext;
    
    /**
     * 页卡集合
     */
    private List<View> mViews;
    
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
        setTitle("任课老师");
        
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
            
                  NewTechserCommentPageView pagerView = new NewTechserCommentPageView(
                          KcThcherFenleiActivity.this);
             // pagerView.sendRequest();
             mViews.add(pagerView);
             }
                     else if (i == 1)
                   {
                         NewTechserCommentPageView pagerView = new NewTechserCommentPageView(
                                 KcThcherFenleiActivity.this);
                            //pagerView.sendRequest();
                            mViews.add(pagerView);
                        }
//                        else if (i == 2)
//                        {
//                            GradeCountPagerView pagerView = new GradeCountPagerView(
//                                    TcherActivity.this);
//                            //pagerView.sendRequest();
//                            mViews.add(pagerView);
//                        }
        }
        mViewPager.setAdapter(new TabPagerAdapter(mViews, titleArray,resArray));
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
