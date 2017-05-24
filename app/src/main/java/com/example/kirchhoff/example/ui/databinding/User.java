package com.example.kirchhoff.example.ui.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.kirchhoff.example.BR;

/**
 * @author Kirchhoff-
 */

public class User extends BaseObservable {

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
}
