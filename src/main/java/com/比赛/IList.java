package com.比赛;

/**
 * Created by kyxw007 on 15/4/11.
 */

public interface IList {
    /**
     * 往列表的尾部增加一个元素
     */
    void add(Object elem);
    /**
     * 获取下标所指定的元素。当下标越界时抛出java.lang.IndexOutOfBoundsException
     */
    Object get(int index);
    /**
     * 获取列表里当前的元素个数
     */
    int size();
    /**
     * 清空列表，移除列表里所有的元素
     */
    void clear();
}