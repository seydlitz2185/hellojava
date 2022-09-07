//java字符串
//java字符串就是Unicode字符序列
//不同于C，Java并没有内置字符串类型字符串，而在java标准类库里提供了预定义类"String"
public class demo02 {
    public static void main(String[] args)
    {

        //case1：使用'+'拼接字符串，若传入值不为字符串会强制转换为字符串
        String str1 = "Hello World";
        int i = 10,j = 20;
        System.out.println(str1);
        System.out.println(str1 + i + j);
        System.out.println(str1+(i+j));

        //case2：求字串：s.substring(i,j)
        String greeting = "Hello";
        String regreeting = greeting.substring(0,3);
        System.out.println(regreeting);
        //java字符串都是不可变字符串：
        //不可以直接修改字符串中的字符，但是可以求子串和拼接字符串后重新赋值(但这样效率低)
        regreeting = greeting.substring(0,3) + "p!";
        System.out.println(regreeting);

        //case3：检测字符串是否相等：s.equals(t)（区分大小写）s.equalsIgnoreCase(t)（不区分大小写）
        System.out.println("hello".equals(greeting));
        System.out.println("hello".equalsIgnoreCase("hello"));
        //不要使用 == 判断字符串，它只能判断两个字符串是否位于存储器同一位置，如果不同位置上的有内容相同的拷贝则无法正确判断
        System.out.println("Hello" == greeting);
        System.out.println("Hel" == greeting.substring(0,3));//本应返回true，但返回false

        //case4：空串和null串
//        空串是一个Java对象，有自己的串长度（0）和内容（空）
//        NULL串则表示没有任何对象与该变量相关联
        String empty = "";
        String NULL = null;
        System.out.print("空串："+empty);
        System.out.println("其长度为："+empty.length());
        System.out.println("null串："+NULL);
        //   System.out.println("其长度为："+NULL.length());此处报错，因为没有长度

//         case5：码点和代码单元 s.length方法可返回字符串的代码单元数量（字符串长度，从0开始计数）
        i = greeting.length();
        System.out.println(i);
//        s.charAt(n)可以返会位置为n（从0开始）处的代码单元，
        String case5 = "⑪ is the set of octonions";
        char ch = case5.charAt(0);
        System.out.println(ch);
//        遍历一个字符串
        int cp = 0;
        j = 0;
        for(i=0;i<case5.length();i++) {
            cp = case5.codePointAt(i);
            if (Character.isSupplementaryCodePoint(cp)) {/*检测cp是否在增补字符集中*/
                System.out.print((char) cp + " ");
                j+=2;
            } else {
                System.out.print((char)cp + " ");
                j++;
            }
        }
        System.out.println();
//       使用 UTF-16 编码表示字符⑪(U+1D546) 需要两个代码单元。（但这里使用的其实还是UTF-8）
//        为避免这个问题，可以使用s.codePoints方法，它会生成一个 int 值的“ 流”,
//        每个 int 值对应一个码点可以将它转换为一个数组 (见 3.6.6),再完成遍历。
        int[] codePoints = case5.codePoints().toArray();
        for(i=0;i < codePoints.length;i++){
            System.out.print((char) codePoints[i]+" ");
        }
        System.out.println();
        String id = "想去驿站的洒脱乱码";
        int[] neo = id.codePoints().toArray();
        for(i=0;i < neo.length;i++){
            System.out.print( neo[i]+" ");
        }
        System.out.println();
        for(int k:neo){
        System.out.println(k);
    }

    }
}
