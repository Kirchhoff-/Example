package com.example.kirchhoff.example.ui.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;

import com.example.kirchhoff.example.ui.tinder.Profile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kirchhoff-
 */

public class TinderUtils {

    public static List<Profile> loadProfiles(Context context) {
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            JSONArray array = new JSONArray(loadJSONFromAsset(context, "profiles.json"));
            List<Profile> profileList = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                Profile profile = gson.fromJson(array.getString(i), Profile.class);
                profileList.add(profile);
            }
            return profileList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String loadJSONFromAsset(Context context, String jsonFileName) {
        String json;
        InputStream is;
        try {
            AssetManager manager = context.getAssets();
            is = manager.open(jsonFileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
