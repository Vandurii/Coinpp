package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import static main.Configuration.*;

public class Main {
    private static BufferedReader bufferedReader;
    private static int currentMontInt;

    public static void main(String[] args) {
        SimpleDateFormat spdMonthString = new SimpleDateFormat(MONTH_STRING_PATTERN);
        SimpleDateFormat spdMonthInt = new SimpleDateFormat(MONTH_INT_PATTERN);
        String monthString = spdMonthString.format(new Date());
        currentMontInt = Integer.parseInt(spdMonthInt.format(new Date()));

        String host = String.format("%s :", monthString);

        String input;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(host);

        try {
            while (!(input = bufferedReader.readLine()).equals(COMMAND_EXIT)) {

                if(input.startsWith(LS_COMMAND)){
                    ls(input);
                }else if(input.startsWith(INFO_COMMAND)){
                    info(input);
                }else {
                    switch (input) {
                        case "cd" -> cd();
                        case "add" -> add();
                        case "clear" -> clearScreen();
                        default -> def(input);
                    }
                }

                System.out.print(host);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ls(String input){
        String flags = input.substring(LS_COMMAND.length());

        if(flags.isEmpty()){
            lsa();
        }else {
            lsf(flags);
        }
    }

    public static void lsf(String args){
        for(Item i: Loader.loadData()){
            System.out.println(i.getFlags(args));
        }
    }

    public static void lsa(){
        for(Item i: Loader.loadData()){
            System.out.println(i.getAllFlags());
        }
    }

    public static void info(String input){
        String flags = input.substring(INFO_COMMAND.length());

        if(flags.isEmpty()){
            float spend = ExpenseTracker.getMonthExpenses(currentMontInt);
            System.out.printf("Spend: %s%n", spend);
        }else {
         //todo
        }
    }

    public static void cd(){
        System.out.println("run cd");
    }

    public static void add() throws IOException {
        System.out.printf("name%sprice%scategory%scode\n", SEPARATOR, SEPARATOR, SEPARATOR);
        String line = bufferedReader.readLine();
        Item item = Item.createItem(line);

        if(item != null) Saver.saveItem(item);
    }

    public static void def(String input){
        System.out.printf("'%s' is not recognized as a command.%n", input);
    }

    public static void clearScreen() {
        System.out.println("The commend is not finished yet.");
    }
}

// i -w (t) / -m (t) / -y (t) / -c (e)
// i -w (n) / -m (n) / -y (n) / -c|f|a|p