package dataRoom;

public class GAMES extends Item {
    private String company;
    public GAMES (String title, String company,
                          int playingTime, boolean gotIt,
                          String comment){
        super(title,playingTime,false,comment);
        this.company = company;
    }
    public void print() {
        System.out.println("GAME:");
        super.print();/*指向父类(Item)的引用(指针)*/
        System.out.println(company);
    }
}
