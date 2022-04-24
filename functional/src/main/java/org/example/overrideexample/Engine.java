package org.example.overrideexample;

import java.util.ArrayList;
import java.util.List;

public class Engine {
    List<Item> itemsList=new ArrayList<>();

    void addItem(Item item){
        itemsList.add(item);
    }

    void remove(Item item){
        itemsList.remove(item);
    }

    void draw(){
        for (Item item : itemsList) {
            item.draw();
        }
    }
}
