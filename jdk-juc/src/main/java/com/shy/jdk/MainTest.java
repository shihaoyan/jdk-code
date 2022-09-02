package com.shy.jdk;

import com.shy.jdk.common.Node;
import com.shy.jdk.common.NodeManager;

/**
 * @author shihaoyan
 * @since 1.0.0
 */
public class MainTest {

    public static void main(String[] args) {
        NodeManager<String> nodeManager = new NodeManager<>();
        Node<String> node1 = new Node<>("node1");
        Node<String> node2 = new Node<>("node2");
        Node<String> node3 = new Node<>("node3");
        Node<String> node4 = new Node<>("node4");
        Node<String> node5 = new Node<>("node5");
        Node<String> node6 = new Node<>("node6");

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        node6.setPrev(node5);
        node5.setPrev(node4);
        node4.setPrev(node3);
        node3.setPrev(node2);
        node2.setPrev(node1);

        nodeManager.setHead(node1);
        nodeManager.setTail(node6);
        System.out.println(nodeManager);
    }
}
