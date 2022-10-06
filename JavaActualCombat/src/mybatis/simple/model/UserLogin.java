package mybatis.simple.model;

import java.io.Serializable;

public class UserLogin implements Serializable {
    private String account;
    private String passwd;
    public void setAccount(String account){this.account = account;};
    public void setPasswd(String passwd){this.passwd = passwd;};
    public String getAccount() {
        return account;
    }
    public String getPasswd() {
        return passwd;
    }
}
