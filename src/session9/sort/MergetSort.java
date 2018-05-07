package session9.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 基本原理 ：不断半分，然后两两合并
 * 时间 （logn+n）
 * Created by LiuShaoFu on 2018/5/7.
 */
public class MergetSort {

    /**
     * 归并排序1
     * 基本排序 使用递归
     * @param list
     * @return
     */
    public static final int[] MergetSort1(int[] list) {
        if (list.length == 1 || list == null) {
            return list;
        }
        int middle = list.length >> 1;
        int[] left = new int[middle];
        int[] right = new int[list.length - middle];
        for (int i = 0; i < list.length; i++) {
            if (i < middle) {
                left[i] = list[i];
            } else right[i - middle] = list[i];
        }
        if (list.length > 1) {
            MergetSort1(left);
            MergetSort1(right);
            merget(left, right, list);
        }
        return list;
    }

    private static void merget(int[] left, int[] right, int[] list) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && right.length > j) {
            if (left[i] > right[j]) {
                list[k] = left[i];
                i++;
            } else {
                list[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            list[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            list[k] = right[j];
            j++;
            k++;
        }
    }

    /**
     * 非递归实现的归并排序
     *  原理：（k*2）每次排序的元素个数
     * @param list
     */
    public static final void MergetSort2(int[] list) {
        int k = 1;
        int[] arr = new int[list.length];
        while (k < list.length) {
            mergetPass(list, arr, k, list.length);
            k *= 2;
            mergetPass(arr, list, k, list.length);
            k *= 2;
        }
    }

    private static void mergetPass(int[] list, int[] newArr, int k, int length) {
        int i = 0, j;

        while (i <length - 2 * k ) {
            merger2(list,newArr,i,i+2*k,i+k);
            i=i+2*k;
        }
        if(i<length-k){
            merger2(list,newArr,i,length,i+k);
        }else {
            for(j=i;j<length;j++){
                    newArr[j]=list[j];
            }
        }
    }

    public static final void merger2(int[] list, int[] newArr, int start, int length,int middle){
        int j=middle,k=start;
        for (;start<middle && j<length;k++){
            if(list[start]>list[j]){
                newArr[k]=list[start++];
            }else   newArr[k]=list[j++];
        }
        while (start<middle) {
            newArr[k]=list[start];
            k++;
            start++;
        }
        while (j<length){
            newArr[k]=list[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] list = new int[]{6, 3, 1, 8, 4};
         MergetSort2(list);
        System.out.println(Arrays.toString(list));
    }
}
