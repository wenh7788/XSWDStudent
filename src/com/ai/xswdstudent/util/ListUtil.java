/*
 * �� �� ��:  ListUtil.java
 * ��    ��:  List������
 * �� �� ��:  ���
 * ����ʱ��:  2013-5-2
 */
package com.ai.xswdstudent.util;

import java.util.ArrayList;
import java.util.List;

/**
 * List������  �����װ��List��ش�����
 * 
 * @author  ���
 * @version  [�汾��, 2013-5-2]
 * @see  [�����/����]
 * @since  [��Ʒ/ģ��汾]
 */
public class ListUtil
{
    /**
     * �ж�List�Ƿ�Ϊ��
     * @param list
     * @return true���� ��false���ǿ�
     * @see [�ࡢ��#��������#��Ա]
     */
    public static boolean isEmpty(List<?> list)
    {
        if (null != list && !list.isEmpty())
        {
            return false;
        }
        return true;
    }
    
    /**
     * �ж�ArrayList�Ƿ�Ϊ��
     * @param list
     * @return true���� ��false���ǿ�
     * @see [�ࡢ��#��������#��Ա]
     */
    public static boolean isEmpty(ArrayList<?> list)
    {
        if (null != list && !list.isEmpty())
        {
            return false;
        }
        return true;
    }
}
