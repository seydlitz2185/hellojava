import java.util.Arrays;

public class demo05_2_array {
    public static void main(String[] args){
        String str = "This is a prototype";
        char[] str_char = str.toCharArray();
//        for-each循环 忽略数组下标
        for(char k:str_char)
            System.out.print(k+" ");
        System.out.println();
//        数组拷贝
        int[] str_cp = str.codePoints().toArray();
        int[] str_cp_copy = str_cp;
        //直接赋值并不能拷贝数组内容，而是指定了一个新的管理者（类比数据库user）
//        使用Arrays.copyOf方法将数组拷贝到新数组中
        int[] copied_str_cp = Arrays.copyOf(str_cp,str_cp.length);
        for(int k:copied_str_cp)
            System.out.print(k+" ");
        System.out.println();
        Arrays.sort(copied_str_cp);
        for(int k:copied_str_cp)
            System.out.print(k+" ");
        System.out.println();
        String rts = new String(copied_str_cp,0,copied_str_cp.length);
        char[] rts_char = rts.toCharArray();
        for(char k:rts_char)
            System.out.print(k+" ");
        System.out.println();
        int check = 97;
        System.out.println(Arrays.binarySearch(copied_str_cp,check));
    }
}
