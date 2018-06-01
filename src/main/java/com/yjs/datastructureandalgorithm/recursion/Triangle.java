package com.yjs.datastructureandalgorithm.recursion;

/**
 * 三角数字
 * create by jiangsongy on 2018/5/30
 */
public class Triangle {

    private int n;

    public int triangle(int n){
        if (n == 1){
            return 1;
        }else if (n < 1){
            throw new RuntimeException("请输入正整数");
        }else {
            return n + this.triangle(n - 1);
        }
    }

    public Triangle(){}

    public Triangle(int n){
        this.n = n;
        System.out.println(this.triangle(n));
    }

    public static void main(String[] args) {
        new Triangle(4);
    }

}
