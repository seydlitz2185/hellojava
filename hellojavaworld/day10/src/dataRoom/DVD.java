package dataRoom;

public class DVD extends Item{

    private String directer;


    public DVD (String title,String directer,
                   int playingTime, boolean gotIt,
                String comment){
            super(title,playingTime,false,comment);
    //在子类构造器中super()如果不含参数，
    //会自动调用父类不含参数的构造器进行初始化
    //如果父类只有一个有参数的构造器就会报错
            this.directer = directer;
        }
    public void print() {
        System.out.println("DVD:");
        super.print();/*指向父类(Item)的引用(指针)*/
        System.out.println(directer);
    }
}

