package mybatis.simple.model;

/**
 * @author stevenyu
 */

public class User {
    private String id;
    private String userName;
    private String userPassword;
    private String userPhoneNum;

    public String getUserName() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPhoneNum() {
        return userPhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.userPhoneNum = phoneNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getPassword() {
        return userPassword;
    }

    public void setPassword(String password) {
        this.userPassword = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + userName + '\'' +
                ", password='" + userPassword + '\'' +
                ", phoneNum='" + userPhoneNum + '\'' +
                '}';
    }
}


