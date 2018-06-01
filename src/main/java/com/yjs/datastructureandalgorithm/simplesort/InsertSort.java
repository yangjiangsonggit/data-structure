package com.yjs.datastructureandalgorithm.simplesort;

import java.util.Arrays;

/**
 * 插入排序
 * create by jiangsongy on 2018/5/29
 */
public class InsertSort {
    private long[] arr = {33,41,31,13,2,55,66,53,22,99,45,245,65,531,1,34,87,3,545,34,12};

    private long[] sort(long[] arr){

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]){
                    this.swap(j - 1,j);
                }
            }
        }
        return arr;
    }

    /**
     * a b 换位
     * create by jiangsongy on 2018/5/29
     */
    private void swap(int a, int b) {
        long tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public InsertSort(){
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
        new InsertSort();
    }
}
