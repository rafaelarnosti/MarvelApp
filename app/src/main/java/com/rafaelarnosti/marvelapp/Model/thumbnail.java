package com.rafaelarnosti.marvelapp.Model;

/**
 * Created by rafae on 26/08/2017.
 */

public class thumbnail {
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    private String path;
    private String extension;
}
