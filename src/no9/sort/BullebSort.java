package no9.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * Created by LiuShaoFu on 2018/5/4.
 */
public class BullebSort {
    public static void BullebSort1(int[] list) {
        for (int i = 1; i < list.length; i++) {
            for (int j = list.length - 1; j >= i; j--) {
                if (list[j - 1] < list[j]) {
                    util.swap(list, j, j - 1);
                }
            }
        }
    }

    public static void BullebSort2(int[] list) {
        boolean flag = true;
        for (int i = 1; i < list.length&&flag; i++) {
            flag=false;
            for (int j = list.length - 1; j >= i; j--) {
                if (list[j - 1] < list[j]) {
                    util.swap(list, j, j - 1);
                    flag=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] list = new int[]{6, 3, 1, 8, 4};
        BullebSort1(list);
        System.out.println(Arrays.toString(list));
        int[] list2 = new int[]{6, 3, 1, 8, 4};
        BullebSort2(list2);
        System.out.println(Arrays.toString(list));
    }
}
