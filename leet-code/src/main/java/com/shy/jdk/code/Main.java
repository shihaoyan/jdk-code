package com.shy.jdk.code;

import java.util.Scanner;

/**
 * @author shihaoyan
 * @date 2022/9/1 22:04
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int beichushu = sc.nextInt();
        int chushu = sc.nextInt();
        int num = test01(beichushu, chushu);
        System.out.println(num);
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
