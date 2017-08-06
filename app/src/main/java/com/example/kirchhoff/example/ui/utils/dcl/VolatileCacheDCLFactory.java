package com.example.kirchhoff.example.ui.utils.dcl;

/**
 * @author Kirchhoff-
 */

public class VolatileCacheDCLFactory {

    private volatile Singleton instance;

    public Singleton getInstance() {
        Singleton res = instance;

        if (res == null) {
            synchronized (this) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
            return instance;
        }

        return res;
    }
}
