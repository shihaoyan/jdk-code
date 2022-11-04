package com.shy.jdk.code;

/**
 * @author haoyan.shi
 */
public class StringDictType implements DictType {

    @Override
    public int hashFunction(String key) {
        return key.hashCode();
    }
}
