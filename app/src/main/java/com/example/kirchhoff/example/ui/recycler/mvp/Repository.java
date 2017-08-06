package com.example.kirchhoff.example.ui.recycler.mvp;

/**
 * @author Kirchhoff-
 */

public class Repository {


    private String title;
    private int starsCount;

    public Repository(String title, int startsCount) {
        this.title = title;
        this.starsCount = startsCount;
    }

    public String getTitle() {
        return title;
    }

    public int getStarsCount() {
        return starsCount;
    }
}
