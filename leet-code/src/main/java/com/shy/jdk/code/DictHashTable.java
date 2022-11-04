package com.shy.jdk.code;

import lombok.Data;

/**
 * @author haoyan.shi
 */
@Data
public class DictHashTable<K, V> {

    private DictEntry<K, V>[] dictEntry;

    private long size;

    private long sizeMask;

    private long used;

    public DictHashTable(int size) {
        this.dictEntry = new DictEntry[size];
        this.size = dictEntry.length;
        this.sizeMask = this.size - 1;
        this.used = 0;
    }

    public DictHashTable() {
        this(4);
    }

}
