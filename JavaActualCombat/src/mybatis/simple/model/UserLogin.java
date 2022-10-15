package mybatis.simple.model;

import java.io.Serializable;

public class UserLogin implements Serializable {
    private String userName;
    private String msg;
    private String id;
    public void setMsg(String msg){this.msg = msg;}
    public void setAccount(String account){this.id = account;}
    public void setName(String name){this.userName = name;}
    public String getAccount() {
        return id;
    }
    public String getMsg() {
        return msg;
    }
    public String getName() {
        return userName;
    }
}
