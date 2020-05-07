package com.example.luv2code.terminator;

public class ProfilingController implements  ProfilingControllerMBean{

    private boolean enable;


    @Override
    public boolean isEnabled() {
        return true;
    }
}
