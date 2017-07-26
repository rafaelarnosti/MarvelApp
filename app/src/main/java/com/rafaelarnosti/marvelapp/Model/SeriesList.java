package com.rafaelarnosti.marvelapp.Model;

import java.lang.reflect.Array;
import java.util.List;

public class SeriesList{
    private int Available;
    private int Returned;
    private String CollectionURI;
    private List<SeriesSummary> Items;

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

    public List<SeriesSummary> getItems() {
        return Items;
    }

    public void setItems(List<SeriesSummary> items) {
        Items = items;
    }
}

class SeriesSummary{
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
