package main;

public class ExpenseTracker {

    public static String getData(String flags){
        return null;
    }

    public static float getMonthExpenses(int n){
        float spend = 0f;

        for(Item i: Loader.loadData()){
            spend += i.getPrice();
        }

        return spend;
    }
}
