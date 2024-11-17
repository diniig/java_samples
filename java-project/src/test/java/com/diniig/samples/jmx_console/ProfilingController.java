package com.diniig.samples.jmx_console;

public class ProfilingController implements ProfilingControllerMBean {

    private boolean enabled = false;

    @Override
    public void setEnabled(boolean v) {
        this.enabled = v;
    }

    public boolean isEnabled() {
        return enabled;
    }

}
