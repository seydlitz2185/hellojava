package dataRoom;

import java.util.ArrayList;

public class Database {
//    一个变量可以保存其所声明的类型或该类®型的任何子类型。
//    在Database中我们从未给容器listItem赋值任何Item类变量
//    而是赋值Item的子类CD和DVD类变量
//    java的对象变量都是多态变量，可以保存不止一种类型的对象
//    变量类型可分为两种：静态变量（声明变量），动态变量
//    声明变量(类型)：如在Database类中add函数传入值是Item item一个已经声明的类型的变量
//    动态变量(类型)：对于main函数中的item可能是DVD也可能是CD，是动态的

    public ArrayList<Item> listItem =
            new ArrayList<Item>();

    public  void add(Item item){
        listItem.add(item);
    }
    public void list(){
        for (Item item : listItem){
            item.print();
//  item.print()是一个多态，即通过一个变量调用一个函数。通过变量调用函数时调用哪一个函数被称为绑定
//  静态绑定：根据变量声明类型Item决定；动态绑定：根据变量动态类型决定（CD、DVD）
//  对于Java，默认所有成员函数调用都是动态绑定（看作使用了this）
//  覆盖：子类和父类中存在名称和参数表完全相同的函数，这一对函数构成覆盖关系
//  即通过父类的变量（Item item）调用存在覆盖关系的函数（item.print）时，
//  会调用变量当时所管理的对象所属的类（CD、DVD）的函数（CD、DVD里的print）

        }
    }

    public static void main(String[] args){
        Database db = new Database();
//        向上造型：将子类对象交给父类变量称为向上造型
//        ！！！子类交给父类总是安全的，父类交给子类（造型）并不总是安全的
//        不同于强制类型转换，造型并不会改变对象的值，只是当作父类的对象来使用
//        注：1、造型(cast)：把一个类的对象赋值给另一个类的变量(管理者，类似指针)
//        注：2、对于大部分oop语言都只能对象赋值给变量，但c++可以将对象赋值给对象
        db.add(new CD("Made In Heaven","Queen",
                4,1000,
                true,"masterpiece"));
        db.add(new CD("Help！","The Beatles",
                4,800,
                true,"love it"));
        db.add(new DVD("Titanic","James Cameron",
                200,true,"pretty good"));
        db.add(new GAMES("Biohazard II","Capcom",10,true,"good"));
        
        db.list();
    }
}
