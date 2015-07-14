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
 * 登录工具类
 * 
 * @author  poorgod
 * @version  [版本号, 2014年7月18日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class LoginUtil
{
    /**
     * 判断是否登录
     * @return
     * @see [类、类#方法、类#成员]
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
     * 重新登录
     * @see [类、类#方法、类#成员]
     */
    public static void login(Context context)
    {
        
    }
    
    /**
     * 退出登录
     * @param context
     * @see [类、类#方法、类#成员]
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
        // 退出登录，清空TOKEN
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
     * 保存登录信息
     * @param context 上下文
     * @param userItem 用户对象
     * @param rememberPassword 是否记住密码
     * @see [类、类#方法、类#成员]
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
            // 登录成功后，同时更新全局变量中的用户信息
            XSApplication.getInstance().loginUserItem = userItem;
        }
    }
    
    /**
     * 获取用户信息
     * @param context 上下文
     * @see [类、类#方法、类#成员]
     */
    public static UserItem getLoginInfo(Context context)
    {
        
        UserItem saveUserItem = new UserItem();
        
        // 从首选项中读取用户信息
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
     * 获取验证登录参数的Map
     * <一句话功能简述>
     * <功能详细描述>
     * @return [参数说明]
     * 
     * @return Map<String,Object> [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
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
