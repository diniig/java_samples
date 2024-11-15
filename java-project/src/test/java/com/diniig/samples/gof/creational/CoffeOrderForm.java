package com.diniig.samples.gof.creational;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoffeOrderForm implements OrderForm {
    private Button submitOrder;
    private Select selectCoffe;
    private TextField customerName;
    private Device device;

    public CoffeOrderForm(Button submitOrder, Select selectCoffe, TextField customerName,  Device device) {
        this.submitOrder = submitOrder;
        this.selectCoffe = selectCoffe;
        this.customerName = customerName;
        this.device = device;
    }

    public void renderForm() {
        device.print("");
    }
}
