package com.shy.jdk.collection;

import lombok.Data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author haoyan.shi
 */
@Data
public class MyQueue<E> {

    private Lock lock = new ReentrantLock();

    private Condition takeCondition = lock.newCondition();

    private Condition putCondition = lock.newCondition();

    private final static int DEFAULT_CAPACITY = 5;

    private int size;

    private int capacity;

    private Node<E> first;

    public MyQueue() {
        first = new Node<>();
        first.setNext(null);
        first.setData(null);
        capacity = DEFAULT_CAPACITY;
    }

    public MyQueue(int capacity) {
        first = new Node<>();
        first.setNext(null);
        first.setData(null);
        this.capacity = capacity;
    }

    public E take() {
        lock.lock();
        try {
            if (size == 0) {
                takeCondition.await();
            }
            size--;
            Node<E> temp = first.next;
            first.next = temp.next;
            if (size < capacity) {
                putCondition.signal();
            }
            return temp.data;
        } catch (Exception e) {
            throw new RuntimeException("出现异常");
        } finally {
            lock.unlock();
        }
    }

    public Node<E> put(E e) {
        if (e == null) {
            throw new RuntimeException("数据不允许为空");
        }
        lock.lock();
        try {
            if (size == capacity) {
                putCondition.await();
            }
            Node<E> temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            Node<E> newNode = new Node<>();
            newNode.setNext(null);
            newNode.setData(e);
            temp.next = newNode;
            size++;
            if (size != 0) {
                takeCondition.signal();
            }
        } catch (Exception exception) {
            throw new RuntimeException("出现异常");
        } finally {
            lock.unlock();
        }

        return null;
    }

    @Data
    private class Node<E> {

        private E data;

        private Node<E> next;
    }

}
