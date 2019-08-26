package com.ngsky.walker.GoF.adapter.classadapter;

/**
 * @Description: 光能适配器，将光能转化为电能，驱动电能驱动车
 * @Author: ngsky
 * @CreateDate: 2019/7/29 9:34
 */
public class OpticalAdapter extends OpticalMotor implements ElectricCar {

    @Override
    public void driveCar() {
        System.out.println("光能 -> 转化为 电能...");
        opticalDrive();
    }
}
