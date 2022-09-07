public class demo02_2_StringBuilder {
    public static void main(String[] args){
//        使用重定义的"+"号链接字符串比较浪费资源
//        Java还提供了StringBuilder用于生成字符串，以下是使用方法举例
        StringBuilder builder = new StringBuilder();
        char ch='a';
        String str=" prototype mobile suit";
        int cp=9935;
        builder.append(ch);
        builder.append(str);
        builder.appendCodePoint(cp);
        builder.setCharAt(1,'h');
        String Gundam= builder.toString();
        System.out.println("length of StringBuilder:"+builder.length());
        System.out.println(Gundam);
        builder.delete(0,builder.length());
        System.out.println("length of String Builder:"+builder.length());
    }
}
