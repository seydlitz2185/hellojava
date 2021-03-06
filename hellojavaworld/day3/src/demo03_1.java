import java.util.* ;
public class demo03_1 {
    /*
    算术运算符与c相同，+ — * /，++ --.etc
    比较运算符基本与c相同，> < == >= <=.etc，比较完成后返回boolean；注意事项：比较运算符不可以连续使用
    逻辑运算符与c相同，注意事项：1、只用于boolean 2、与、或可以连写 3与，或是双目运算符，非是单目运算符
    */
    public static void main ( String[] args) {//case1:算术运算符举例——自增
        int i = 10;
        System.out.println("i的初始值为：");
        System.out.println(i);
        System.out.println("后自增：执行时i不变，执行后i变");
        System.out.println(i++);
        System.out.println(i);
        System.out.println("前自增：执行时i立刻变");
        System.out.println(++i);
        System.out.println(i);
        //case2:比较运算符
        System.out.println(10>15);//false
        System.out.println(10<15);//ture
/*        System.out.println(10>15>1);
        java: 二元运算符 '>' 的操作数类型错误
        第一个类型:  boolean
        第二个类型: int
 */
    /*case3:逻辑运算符 与 && （左右都true才返回ture）或 ||（左右有true返回ture）
    非 ！（取反，true变false，false变ture） */
        System.out.println(3<4 && 10>5);//true && true,返回true
    /*case3.1:短路 与、非具有短路效果，若&&根据左边已经可以判断结果，右边的代码不会执行,从而节省性能
    因此若右边进行其他操作（如自增）会被略过。不建议写短路代码*/
        int a = 5;
        System.out.println(10>15 && 11>a--);
        System.out.println(a);//a还是5
    /*case4: 位运算符 ：&（and）|（or）^（xor 异或）~（not）
            前四个位运算符运算方法就是对二进制数每一位单独逻辑运算，可参考汇编语言或数字电路
            >>(左移)，<<(右移),>>>(左移高位补0)（移位运算的右操作数要完成模32的运算）*/
         i = 18;//18 = 10010
        int fifthBitFormRight = (i & 0b10000)/0b10000;
        int fifthBitFormRight1= (i & (1 << 4)) >>4;
        /*按位模式运算，若i的二进制数第5位上有1 则返回1，否则返回0 利用&适当结合的2的幂，
        可以把其他的位掩蔽掉，只保留其中的一位*/
        System.out.println(fifthBitFormRight);
        System.out.println(fifthBitFormRight1);

        /* java无C中的逗号运算符，逗号运算符就是(expression1，expression2，..., expression100)
        从左到右依次运行，结果就是最后一个表达式的值（详见C和指针）
        运算符优先级：
        ()[] （方法调用）                                     从左向右
        ! ~ ++ -- + -（单目运算正负） ()（强制类型转换）new      从右向左
        * / %                                               从左向右
        >> << >>>                                           从左向右
        < <= > >= instanceof                                从左向右
        == !=                                               从左向右
        &                                                   从左向右
        ^                                                   从左向右
        |                                                   从左向右
        &&                                                  从左向右
        ||                                                  从左向右
        ?:                                                  从右向左
        = += -+ *= %= &= |= ^= <<= >>= >>>=                 从右向左
         */
        /* case5:枚举类型   基本同C*/
        enum Size{SMALL,MEDIUM,LARGE,EXTRA_LARGE};
        Size s = Size.MEDIUM;
        System.out.println(s);
    }
}
