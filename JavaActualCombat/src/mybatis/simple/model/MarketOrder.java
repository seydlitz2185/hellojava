package mybatis.simple.model;

public class MarketOrder {
    private int marketId;
    private String hostUserId;
    private String deliverUserId;
    private String marketTime;
    private String marketPrice;
    private String marketContact;
    private String marketTags;
    private String marketInfo;

    public  MarketOrder(){

    }

    public MarketOrder(int marketId, String hostUserId, String deliverUserId, String marketTime, String marketPrice, String marketContact, String marketTags, String marketInfo) {
        this.marketId = marketId;
        this.hostUserId = hostUserId;
        this.deliverUserId = deliverUserId;
        this.marketTime = marketTime;
        this.marketPrice = marketPrice;
        this.marketContact = marketContact;
        this.marketTags = marketTags;
        this.marketInfo = marketInfo;
    }

    public int getMarketId() {
        return marketId;
    }
    public String getMarketContact() {
        return marketContact;
    }
    public String getMarketInfo() {
        return marketInfo;
    }
    public String getDeliverUserId(){
        return deliverUserId;
    }
    public String getHostUserId() {
        return hostUserId;
    }
    public String getMarketPrice() {
        return marketPrice;
    }
    public String getMarketTags() {
        return marketTags;
    }
    public String getMarketTime() {
        return marketTime;
    }


    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }
    public void setMarketContact(String marketContact) {
        this.marketContact = marketContact;
    }
    public void setMarketInfo(String marketInfo) {
        this.marketInfo = marketInfo;
    }
    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }
    public void setMarketTime(String marketTime) {
        this.marketTime = marketTime;
    }
    public void setMarketTags(String marketTags) {
        this.marketTags = marketTags;
    }
    public void setHostUserId(String hostUserId) {
        this.hostUserId = hostUserId;
    }
    public void setDeliverUserId(String deliverUserId) {
        this.deliverUserId = deliverUserId;
    }
}
