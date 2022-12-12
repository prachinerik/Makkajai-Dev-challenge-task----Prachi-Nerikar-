package main;

import java.util.List;

public class Invoice {

    private final List<Item> items;

    public Invoice(List<Item> itemList) {
        this.items = itemList;
    }

    public Iterable<Item> getItems() {
        return this.items;
    }
}
