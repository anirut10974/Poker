package poker;

import java.util.regex.Pattern;

public class Utils {

    public boolean validVariable(String code, String variable) {
        boolean isCheck = false;
        try {
            Pattern pattern;
            pattern = Pattern.compile(code);
            isCheck = (pattern.matcher(variable)).matches();
        } catch (Exception e) {
            System.out.println(e);
        }
        return isCheck;
    }
    
    public String twoDigits(int value) {
        return String.format("%02d", value);
    }
    
}
