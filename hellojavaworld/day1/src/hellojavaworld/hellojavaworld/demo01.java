package hellojavaworld;

//数据类型自动转换原则：数据范围从小到大转换
public class demo01 {
    public static void main (String[] args) {
        System.out.println(1024); /*整数，默认int*/
        System.out.println(3.14);/*浮点数，默认float*/
    //数据类型自动转换
    //case 1：左边long，右边int，符合从小到大，触发自动转换
        long num1 = 100;
        System.out.println(num1);
    //case 2: 左边float，右边long，虽然long占8个byte大于float的4个字节，但float的数据范围更大，也可以出发自动转换
        float num2 = 25L;
        System.out.println(num2);

    //数据类型强制转换原则： 小的数据范围 变量名称 = （小的数据范围）拥有大数据范围的数据
    //case 3：左边int，右边double，从大到小，使用强制转换成int
        int num3 = (int)3.50;//没有四舍五入，省略全部小数
        System.out.println(num3);
    //强制类型转换可能导致数据溢出，最好不要用。除了boolean数据都可以进行类型转换
    //case 4: byte类型最大为128，（byte）300发生数值溢出，结果等于44
        byte ch1 = (byte)300;
        System.out.println(ch1);

    }

}
