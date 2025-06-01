package main;

import java.text.SimpleDateFormat;
import java.util.Date;

import static main.Configuration.*;

public class Item {
    private String name;
    private float price;
    private String category;
    private int code;
    private String date;
    private String time;
    private String weekday;
    private String week;

    private static char separator = SEPARATOR;

    public Item(String name, float price, String category, int code){
        this.name = name;
        this.price = price;
        this.category = category;
        this.code = code;

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);;
            String info = simpleDateFormat.format(new Date());
            String[] table = info.split(" ");
            this.date = table[0];
            this.time = table[1];
            this.weekday = table[2];
            this.week = table[3];

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private Item(String name, float price, String category, int code, String date, String time, String weekday, String week){
        this.name = name;
        this.price = price;
        this.category = category;
        this.code = code;
        this.date = date;
        this.time = time;
        this.weekday = weekday;
        this.week = week;
    }

    public static Item parseItem(String data){
        try {
            String[] dataTable = data.split(separator + "");
            String name = dataTable[0];
            float price = Float.parseFloat(dataTable[1]);
            String category = dataTable[2];
            int code = Integer.parseInt(dataTable[3]);
            String date = dataTable[4];
            String time = dataTable[5];
            String weekday = dataTable[6];
            String week = dataTable[7];

            return new Item(name, price, category, code, date, time, weekday, week);
        }catch (ArrayIndexOutOfBoundsException iob){
            iob.printStackTrace();
            System.out.println("The operation failed. Ann error occurred. The data are probably incorrect.\n" +
                    "Data:" + data + "|\n");
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static Item createItem(String data){
        try {
            String[] dataTable = data.split(separator + "");
            String name = dataTable[0];
            float price = Float.parseFloat(dataTable[1]);
            String category = dataTable[2];
            int code = Integer.parseInt(dataTable[3]);

            return new Item(name, price, category, code);
        }catch (ArrayIndexOutOfBoundsException iob){
            iob.printStackTrace();
            System.out.println("The operation failed. Ann error occurred. The data are probably incorrect.\n" +
                    "Data:" + data + "|\n");
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public String parseString(){
        String data = "";

        data += (this.name + separator);
        data += (String.valueOf(this.price) + separator);
        data += this.category + separator;
        data += String.valueOf(code) + separator;
        data += this.date + separator;
        data += this.time + separator;
        data += this.weekday + separator;
        data += this.week;

        return data;
    }

    public float getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }

    public String getFlags(String args){
        String output = "";
        String[] argTable = args.split(FLAG_SEPARATOR + "");

        for (String s : argTable) {
            String se = s.trim();
            if(se.isEmpty()) continue;
            char flag = se.charAt(0);
            String newFlag = getFlag(flag) + "\t";

            if (newFlag.trim().equals(ERROR_CODE)){
                return String.format(FLAG_ERROR, flag);
            }else{
                output += newFlag;
            }
        }

        return output;
    }

    private String getFlag(char c){
        return switch (c) {
            case 'n' -> this.name;
            case 'p' -> String.valueOf(this.price);
            case 'c' -> this.category;
            case 'q' -> String.valueOf(this.code);
            case 'd' -> this.date;
            case 't' -> this.time;
            case 'w' -> this.weekday;
            case 'W' -> this.week;
            default -> ERROR_CODE;
        };
    }

    public String getAllFlags(){
        return getFlags("-n-p-c-q-d-t-w-W");
    }

    @Override
    public String toString(){
        return "name: " + this.name + "\tprice: " + this.price + "\tcategory: " + category + "\tcode: " + code + "\tdate: " + date;
    }
}
