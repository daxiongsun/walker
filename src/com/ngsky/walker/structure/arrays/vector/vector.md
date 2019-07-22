# 目的
实现一个可自动调整大小的动态数组

# review
1.什么是动态数组？
2.如何实现动态数组？
3.时间、空间复杂度如何计算？
4.优化点有哪些？
如:数据量庞大时，扩容带来时间和性能问题。

# 简介
## 多维数组
多维数组也是使用一维数组实现的，只不过元素类型变成数组而已，称为 "数组的数组"。
## 动态数组
在进行数组操作时不需要考虑容量问题，vector自动实现容量的扩展以及收缩。
## 不规则数组
创建数组时，行数确定，但 列数 不确定，存储元素后，可存在以下情况：
///////////////////////////////////
///     1 3 4 5 6 7 
///    3 5 1             
///     2 3 4 1 2 3 4 
//////////////////////////////////
## 调整数组大小
调整数组大小的策略可自行定义，这里采用通用方式：
当数组元素个数等于容量时，扩大为容量的2倍。
当数组元素个数为(或不足)容量的1/4时，缩减为容量的1/2。

# 原理分析
## API
```
int size() # vector 元素个数
int capacity() # vector 容量
boolean is_empty() # 是否为空
T at(int index) # 返回指定索引处元素
void push(T item) # 在末端添加元素
void insert(int index, T item) # 新增元素
void prepend(T item) # 在索引为0处添加元素
T pop() # 弹出末端元素
T delete(int index) # 删除索引处元素
int[] remove(T item) # 删除元素,返回元素所在索引列表
int find(T item) # 查找元素首次出现位置
```
## 调整数组大小策略
1.新增元素时，如果元素数量达到容量时，将vector容器容量调整为 原来容量的 2 倍。
2.移除元素时，如果元素数量处于容量小于等于 1/4，那么将容量缩容为原来的 1/2。

##  注意点
1.新增元素时，需要将指定索引后的元素向后移动。
2.移除元素时，需要将指定索引后的元素向前移动。

## 时间复杂度
元素个数: size , vector 容量： capacity
push(item) / pop() / at(index) : O(1)

insert(index,item) / delete(index): 由于需要向后/前移动,时间复杂度为 O(size - index)

remove(item): 遍历查找整个容器, 时间复杂度 O(size)

find(item) # 最坏情况下，时间复杂度为 O(size)

## 空间复杂度
采用数组实现，在内存中为连续的内存空间。空间需求为 size *  元素大小 + (capacity - size) * 引用大小。 空间复杂度为 O(capacity)。

# coding
```
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

```

# 参考
github: https://github.com/jwasham/coding-interview-university