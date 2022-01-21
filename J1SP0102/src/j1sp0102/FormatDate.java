package j1sp0102;

import java.text.SimpleDateFormat;
import java.util.Date;

class FormatDate {

    static void determineDayOfWeek(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
        System.out.println("Your day is " + formatter.format(date));
    }

}
