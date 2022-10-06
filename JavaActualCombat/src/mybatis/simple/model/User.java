package mybatis.simple.model;

/**
 * @author stevenyu
 */

public class User {
    private long id;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userPhoneNum;

    public String getUserName() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getEmail() {
        return userEmail;
    }

    public void setEmail(String email) {
        this.userEmail = email;
    }

    public String getPhoneNum() {
        return userPhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.userPhoneNum = phoneNum;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
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
                ", email='" + userEmail + '\'' +
                ", password='" + userPassword + '\'' +
                ", phoneNum='" + userPhoneNum + '\'' +
                '}';
    }
}


