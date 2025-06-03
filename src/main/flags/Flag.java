package main;

public class Flag {
    public FlagType type;
    public char name;
    public int value;

    public Flag(char name, FlagType type){
        this.name = name;
        this.type = type;
        this.value = -1;
    }

    public Flag(char name, FlagType type, int value){
        if(value <  0) throw new RuntimeException("The value must be greater then 0.");
        this.name = name;
        this.type = type;
        this.value = value;
    }
}
