package com.ngsky.walker.GoF.adapter.objectadapter;

/**
 * @Description:
 * @Author: ngsky
 * @CreateDate: 2019/7/29 9:44
 */
public class UsbAdapter implements Ps2 {

    private Usb usb;

    public UsbAdapter(Usb usb) {
        this.usb = usb;
    }

    @Override
    public boolean isPs2() {
        System.out.println("Usb 适配器，Usb -> Ps2");
        return usb.isUsb();
    }
}
