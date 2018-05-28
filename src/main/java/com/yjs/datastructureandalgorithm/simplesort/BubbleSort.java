package com.yjs.datastructureandalgorithm.simplesort;

import java.util.Arrays;

/**
 * 冒泡排序
 * create by jiangsongy on 2018/5/29
 */
public class BubbleSort {

    private long[] arr = {33,41,31,13,2,55,66,53,22,99,45,245,65,531,1,34,87,3,545,34,12};

    private long[] sort(long[] arr){

        for (int i = arr.length -1; i > 1; i--) {

            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]){
                    long temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        return arr;
    }

    public BubbleSort(){
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
        new BubbleSort();
    }
}
