package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import static main.Configuration.DATA_PATH;

public class Saver {

    public static boolean writeData(String path, List<Item> itemList, boolean append){
        try{
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter(path, append));

            for(Item item: itemList){
                bufWriter.write(item.parseString() + "\n");
            }

            bufWriter.close();
            return true;
        }catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean writeData(String path, Item item, boolean append){
        try{
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter(path, append));
            bufWriter.write(item.parseString() + "\n");
            bufWriter.close();

            return true;
        }catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void saveItem(Item item){
        boolean added = writeData(DATA_PATH, item, true);
        if(added) System.out.println("The item was added to the list.");
    }

    public static void saveItems(List<Item> items){
        boolean added = writeData(DATA_PATH, items, true);
        if(added) System.out.println("The item was added to the list.");
    }
}
