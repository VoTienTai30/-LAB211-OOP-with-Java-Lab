package j1sp0102;

import java.text.ParseException;
import java.util.Date;

public class Main {
    
    public static void main(String[] args) throws ParseException {
        // 1. Input date with [dd/mm/yyyy] format
        Date date = GetInput.inputDate();
        // 2. Determine day of week of input date
        FormatDate.determineDayOfWeek(date);
    }
}
