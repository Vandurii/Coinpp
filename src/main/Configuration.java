package main;

public class Configuration {

    public static final String DATA_PATH = "src/data.txt";
    public static final char SEPARATOR = '/';
    public static final String DATE_PATTERN = "dd-M-yyyy hh:mm E w";
    public static final String MONTH_INT_PATTERN = "MM";
    public static final String MONTH_STRING_PATTERN = "MMM";

    public static final String COMMAND_EXIT = "exit";
    public static final char FLAG_SEPARATOR = '-';
    public static final String ERROR_CODE = "404";
    public static final String FLAG_ERROR = "'%s' is not recognized as a flag.%n";

    public static final String LS_COMMAND = "ls";
    public static final String INFO_COMMAND = "info";
    public static final String CD_COMMAND = "cd";
    public static final String ADD_COMMAND = "add";
    public static final String CLEAR_COMMAND = "clear";
}

// Cosmetic     - c
// Food         - f
// Alcohol      - a
// Phone        - p
// Traffic      - t
// Work         - w
// Recreation   - r
// House        - h
// Bills        - b

// i -w (t) / -m (t) / -y (t) / -c (e)
// i -w (n) / -m (n) / -y (n) / -c|f|a|p

// add id to the items