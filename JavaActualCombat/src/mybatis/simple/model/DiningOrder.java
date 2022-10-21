package mybatis.simple.model;

public class DiningOrder {
    private int diningId;
    private String hostUserId;
    private String deliverUserId;
    private String diningName;
    private String diningTime;
    private String diningPrice;
    private String diningContact;
    private String diningTags;
    private String diningInfo;

    public  DiningOrder(){

    }

    public DiningOrder(int diningId, String hostUserId, String deliverUserId, String diningName, String diningTime, String diningPrice, String diningContact, String diningTags, String diningInfo) {
        this.diningId = diningId;
        this.hostUserId = hostUserId;
        this.deliverUserId = deliverUserId;
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
    public String getDeliverUserId(){
        return deliverUserId;
    }
    public String getHostUserId() {
        return hostUserId;
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
    public void setHostUserId(String hostUserId) {
        this.hostUserId = hostUserId;
    }
    public void setDeliverUserId(String deliverUserId) {
        this.deliverUserId = deliverUserId;
    }

}
