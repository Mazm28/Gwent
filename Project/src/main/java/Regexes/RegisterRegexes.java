package Regexes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum RegisterRegexes {
    USERNAME("[A-Za-z0-9-]+"),
    EMAIL("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"),
    PASSWORD_WEAKNESS1("^.*[A-Z].*$"),
    PASSWORD_WEAKNESS2("^.*[!@#\\$&].*$"),
    PASSWORD_WEAKNESS3("^.*[0-9].*$"),
    PASSWORD_WEAKNESS4("^.*[a-z].*$"),
    PASSWORD("^[A-Za-z0-9!@#\\$&]+$");

    private final String regex;

    RegisterRegexes(String regex) {
        this.regex = regex;
    }

    public static Matcher getMatcher(String input, RegisterRegexes regex) {
        return Pattern.compile(regex.regex).matcher(input);
    }
}
