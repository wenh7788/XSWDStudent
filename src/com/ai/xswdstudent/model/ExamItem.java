package com.ai.xswdstudent.model;

import java.util.ArrayList;

/**
 * 考试对象
 * <�?��话功能简�?
 * <功能详细描述>
 * 
 * @author  poorgod
 * @version  [版本�? 2015-5-19]
 * @see  [相关�?方法]
 * @since  [产品/模块版本]
 */
public class ExamItem
{
    
    /**
     * 考试编号
     */
    public String examinationId;
    
    /**
     * 考试名称
     */
    public String examinationName;
    
    /**
     * 学年
     */
    public String schoolYear;   //
    
    /**
     * 1 上学�?2 下学�?
     */
    public String semester;
    
    /**
     * 学科成绩集合
     */
    public ArrayList<SubjectItem> list;
    
}
