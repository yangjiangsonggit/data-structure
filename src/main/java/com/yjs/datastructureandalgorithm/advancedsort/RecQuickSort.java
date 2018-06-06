package com.yjs.datastructureandalgorithm.advancedsort;

/**
 * 快速排序-三项数据取中值
 * create by jiangsongy on 2018/6/2
 */
public class RecQuickSort {

    private long[] sortArr = {2,44,33,17,4,454,23,5,9,78,24,54,8,45,27,412,63,12,34};

    public RecQuickSort(){}

    private void quickSort(int left, int right) {
        this.recQuickSort(left,right);
    }

    private void recQuickSort(int left, int right) {
        int size = right - left + 1;
        //小范围
        if (size <=3 ){
            this.manualSort(left,right);
        }else { //大范围
            //三项数据取中值
            long median = this.medianOf(left,right);
            int partition = this.partition(left,right,median);
            this.recQuickSort(left,partition - 1);
            this.recQuickSort(partition + 1,right);
        }
    }

    private int partition(int left, int right, long pivot) {
        int leftPar = left;
        int rightPar = right - 1;

        while (true){
            while (this.sortArr[++leftPar] < pivot){
                ;
            }
            while (this.sortArr[--rightPar] > pivot){
                ;
            }

            if (leftPar >= rightPar){
                break;
            }else {
                this.swap(leftPar,rightPar);
            }
        }
        this.swap(leftPar,right - 1);
        return leftPar;
    }

    private long medianOf(int left, int right) {
        int center = (left + right) / 2;
        if (this.sortArr[left] > this.sortArr[center]){
            this.swap(left,center);
        }
        if (this.sortArr[left] > this.sortArr[right]){
            this.swap(left,right);
        }
        if (this.sortArr[center] > this.sortArr[right]){
            this.swap(center,right);
        }
        //把枢纽值存到倒数第二个位置
        this.swap(center,right - 1);
        return this.sortArr[right - 1];
    }

    private void manualSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1){
            return;
        }
        if (size == 2){
            if (this.sortArr[left] > this.sortArr[right]){
                this.swap(left,right);
            }
            return;
        }else { //size == 3
            if (this.sortArr[left] > this.sortArr[right]){
                this.swap(left,right);
            }
            if (this.sortArr[left] > this.sortArr[right - 1]){
                this.swap(left,right - 1);
            }
            if (this.sortArr[right - 1] > this.sortArr[right]){
                this.swap(right - 1,right);
            }
        }
    }

    private void swap(int left, int right) {
        long tmp = this.sortArr[left];
        this.sortArr[left] = this.sortArr[right];
        this.sortArr[right] = tmp;
    }

    private void print(long[] sortArr) {
        for (int i = 0; i < sortArr.length; i++) {
            System.out.print(sortArr[i] + ",");
        }
    }

    public static void main(String[] args) {
        RecQuickSort recQuickSort = new RecQuickSort();
        recQuickSort.print(recQuickSort.sortArr);
        System.out.println("");

        recQuickSort.quickSort(0,recQuickSort.sortArr.length - 1);

        recQuickSort.print(recQuickSort.sortArr);
    }

}
