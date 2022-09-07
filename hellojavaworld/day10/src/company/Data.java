package company;

import java.util.ArrayList;
import java.util.HashMap;

public class Data {
    private HashMap<String,Member> listMember = new HashMap<>();
    public void put(String s, Member m){
        listMember.put(s,m);
    }
    public void list() {
        System.out.println("list:");
        for (String key :listMember.keySet()){
            System.out.println(key+" "+listMember.get(key).toString());
        }
    }
    public static void main(String[] args){
        Data db = new Data();
        db.put("001",new Employee("Steve",1000,2021,6,"A"));
        db.put("002",new Employee("Tom",2000,2020,9,"B"));
        db.put("003",new Manager("Jerry",5000,2010,1,"Boss"));
        db.list();
    }
}
