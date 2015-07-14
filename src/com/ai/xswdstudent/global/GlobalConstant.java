package com.ai.xswdstudent.global;


/**
 * <һ�仰���ܼ���>
 * ������
 * 
 * @author  yangchao
 * @version  [�汾��, 2013-10-24]
 * @see  [�����/����]
 * @since  [��Ʒ/ģ��汾]
 */
public class GlobalConstant
{
    
    /**
     * ��װ�ɹ���action
     */
    public static final String ACTION_COM_XWEISOFT_LYGINFO_INSTALLED = "android.intent.com.xweisoft.lyginfo.installed";
    
    /**
     * ���سɹ���action
     */
    public static final String ACTION_COM_XWEISOFT_LYGINFO_UNINSTALLED = "android.intent.com.xweisoft.lyginfo.uninstalled";
    
    /**
     * ֪ͨ�������ؽ������ı�ʶ
     */
    public static final int UPDATE_PROGRESSBAR = 1001;
    
    /**
     * �洢�ռ䲻��
     */
    public static final int LOW_MEMORY = 1014;
    
    /**
     * ����url���Ϸ������ص�url������׺��
     */
    public static final int URL_ILLAGELE = 1015;
    
    /**
     * mtnӦ�õİ���
     */
    public static final String MTN_APP_PACKAGE_NAME = "com.xweisoft.wx.family";
    
    /**
     * SD��·��
     */
    public static final String SDCARD_PATH = "/mnt/sdcard/";
    
    /**
     * sd��Ŀ¼
     */
    public static final String SDCARD_BASE_PATH = SDCARD_PATH
            + MTN_APP_PACKAGE_NAME + "/";
    
    /**
     * �ļ������Ŀ¼
     */
    public static final String FILE_CACHE_DIR = GlobalConstant.SDCARD_BASE_PATH
            + "Cache/";
    
    /**
     * ͼƬ�����Ŀ¼
     */
    public static final String IMAGE_CACHE_DIR = GlobalConstant.SDCARD_BASE_PATH
            + "Image/";
    
    /**
     * ��װ·����SD����
     */
    public static final String INSTALL_PATH_SD = SDCARD_BASE_PATH + "Install/";
    
    /**
     * ����������
     */
    public static final String INSTALL_FILE_NAME = "WXFamily_update_";
    
    /**
     * ����·����SD����
     */
    public static final String DOWNLOAD_PATH_SD = SDCARD_BASE_PATH
            + "DownLoad/";
    
    /**
     * ��־����·����SD����
     */
    public static final String LOG_PATH_SD = SDCARD_BASE_PATH + "Log/";
    
    /**
     * Ӧ��ͼ���Ĭ������
     */
    public static final String APP_DEFAULT_ICON_NAME = "default.png";
    
    /**
     * �ļ���д����
     */
    public static final int IOEXCEPTION = 0x124342;
    
    /**
     * Ĭ����Ļ�Ŀ�
     */
    public static final int DEFAULT_SCREEN_WIDTH = 0;
    
    /**
     * Ĭ����Ļ�ĸ�
     */
    public static final int DEFAULT_SCREEN_HEIGHT = 0;
    
    /**
     * ˢ���б�
     */
    public static final int DOWNLOADSUCESSPUSHLIST = 99999;
    
    /**
     * "3gwap"�ַ�������
     */
    public static final String NETWORK_TYPE_WAP = "wap";
    
    /**
     * ��װ�ɹ�����handler��Ϣ��ʾ
     */
    public static final int INSTALL_SUCESS = 0;
    
    /**
     * APP��װ
     */
    public static final int INSTALL_APP = 1;
    
    /**
     *  �����ļ��� zip,wgt,apk��Ϊ�Ĳ�֧�ְ�װ������
     */
    public static final int INSTALL_OTHER = 3;
    
    /**
     * AES������Կ
     */
    public static final String AES_KEY = "odp5789421mobily";
    
    /**
     * ��װ
     */
    public static final int BUTTON_TYPE_INSTALL = 2;
    
    /**
     * �Ѱ�װ  status
     */
    public static final int BUTTON_TYPE_UNINSTALL = 1;
    
    /**
     * ͼƬ�ļ�
     */
    public static final int FILE_PHOTO = 0;
    
    /**
     * ��Ƶ�ļ�
     */
    public static final int FILE_VIDEO = 1;
    
    /**
     * ������Ϣ����SharePreferences
     */
    public static final String SETTING_MSG_MANAGE_PREFERENCE = "setting_msg_manage_preference";
    
    /**
     * ������Ϣ����洢����״̬��key
     */
    public static final String SETTING__MSG_MANAGE_KEY = "msg_manage";
    
    /**
     * ����ֹͣʱ��
     */
    public static final String SETTING_MUSIC_STOP_TIME_KEY = "music_stop_time";
    
    /**
     * ��¼�û�SharePreferences
     */
    public static final String LOGIN_USER_PREFERENCE = "login_user_preference";
    
    /**
     * ��¼�û�ID
     */
    public static final String LOGIN_USER_ID = "login_user_id";
    
    /**
     * ��¼�û�Name
     */
    public static final String LOGIN_USER_NAME = "login_user_name";
    
    /**
     * ��¼�û�Cookie
     */
    public static final String LOGIN_COOKIE = "login_user_cookie";
    
    /**
     * ��¼�û�UploadHash
     */
    public static final String LOGIN_UPLAODHASH = "login_user_uploadhash";
    
    /**
     * �û���Ϣ
     * 
     * @author  ���
     * @version  [�汾��, 2014��6��30��]
     * @see  [�����/����]
     * @since  [��Ʒ/ģ��汾]
     */
    public static class UserInfoPreference
    {
        /**
         * ��ѡ���ļ���
         */
        public static final String PREFERENCE_NAME = "userinfo_preference";
        
        /**
         * �û�ID
         */
        public static final String UID = "uid";
        
        /**
         * �ֻ�����
         */
        public static final String TELPHONE = "telphone";
        
        /**
         * ����
         */
        public static final String PASSWORD = "password";
        
        /**
         * �Ա�
         */
        public static final String GENDER = "gender";
        
        /**
         * ͷ��
         */
        public static final String HEADER = "header";
        
        /**
         * �û�����
         */
        public static final String CHILDREN = "children";
        
        /**
         * ����id
         */
        public static final String PUSHID = "pushid";
        
    }
    
    /**
     * �Ƿ��ס����
     */
    public static final String REMEMBER_PASSWORD = "remember_pwd";
    
    /**
     * ��
     */
    public static final String MAN = "1";
    
    /**
     * Ů
     */
    public static final String WOMAN = "0";
    
    /**
     * Android�ͻ���������1 ios��2
     */
    public static final String CLIENT_TYPE_ANDROID = "1";
    
    /**
     * ϵͳ��Ϣ ֪ͨ��Ϣ
     */
    public static final String NOTIFICATION_MESSAGE_SYSTEM = "sysMsg";
    
    /**
     * ѧУ��Ϣ ֪ͨ��Ϣ
     */
    public static final String NOTIFICATION_MESSAGE_SCHOOL = "schoolMsg";
    
    /**
     * �༶��Ϣ ֪ͨ��Ϣ
     */
    public static final String NOTIFICATION_MESSAGE_CLASS = "classMsg";
    
    /**
     * �༶��ҵ ֪ͨ��Ϣ
     */
    public static final String NOTIFICATION_MESSAGE_WORK = "homeworkMsg";
    
    /**
     * ֪ͨ��Ϣ�㲥
     */
    public static final String NOTIFICATION_MSG_RECEIVER = "wx_family_notification_msg";
    
}
