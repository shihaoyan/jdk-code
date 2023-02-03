package com.shy.jdk.code;

import com.shy.jdk.code.entry.Dict;

/**
 * @author shihaoyan
 * @date 2022/9/1 22:04
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {

        LinkNode head = LinkTable.insertNode(LinkNode.builder().data(0).build(), LinkNode.builder().data(1).build());
        LinkTable.printf(head);
        Dict<String, String> dict = new Dict<>();
        dict.set("abc", "123");
        dict.set("def", "456");
        dict.set("ghi", "789");
        dict.set("jkl", "102");
        dict.set("mln", "213");
        dict.set("asd", "234");
    }

}
