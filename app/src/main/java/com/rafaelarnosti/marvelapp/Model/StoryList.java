package com.rafaelarnosti.marvelapp.Model;

import java.lang.reflect.Array;
import java.util.List;

public class StoryList{
    public int getAvailable() {
        return Available;
    }

    public void setAvailable(int available) {
        Available = available;
    }

    public int getReturned() {
        return Returned;
    }

    public void setReturned(int returned) {
        Returned = returned;
    }

    public String getCollectionURI() {
        return CollectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        CollectionURI = collectionURI;
    }

    public List<StorySummary> getItems() {
        return Items;
    }

    public void setItems(List<StorySummary> items) {
        Items = items;
    }

    private int Available;
    private int Returned;
    private String CollectionURI;
    private List<StorySummary> Items;
}
class StorySummary{
    public String getResourceURI() {
        return ResourceURI;
    }

    public void setResourceURI(String resourceURI) {
        ResourceURI = resourceURI;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    private String ResourceURI;
    private String Name;
}
