package com.rafaelarnosti.marvelapp.Model;

import android.media.Image;

import java.util.Date;
import java.util.List;

/**
 * Created by RAFAELLUIZMAZZINIARN on 17/07/2017.
 */

public class Super {
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getModified() {
        return Modified;
    }

    public void setModified(Date modified) {
        Modified = modified;
    }

    public String getResourceURI() {
        return ResourceURI;
    }

    public void setResourceURI(String resourceURI) {
        ResourceURI = resourceURI;
    }



    public Image getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        Thumbnail = thumbnail;
    }

    public ComicList getComics() {
        return Comics;
    }

    public void setComics(ComicList comics) {
        Comics = comics;
    }

    public StoryList getStories() {
        return Stories;
    }

    public void setStories(StoryList stories) {
        Stories = stories;
    }

    public EventList getEvents() {
        return Events;
    }

    public void setEvents(EventList events) {
        Events = events;
    }

    public SeriesList getSeries() {
        return Series;
    }

    public void setSeries(SeriesList series) {
        Series = series;
    }

    public List<Url> getUrls() {
        return Urls;
    }

    public void setUrls(List<Url> urls) {
        Urls = urls;
    }

    private String Name;
    private String Description;
    private Date Modified;
    private String ResourceURI;
    private List<Url> Urls;
    private Image Thumbnail;
    private ComicList Comics;
    private StoryList Stories;
    private EventList Events;
    private SeriesList Series;
}



