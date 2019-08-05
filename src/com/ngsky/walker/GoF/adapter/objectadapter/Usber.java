package com.ngsky.walker.GoF.adapter.objectadapter;

/**
 * @Description:
 * @Author: sunyx@lenovocloud.com
 * @CreateDate: 2019/7/29 9:43
 */
public class Usber implements Usb {
    @Override
    public boolean isUsb() {
        System.out.println("我是USB接口");
        return true;
    }
}
