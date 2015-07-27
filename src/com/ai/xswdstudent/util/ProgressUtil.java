/*
 * �� �� ��:  ProgressUtil.java
 * ��    ��:  ������������
 * �� �� ��:  ���
 * ����ʱ��:  2013��7��31��
 */
package com.ai.xswdstudent.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/**
 * ������������
 * 
 * @author  ���
 * @version  [�汾��, 2013��7��31��]
 * @see  [�����/����]
 * @since  [��Ʒ/ģ��汾]
 */
public class ProgressUtil
{
    /**
     * �Ƿ�ȡ�����ϴ�ͼƬ����Ƶ���������
     */
    public static boolean isUploadCancel = false;
    
    public static ProgressDialog progressDialog = null;
    
    /**
     * ��ʾ������
     * @param context
     * @param message
     * @see [�ࡢ��#��������#��Ա]
     */
    public static void showProgressDialog(Context context, String message)
    {
        if (null != progressDialog && progressDialog.isShowing())
        {
            return;
        }
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage(message);
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(true);
        if (context instanceof Activity && ((Activity) context).isFinishing())
        {
            return;
        }
        progressDialog.show();
    }
    
    /**
     * ��ʾ������,�����Ƿ���backȡ�����ߵ���Ի���֮��ȡ���Ի���
     * @param context
     * @param message
     * @see [�ࡢ��#��������#��Ա]
     */
    public static void showProgressDialog(Context context, String message,
            boolean isDismiss)
    {
        if (null != progressDialog && progressDialog.isShowing())
        {
            return;
        }
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage(message);
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(isDismiss);
        if (context instanceof Activity && ((Activity) context).isFinishing())
        {
            return;
        }
        progressDialog.show();
    }
    
    /**
     * �ϴ�ͼƬ������Ƶʱ��ʾ�Ľ�����
     * @param context
     * @param message
     * @see [�ࡢ��#��������#��Ա]
     */
    public static void showUploadProgressDialog(Context context, String message)
    {
        if (null != progressDialog && progressDialog.isShowing())
        {
            return;
        }
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage(message);
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setOnCancelListener(new OnCancelListener()
        {
            @Override
            public void onCancel(DialogInterface dialog)
            {
                isUploadCancel = true;
            }
        });
        if (context instanceof Activity && ((Activity) context).isFinishing())
        {
            return;
        }
        progressDialog.show();
    }
    
    /**
     * ���ؽ�����
     * @see [�ࡢ��#��������#��Ա]
     */
    public static void dismissProgressDialog()
    {
        if (null != progressDialog && progressDialog.isShowing())
        {
            progressDialog.dismiss();
        }
    }
}
