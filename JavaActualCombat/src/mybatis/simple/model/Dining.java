package mybatis.simple.model;

public class Dining {
    private int diningId;
    private String diningUser;
    private String diningUserId;
    private String diningName;
    private String diningTime;
    private String diningPrice;
    private String diningContact;
    private String diningTags;
    private String diningInfo;

    public Dining(){

    }
    public Dining( String diningUser, String diningUserId, String diningName, String diningTime, String diningPrice, String diningContact, String diningTags, String diningInfo) {
        this.diningUser = diningUser;
        this.diningUserId = diningUserId;
        this.diningName = diningName;
        this.diningTime = diningTime;
        this.diningPrice = diningPrice;
        this.diningContact = diningContact;
        this.diningTags = diningTags;
        this.diningInfo = diningInfo;
    }
    public Dining( int diningId,String diningUser, String diningUserId, String diningName, String diningTime, String diningPrice, String diningContact, String diningTags, String diningInfo) {
        this.diningId = diningId;
        this.diningUser = diningUser;
        this.diningUserId = diningUserId;
        this.diningName = diningName;
        this.diningTime = diningTime;
        this.diningPrice = diningPrice;
        this.diningContact = diningContact;
        this.diningTags = diningTags;
        this.diningInfo = diningInfo;
    }
    public int getDiningId() {
        return diningId;
    }
    public String getDiningContact() {
        return diningContact;
    }
    public String getDiningInfo() {
        return diningInfo;
    }
    public String getDiningName() {
        return diningName;
    }
    public String getDiningPrice() {
        return diningPrice;
    }
    public String getDiningTags() {
        return diningTags;
    }
    public String getDiningTime() {
        return diningTime;
    }
    public String getDiningUser() {
        return diningUser;
    }
    public String getDiningUserId() {
        return diningUserId;
    }
    public void setDiningId(int diningId) {
        this.diningId = diningId;
    }
    public void setDiningContact(String diningContact) {
        this.diningContact = diningContact;
    }
    public void setDiningInfo(String diningInfo) {
        this.diningInfo = diningInfo;
    }
    public void setDiningName(String diningName) {
        this.diningName = diningName;
    }
    public void setDiningPrice(String diningPrice) {
        this.diningPrice = diningPrice;
    }
    public void setDiningTime(String diningTime) {
        this.diningTime = diningTime;
    }
    public void setDiningTags(String diningTags) {
        this.diningTags = diningTags;
    }
    public void setDiningUser(String diningUser) {
        this.diningUser = diningUser;
    }
    public void setDiningUserId(String diningUserId) {
        this.diningUserId = diningUserId;
    }
}
