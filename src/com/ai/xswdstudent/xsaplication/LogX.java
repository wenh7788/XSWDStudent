package com.ai.xswdstudent.xsaplication;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import android.os.Environment;
import android.os.StatFs;
import android.util.Log;

import com.ai.xswdstudent.global.GlobalConstant;

/**
 * <һ�仰���ܼ���>
 * ��־��
 * 
 * @author  administrator
 * @version  [�汾��, 2013-10-24]
 * @see  [�����/����]
 * @since  [��Ʒ/ģ��汾]
 */
public final class LogX extends Thread
{
	/**
	 * ����·��
	 */
	public static final String DEFAULT_LOG_PATH = GlobalConstant.LOG_PATH_SD;
	   
    /**
     * ��־��
     */
    private static final String TAG = "===LogX===";

    /**
     * д����ļ���
     */
    private static final String FILENAME = "log.txt";

    /**
     * ��־�������������������ʱ��������־����ɾ��������־
     */
    private static final long MAXLOGSIZE = 1024 * 1024 * 3;
	
    /**
     * ʵ������
     */
    private static LogX instance;
    
	/**
	 * ����·��
	 */
    private String logPath = DEFAULT_LOG_PATH;
	
	/**
	 * д�ļ�������б�
	 */
	private Queue<String> lstStorageTask;

	/**
	 * д�ļ��߳��Ƿ���������
	 */
	private boolean isRunnig;

	/**
	 * ��Ҫ���д����ļ�������
	 */
	private RandomAccessFile randomAccessFile = null;
	
	private File file = null;
	
	/**
     * �Ƿ��¼ϵͳ������־  true ��¼�� false ����¼
     */
    public static boolean infoFlag = false;
	
    private static LogX inst = null;
    
    /**
     * ���캯��      
     */
    private LogX()
    {
        this(DEFAULT_LOG_PATH);
    }
    
    /**
     * ���캯��  
     */
    private LogX(String path)
    {
        isRunnig = true;
        logPath = path;
        lstStorageTask = new LinkedList<String>();
        openFile();
    }
    
    /**
     * ���캯��  
     * @param flag true ��¼��־  false ����¼
     */
    private LogX(boolean flag)
    {
        isRunnig = flag;
    }
	
    /**
     * [һ�仰���ܼ���]<BR>
     * ����infoFlag true ��¼ϵͳ��־�� false ����¼
     * @return ��־ʵ��
     */
    public static LogX getInstance()
    {
        if (infoFlag)
        {
            inst = getNewInstance();
        }
        else
        {
            if (null == inst)
            {
                inst = new LogX(infoFlag);
            }
        }
        return inst;
    }
    
    /**
     * ��ȡ��־ʵ��<BR>
     * @return ��־ʵ��
     */
	public static LogX getNewInstance()
	{
		if (instance != null)
		{
			return instance;
		}
		
		synchronized (LogX.class)
		{
//			if (instance == null)
//			{
//				instance = new LogX();
//				if (GlobalVariable.isAllowWriteLogFile)
//				{
//					instance.start();
//				}
//			}
			
//			if (GlobalVariable.isAllowWriteLogFile && !instance.isAlive())
//			{
//				instance.interrupt();
//				instance = new LogX();
//				instance.start();
//			}
		}

		return instance;
	}

	/**
	 * ���sdcard�γ�����ֹͣ��¼��־
	 */
	public void stopLog()
	{
	    try
	    {
	        isRunnig = false;
	        if (instance != null)
	        {
	            instance.interrupt();
	        }
	        closeFile();
	    }
	    catch (Exception e)
	    {
	        Log.i(TAG, "stop the write log thread.");
	    }
	}
	
	/**
	 * ��¼info��־<BR>
	 * @param tag ��־��ʾ
	 * @param message ��Ϣ
	 */
	public void i(String tag, String message)
	{
		message = formatMessage(message);
		Log.i(tag, message);
		trace(tag, message);
	}
	
	/**
	 * ��¼error��־<BR>
     * @param tag ��־��ʾ
     * @param message ��Ϣ
	 */
	public void e(String tag, String message)
	{
		message = formatMessage(message);
		Log.e(tag, message);
		trace(tag, message);
	}
	
	/**
	 * ��¼debug��־<BR>
     * @param tag ��־��ʾ
     * @param message ��Ϣ
	 */
	public void d(String tag, String message)
	{
		message = formatMessage(message);
		Log.d(tag, message);
		trace(tag, message);
	}
	
	/**
	 * ��¼verbose��־<BR>
     * @param tag ��־��ʾ
     * @param message ��Ϣ
	 */
	public void v(String tag, String message)
	{
		message = formatMessage(message);
		Log.v(tag, message);
		trace(tag, message);
	}
	
	/**
	 * ��¼warning��־<BR>
     * @param tag ��־��ʾ
     * @param message ��Ϣ
	 */
	public void w(String tag, String message)
	{
		message = formatMessage(message);
		Log.w(tag, message);
		trace(tag, message);
	}
	
	/**
	 * ��ȡ��־�����Ϊnull�����ؿ�ָ����־<BR>
	 * [������ϸ����]
	 * @param message ��־��Ϣ
	 * @return ��־��Ϣ
	 */
	private String formatMessage(String message)
	{
		if (message == null)
		{
			message = "java.lang.NullPointerException.";
		}
		return message;
	}
	
	/**
	 * ��洢�߳������д�ļ�����
	 * @param log    ��־��Ϣ
	 */
	private void trace(String tag, String message)
	{
		if (isRunnig)
		{
			synchronized (lstStorageTask)
			{
				if (needClearLogs())
				{
					deleteFile();
					closeFile();
					openFile();
				}
				
				lstStorageTask.add(tag + "---||  " + message + "\n");
				lstStorageTask.notify();
			}
		}
	}

	/**
	 * �߳�ִ����
	 */
	public void run()
	{
		while (isRunnig)
		{
			try
			{
				if (lstStorageTask == null)
				{
					Log.i(TAG, "In storage thread the lstStorageTask is null.");
					break;
				}

				String dataBlock = null;
				synchronized (lstStorageTask)
				{
					// �����ǰû��Ҫд�����ݣ��ȴ�...
					if (lstStorageTask.isEmpty())
					{
						lstStorageTask.wait();
					}

					// ��������ݣ�ȡ��Ҫд������
					if (!lstStorageTask.isEmpty())
					{
						dataBlock = (String) lstStorageTask.poll();
					}
				}

				// ִ��д�ļ��Ĳ���
				if (dataBlock != null)
				{
					writeFile(dataBlock.getBytes());
				}
			}
			catch (InterruptedException e)
			{
				// ��ֹд�ļ��߳�
				Log.i(TAG, "The write file thread is closed.");
				isRunnig = false;
				break;
			}
		}
	}

	/**
	 * ��SD���д洢�ļ�ʱ������
	 */
	private void writeLogError()
	{
		// ��λд�ļ��߳����б�־
		isRunnig = false;

		// �ر��ļ���
		closeFile();

		// ���д�ļ�����
		clearLogTaskList();
	}

	/**
	 * �ر��ļ����� 
	 */
	private void closeFile()
	{
		try
		{
			if (randomAccessFile != null)
			{
				randomAccessFile.close();
			}
		}
		catch (IOException e)
		{
			Log.e(TAG, e.getMessage());
		}
		finally
		{
			randomAccessFile = null;
		}
	}

	/**
	 *  ���д�ļ�����
	 */
	private void clearLogTaskList()
	{
		synchronized (lstStorageTask)
		{
			// ��������е��������
			Iterator<String> tasks = lstStorageTask.iterator();
			while (tasks.hasNext())
			{
				String task = tasks.next();
				if (task != null)
				{
					// ����ڴ�
					task = null;
				}
			}
			// ��������б�
			lstStorageTask.clear();
		}
	}

	/**
	 * �Ƿ���Ҫ���<BR>
	 * @return �Ƿ���Ҫ���
	 */
	private boolean needClearLogs()
	{
		if (file.length() >= MAXLOGSIZE)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * �����ļ�����    
	 */
	private void openFile() 
	{
		File dir = new File(logPath);
		if (!dir.exists())
		{
			dir.mkdirs();
		}
		
		createFile();
	}
	
	/**
	 * ɾ���ļ�    
	 */
	private void deleteFile()
	{
		if (file.exists())
		{
			try
			{
				if (file.delete())
				{
					Log.i(TAG, "Delete log file success");
				}
				else
				{
					Log.e(TAG, "Delete log file failed");
				}
			}
			catch (Exception e)
			{
				Log.e(TAG, e.getMessage());
			}
		}
	}
	
	/**
	* ͨ���ṩ���ļ�����Ĭ��·���������ļ�
	* @param fileName     �ļ�������
	* @return ���ɵ��ļ�
	*/
	private void createFile()
	{
		if (file == null)
		{
			file = new File(logPath + FILENAME);
		}
		
		if (!file.exists())
		{
			try
			{
				file.createNewFile();
				closeFile();
			}
			catch (IOException e)
			{
				Log.e(TAG, e.getMessage());
			}
			
			createRandomAccessFile();
		}
		else if (randomAccessFile == null)
		{
			createRandomAccessFile();
		}
	}
	
	/**
	 * ����RandomAccessFile
	 */
	private void createRandomAccessFile()
	{
		try
		{
			randomAccessFile = new RandomAccessFile(file, "rw");
			
			if (randomAccessFile == null)
			{
				Log.e(TAG, "initial LogX file error.");
			}
		}
		catch (Exception e)
		{
			closeFile();
			Log.e(TAG, e.getMessage());
		}
	}
	
	private void writeFile(byte[] io)
	{
		if (io != null)
		{
			if (randomAccessFile != null)
			{
				try
				{
					createFile();
					randomAccessFile.seek(randomAccessFile.length());
					randomAccessFile.write(io);
				}
				catch (IOException e)
				{
					Log.e(TAG, e.getMessage());
					String state = Environment.getExternalStorageState();
			        if (!state.equals(Environment.MEDIA_MOUNTED) || io.length >= getAvailableStore()) 
			        {
			        	writeLogError();
			        }
				}
			}
			else
			{
				String state = Environment.getExternalStorageState();
				if (!state.equals(Environment.MEDIA_MOUNTED) || io.length >= getAvailableStore()) 
		        {
		        	writeLogError();
		        }
			}
		}
	}
	
    private long getAvailableStore() 
    {

        // ȡ��sdcard�ļ�·��
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory()
				.getAbsolutePath());

        // ��ȡblock��SIZE
        long blocSize = statFs.getBlockSize();

        // ��ȡBLOCK����
        //long totalBlocks = statFs.getBlockCount();
        // ��ʹ�õ�Block������
        long availaBlock = statFs.getAvailableBlocks();
        
        //long total = totalBlocks * blocSize;
        long availableSpare = availaBlock * blocSize;
        
        return availableSpare;

}
}