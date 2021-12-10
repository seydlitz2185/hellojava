package dataRoom;

public class Item {
    //将子类中通用的部分放进父类
    private String title;
    private int playingTime;
    private boolean gotIt;
    private String comment;

    public Item(String title, int playingTime,
                boolean gotIt, String comment) {
        this.title = title;
        this.playingTime = playingTime;
        this.gotIt = gotIt;
        this.comment = comment;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void print() {
        System.out.println(title);
    }
}
