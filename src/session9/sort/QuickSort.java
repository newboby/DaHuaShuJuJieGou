package session9.sort;

import session9.util.util;

import java.util.Arrays;

/**
 * 快速排序
 * Created by LiuShaofu on 2018/5/8.
 */
public class QuickSort {
    public static final void QuickSort1(int[] list) {
        QSort(list, 0, list.length-1);

    }

    private static void QSort(int[] list, int low, int hight) {
        int pivot;
        if (low < hight) {
            pivot = Partition(list, low, hight ); //
            QSort(list, low, pivot - 1);
            QSort(list, pivot+1, hight);
        }

    }

    private static int Partition(int[] list, int low, int hight) {
        int provi = list[low];
        while (low < hight) {
            while (low < hight && list[hight] >= provi)
                hight--;
            util.swap(list, low, hight);
            while (low < hight && list[low] <= provi)
                low++;
            util.swap(list, low, hight);

        }
        return low;
    }

    public static void main(String[] args) {
        int[] list = new int[]{6, 3, 1, 8, 4};
        QuickSort1(list);
        System.out.println(Arrays.toString(list));
    }
}
