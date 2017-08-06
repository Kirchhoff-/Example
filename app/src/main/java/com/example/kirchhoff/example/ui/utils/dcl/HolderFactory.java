package com.example.kirchhoff.example.ui.utils.dcl;

/**
 * @author Kirchhoff-
 */

//Best realization if we need static lazy Singleton
public class HolderFactory {

    public static Singleton get() {
        return Holder.instance;
    }

    private static class Holder {
        public static final Singleton instance = new Singleton();
    }
}
