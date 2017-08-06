package com.example.kirchhoff.example.ui.utils.dcl;

/**
 * @author Kirchhoff-
 */
//Realization of Singleton which fixs problem of NonVolatileDCLFactory
public class VolatileDCLFactory {

    private volatile Singleton instance;

    public Singleton get() {
        if (instance == null) { // check 1
            synchronized (this) {
                if (instance == null) { //check 2
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
