package main;

import java.util.ArrayList;
import java.util.List;

import static main.Configuration.*;

public class FlagParser {

    public static List<Flag> getInfoF(String flags){
        List<Flag> fList = new ArrayList<>();

        if(flags.matches(timeRegex)){
            fList.add(new Flag(flags.charAt(0), FlagType.cat));
        }else if(flags.matches(timeRegexF)){
            fList.add(new Flag(flags.charAt(0), FlagType.cat, Integer.parseInt(flags.substring(1))));
        }else if(flags.matches(catRegex)){
            fList.addAll(getCategoriesFlag(flags));
        }else if(flags.matches(infoCommands)){
            String[] flagsTable = flags.split(FLAG_SEPARATOR + "");

            for(String f: flagsTable){
                if(f.matches(timeRegex)){
                    fList.add(new Flag(f.charAt(0), FlagType.cat));
                }else if(flags.matches(timeRegexF)){
                    fList.add(new Flag(f.charAt(0), FlagType.cat, Integer.parseInt(f.substring(1))));
                }else if(flags.matches(catRegex)) {
                    fList.addAll(getCategoriesFlag(flags));
                }
            }
        }

        return fList;
    }

    public static List<Flag> getCategoriesFlag(String flags){
        String f = flags.substring(4);
        List<Flag> fList = new ArrayList<>();

        for(char c: f.toCharArray()){
            fList.add(new Flag(c, FlagType.cat));
        }

        return fList;
    }
}
