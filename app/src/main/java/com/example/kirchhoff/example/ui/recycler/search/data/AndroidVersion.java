package com.example.kirchhoff.example.ui.recycler.search.data;

import android.support.annotation.Nullable;

/**
 * @author Kirchhoff-
 */

public class AndroidVersion {
    @Nullable
    private String ver;
    @Nullable
    private String name;
    @Nullable
    private String api;

    public AndroidVersion(@Nullable String ver,
                          @Nullable String name,
                          @Nullable String api) {
        this.ver = ver;
        this.name = name;
        this.api = api;
    }

    public String getVer() {
        return ver;
    }

    public String getName() {
        return name;
    }

    public String getApi() {
        return api;
    }
}
