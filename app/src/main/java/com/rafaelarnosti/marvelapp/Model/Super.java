package com.rafaelarnosti.marvelapp.Model;

import android.media.Image;

import java.util.Date;
import java.util.List;

/**
 * Created by RAFAELLUIZMAZZINIARN on 17/07/2017.
 */

public class Super {


    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        modified = modified;
    }

   // public Image getThumbnail() {return thumbnail ;}

    //public void setThumbnail(Image thumbnail){ thumbnail = thumbnail;}

    public thumbnail getThumbnail() {return  thumbnail;}
    public void  setThumbnail(thumbnail thumbnail){thumbnail = thumbnail;}


    private int id;
    private String name;
    private String description;
    private Date modified;
    //private Thumbnail thumbnail ;
    private thumbnail thumbnail;
}



