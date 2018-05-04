package session9.sort;

import session9.util.util;

import java.util.Arrays;

/**
 * 堆排序
 * 原理：根据完全树的性质
 * 时间 （nlogn）
 * Created by Administrator on 2018/5/4.
 */
public class HeapSort {

    /**
     * @param list
     * @param i
     * @param len  list的长度
     */
    public static final void heapAdjust(int[] list, int i, int len) {
        int temp, j;
        temp = list[i]; //当前父节点
        //j=i*2+1
        for (j = i * 2 + 1; j < len; j = j * 2 + 1) {
            if (j+1 < len && list[j + 1] > list[j]) {
                j = j + 1;
            }
            if (temp >= list[j]) {
                break;
            }
            list[i] = list[j];
            i = j;
        }
        list[i] = temp;
    }

    public static final void heapSort(int[] list) {
        for (int i = list.length / 2; i >= 0; i--) {
            heapAdjust(list, i , list.length);
        }
        System.out.println(Arrays.toString(list));
        for (int i = list.length - 1; i > 0; i--) {
            util.swap(list, 0, i);
            heapAdjust(list, 0, i);
        }

    }

    public static void HeapAdjust(int[] array, int parent, int length) {
        int temp = array[parent]; // temp保存当前父节点
        int child = 2 * parent + 1; // 先获得左孩子
        while (child < length) {
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (child + 1 < length && array[child] < array[child + 1]) {
                child++;
            }
            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= array[child])
                break;
            // 把孩子结点的值赋给父结点
            array[parent] = array[child];
            // 选取孩子结点的左孩子结点,继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }
        array[parent] = temp;
    }

    public static void heapSort1(int[] list) {
        // 循环建立初始堆
        for (int i = list.length / 2; i >= 0; i--) {
            HeapAdjust(list, i, list.length);
        }
        // 进行n-1次循环，完成排序
        for (int i = list.length - 1; i > 0; i--) {
            // 最后一个元素和第一元素进行交换
            int temp = list[i];
            list[i] = list[0];
            list[0] = temp;
            // 筛选 R[0] 结点，得到i-1个结点的堆
            HeapAdjust(list, 0, i);
//            System.out.format("第 %d 趟: \t", list.length - i);
        }
    }

    public static void main(String[] args) {
        int[] list = new int[]{8, 12, 40, 70, 10, 60, 90};
        heapSort(list);
        System.out.println(Arrays.toString(list));
    }
}
