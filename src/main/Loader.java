package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static main.Configuration.DATA_PATH;

public class Loader {

    public static List<Item> getData(String path){
        List<Item> data = new ArrayList<>();
        try{
            String line;
            BufferedReader bufReader = new BufferedReader(new FileReader(path));

            while((line = bufReader.readLine()) != null){
                data.add(Item.parseItem(line));
            }

            bufReader.close();
        }catch(Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public static List<Item> loadData(){
        return  getData(DATA_PATH);
    }
}
