package com.yjs.datastructureandalgorithm.recursion;

import java.util.Arrays;

/**
 * 归并排序
 * create by jiangsongy on 2018/6/1
 */
public class MergeSort {

    private long[] arrA = {22,44,66,77,99};
    private long[] arrB = {11,55,88,110};
    private long[] arrC = new long[9];

    private long[] runSort(long[] arrA,long[] arrB,long[] arrC){
        int idxA = 0;
        int idxB = 0;
        int idxC = 0;

        while (idxA < arrA.length && idxB < arrB.length){
            if (arrA[idxA] < arrB[idxB]){
                arrC[idxC++] = arrA[idxA++];
            }else {
                arrC[idxC++] = arrB[idxB++];
            }
        }

        while (idxA < arrA.length){
            arrC[idxC++] = arrA[idxA++];
        }

        while (idxB < arrB.length){
            arrC[idxC++] = arrB[idxB++];
        }

        return arrC;
    }


    private void printArr(long[] arr){
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(arr).forEach(e -> {
            stringBuilder.append(e + ",");
        });
        System.out.println(stringBuilder.toString());
    }

    public MergeSort(){
        this.printArr(this.runSort(this.arrA,this.arrB,this.arrC));
    }

    public static void main(String[] args) {
        //1
//        new MergeSort();

        //2
        long[] arr = {44,23,454,675,32,54,13,45,77,87,7,33,63};
        long[] result = recursionMergeSort(arr,0,arr.length - 1);
        printMergeSort(result);
    }


    private static long[] recursionMergeSort(long[] workSpace,int lowerBound,int upperBound){

        int mid = (lowerBound + upperBound) / 2;
        if (lowerBound < upperBound){
            recursionMergeSort(workSpace,lowerBound,mid);
            recursionMergeSort(workSpace,mid + 1,upperBound);
            mergeSort(workSpace,lowerBound,mid,upperBound);
        }
        return workSpace;
    }

    private static void mergeSort(long[] workSpace, int lowerBound, int mid, int upperBound) {

        long[] tmpArr = new long[upperBound - lowerBound + 1];
        int tmpIdx = 0;
        int leftIdx = lowerBound;
        int rightIdx = mid + 1;

        while (leftIdx <= mid && rightIdx <= upperBound) {
            if (workSpace[leftIdx] < workSpace[rightIdx]) {
                tmpArr[tmpIdx++] = workSpace[leftIdx++];
            }else {
                tmpArr[tmpIdx++] = workSpace[rightIdx++];
            }
        }

        while (leftIdx <= mid){
            tmpArr[tmpIdx++] = workSpace[leftIdx++];
        }

        while (rightIdx <= upperBound){
            tmpArr[tmpIdx++] = workSpace[rightIdx++];
        }

        for (int i = 0; i < tmpArr.length; i++) {
            workSpace[lowerBound + i] = tmpArr[i];
        }

    }

    private static void printMergeSort(long[] arr){
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(arr).forEach(e -> {
            stringBuilder.append(e + ",");
        });
        System.out.println(stringBuilder.toString());
    }


}
