/*
 * �� �� ��:  StringUtil.java
 * ��    ��:  �ַ���������
 * �� �� ��:  ���
 * ����ʱ��:  2013-5-2
 */
package com.ai.xswdstudent.util;

/**
 * �ַ���������  �����װ���ַ�����ز�������
 * 
 * @author  ���
 * @version  [�汾��, 2013-5-2]
 * @see  [�����/����]
 * @since  [��Ʒ/ģ��汾]
 */
public class StringUtil
{
    /**
     * �ж��ַ����Ƿ�Ϊ��
     * @param str
     * @return true���� ��false���ǿ�
     * @see [�ࡢ��#��������#��Ա]
     */
    public static boolean isEmpty(String str)
    {
        if ((null != str) && (!"".equals(str)) && (!"null".equals(str)))
        {
            return false;
        }
        return true;
    }
}
