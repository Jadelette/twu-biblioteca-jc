package com.twu.biblioteca;

import java.util.LinkedHashMap;

public class Movie implements StockType {

    private LinkedHashMap<String, String> productInfo = new LinkedHashMap<>();

    private String reference;

    private String type = "movie";

    public Movie(String name, String year, String director, String rating, String reference) {

        this.reference = reference;

        productInfo.put("Reference", reference);
        productInfo.put("Name", name);
        productInfo.put("Director", director);
        productInfo.put("Year", year);
        productInfo.put("Rating", rating);
    }

    @Override
    public String getRef(){
        return reference;
    }

    @Override
    public String getType(){
        return type;
    }

    @Override
    public LinkedHashMap<String, String> getProductInfo() {
        return productInfo;
    }
}

