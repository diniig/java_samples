package com.diniig.samples.gof.creational;

public class CoffeOrderFormBuilder {

    GUIFactory factory;
    DeviceFactory deviceFactory;

    public CoffeOrderFormBuilder addPageElementsFactory(GUIFactory factory) {
        this.factory = factory;
        return this;
    }

    public CoffeOrderFormBuilder addDeviceFactory(DeviceFactory deviceFactory) {
        this.deviceFactory = deviceFactory;
        return this;
    }

    public OrderForm build() {
        return new CoffeOrderForm(
                factory.createButton(),
                factory.createSelect(),
                factory.createTextField(),
                deviceFactory.createDevice());
    }
}
