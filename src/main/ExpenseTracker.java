package main;

import java.util.List;

import static main.Configuration.DATE_SEPARATOR;

public class ExpenseTracker {

    public static String getData(String flags){
        return null;
    }

    public static float getMonthExpenses(int month){
        float spend = 0f;

        for(Item i: Loader.loadData()){
            int monthInt = Integer.parseInt(i.getDate().split(DATE_SEPARATOR + "")[1]);
            if(month == monthInt) {
                spend += i.getPrice();
            }
        }

        return spend;
    }

    public static float calcItemsValue(List<Item> items){
        float spend = 0f;

        for(Item i: items){
            spend += i.getPrice();
        }

        return spend;
    }

    public static void printExpenses(int currentMontInt){
        float spend = ExpenseTracker.getMonthExpenses(currentMontInt);
        System.out.printf("Spend: %s%n", spend);
    }

    public static void printExpenses(List<Item> items){
        float spend = calcItemsValue(items);
        System.out.printf("Spend: %s%n", spend);
    }

}
