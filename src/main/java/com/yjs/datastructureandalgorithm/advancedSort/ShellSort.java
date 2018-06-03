package com.yjs.datastructureandalgorithm.advancedSort;


/**
 * 希尔排序
 * create by jiangsongy on 2018/6/2
 */
public class ShellSort {

    private long[] sortArr = {2,44,33,17,4,454,23,5,9,78,24,54,8,45,27,412,63,12,34};

    private long[] shellSort(long[] arr){

        int h = 1;
        //增量序列最大值
        while (h <= arr.length / 3){
            h = h * 3 + 1;
        }

        while (h > 0){
            for (int i = h; i < arr.length; i += h) {
                //对当前元素做插入排序
                if (arr[i] < arr[i - h]){
                    long tmp = arr[i];
                    int j = i - h;
                    while (j >= 0 && arr[j] > tmp){
                        arr[j + h] = arr[j];
                        j -= h;
                    }
                    arr[j + h] = tmp;
                }
            }
            h = (h - 1) / 3;
        }
        return arr;
    }

    private static void printSortedArr(long[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    public ShellSort(){
        this.printSortedArr(this.shellSort(this.sortArr));
    }

    public static void main(String[] args) {
        new ShellSort();
    }
}
