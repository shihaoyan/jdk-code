package com.shy.jdk.code.entry;

import lombok.Data;

/**
 * @author haoyan.shi
 */
@Data
public class DictEntry<K, V> {

    private K key;

    private V value;

    private DictEntry<K, V> next;
}

