package com.diniig.samples.gof.creational;

public class MobileDeviceFactory implements DeviceFactory {

    @Override
    public Device createDevice() {
        return new Mobile();
    }

}
