package com.frankstar.leetcode.排序;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode.排序
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2020年05月08日 22:16
 */
public class 归并排序 {

    public int[] sort(int[] arr){
        int[] result = new int[arr.length];
        divideSort(arr, 0, arr.length-1, result);

        return arr;
    }

    private void divideSort(int[] arr, int left, int right, int[] result) {

        if (left < right) {
            int mid = (left + right)/2;

            divideSort(arr, left, mid, result);
            divideSort(arr, mid+1, right, result);

            merge(arr, left, mid, right, result);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] result) {
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                result[t++] = arr[i++];
            }else {
                result[t++] = arr[j++];
            }
        }

        while(j<=right){
            result[t++] = arr[j++];
        }
        while(i<=mid){
            result[t++] = arr[i++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = result[t++];
        }
    }

}
