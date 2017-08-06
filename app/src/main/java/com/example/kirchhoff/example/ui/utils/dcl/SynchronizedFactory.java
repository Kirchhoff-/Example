package com.example.kirchhoff.example.ui.utils.dcl;

/**
 * @author Kirchhoff-
 */

//Heavy realization for synchronization
public class SynchronizedFactory {

    private Singleton instance;

    public Singleton get() {
        synchronized (this) {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }
}
