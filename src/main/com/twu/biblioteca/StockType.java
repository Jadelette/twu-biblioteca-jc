package com.twu.biblioteca;

import java.util.LinkedHashMap;

public interface StockType {

    String getType();
    String getRef();

    LinkedHashMap<String, String> getProductInfo();



}
