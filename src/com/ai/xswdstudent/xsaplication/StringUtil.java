package com.ai.xswdstudent.xsaplication;
public class StringUtil
{
    public static boolean isEmpty(String str)
    {
        if ((null != str) && (!"".equals(str)) && (!"null".equals(str)))
        {
            return false;
        }
        return true;
    }
}
