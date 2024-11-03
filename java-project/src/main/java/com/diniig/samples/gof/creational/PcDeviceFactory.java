package com.diniig.samples.gof.creational;

public class PcDeviceFactory implements DeviceFactory {

    @Override
    public Device createDevice() {
        return new PC();
    }

}
