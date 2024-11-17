package com.diniig.samples.jmx_console;

import org.junit.jupiter.api.Test;

import java.lang.management.ManagementFactory;

import javax.management.ObjectName;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MBeanTest {

    private ProfilingController controller;

    @Test
    void test() throws Exception {
        controller = new ProfilingController();
        ManagementFactory.getPlatformMBeanServer().registerMBean(controller,
                new ObjectName("domain_name", "name", "prof_controller"));
        while (true) {
            log.info("enabled = {}", controller.isEnabled());
            Thread.sleep(1000);
        }
    }

}
