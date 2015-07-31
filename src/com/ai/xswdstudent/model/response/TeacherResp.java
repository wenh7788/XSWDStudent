package com.ai.xswdstudent.model.response;

import java.util.ArrayList;

import com.ai.xswdstudent.model.teacher;

/**
 * 当前考试的列表
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  poorgod
 * @version  
 * @see  
 * @since  [产品/模块版本]
 */
public class TeacherResp 
{
    
    
    /**
     * 年级名称
     */
    public String count;
  
    /**
     * 学年
     */
    public int teachAge;   
    
    
    
    /**
     * 年级名称
     */
    public String signature;
  
    /**
     * 学年
     */
    public int courseName;   
    
    
    /**
     * 年级名称
     */
    public String realName;
  
    
    
    
    /**
     * 往期老师集合
     */
    public ArrayList<teacher> tcpInfoList;
    
}
