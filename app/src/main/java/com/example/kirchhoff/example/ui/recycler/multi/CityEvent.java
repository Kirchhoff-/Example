package com.example.kirchhoff.example.ui.recycler.multi;

/**
 * @author Kirchhoff-
 */

public class CityEvent {

    public static final int CITY_TYPE = 0;
    public static final int EVENT_TYPE = 1;
    private String name;
    private String description;
    private int type;

    public CityEvent(String name, String description, int type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
