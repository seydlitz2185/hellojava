import java.util.Scanner;

public class demo04 {
    public static void main (String[] args) {
//       格式化输入
        System.out.println("Hello!\n"+"What's your name?\n"+"How old are you?");

        Scanner in = new Scanner(System.in);
        String regreeting=in.next();
        String name = in.next();
        int age = in.nextInt();
        StringBuilder builder = new StringBuilder();
        builder.append(regreeting);
        builder.append(", my name is ");
        builder.append(name);
        builder.append(" and I'm ");
        builder.append(age);
        builder.append(" years old.");
        String reply = builder.toString();
//        使用format方法拼接字符串
        String replyformat = String.format("%1$s, my name is %2$s and I'm %3$d years old\n",regreeting,name,age);
        System.out.println(reply);
        System.out.println(replyformat);
    }
}

