package com.example.lno.litenoteorganizer;

import android.net.Uri;

/**
 * Created by Rizal Rey on 3/3/2018.
 */

public class Spacecraft {
    String name;
    Uri uri;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}