package com.example.kirchhoff.example.ui.utils.dcl;

/**
 * @author Kirchhoff-
 */

//With this realization we can get problem access instance in different thread before
//code in synchronized will be finished
public class NonVolatileDCLFactory {

    private Singleton instance;

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
