package com.github.mall.test;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * @Author 王炎
 * @Date 2019/9/25 9:21
 * @ModifyDate 2019/9/25 9:21
 * @Version 1.0
 */
public class ThreadTest {
    public static void main(String[] args) {
        SignleDemo instance = SignleDemo.getInstance();
        SignleDemo instance1 = SignleDemo.getInstance();
        if(instance==instance1){
            System.out.println(1111);
        }
    }
}
