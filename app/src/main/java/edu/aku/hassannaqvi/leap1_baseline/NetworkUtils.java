package edu.aku.hassannaqvi.leap1_baseline;

import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;

import edu.aku.hassannaqvi.leap1_baseline.core.AppMain;

public class NetworkUtils {
    public static URL buildUrl(String getApiUrl) {
        Uri builtUri = Uri.parse(AppMain.PROJECT_URI).buildUpon()
                .appendPath(getApiUrl)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }
}
