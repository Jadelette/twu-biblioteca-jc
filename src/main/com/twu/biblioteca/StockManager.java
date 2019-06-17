package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class StockManager {

    private ArrayList<StockType> stock = new ArrayList<>();
    private List<StockType> reservedItems = new ArrayList<>();

    public StockManager( ) { }

    public  ArrayList<StockType>getStock() {
        return stock;
    }

    public  void addItemToStock(StockType item) {
        stock.add(item);
    }

    public  void removeItemFromStock(String ref) {
        for (StockType item : reservedItems) {
            if (item.getRef().contains(ref)){
                stock.remove(item);
            }
        }
    }

    public List<StockType> getReservedItems(){
        return reservedItems;
    }

    public void addItemToReservedList(String ref){
        StockType itemToReserve = null;
        for (StockType item : stock) {
            if (item.getRef().equals(ref)) {
                itemToReserve = item;
            }
        }
        if (itemToReserve == null) {throw new InputMismatchException();
            } else {
            reservedItems.add(itemToReserve);
        }
    }

    public void removeItemFromReservedList(String ref) {
        for (StockType item : stock) {
            if (item.getRef().contains(ref)){
                reservedItems.remove(item);
            }
        }
    }

    public void returnItemToStock(String ref){
        StockType itemToReturn = null;
        for (StockType book : reservedItems) {
            if (book.getRef().equals(ref)) {
                itemToReturn = book;
            }
        }
        if (itemToReturn == null) {throw new InputMismatchException();
        } else {
            stock.add(itemToReturn);
        }
    }

    public String determineStockType(){
        StockType item = stock.get(0);
        String type = item.getType();
        return type;
    }


    public void clearStock() {
        stock = new ArrayList<>();
    }

    public void clearReservedList() {
        reservedItems = new ArrayList<>();
    }

}
