package com.shy.jdk.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author haoyan.shi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node<T> {

    private Node<T> prev;

    private Node<T> next;

    private T data;

    public Node(T data) {
        this.data = data;
    }

}
