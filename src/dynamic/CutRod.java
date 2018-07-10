package dynamic;

import java.util.Arrays;

/**
 * 算法导论15.1切钢条问题
 * 长度 i         1   2  3  4  5  6  7  8  9  10
 * 价格 Pi        1  5  8  9  10  17 17 20 24 30
 * <p>
 * Created by Administrator on 2018/6/26.
 */
public class CutRod {
    static int[] s = null;  //分割的位置

    public static void setS(int n) {
        s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = i+1 ;
        }
    }

    public static void main(String[] args) {
        int[] Pi = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
//        int bottom[] = bottom(Pi, 10);
//        System.out.println(Arrays.toString(bottom));
//        System.out.println(Arrays.toString(s));
        System.out.println(memoized(Pi, 10));
    }

    /**
     * 自低向上的算法，
     * 例如：n=5
     * n=1时，p=1
     * n=2时,n=1+1 、n=2 ,p2=max(p2,p1+p1);得到的是最优解
     * n=3时,n=1+1+1、n=1+2、n=3，p3=max(p3,p2)  p2已经在n=2时得出最优解，
     * 故：动态求解是求得子集的最优解，合并为整个问题的最优解
     *
     * @param Pi 价格数组
     * @param n  长度
     * @return
     */

    public static int[] bottom(int[] Pi, int n) {
        int[] r = new int[n];
        setS(n);
        Arrays.fill(r, 0);
        for (int j = 0; j < n; j++) {
            int q = Pi[j];
            for (int a = 0; a < j; a++) {
//                int i = r[a] + r[j - a];
//                q=Math.max(q,r[a]+r[j-a-1]);
                if (q < r[a] + r[j - a - 1]) {
                    q = r[a] + r[j - a - 1];
                    s[j] = a + 1;
                }
            }
            r[j] = q;
        }
        return r;
    }

    /**
     * 自顶向下 ，带备忘录
     *
     *
     * @param Pi
     * @param n
     * @return
     */
    public static int memoized(int[] Pi, int n) {
        int[] r = new int[n];
        Arrays.fill(r, -1);
        return aux(Pi, n-1, r);
    }

    public static int aux(int[] Pi, int n, int[] r) {
        int q;
        if (r[n] >= 0) {
            return r[n];
        }
        if (n == 0) {
            q = 1;
        } else {
            q = Pi[n -1];
            for (int i = 1; i < n; i++) {
                q = Math.max(q, Pi[i-1] + aux(Pi, n - i, r));
            }
        }
        r[n] = q;
        return q;
    }
}
