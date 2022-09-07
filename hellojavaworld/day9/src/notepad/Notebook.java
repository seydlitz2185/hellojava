package notepad;

import java.util.ArrayList;
import java.util.HashSet;

class Value {
    private int i;
    public void set(int i) { this.i = i;}
    public int get(){return i;}
//   只要在类里定义过一下函数，就可以在输出
//    System.out.println(对象管理者)时直接将对象内容打印成字符串
    public String toString(){return  ""+i;}

}

public class Notebook {
    /*容器是一种泛型类，ArrayList是类名
    <String>表示这个类用于存放String，
    notes是对象管理者（对象名）*/
    private ArrayList<String> notes = new ArrayList<String>();

    public void add(String s){
        notes.add(s);
    }
    public void add(String s,int location){
        notes.add(location,s);
    }
    public int getSize(){
        return notes.size();
    }
    public String getNote(int index){
        return notes.get(index);
    }
    public void removeNote(int index){
        notes.remove(index);
    }
    public String[] list(){
        String[] a = new String[notes.size()];
//        这是一个对象数组

//for (int i = 0; i<notes.size();i++){
//            a[i] = notes.get(i);
//        }
        notes.toArray(a);
        return a;
    }

    public static void main(String[] args){
        Value v = new Value();
        v.set(10);
        System.out.println(v);
//        数组内是String对象的管理者，如果没给他们赋值那就约等于空指针
//        String [] temp = new String[10];
//        System.out.println(temp[0]);
//        容器的性质和字符串数组相似，也可以用foreach循环遍历
        ArrayList<String> a =new ArrayList<String>();
        a.add("one");
        a.add("two");
        a.add("three");
        System.out.println(a);
//        集合容器 参考数学集合，会合并重复的
        HashSet<String> s = new HashSet<String>();
        s.add("one");
        s.add("two");
        s.add("one");
        System.out.println(s) ;
//        Notebook nb = new Notebook();
//        nb.add("first");
//        nb.add("second");
//        System.out.println(nb.getNote(1));
//        nb.add("third",1);
//        System.out.println(nb.getSize());
//        System.out.println(nb.getNote(1));
//        nb.removeNote(1);
//        String [] a = nb.list();
//        for (String s : a){
//            System.out.println(s);
//        }
    }
}
