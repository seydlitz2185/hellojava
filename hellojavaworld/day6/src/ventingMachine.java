import java.util.Scanner;
//应使用HashMap再次实现
//不要用枚举
public class ventingMachine {
//类定义包括：成员变量，成员函数（方法）
//成员变量分为：类(静态)变量（有static）和实例变量（无static）
//成员变量和函数的值是属于每一个对象，除非加static关键字
//类变量可被所有对象共享
    items bread = Enum.valueOf(items.class,"bread");
    items chips = Enum.valueOf(items.class,"chips");
    items coke =  Enum.valueOf(items.class,"coke");
    items NULL = null;
    int balance;/*余额*/
    int total;/*总营业额*/
    boolean check = true;
    items selectItems(int i){
        return switch (i) {
            case 1 -> bread;
            case 2 -> chips;
            case 3 -> coke;
            default -> NULL;
        };
    }
//    打招呼
    void showPrompt(){
        System.out.println("欢迎光临！");
    }
//    显示菜单
    void showItems(){
        for (items item : items.values()){
            System.out.println(item.num+" "+item.name+" "+item.price);
        }
    }
//    投币
    void insertBill(int bill){
        if (bill >= 0){
            balance += bill;
        }
        this.showBalance();
    }
//    显示余额
    void showBalance(){
        System.out.printf("余额：%d元\n",balance);
    }
//    买东西
    void orderFood(int num){
        if(num >=1 && num <= 3) {
            items item = this.selectItems(num);
            this.calculator(item.num);
        } else if (num == -1){
            check = false;
            this.change();
        }else{
            System.out.println("抱歉，暂时没有这个商品");
        }
    }
//    计算
    void calculator(int num){
        items item = this.selectItems(num);
        if (item.getPrice(num) >0){
            if (balance >= item.getPrice(num)){
                System.out.println("您已成功地完成购买");
                balance -= item.getPrice(num);
                total += balance;
                this.hereYouAre(num);
                this.showBalance();
            } else{
                System.out.println("您的购买无法完成");
            }
        }
    }
//    弹出商品
    void hereYouAre(int num){
        items item = this.selectItems(num);
        if(num == item.num){
            System.out.println("给你"+item.name);
        }
    }
//    找零
    void change(){
        System.out.printf("找零：%d元\n",balance);
        balance = 0;
    }

public enum items/*这是一个枚举类*/
    {   bread("面包",1,5),
        chips("薯片",2,10),
        coke("可乐",3,3);
        final String name;
        final int num;
        int price;
        items(String name, int num, int price) {
            this.name = name;
            this.num = num;
            this.price = price;
        }

        String getName(int i){
            if(i == this.num){
                return this.name;
            }else return "NAME ERROR";
        }
        int getNum(int i){
            if (i == this.num){
                return this.num;
            } else return 0;
        }
        int getPrice(int i){
            if(i == this.num)
                return this.price;
            else return 0;
        }
    }

    public static void main(String[] args){
//bread.price 不可以调用原因：
// main函数是static的，只能调用static的类变量或函数
//price属于枚举对象bread，bread是venting machine类的成员变量，
// 不能被main直接调用，需要先调用类生成一个vm对象后才能调用bread.price
// 可以：System.out.println(vm.bread.price)；
//或者：System.out.println(items.bread);
        Scanner in =  new Scanner(System.in);
        ventingMachine vm = new ventingMachine();
        vm.showPrompt();
        vm.showItems();
        do{
            int i = in.nextInt();
            if(i > 0) {
                vm.insertBill(i);
            }
            vm.orderFood(in.nextInt());
        }while (vm.check);
    }
}
