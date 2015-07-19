package com.ai.xswdstudent.view;

import com.ai.xswdstudent.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

/**
 * ֧�����¼�ͷ��ListView
 *
 * <a class="referer" href="http://my.oschina.net/arthor" target="_blank">@author</a> Mr. Lu
 */
public class ArrowListView extends ListView {
  
    private final float scale = getContext().getResources().getDisplayMetrics().density;
    private float topArrowPadding;
    private float bottomArrowPadding;
  
    private static float DEFAULT_TOP_PADDING_DP = 2.0f;
    private static float DEFAULT_BOTTOM_PADDING_DP = 2.0f;
  
    public ArrowListView(Context context, AttributeSet attrs) {
        super(context, attrs);
  
        String strTopArrowPadding = attrs.getAttributeValue(null,
                "topArrowPadding");
        String strBottomArrowPadding = attrs.getAttributeValue(null,
                "bottomArrowPadding");
  
        topArrowPadding = convertDisplayUom(strTopArrowPadding,
                DEFAULT_TOP_PADDING_DP);
        bottomArrowPadding = convertDisplayUom(strBottomArrowPadding,
                DEFAULT_BOTTOM_PADDING_DP);
  
        Log.v("ArrowListView", String.valueOf(topArrowPadding));
    }
  
    /**
     * ��λת��
     */
    private float convertDisplayUom(String sour, float defaultValue) {
        try {
            if (sour.toLowerCase().endsWith("px")) {
                return Float.parseFloat(sour.toLowerCase().replace("px", ""));
            } else if (sour.toLowerCase().endsWith("dp")) {
                return Integer.parseInt(sour.toLowerCase().replace("dp",
                        ""))
                        * scale + 0.5f;
            }
        } catch (Exception e) {
        }
  
        return (defaultValue * scale + 0.5f);
    }
  
    /**
     * onDraw����������ListView����λ�û����ͷ.
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
  
        // ȡ�ü�ͷ��ͼƬ���˴��ǹ̶�ͼƬ����ʵ�Ͽ����������÷�ʽ
        Bitmap topPic = ((BitmapDrawable) getResources().getDrawable(
                R.drawable.img_pull)).getBitmap();
        Bitmap bottomPic = ((BitmapDrawable) getResources().getDrawable(
                R.drawable.img_pull)).getBitmap();
  
        // ȡ��ListView�Ļ��������С
        Rect r = new Rect();
        this.getDrawingRect(r);
  
        // �����ͷ�Ļ���λ��
        float top = r.top + topArrowPadding;
        float bottom = r.bottom - bottomArrowPadding - bottomPic.getHeight();
        float left = r.left + (r.right - r.left - topPic.getWidth()) / 2;
  
        // �����Ƿ���Ҫ����
        boolean drawTop = false;
        boolean drawBottom = false;
  
        if (this.getChildCount() > 0) {
            Rect rTop = new Rect();
            this.getChildAt(0).getLocalVisibleRect(rTop);
            Rect rBottom = new Rect();
            View lastChild = this.getChildAt(this.getChildCount() - 1);
            lastChild.getLocalVisibleRect(rBottom);
  
            drawTop = (this.getFirstVisiblePosition() > 0 || this
                            .getFirstVisiblePosition() == 0
                            && rTop.top > 0);
            drawBottom = (this.getLastVisiblePosition() < this.getAdapter()
                            .getCount() - 1 || this.getLastVisiblePosition() == this
                            .getAdapter().getCount() - 1
                            && rBottom.bottom < lastChild.getHeight());
        }
        // �����ͷ
        if (drawTop) {
            canvas.drawBitmap(topPic, left, top, paint);
        }
  
        if (drawBottom) {
            canvas.drawBitmap(bottomPic, left, bottom, paint);
        }
    }
}