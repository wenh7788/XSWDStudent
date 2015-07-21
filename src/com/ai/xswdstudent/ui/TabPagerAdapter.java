
package com.ai.xswdstudent.ui;
import java.util.ArrayList;
import java.util.List;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * ViewPager������
 * 
 * @author  gac
 * @version  [�汾��, 2014��6��19��]
 * @see  [�����/����]
 * @since  [��Ʒ/ģ��汾]
 */
public class TabPagerAdapter extends PagerAdapter
{
    
    /**
     * ҳ������
     */
    private List<View> mViews;
    
    /**
     * ���⼯��
     */
    private String[] mItems;
    
    /**
     * ���⼯��
     */
    private int[] mRes;
    
    public TabPagerAdapter(List<View> mViews, String[] mItems)
    {
        super();
        this.mViews = mViews;
        this.mItems = mItems;
        if (null == mViews)
        {
            this.mViews = new ArrayList<View>();
        }
        if (null == mItems)
        {
            this.mItems = new String[mViews.size()];
        }
        if (null == mRes)
        {
            this.mRes = new int[mViews.size()];
        }
    }
    
    public TabPagerAdapter(List<View> mViews, String[] mItems, int[] mRes)
    {
        super();
        this.mViews = mViews;
        this.mItems = mItems;
        this.mRes = mRes;
        if (null == mViews)
        {
            this.mViews = new ArrayList<View>();
        }
        if (null == mItems)
        {
            this.mItems = new String[mViews.size()];
        }
        if (null == mRes)
        {
            this.mRes = new int[mViews.size()];
        }
    }
    
    
    //�Լ������
    
    
    public TabPagerAdapter(List<View> mViews, int[] mRes)
    {
        super();
        this.mViews = mViews;
        this.mRes = mRes;
        if (null == mViews)
        {
            this.mViews = new ArrayList<View>();
        }
        if (null == mRes)
        {
            this.mRes = new int[mViews.size()];
        }
    }
    
    
    @Override
    public int getCount()
    {
        return mViews.size();
    }
    
    @Override
    public boolean isViewFromObject(View arg0, Object arg1)
    {
        return arg0 == arg1;
    }
    
    @Override
    public void destroyItem(View container, int position, Object object)
    {
        if (mViews != null && mViews.size() > position)
        {
            ((ViewPager) container).removeView(mViews.get(position));
        }
    }
    
    @Override
    public Object instantiateItem(View container, int position)
    {
        ((ViewPager) container).addView(mViews.get(position));
        return mViews.get(position);
    }
    
    @Override
    public void finishUpdate(View arg0)
    {
        
    }
    
    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1)
    {
        
    }
    
    @Override
    public Parcelable saveState()
    {
        return null;
    }
    
    @Override
    public void startUpdate(View arg0)
    {
        
    }
    
    @Override
    public CharSequence getPageTitle(int position)
    {
        return null != mItems[position] ? mItems[position] : "";
    }
    
    public int getTitleRes(int position)
    {
        return 0 != mRes[position] ? mRes[position] : 0;
    }
}
