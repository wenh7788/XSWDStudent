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
     * MobilyApplicationʵ��
     */
    private static XSApplication instance;
    
    /**
     * ���������ļ�map
     */
    private Hashtable<String, String> systemInfo;
    
    /**
     * Ӧ�ó��������ַ
     */
    private String requestUrl;
    
    /**
     * https�����ַ
     */
    private String requestHttpsUrl;
    
    
    /**
     * �û�����
     */
    public UserItem loginUserItem;
    
    /**
     * ���cookie�Ļ���list
     */
    public List<String> cookieList = new ArrayList<String>();
    
    /**
     * finishActivity����,���ڹ���activity�л��䣬finish���м����е�activity
     */
    private List<Activity> finishActivities = new ArrayList<Activity>();
    
    /**
     * ���cookie�Ļ���map
     */
    public HashMap<String, String> cookieContiner = new HashMap<String, String>();
    
    /**
     * ��ͨͼƬ������
     */

    
    /**
     * Բ��ͼƬ������
     */
    
    /**
     * mina������
     */
   // public MinaManager minaManager;
    
    /**
     * ��Ϣ���� ������Ϣ�洢Map
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
        
        // �����쳣����ʵ��
        //ueHandler = new UEHandler();
      //  Thread.setDefaultUncaughtExceptionHandler(ueHandler);
        
        //        getUserPreference();
        
        // ��ȡϵͳ��ʼ����Ϣ
      //  getSystemConfig();
        
        //initPhoneParams(this);
        //initImageLoader(getApplicationContext());
        getCookie();
        
        //        CCPAppManager.setContext(instance);
        
        //����ȫ�ֵ�ͼƬ������
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
     * ���������ļ�����־����
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
     * ��ȡ��¼�����cookie����
     * <һ�仰���ܼ���>
     * <������ϸ����> [����˵��]
     * 
     * @return void [��������˵��]
     * @exception throws [Υ������] [Υ��˵��]
     * @see [�ࡢ��#��������#��Ա]
     */
    private void getCookie()
    {
        //��ȡ����cookie
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
     * ��ȡ�û���ѡ��
     * @see [�ࡢ��#��������#��Ա]
     */
    private void getUserPreference()
    {
        loginUserItem = LoginUtil.getLoginInfo(this);
    }
    
    /**
     * ��ʼ��ͼƬ���ع�����
     * <һ�仰���ܼ���>
     * <������ϸ����>
     * @param context [����˵��]
     * 
     * @return void [��������˵��]
     * @exception throws [Υ������] [Υ��˵��]
     * @see [�ࡢ��#��������#��Ա]
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
     * ����ʱ��ʼ��ϵͳUA
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
     * ��ȡϵͳ��Ϣ�����������ַ��������Ϣ��
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
//            // ���������ַ
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
     * ��ȡ���ص�ַ<BR>
     * 
     * @return ���ص�ַ
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
     * �ر������л�֮����Ҫfinish��ҳ��
     * <������ϸ����> [����˵��]
     * @return void [��������˵��]
     * @exception throws [Υ������] [Υ��˵��]
     * @see [�ࡢ��#��������#��Ա]
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
