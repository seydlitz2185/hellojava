package mybatis.simple.model;

public class Market {
    private int marketId;
    private String marketUser;
    private String marketUserId;
    private String marketTime;
    private String marketPrice;
    private String marketContact;
    private String marketTags;
    private String marketInfo;

    public Market(){

    }
    public Market( String marketUser, String marketUserId,String marketTime, String marketPrice, String marketContact, String marketTags, String marketInfo) {
        this.marketUser = marketUser;
        this.marketUserId = marketUserId;
        this.marketTime = marketTime;
        this.marketPrice = marketPrice;
        this.marketContact = marketContact;
        this.marketTags = marketTags;
        this.marketInfo = marketInfo;
    }
    public Market( int marketId,String marketUser, String marketUserId, String marketTime, String marketPrice, String marketContact, String marketTags, String marketInfo) {
        this.marketId = marketId;
        this.marketUser = marketUser;
        this.marketUserId = marketUserId;
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
    public String getMarketPrice() {
        return marketPrice;
    }
    public String getMarketTags() {
        return marketTags;
    }
    public String getMarketTime() {
        return marketTime;
    }
    public String getMarketUser() {
        return marketUser;
    }
    public String getMarketUserId() {
        return marketUserId;
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
    public void setMarketUser(String marketUser) {
        this.marketUser = marketUser;
    }
    public void setMarketUserId(String marketUserId) {
        this.marketUserId = marketUserId;
    }
}
