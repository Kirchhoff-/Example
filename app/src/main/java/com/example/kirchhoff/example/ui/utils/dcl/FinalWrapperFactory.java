package com.example.kirchhoff.example.ui.utils.dcl;

/**
 * @author Kirchhoff-
 */

public class FinalWrapperFactory {
    private FinalWrapper wrapper;


    public Singleton get() {
        if (wrapper == null) { //check 1
            synchronized (this) {
                if (wrapper == null) { // check 2
                    wrapper = new FinalWrapper(new Singleton());
                }
            }
        }

        return wrapper.instance;
    }


    private static class FinalWrapper {
        public final Singleton instance;

        public FinalWrapper(Singleton instance) {
            this.instance = instance;
        }
    }
}
