package com.shy.jdk.code;

/**
 * @author shihaoyan
 * @date 2022/9/1 22:04
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {

        LinkNode head = LinkTable.insertNode(LinkNode.builder().data(0).build(), LinkNode.builder().data(1).build());
        LinkTable.printf(head);


    }
}
