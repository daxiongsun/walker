package com.ngsky.walker.GoF.adapter.objectadapter;

/**
 * @Description:
 * @Author: sunyx@lenovocloud.com
 * @CreateDate: 2019/7/29 9:46
 */
public class Client {
    public static void main(String[] args) {
        Ps2 ps2 = new UsbAdapter(new Usber());
        ps2.isPs2();
    }
}
