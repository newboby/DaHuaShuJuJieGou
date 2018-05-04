package no9.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 原理：每次外层循环时，把当前索引标记为max （max=i）
 *        内存循环把当前索引上的值与后面的（还没排好序的部分）比较，把最大值得索引赋予max，内存循环完把 i 与 max 换位置
 *        i   max   都是索引
 * 排序所需的时间 (n*n)  空间  (n)
 * 与冒泡排序的区别：冒泡排序两个数比较后发现位置不对就交换，
 *                   选择排序两个比较后发现位置不对就标记索引（就是赋值给max），与后面全部比较完成后，才把max与i交换
 *                   选择排序减少了交换次数
 * Created by LiuShaoFu on 2018/5/4.
 */
public class SelectSort {

    public static final void SelectSort1(int[] list) {
        int i, j, max;
        for (i = 0; i < list.length; i++) {
            j = list.length - 1;
            max = i;
            for (; j > i; j--) {
                if (list[max] < list[j]) {
                    max = j;
                }
            }
            util.swap(list, i, max);
        }
    }

    public static void main(String[] args) {
        int[] list = new int[]{6, 3, 1, 8, 4};
        SelectSort1(list);
        System.out.println(Arrays.toString(list));
    }
}
