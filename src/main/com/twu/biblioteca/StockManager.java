package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class StockManager {

    private List<StockType> Stock = new ArrayList<>();
    private List<StockType> reservedItems = new ArrayList<>();

    public StockManager( ) { }

    public  List<StockType>getStock() {
        return Stock;
    }

    public  void addItemToStock(StockType item) {
        Stock.add(item);
    }

    public  void removeItemFromStock(String ref) {
        for (StockType item : reservedItems) {
            if (item.getRef().contains(ref)){
                Stock.remove(item);
            }
        }
    }

    public List<StockType> getReservedItems(){
        return reservedItems;
    }

    public void addItemToReservedList(String ref){
        StockType itemToReserve = null;
        for (StockType item : Stock) {
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
        for (StockType item : Stock) {
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
            Stock.add(itemToReturn);
        }
    }


    public void clearStock() {
        Stock = new ArrayList<>();
    }

    public void clearReservedList() {
        reservedItems = new ArrayList<>();
    }

}
