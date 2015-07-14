package com.ai.xswdstudent.xsaplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.global.GlobalConstant;
import com.ai.xswdstudent.model.UserItem;

public class XSApplication extends Application
{
    
    
private final String TAG = "===WXApplication===";
    
    /**
     * MobilyApplication实例
     */
    private static XSApplication instance;
    
    /**
     * 保存配置文件map
     */
    private Hashtable<String, String> systemInfo;
    
    /**
     * 应用程序请求地址
     */
    private String requestUrl;
    
    /**
     * https请求地址
     */
    private String requestHttpsUrl;
    
    
    /**
     * 用户对象
     */
    public UserItem loginUserItem;
    
    /**
     * 存放cookie的缓存list
     */
    public List<String> cookieList = new ArrayList<String>();
    
    /**
     * finishActivity管理,用于管理activity切换间，finish掉中间所有的activity
     */
    private List<Activity> finishActivities = new ArrayList<Activity>();
    
    /**
     * 存放cookie的缓存map
     */
    public HashMap<String, String> cookieContiner = new HashMap<String, String>();
    
    /**
     * 普通图片配置类
     */

    
    /**
     * 圆形图片配置类
     */
    
    /**
     * mina管理类
     */
   // public MinaManager minaManager;
    
    /**
     * 消息中心 分类消息存储Map
     */
   // public Map<String, MsgContentItem> notificationMsgMap = new HashMap<String, MsgContentItem>();
    
  //  public ApplyInfoItem applyInfoItem;
    
    public long lastTime;
    
    public String childrenClassIds;
    
    public static XSApplication getInstance()
    {
        return instance;
    }
    
    @Override
    public void onCreate()
    {
        super.onCreate();
        instance = this;
        
        systemInfo = new Hashtable<String, String>();
        
        // 设置异常处理实例
        //ueHandler = new UEHandler();
      //  Thread.setDefaultUncaughtExceptionHandler(ueHandler);
        
        //        getUserPreference();
        
        // 获取系统初始化信息
      //  getSystemConfig();
        
        //initPhoneParams(this);
        //initImageLoader(getApplicationContext());
        getCookie();
        
        //        CCPAppManager.setContext(instance);
        
        //定义全局的图片配置类
//        options = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.ysh_transparent_img)
//                .cacheInMemory(true)
//                .cacheOnDisk(true)
//                .considerExifParams(true)
//                .build();
//        optionsCircle = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.ysh_transparent_img)
//                .cacheInMemory(true)
//                .displayer(new CircleBitmapDisplayer())
//                .cacheOnDisk(true)
//                .considerExifParams(true)
//                .build();
//        
    }
    
    /**
     * 返回配置文件的日志开关
     * @return
     */
    public boolean getLoggingSwitch()
    {
        try
        {
            ApplicationInfo appInfo = getPackageManager().getApplicationInfo(getPackageName(),
                    PackageManager.GET_META_DATA);
            boolean b = appInfo.metaData.getBoolean("LOGGING");
            //LogUtil.w("[ECApplication - getLogging] logging is: " + b);
            return b;
        }
        catch (NameNotFoundException e)
        {
            e.printStackTrace();
        }
        
        return false;
    }
    
    /**
     * 获取登录保存的cookie数据
     * <一句话功能简述>
     * <功能详细描述> [参数说明]
     * 
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    private void getCookie()
    {
        //获取本地cookie
        String cookieJsonStr = SharedPreferencesUtil.getSharedPreferences(getApplicationContext(),
                SharedPreferencesUtil.SP_KEY_LOGIN_COOKIE,
                "");
        try
        {
            JSONArray jsonArray = new JSONArray(cookieJsonStr);
            for (int i = 0; i < jsonArray.length(); i++)
            {
                String cookie = jsonArray.getString(i);
                if (!StringUtil.isEmpty(cookie))
                {
                    int p = cookie.indexOf("=");
                    String key = cookie.substring(0, p);
                    String value = cookie.substring(p + 1, cookie.indexOf(";"));
                    XSApplication.getInstance().cookieContiner.put(key, value);
                }
            }
        }
        catch (JSONException e)
        {
        }
    }
    
    /**
     * 获取用户首选项
     * @see [类、类#方法、类#成员]
     */
    private void getUserPreference()
    {
        loginUserItem = LoginUtil.getLoginInfo(this);
    }
    
    /**
     * 初始化图片加载工具类
     * <一句话功能简述>
     * <功能详细描述>
     * @param context [参数说明]
     * 
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
//    public static void initImageLoader(Context context)
//    {
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
//                context).threadPriority(Thread.NORM_PRIORITY - 2)
//                .denyCacheImageMultipleSizesInMemory()
//                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
//                .tasksProcessingOrder(QueueProcessingType.LIFO)
//                .writeDebugLogs()
//                .build();
//        ImageLoader.getInstance().init(config);
//    }
    
    /**
     * 启动时初始化系统UA
     * 
     * @param context
     */
//    private void initPhoneParams(Context context)
//    {
//        WebView wv = new WebView(context);
//        WebSettings webset = wv.getSettings();
//        GlobalVariable.uA = webset.getUserAgentString();
//        GlobalVariable.IMSI = ((android.telephony.TelephonyManager) getSystemService(TELEPHONY_SERVICE)).getSubscriberId();
//        GlobalVariable.IMEI = ((android.telephony.TelephonyManager) getSystemService(TELEPHONY_SERVICE)).getDeviceId();
//    }
    
    /**
     * 获取系统信息，如服务器地址，桌面信息等
     */
//    private void getSystemConfig()
//    {
//        InputStream is = getApplicationContext().getResources()
//                .openRawResource(R.raw.system);
//        try
//        {
//            String[] array = null;
//            byte[] a = new byte[is.available()];
//            is.read(a);
//            String temp = new String(a);
//            String[] temps = temp.split("\r\n");
//            for (String string : temps)
//            {
//                array = string.split("==");
//                systemInfo.put(array[0], array[1].replace("\r\n", ""));
//            }
//            // 设置请求地址
//            requestUrl = systemInfo.get("yshpb_request_url");
//            
//            requestHttpsUrl = systemInfo.get("yshpb_https_request_url");
//            String infoLog = systemInfo.get("yshpb_info_log_record");
//            if ("1".equals(infoLog))
//            {
//                LogX.infoFlag = true;
//            }
//        }
//        catch (IOException e)
//        {
//            LogX.getInstance().e(TAG, e.toString());
//        }
//    }
    
    public Hashtable<String, String> getSystemInfo()
    {
        return systemInfo;
    }
    
    public String getRequestUrl()
    {
        return requestUrl;
    }
    
    /**
     * 获取下载地址<BR>
     * 
     * @return 下载地址
     */
    public String getDownloadSavePath()
    {
        return GlobalConstant.DOWNLOAD_PATH_SD;
    }
    
    public String getRequestHttpsUrl()
    {
        return requestHttpsUrl;
    }
    
    public void setRequestHttpsUrl(String requestHttpsUrl)
    {
        this.requestHttpsUrl = requestHttpsUrl;
    }
    
    public void addFinishActivity(Activity activity)
    {
        if (!finishActivities.contains(activity))
        {
            finishActivities.add(activity);
        }
    }
    
    /**
     * 关闭所有切换之间需要finish的页面
     * <功能详细描述> [参数说明]
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public void closedFinishActivity()
    {
        if (null != finishActivities && !finishActivities.isEmpty())
        {
            for (Activity a : finishActivities)
            {
                a.finish();
            }
            
            finishActivities.clear();
        }
    }
    
   
}
