package mybatis.simple.model;

import java.io.Serializable;

public class UserLogin implements Serializable {
    private String userName;
    private String msg;
    private String id;
    private String phoneNum;

    public  UserLogin(){}

    public UserLogin(String userName, String msg, String id, String phoneNum) {
        this.userName = userName;
        this.msg = msg;
        this.id = id;
        this.phoneNum = phoneNum;
    }

    public void setMsg(String msg){this.msg = msg;}
    public void setAccount(String account){this.id = account;}
    public void setName(String name){this.userName = name;}
    public void setPhoneNum(String phoneNum){this.phoneNum = phoneNum;}
    public String getAccount() {
        return id;
    }
    public String getMsg() {
        return msg;
    }
    public String getName() {
        return userName;
    }
    public String getPhoneNum(){return phoneNum;}
}
