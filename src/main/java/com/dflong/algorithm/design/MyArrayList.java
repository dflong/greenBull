package com.dflong.algorithm.design;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 自定义 ArrayList 实现
 * 使用基本数组作为底层数据结构
 */
public class MyArrayList<E> {

    // 默认初始容量
    private static final int DEFAULT_CAPACITY = 10;

    // 底层数组
    private Object[] elementData;

    // 当前元素数量
    private int size;

    // 构造方法
    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
        this.size = 0;
    }

    // 添加元素到末尾
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
        return true;
    }

    // 在指定位置插入元素
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);

        // 从 index 位置开始，所有元素向后移动一位
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    // 获取指定位置的元素
    @SuppressWarnings("unchecked")
    public E get(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }

    // 设置指定位置的元素
    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        rangeCheck(index);
        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    // 删除指定位置的元素
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        rangeCheck(index);
        E oldValue = (E) elementData[index];

        int numMoved = size - index - 1;
        if (numMoved > 0) { // 整体向前移动一位
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }

        elementData[--size] = null; // 让 GC 回收
        return oldValue;
    }

    // 删除指定元素（第一个匹配的）
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    fastRemove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    fastRemove(i);
                    return true;
                }
            }
        }
        return false;
    }

    // 快速删除（内部使用）
    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
    }

    // 获取元素数量
    public int size() {
        return size;
    }

    // 判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 判断是否包含指定元素
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    // 查找元素第一次出现的位置
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    // 查找元素最后一次出现的位置
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    // 清空所有元素
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    // 转换为数组
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    // 转换为指定类型的数组
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        }
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    // 确保容量足够
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elementData.length) {
            int newCapacity = calculateNewCapacity(elementData.length, minCapacity);
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    // 计算新的容量
    private int calculateNewCapacity(int oldCapacity, int minCapacity) {
        int newCapacity = oldCapacity + (oldCapacity >> 1); // 1.5 倍
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        // 防止溢出
        if (newCapacity > Integer.MAX_VALUE - 8) {
            newCapacity = Integer.MAX_VALUE;
        }
        return newCapacity;
    }

    // 调整数组容量到当前元素数量
    public void trimToSize() {
        if (size < elementData.length) {
            elementData = (size == 0)
                    ? new Object[DEFAULT_CAPACITY]
                    : Arrays.copyOf(elementData, size);
        }
    }

    // 获取当前容量
    public int capacity() {
        return elementData.length;
    }

    // 范围检查
    private void rangeCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // 添加时的范围检查
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // 迭代器（简化版）
    public Iterator<E> iterator() {
        return new Itr();
    }

    // 内部迭代器类
    private class Itr implements Iterator<E> {
        int cursor = 0;
        int lastRet = -1;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E next() {
            int i = cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            Object[] elementData = MyArrayList.this.elementData;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            try {
                MyArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }

    // 测试方法
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        // 测试添加
        list.add("Java");
        list.add("Python");
        list.add("C++");
        System.out.println("初始列表: " + Arrays.toString(list.toArray()));

        // 测试插入
        list.add(1, "JavaScript");
        System.out.println("插入后: " + Arrays.toString(list.toArray()));

        // 测试获取
        System.out.println("第二个元素: " + list.get(1));

        // 测试设置
        String oldValue = list.set(2, "Go");
        System.out.println("修改了: " + oldValue);
        System.out.println("修改后: " + Arrays.toString(list.toArray()));

        // 测试删除
        list.remove(0);
        System.out.println("删除后: " + Arrays.toString(list.toArray()));

        // 测试包含
        System.out.println("是否包含 Go: " + list.contains("Go"));

        // 测试大小
        System.out.println("当前大小: " + list.size());
        System.out.println("当前容量: " + list.capacity());

        // 测试迭代器
        System.out.print("迭代器遍历: ");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 测试清空
        list.clear();
        System.out.println("清空后大小: " + list.size());
        System.out.println("是否为空: " + list.isEmpty());
    }
}
