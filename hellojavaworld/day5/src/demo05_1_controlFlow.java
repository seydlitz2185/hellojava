import java.util.*;
public class demo05_1_controlFlow {
    public static void main(String[] args){
//        控制流程基本与C相同，包括if-else、switch；while、do while和for，此外对于遍历数组提供了更方便的for-each循环
//        示例：火车票购票
        int i, j ,k;
        final int price = 10;
        int bill = 0 ;
        int cnt =0;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎乘坐Java城际列车，票价10元");

            while(bill != -1  ){
                System.out.println("请投币：(输入\"-1\"结束投币)");
                bill = in.nextInt();
                if (bill != -1)
                    cnt =cnt + bill;
            }

            System.out.println("投币结束");
            System.out.println("购买车票请输入\'1\',退款请输入\'0\'");

            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    if (cnt >= price) {
                        //打印车票
                        System.out.println("********************");
                        System.out.println("*   Java城际列车    *");
                        System.out.println("*    票价：10元     *");
                        System.out.println("*     欢迎乘车      *");
                        System.out.println("*    祝您旅途愉快～  *");
                        System.out.println("********************");

                        System.out.printf("找零：%d元\n", cnt - price);
                    } else {
                        System.out.println("钱不够，购买失败");
                        System.out.printf("退款:%d元\n",cnt);
                    }
                    break;
                case 0:
                    System.out.printf("退款:%d元\n",cnt);
                    break;
            }
            bill = 0;
            cnt = 0;
            System.out.println();
        }
    }
}
