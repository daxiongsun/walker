package com.ngsky.walker.structure.arrays.vector;

import java.util.Arrays;

/**
 * <dl>
 * <dt>VectorTest</dt>
 * <dd>Description:</dd>
 * <dd>CreateDate: 19-7-21 上午10:43</dd>
 * </dl>
 *
 * @author ngsky
 */
public class VectorTest {
    public static void main(String[] args) throws Exception {
        Vector vector = new Vector(9);
        System.out.println("size:" + vector.size());
        System.out.println("capacity:" + vector.capacity());
        vector.push(100);
        vector.push(120);
        vector.push(100);
        vector.push(110);
        vector.push(150);
        vector.push(300);
        System.out.println("size:" + vector.size());
        System.out.println("capacity:" + vector.capacity());
        vector.insert(3, 300000);
        System.out.println("vector[3]" + vector.at(3));
        System.out.println("pop:" + vector.pop());
        System.out.println("remove list:" + Arrays.toString(vector.remove(100)));
    }
}
