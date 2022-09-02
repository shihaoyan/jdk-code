package com.shy.jdk.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author haoyan.shi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeManager<T> {

    private Node<T> head;

    private Node<T> tail;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> node = head;
        while (Objects.nonNull(node)) {
            sb.append(node.getData());
            sb.append("-");
            node = node.getNext();
        }
        return sb.toString();
    }
}
