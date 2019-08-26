package com.ngsky.walker.GoF.adapter.classadapter;

/**
 * @Description:
 * @Author: ngsky
 * @CreateDate: 2019/7/29 9:36
 */
public class Client {
    public static void main(String[] args) {
        ElectricCar car = new OpticalAdapter();
        car.driveCar();
    }
}
