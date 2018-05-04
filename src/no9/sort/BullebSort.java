package no9.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 排序所需的时间(n*n),空间 (n)
 * Created by LiuShaoFu on 2018/5/4.
 */
public class BullebSort {
    /**
     * 基本冒泡排序
     * @param list
     */
    public static void BullebSort1(int[] list) {
        for (int i = 1; i < list.length; i++) {
            for (int j = list.length - 1; j >= i; j--) {
                if (list[j - 1] < list[j]) {
                    util.swap(list, j, j - 1);
                }
            }
        }
    }

    /**
     * 优化后的冒泡排序
     * 设置一个flag
     * 每次内循环开始时将flag设置为false,
     * 如果没有交换发生，则说明从当前  i-->end（末尾）的顺序已经排好顺序，不需要再循环
     * 如果有交换发生，flag=true，说明数组还发生交换，顺序尚未排好，下次循环继续进行
     *
     * @param list
     */
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
