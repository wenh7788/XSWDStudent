package com.ai.xswdstudent.xsaplication;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.ai.xswdstudent.activity.LoginActivity;
import com.ai.xswdstudent.global.GlobalConstant;
import com.ai.xswdstudent.model.UserItem;
import com.ai.xswdstudent.util.ListUtil;

/**
 * ��¼������
 * 
 * @author  poorgod
 * @version  [�汾��, 2014��7��18��]
 * @see  [�����/����]
 * @since  [��Ʒ/ģ��汾]
 */
public class LoginUtil
{
    /**
     * �ж��Ƿ��¼
     * @return
     * @see [�ࡢ��#��������#��Ա]
     */
    public static boolean isLogin(Context context)
    {
        UserItem user = XSApplication.getInstance().loginUserItem;
        if (null != user)
        {
            if (!TextUtils.isEmpty(user.userId))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }
    
    /**
     * ���µ�¼
     * @see [�ࡢ��#��������#��Ա]
     */
    public static void login(Context context)
    {
        
    }
    
    /**
     * �˳���¼
     * @param context
     * @see [�ࡢ��#��������#��Ա]
     */
    public static void logout(Activity context)
    {
        boolean isRemember = SharedPreferencesUtil.getSharedPreferences(context,
                GlobalConstant.REMEMBER_PASSWORD,
                true);
        SharedPreferencesUtil.saveSharedPreferences(context,
                GlobalConstant.UserInfoPreference.UID,
                "");
        if (!isRemember)
        {
            SharedPreferencesUtil.saveSharedPreferences(context,
                    GlobalConstant.UserInfoPreference.PASSWORD,
                    "");
        }
        // �˳���¼�����TOKEN
        XSApplication.getInstance().loginUserItem = null;
        XSApplication.getInstance().cookieList.clear();
        XSApplication.getInstance().cookieContiner.clear();
        
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        
        NotificationManager manager = (NotificationManager) (context.getSystemService(Context.NOTIFICATION_SERVICE));
        manager.cancelAll();
        context.startActivity(intent);
        ((Activity) context).finish();
    }
    
    /**
     * �����¼��Ϣ
     * @param context ������
     * @param userItem �û�����
     * @param rememberPassword �Ƿ��ס����
     * @see [�ࡢ��#��������#��Ա]
     */
    public static void saveLoginInfo(Context context, UserItem userItem)
    {
        if (null != userItem)
        {
            String uid = userItem.userId;
            String phone = userItem.phone;
            String password = userItem.password;
            String gender = userItem.parentSex;
            String pushId = userItem.pushId;
            //            String children = userItem.children;
            
            SharedPreferencesUtil.saveSharedPreferences(context,
                    GlobalConstant.UserInfoPreference.TELPHONE,
                    phone);
            SharedPreferencesUtil.saveSharedPreferences(context,
                    GlobalConstant.UserInfoPreference.GENDER,
                    gender);
            if (SharedPreferencesUtil.getSharedPreferences(context,
                    GlobalConstant.REMEMBER_PASSWORD,
                    false))
            {
                SharedPreferencesUtil.saveSharedPreferences(context,
                        GlobalConstant.UserInfoPreference.UID,
                        uid);
                SharedPreferencesUtil.saveSharedPreferences(context,
                        GlobalConstant.UserInfoPreference.PASSWORD,
                        password);
                SharedPreferencesUtil.saveSharedPreferences(context,
                        GlobalConstant.UserInfoPreference.PUSHID,
                        pushId);
            }
            StringBuffer buffer = new StringBuffer();
//            if (!ListUtil.isEmpty(userItem.children))
//            {
//                for (ChildrenItem item : userItem.children)
//                {
//                    if (null != item)
//                    {
//                        buffer.append(item.classinfoId + ",");
//                    }
//                }
//            }
            XSApplication.getInstance().childrenClassIds = buffer.toString();
            // ��¼�ɹ���ͬʱ����ȫ�ֱ����е��û���Ϣ
            XSApplication.getInstance().loginUserItem = userItem;
        }
    }
    
    /**
     * ��ȡ�û���Ϣ
     * @param context ������
     * @see [�ࡢ��#��������#��Ա]
     */
    public static UserItem getLoginInfo(Context context)
    {
        
        UserItem saveUserItem = new UserItem();
        
        // ����ѡ���ж�ȡ�û���Ϣ
        String uid = SharedPreferencesUtil.getSharedPreferences(context,
                GlobalConstant.UserInfoPreference.UID,
                "");
        String telphone = SharedPreferencesUtil.getSharedPreferences(context,
                GlobalConstant.UserInfoPreference.TELPHONE,
                "");
        String password = SharedPreferencesUtil.getSharedPreferences(context,
                GlobalConstant.UserInfoPreference.PASSWORD,
                "");
        String gender = SharedPreferencesUtil.getSharedPreferences(context,
                GlobalConstant.UserInfoPreference.GENDER,
                "1");
        
        saveUserItem.userId = uid;
        saveUserItem.phone = telphone;
        saveUserItem.password = password;
        saveUserItem.parentSex = gender;
        //        saveUserItem.children = children;
        return saveUserItem;
    }
    
    /**
     * ��ȡ��֤��¼������Map
     * <һ�仰���ܼ���>
     * <������ϸ����>
     * @return [����˵��]
     * 
     * @return Map<String,Object> [��������˵��]
     * @exception throws [Υ������] [Υ��˵��]
     * @see [�ࡢ��#��������#��Ա]
     */
    public static Map<String, Object> getCheckLoginParams()
    {
        HashMap<String, Object> map = new HashMap<String, Object>();
        String uid = "";
        UserItem userItem = XSApplication.getInstance().loginUserItem;
        if (null != userItem)
        {
            uid = userItem.userId;
        }
        map.put("uid", uid);
        return map;
    }
}
