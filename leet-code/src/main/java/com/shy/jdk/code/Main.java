package com.shy.jdk.code;

/**
 * @author shihaoyan
 * @date 2022/9/1 22:04
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Dict<String, String> dict = new Dict<>();
        dict.set("abc", "123");
        dict.set("def", "456");
        dict.set("ghi", "789");
        dict.set("jkl", "102");
        dict.set("mln", "213");
        dict.set("asd", "234");
    }

    public static int test01(int beichushu, int chushu) {
        int temp = beichushu;
        int num = 0;
        while (temp >= chushu) {
            num++;
            temp -= chushu;
        }
        return num;
    }
}
