package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMethods {

    public static String getCurrentDate_d() {
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("d");
        return df.format(now);
    }
}

