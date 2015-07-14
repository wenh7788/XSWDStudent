package com.ai.xswdstudent.model;

import java.io.Serializable;


public class UserItem implements Serializable
{
   
    private static final long serialVersionUID = 1L;
    
   
    public String userId;
    
   
    public String parentSex;
    
    
    public String phone;
    
    
    public String password;
    
   
   // public ArrayList<ChildrenItem> children;
    
    
    public String imageHeadUrl;
    
    
    public String appellation;
    
   
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
