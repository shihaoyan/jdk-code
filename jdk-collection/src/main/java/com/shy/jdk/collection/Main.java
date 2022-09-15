package com.shy.jdk.collection;

/**
 * @author shihaoyan
 * @date 2022/8/27 22:21
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.put("123");
        myQueue.put("456");
        myQueue.put("789");
        myQueue.put("abc");
        myQueue.put("def");

        System.out.println("执行完毕");

    }

}
