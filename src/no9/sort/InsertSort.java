package no9.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 原理：将数插入前面的排好序的里面
 * 消耗时间(n*n)
 * Created by Administrator on 2018/5/4.
 */
public class InsertSort {
    public static final void InsertSort1(int[] list) {
        for (int i = 1; i < list.length; i++) {
            if (list[i] < list[i - 1]) {        //list[i]代表当前，list[i-1]代表已经排好序的末项（也就是最大的值），
                                                // 如果当前项和末项不符合条件（当前代码里代表比末项大），不用判断，直接放在末项后面，
                                                // 如果当前项和末项符合条件，需要将当前项插入到前面排好序的里面
                int temp = list[i];
                int j = i - 1;
                for (; j != -1 && list[j] > temp; j--) { //j!=-1放在前面，因为java的&&是短路运算，前项不成立就不计算后项
                    list[j + 1] = list[j];               //从排好序的末项判断，找到合适的位置，后面的后推1
                }
                list[j + 1] = temp;

            }
        }
    }

    public static void main(String[] args) {
        int[] list2 = new int[]{6, 3, 1, 8, 4};
        InsertSort1(list2);
        System.out.println(Arrays.toString(list2));
    }
}
