package com.ai.xswdstudent.xsaplication;

import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/**
 * <�?��话功能简�?
 * SharedPreferences统一管理�?
 * 
 * @author  administrator
 * @version  [版本�? 2013-10-24]
 * @see  [相关�?方法]
 * @since  [产品/模块版本]
 */
public class SharedPreferencesUtil
{
    /**
     * 登陆cookie
     */
    public static final String SP_KEY_LOGIN_COOKIE = "sp_key_login_cookie";
    
    /**
     * 宣传界面sharepreference的name
     */
    public static final String GUIDE_VIEW_PREFERENCE_NAME = "guide_view_preference_flag";
    
    /**
     * 启动图片url
     */
    public static final String SP_KEY_LOAD_IMAGE_URL = "sp_key_load_image_url";
    
    /**
     * 启动图片url
     */
    public static final String SP_KEY_DOWNLOAD_URL = "sp_key_download_url";
    
    /**
     * 侧滑栏目请求json数据
     */
    public static final String SP_KEY_RIGHT_MENU_JSON = "sp_key_right_menu_json";
    
    /**
     * 足迹（字符：�?,"隔开�?
     */
    public static final String SP_KEY_HISTORY_DATA = "sp_key_history_data";
    
    /**
     * Assets数据缓存
     */
    public static final String SP_KEY_ASSETS_DATA = "sp_key_assets_data";
    
    /**
     * 订餐订单属�?数据缓存
     */
    public static final String SP_KEY_ORDER_MEAL_ATTR_DATA = "sp_key_order_meal_attr_data";
    
    public static final String SP_KEY_LIFE_CATEGORY_DATA = "sp_key_life_category_data";
    
    public static final String SP_KEY_LIFE_AREA_DATA = "sp_key_life_area_data";
    
    /**
     * Area数据缓存
     */
    public static final String SP_KEY_AREA_DATA = "sp_key_area_data";
    
    /**
     * 预定服务中订餐数据缓�?
     */
    public static final String SP_KEY_MEAL_DATA = "sp_key_meal_data";
    
    /**
     * 搜索数据缓存
     */
    public static final String SP_KEY_SEARCH_HISTORY_DATA = "sp_key_search_history_data";
    
    /**
     * 预约挂号城市
     */
    public static final String SP_KEY_HEALTH_CITY_DATA = "sp_key_health_city_data";
    
    /**
     * 二手�?
     */
    public static final String SP_KEY_SECOND_HOUSE_DATA = "sp_key_second_house_data";
    
    /**
     * 二手�?
     */
    public static final String SP_KEY_SECOND_CAR_DATA = "sp_key_second_car_data";
    
    /**
     * 获取默认的SharedPreferences
     * @param context
     * @return    
     */
    private static SharedPreferences getSharedPreferences(Context context)
    {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
    
    /**
     * 
     * 保存设置<BR>
     * 保存�?��常量到SharedPreferences
     * @param context
     * @param map
     */
    public static void saveSharedPreferences(Context context,
            Map<String, String> map)
    {
        if (map == null || map.isEmpty())
        {
            return;
        }
        
        SharedPreferences sp = getSharedPreferences(context);
        Editor editor = sp.edit();
        for (String key : map.keySet())
        {
            editor.putString(key, map.get(key));
        }
        editor.commit();
    }
    
    /**
     * 
     * 保存设置<BR>
     * 保存�?��常量到SharedPreferences
     * @param key �?
     * @param value 要保存的�?
     */
    public static void saveSharedPreferences(Context context, String key,
            String value)
    {
        SharedPreferences sp = getSharedPreferences(context);
        Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }
    
    /**
     * 
     * 保存设置<BR>
     * 保存�?��常量到SharedPreferences
     * @param key �?
     * @param value 要保存的�?
     */
    public static void saveSharedPreferences(Context context, String key,
            boolean value)
    {
        SharedPreferences sp = getSharedPreferences(context);
        Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }
    
    /**
     * 
     * 获得保存到SharedPreferences的常�?BR>
     * 
     * @param context
     * @param key �?
     * @param defaultValue 默认�?
     * @return 保存在SharedPreferences中键�?��应的�?
     */
    public static String getSharedPreferences(Context context, String key,
            String defaultValue)
    {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getString(key, defaultValue);
    }
    
    /**
     * 
     * 获得保存到SharedPreferences的常�?BR>
     * 
     * @param context
     * @param key �?
     * @param defaultValue 默认�?
     * @return 保存在SharedPreferences中键�?��应的�?
     */
    public static boolean getSharedPreferences(Context context, String key,
            boolean defaultValue)
    {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(key, defaultValue);
    }
    
}
