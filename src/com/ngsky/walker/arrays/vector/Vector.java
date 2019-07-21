package com.ngsky.walker.arrays.vector;

/**
 * <dl>
 * <dt>Vector</dt>
 * <dd>Description:</dd>
 * <dd>CreateDate: 19-7-20 下午10:37</dd>
 * </dl>
 *
 * @author ngsky
 */
public class Vector<T> {

    /**
     * 元素个数
     */
    private int size;

    /**
     * vector 容量
     */
    private int capacity;

    /**
     * vector 容器
     */
    private T[] arr;

    /**
     * vector 容器默认容量
     */
    private final static int DEFAULT_CAPACITY = 10;

    public Vector(int capacity) {
        this.capacity = capacity <= 0 ? DEFAULT_CAPACITY : capacity;
        arr = (T[]) new Object[this.capacity];
    }

    /**
     * 元素个数
     */
    public int size() {
        return size;
    }

    /**
     * vector 容量
     */
    public int capacity() {
        return null == arr ? 0 : capacity;
    }

    /**
     * vector 是否为空
     */
    public boolean is_empty() {
        return size == 0;
    }

    /**
     * 返回vector 索引处的元素
     */
    public T at(int index) throws Exception {
        checkIndex(index);
        return arr[index];
    }

    /**
     * 在vector 末端添加元素
     */
    public void push(T item) {
        checkCapacity(1);
        arr[size++] = item;
    }

    /**
     * 在指定索引处添加元素,索引后的元素向后移动
     */
    public void insert(int index, T item) {
        checkCapacity(1);
        for (int i = size; i < index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
        size++;
    }

    /**
     * 在索引 index = 0;处添加元素
     */
    public void prepend(T item) {
        insert(0, item);
    }

    /**
     * 弹出vector末端元素
     */
    public T pop() {
        T ret = arr[size - 1];
        arr[size - 1] = null;
        checkCapacity(0);
        size--;
        return ret;
    }

    /**
     * 删除指定索引处的元素，并将索引后的元素向前移动
     */
    public T delete(int index) throws Exception {
        checkIndex(index);
        T ret = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        checkCapacity(0);
        size--;
        return ret;
    }

    /**
     * 删除元素,可删除多个，并返回索引列表
     */
    public int[] remove(T item) {
        int[] tmp = new int[size];
        int retIndex = 0;
        for (int i = 0; i < size; i++) {
            if (null != item && item.equals(arr[i])) tmp[retIndex++] = i;
        }
        int[] ret = new int[retIndex];
        for (int i = 0; i < retIndex; i++) {
            try {
                delete(tmp[i]);
                ret[i] = tmp[i];
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    /**
     * 查找元素,返回首次找到元素的索引
     */
    public int find(T item) {
        for (int i = 0; i < size; i++) {
            if (null != item && item.equals(arr[i])) return i;
        }
        return -1;
    }

    /**
     * 决策是否进行扩容或者缩容
     * 当容量满时，进行扩容
     * 当元素数为容量1/4时，进行缩容
     */
    private void checkCapacity(int flag) {
        if (flag == 1 && size >= capacity()) expand();
        if (flag == 0 && ((double)size / (double)capacity()) <= (double)(1 / 4)) shrink();
    }

    /**
     * 扩容为原来容量的 2 倍
     */
    private void expand() {
        T[] tmp = (T[]) new Object[capacity() * 2];
        for (int i = 0; i < size; i++) {
            tmp[i] = arr[i];
        }
        arr = tmp;
        capacity *= 2;
    }

    /**
     * 缩容为原来的 1/2
     */
    private void shrink() {
        T[] tmp = (T[]) new Object[capacity() / 2];
        for (int i = 0; i < size; i++) {
            tmp[i] = arr[i];
        }
        arr = tmp;
        capacity /= 2;
    }

    /**
     * 索引检查
     */
    private void checkIndex(int index) throws Exception {
        if (index < 0 || index >= size) throw new Exception("index 超出容量");
    }
}
