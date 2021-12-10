import java.util.*;
public class demo05_4_ticTacToe {

    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        final int size = 3;
        int[][] square = new int [size][size];
        boolean gotResult = false;
        int numberOfX = 1;
        int numberOfO = 0;

//      在本程序中需要使用普通for循环读入数组
        for(int i = 0;i< square.length;i++) {
            for (int j = 0; j < square[i].length; j++) {
                square[i][j] = in.nextInt();
            }
        }

//      for-each遍历二维数组 显示棋盘
        int i= 0,j = 0;
        for(int[] row : square) {
            for (int value : row) {
                System.out.print(square[i][j]+" ");
                j++;
            }
            j=0;
            i++;
            System.out.println();
        }

//        判断胜负
    for(int[] row : square) {
        for (int value : row) {
        //if();
        }
    }

    }
}
