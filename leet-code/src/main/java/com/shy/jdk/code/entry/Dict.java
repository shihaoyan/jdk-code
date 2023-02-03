package com.shy.jdk.code.entry;

import com.shy.jdk.code.DictType;
import com.shy.jdk.code.StringDictType;
import lombok.Data;

import java.util.Objects;

/**
 * @author haoyan.shi
 */
@Data
public class Dict<K, V> {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    private DictType dictType;

    private Object privateData;

    private DictHashTable<K, V> dictHashTable;

    private DictHashTable<K, V> reDictHashTable;

    private long reHashIdx;

    public Dict(DictType dictType) {
        this.dictType = dictType;
        privateData = 0;
        this.dictHashTable = new DictHashTable<>();
        this.reDictHashTable = null;
        reHashIdx = -1;
    }

    public Dict() {
        this(new StringDictType());
    }

    public void set(K key, V value) {
        DictEntry<K, V>[] dictEntrys = dictHashTable.getDictEntry();
        int hash = dictType.hashFunction((String) key);
        long index = hash & dictHashTable.getSizeMask();
        DictEntry<K, V> kvDictEntry = dictEntrys[(int) index];
        if (Objects.isNull(kvDictEntry)) {
            kvDictEntry = new DictEntry<>();
        }
        K oldKey = kvDictEntry.getKey();
        if (Objects.isNull(oldKey)) {
            kvDictEntry.setKey(key);
            kvDictEntry.setValue(value);
            kvDictEntry.setNext(null);
        } else if (oldKey.equals(key)) {
            DictEntry<K, V> newDictEntry = new DictEntry<>();
            newDictEntry.setKey(key);
            newDictEntry.setValue(value);
            DictEntry<K, V> next = kvDictEntry.getNext();
            if (Objects.isNull(next)) {
                kvDictEntry.setNext(newDictEntry);
            } else {
                kvDictEntry.setNext(newDictEntry);
                newDictEntry.setNext(next);
            }
        }
        dictHashTable.setUsed(dictHashTable.getUsed() + 1);
        dictEntrys[(int) index] = kvDictEntry;
    }

    private int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
