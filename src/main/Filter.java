package main;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    public static List<Item> FilterCategory(String category){
        List<Item> fList = new ArrayList<>();

        for(Item item: Loader.loadData()){
            if(item.getCategory().equals(category)) fList.add(item);
        }

        return fList;
    }
}
