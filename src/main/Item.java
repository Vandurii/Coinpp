package main;

import java.text.SimpleDateFormat;
import java.util.Date;

import static main.Configuration.*;

public class Item {
    public static int metaN;
    public static int metaP;
    public static int metaC;
    public static int metaQ;
    public static int metaS;
    public static int metaD;
    public static int metaT;
    public static int metaW;
    public static int metaWW;

    private String name;
    private float price;
    private String category;
    private String code;
    private String shop;
    private String date;
    private String time;
    private String weekday;
    private String week;

    private static char separator = SEPARATOR;

    public Item(String name, float price, String category, String code, String shop){
        this.name = name;
        this.price = price;
        this.category = category;
        this.code = code;
        this.shop = shop;

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

    private Item(String name, float price, String category, String code, String shop, String date, String time, String weekday, String week){
        this.name = name;
        this.price = price;
        this.category = category;
        this.code = code;
        this.shop = shop;
        this.date = date;
        this.time = time;
        this.weekday = weekday;
        this.week = week;
    }

    public static Item parseItem(String data){
        try {
            String[] dataTable = data.split(separator + "");

            String name = dataTable[0];
            int nLen = name.length() + PRINT_DISTANCE;
            if(nLen > metaN) metaN = nLen;

            float price = Float.parseFloat(dataTable[1]);
            int pLen = String.valueOf(price).length() + PRINT_DISTANCE;
            if(pLen > metaP) metaP = pLen;

            String category = dataTable[2];
            int cLen = category.length() + PRINT_DISTANCE;
            if(cLen > metaC) metaC = cLen;

            String code = dataTable[3];
            int qLen = code.length() + PRINT_DISTANCE;
            if(qLen > metaQ) metaQ = qLen;

            String shop = dataTable[4];
            int sLen = shop.length() + PRINT_DISTANCE;
            if(sLen > metaS) metaS = sLen;

            String date = dataTable[5];
            int dLen = date.length() + PRINT_DISTANCE;
            if(dLen > metaD) metaD = dLen;

            String time = dataTable[6];
            int tLen = time.length() + PRINT_DISTANCE;
            if(tLen > metaT) metaT = tLen;

            String weekday = dataTable[7];
            int wLen = weekday.length() + PRINT_DISTANCE;
            if(wLen > metaW) metaW = wLen;

            String week = dataTable[8];
            int wwLen = name.length() + PRINT_DISTANCE;
            if(wwLen > metaWW) metaWW = wwLen;

            return new Item(name, price, category, code, shop, date, time, weekday, week);
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
            String code = dataTable[3];
            String shop = dataTable[4];

            return new Item(name, price, category, code, shop);
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
        data += this.shop + separator;
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

    public String getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }

    public String getShop() {
        return shop;
    }

    public String getTime() {
        return time;
    }

    public String getWeekday() {
        return weekday;
    }

    public String getWeek() {
        return week;
    }

    public String getFlags(String args){
        String output = "";
        String[] argTable = args.split(FLAG_SEPARATOR + "");

        for (String s : argTable) {
            String se = s.trim();
            if(se.isEmpty()) continue;
            char flag = se.charAt(0);
            String newFlag = getFlag(flag);

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
            case 'n' -> this.name + createSpace(metaN - this.name.length());
            case 'p' -> this.price + createSpace(metaP - String.valueOf(this.price).length());
            case 'c' -> this.category + createSpace(metaC - this.category.length());
            case 'q' -> this.code + createSpace(metaQ - this.code.length());
            case 's' -> this.shop + createSpace(metaS - this.shop.length());
            case 'd' -> this.date + createSpace(metaD - this.date.length());
            case 't' -> this.time + createSpace(metaT - this.time.length());
            case 'w' -> this.weekday + createSpace(metaW - this.weekday.length());
            case 'W' -> this.week + createSpace(metaWW - this.week.length());
            default -> ERROR_CODE;
        };
    }

    public static String createSpace(int n){
        String space = "";
        while(n-- > 0){
            space += " ";
        }

        return space;
    }

    public String getAllFlags(){
        return getFlags("-n-p-c-q-s-d-t-w-W");
    }

    @Override
    public String toString(){
        return "name: " + this.name + "\tprice: " + this.price + "\tcategory: " + category + "\tcode: " + code + "\tdate: " + date;
    }
}
