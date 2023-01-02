package mybatis.simple.model;

public class ExpressOrder {
    private int expressId;
    private String hostUserId;
    private String deliverUserId;
    private String expressName;
    private String expressCode;
    private String expressTime;
    private String expressPrice;
    private String expressContact;
    private String expressInfo;

    public  ExpressOrder(){

    }

    public ExpressOrder(int expressId, String hostUserId, String deliverUserId, String expressName, String expressCode, String expressTime, String expressPrice, String expressContact, String expressInfo) {
        this.expressId = expressId;
        this.hostUserId = hostUserId;
        this.deliverUserId = deliverUserId;
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
    public String getExpressCode() { return expressCode;}
    public String getExpressName() {
        return expressName;
    }
    public String getDeliverUserId(){
        return deliverUserId;
    }
    public String getHostUserId() {
        return hostUserId;
    }
    public String getExpressPrice() {
        return expressPrice;
    }
    public String getExpressTime() {
        return expressTime;
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
    public void setHostUserId(String hostUserId) {
        this.hostUserId = hostUserId;
    }
    public void setDeliverUserId(String deliverUserId) {
        this.deliverUserId = deliverUserId;
    }
}
