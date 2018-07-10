package dynamic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 算法导论15.2矩阵链乘
 * Created by Administrator on 2018/6/26.
 */
public class ChainOrder {

    //    public static void main(String[] args) {
//        int[] p=new int[]{30,35,15,5,10,20,25};
//        int[][] martix = martix(p);
//    }
//    public static int[][] s2;
//    public static int[][] martix(int[] p) {
//        int q;
//        int n = p.length - 1;   //p.length+1=n   p=(p0,p1,p2....pn)
//        int[][] m = new int[n][n];
//         s = new int[n - 1][n - 1];
//        for (int i = 0; i < n; i++) {
//            m[i][i] = 0;
//        }
//        for (int l = 2; l <= n; l++) {       // l 矩阵长度
//            for (int i = 0; i <= n - l + 1; i++) {
//                int j = i + l - 1;            //j-i+1=l     l是m[i,j]长度
//                m[i][j] = Integer.MAX_VALUE;
//                for (int k = 0; k < j - 1; k++) {
//                    q = m[i][k] + m[k][j] + p[i - 1] * p[j] * p[k];
//                    if (q < m[i][j]) {
//                        m[i][j] = q;
//                        s[i][j] = k;
//                    }
//                }
//            }
//        }
//        return m;
//    }
//    public static void  print(int[][] s,int i,int j){
//        if(i==j){
//            System.out.print("A");
//        }else {
//            print(s,i,s[i][j]);
//            print(s,s[i][j]+1,j);
//            System.out.print(")");
//        }
//
//    }
    private static int n;
    private static int[][] m = new int[100][100];
    private static int[][] s = new int[100][100];
    private static int[] p = new int[105];
    private static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = 5;
        p[0] = 30;
//        35 15 5 10 20 25;
        p[1] = 35;
        p[2] = 15;
        p[3] = 5;
        p[4] = 10;
        p[5] = 20;
        p[6]=25;
        for (int i = 0; i <= n; i++) {
//            p[i] = scan.nextInt();
            m[i][i] = 0;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = MAX;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        print(1, n);
        System.out.printf(" %d\n", m[1][n]);
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                System.out.print((s[i][j])+" ");
            }
            System.out.println();

        }    System.out.println();
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                System.out.print((m[i][j])+" ");
            }
            System.out.println();
        }
    }

    public static void print(int i, int j) {
        if (i == j)
            System.out.print("A" + i);
        else {
            System.out.print("(");
            print(i, s[i][j]);
            print(s[i][j] + 1, j);
            System.out.print(")");
        }
    }
}

