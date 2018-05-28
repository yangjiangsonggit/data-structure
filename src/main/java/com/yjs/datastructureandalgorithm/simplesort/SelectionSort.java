package com.yjs.datastructureandalgorithm.simplesort;

import java.util.Arrays;

/**
 * 选择排序
 * create by jiangsongy on 2018/5/29
 */
public class SelectionSort {
    private long[] arr = {33,41,31,13,2,55,66,53,22,99,45,245,65,531,1,34,87,3,545,34,12};

    private long[] sort(long[] arr){

        for (int j = 0; j < arr.length - 1; j++) {
            int min = j;
            for (int i = j + 1; i < arr.length - 1; i++) {
                if (arr[min] > arr[i + 1]){
                    min = i + 1;
                }
            }
            this.swap(j,min);

        }
        return arr;
    }

    private void swap(int i, int min) {
        long tmp = arr[i];
        arr[i] = arr[min];
        arr[min] = tmp;
    }

    public SelectionSort(){
        this.print(this.sort(this.arr));
    }

    private void print(long[] sort) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(sort).forEach(e -> {
            stringBuilder.append(e + ",");
        });
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {
        new SelectionSort();
    }
}
