package com.example.kirchhoff.example.ui.architecture.example2.mvc;

/**
 * @author Kirchhoff-
 */

public interface CounterController {

    void increase();

    void setOnCounterIncreaseListener(OnCounterIncreaseListener listener);
}
