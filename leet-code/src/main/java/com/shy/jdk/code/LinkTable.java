package com.shy.jdk.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author shihaoyan
 * @date 2022/10/15 12:56
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@Builder
class LinkNode {

    int data;

    LinkNode next;

}

public class LinkTable {

    public static LinkNode insertNode(LinkNode head, LinkNode newNode) {

        if (head == null) {
            return null;
        }

        LinkNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        return head;
    }

    public static LinkNode deleteNode(LinkNode head, int val) {

        if (head == null) {
            return null;
        }
        if (head.data == val) {
            return head.next;
        }
        LinkNode node = head;
        while (node.next != null) {
            if (node.next.data == val) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        
        return head;
    }

    public static void printf(LinkNode head) {

        if (head == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        LinkNode node = head;
        while (node != null) {
            stringBuilder.append(node.data).append(",");
            node = node.next;
        }
        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
        stringBuilder.append("]");
        System.out.println(stringBuilder);

    }

}
