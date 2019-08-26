package com.ngsky.walker.structure.linked;

/**
 * @Description:
 * @Author: ngsky
 * @CreateDate: 2019/8/14 9:50
 */
public class SimpleLinked {

    private class Node {
        private Node prex;
        private Node next;
        private int data;
    }

    private int size;
    private Node root;
    private Node tail;

    // size() - returns number of data elements in list
    public int size() {
        return size;
    }

    // empty() - bool returns true if empty
    public boolean empty() {
        return size == 0;
    }

    // value_at(index) - returns the value of the nth item (starting at 0 for first)
    public int value_at(int index) {
        if (empty()) {
            System.out.println("linked is empty");
            return -1;
        }
        if (index >= size) {
            System.out.println("index is not found");
            return 0;
        }
        return dfs(root, index, 0);
    }

    private int dfs(Node node, int index, int tmp) {
        if (tmp >= index) return node.data;
        return dfs(node.next, index, tmp + 1);
    }

    // push_front(value) - adds an item to the front of the list
    public void push_front(int value) {
        if (empty()) {
            root = new Node();
            root.data = value;
            tail = root;
            size++;
        } else {
            Node tmp = root;
            Node n = new Node();
            n.data = value;
            n.next = root;
            root = n;
            tmp.prex = root;
            size++;
        }
    }

    // pop_front() - remove front item and return its value
    public int pop_front() {
        if (empty()) {
            return 0;
        } else if (size == 1) {
            int res = root.data;
            root = null;
            size--;
            return res;
        }
        Node tmp = root.next;
        int res = root.data;
        root = null;
        tmp.prex = null;
        size--;
        return res;
    }

    // push_back(value) - adds an item at the end
    public void push_back(int value) {
        if (empty()) {
            root = new Node();
            root.data = value;
            tail = root;
            size++;
        } else {
            Node tmp = new Node();
            tmp.data = value;
            tmp.prex = tail;
            tail.next = tmp;
            tail = tmp;
            size++;
        }
    }

    // pop_back() - removes end item and returns its value
    public int pop_back() {
        if(empty()) return 0;
        if (size == 1) {
            int res = root.data;
            root = null;
            size--;
            return res;
        } else {
            int res = tail.data;
            tail = null;
            size--;
            return res;
        }
    }

    // front() - get value of front item
    public int front(){
        if(empty()) return 0;
        return root.data;
    }

    // back() - get value of end item
    public int back(){
        if(empty()) return 0;
        return tail.data;
    }

    // insert(index, value) - insert value at index, so current item at that index is pointed to by new item at index

    // erase(index) - removes node at given index

    // value_n_from_end(n) - returns the value of the node at nth position from the end of the list

    // reverse() - reverses the list

    // remove_value(value) - removes the first item in the list with this value
}
