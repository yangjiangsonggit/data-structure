package com.yjs.datastructureandalgorithm.recursion;


/**
 * 汉诺塔
 * create by jiangsongy on 2018/5/30
 */
public class Hanoi {

    private int diskNumber;

    /**
     * @topOrderedNumber 盘子数量
     * @from 初始塔座
     * @inter 中间塔座
     * @to 目标塔座
     * create by jiangsongy on 2018/5/30
     */
    public void move(int topOrderedNumber,String from,String inter,String to){
        if (topOrderedNumber == 1){
            System.out.println("move disk 1 from " + from + " to " + to);
        }else {
            this.move(topOrderedNumber - 1,from,to,inter);
            System.out.println("move disk " + topOrderedNumber + " from " + from + " to " + to);
            this.move(topOrderedNumber -1,inter,from,to);
        }
    }

    public Hanoi(){}

    public Hanoi(int diskNumber){
        this.diskNumber = diskNumber;
        this.move(this.diskNumber,"初始塔座","中间塔座","目标塔座");
    }

    public static void main(String[] args) {
        new Hanoi(6);
    }
}
