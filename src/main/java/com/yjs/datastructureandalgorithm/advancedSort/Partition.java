package com.yjs.datastructureandalgorithm.advancedSort;


/**
 * 划分
 * create by jiangsongy on 2018/6/2
 */
public class Partition {

    private long[] sortArr = {2,44,33,17,4,454,23,5,9,78,24,54,8,45,27,412,63,12,34};

    //枢纽
    private long pivot = 34;

    private long[] partitonSort(int left,int right,long pivot,long[] arr){

        int leftPar = left - 1;
        int rightPar = right + 1;

        while (true){
            //寻找比枢纽大的元素下标
            while (leftPar < right && arr[++leftPar] < pivot)
                ;

            while (rightPar > left && arr[--rightPar] > pivot)
                ;

            if (leftPar >= rightPar){
                break;
            }else {
                this.swap(leftPar,rightPar,arr);
            }

        }
        return arr;
    }

    private void swap(int leftPar, int rightPar, long[] arr) {
        long tmp = arr[leftPar];
        arr[leftPar] = arr[rightPar];
        arr[rightPar] = tmp;
    }

    private static void printSortedArr(long[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    public Partition(){
        this.printSortedArr(this.partitonSort(0,sortArr.length - 1,this.pivot,this.sortArr));
    }

    public static void main(String[] args) {
        new Partition();
    }
}
