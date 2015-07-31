package com.ai.xswdstudent.model;

import java.io.Serializable;

public class UserItem implements Serializable
{
    
    private static final long serialVersionUID = 1L;
    
    public String studentId; //
    
    public String userId;
    
    public String parentSex;
    
    public String mobile;
    
    public String password;
    
    // public ArrayList<ChildrenItem> children;
    public int photoId; //用户照片id
    
    public String userName; //userName
    
    public String nickname; //nickname realName
    
    public String realName; //nickname realName
    
    public int id;//nickname realName
    
    public String email;
    
    public int gender;
    
    public String address;
    
    public int birthyear;
    
    public int birthmoth;
    
    public int birthday;
    
    public int degreeId;
    
    public int interster ;//xingquaihao
    public int signature ;//gexingqianming
    public int intro ;//gerenshuoming
    
    //public File  studentPhoto; //sanchuanxueshengzhaopian
    
    /***
     * 
     * */
    public String pushId;
    
    private String subAccountSid = "";
    
    private String voipAccount = "";
    
    private String dateCreated = "";
    
    private String friendlyName = "";
    
    private String voipPwd = "";
    
    private String subToken = "";
    
    //  public ChildrenItem selectedItem;
    
    public String getSubAccountSid()
    {
        return subAccountSid;
    }
    
    public void setSubAccountSid(String subAccountSid)
    {
        this.subAccountSid = subAccountSid;
    }
    
    public String getVoipAccount()
    {
        return voipAccount;
    }
    
    public void setVoipAccount(String voipAccount)
    {
        this.voipAccount = voipAccount;
    }
    
    public String getDateCreated()
    {
        return dateCreated;
    }
    
    public void setDateCreated(String dateCreated)
    {
        this.dateCreated = dateCreated;
    }
    
    public String getFriendlyName()
    {
        return friendlyName;
    }
    
    public void setFriendlyName(String friendlyName)
    {
        this.friendlyName = friendlyName;
    }
    
    public String getVoipPwd()
    {
        return voipPwd;
    }
    
    public void setVoipPwd(String voipPwd)
    {
        this.voipPwd = voipPwd;
    }
    
    public String getSubToken()
    {
        return subToken;
    }
    
    public void setSubToken(String subToken)
    {
        this.subToken = subToken;
    }
    
}
