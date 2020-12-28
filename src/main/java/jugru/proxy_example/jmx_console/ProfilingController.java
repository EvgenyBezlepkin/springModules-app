package jugru.proxy_example.jmx_console;

import jugru.proxy_example.jmx_console.ProfilingControllerMBean;


public class ProfilingController implements ProfilingControllerMBean {

    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
