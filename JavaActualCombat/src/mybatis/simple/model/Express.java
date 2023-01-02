package mybatis.simple.model;

public class Express {
    private int expressId;
    private String expressUser;
    private String expressUserId;
    private String expressName;
    private String expressCode;
    private String expressTime;
    private String expressPrice;
    private String expressContact;
    private String expressInfo;

    public Express(){

    }
    public Express( String expressUser, String expressUserId, String expressName,String expressCode, String expressTime, String expressPrice, String expressContact, String expressInfo) {
        this.expressUser = expressUser;
        this.expressUserId = expressUserId;
        this.expressName = expressName;
        this.expressCode = expressCode;
        this.expressTime = expressTime;
        this.expressPrice = expressPrice;
        this.expressContact = expressContact;
        this.expressInfo = expressInfo;
    }
    public Express( int expressId,String expressUser, String expressUserId, String expressName, String expressCode,String expressTime, String expressPrice, String expressContact, String expressInfo) {
        this.expressId = expressId;
        this.expressUser = expressUser;
        this.expressUserId = expressUserId;
        this.expressName = expressName;
        this.expressCode = expressCode;
        this.expressTime = expressTime;
        this.expressPrice = expressPrice;
        this.expressContact = expressContact;
        this.expressInfo = expressInfo;
    }
    public int getExpressId() {
        return expressId;
    }
    public String getExpressContact() {
        return expressContact;
    }
    public String getExpressInfo() {
        return expressInfo;
    }
    public String getExpressName() {
        return expressName;
    }
    public String getExpressCode() { return expressCode;}
    public String getExpressPrice() {
        return expressPrice;
    }
    public String getExpressTime() {
        return expressTime;
    }
    public String getExpressUser() {
        return expressUser;
    }
    public String getExpressUserId() {
        return expressUserId;
    }
    public void setExpressId(int expressId) {
        this.expressId = expressId;
    }
    public void setExpressContact(String expressContact) {
        this.expressContact = expressContact;
    }
    public void setExpressInfo(String expressInfo) {
        this.expressInfo = expressInfo;
    }
    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }
    public void setExpressCode(String expressCode) { this.expressCode = expressCode;}
    public void setExpressPrice(String expressPrice) {
        this.expressPrice = expressPrice;
    }
    public void setExpressTime(String expressTime) {
        this.expressTime = expressTime;
    }
    public void setExpressUser(String expressUser) {
        this.expressUser = expressUser;
    }
    public void setExpressUserId(String expressUserId) {
        this.expressUserId = expressUserId;
    }
}
