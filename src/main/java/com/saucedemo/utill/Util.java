package com.saucedemo.utill;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Util {

    public static String getCurrentDateTime() {
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String date = formatter.format(currentDate.getTime()).replace("/","_");
        date = date.replace(":","_");
        return date;
    }
    public static String getReportName() {
        String localDateTime = getCurrentDateTime();
        StringBuilder name = new StringBuilder()
                .append("AutomationReport_")
                .append(localDateTime)
                .append(".html");
        return name.toString();
    }
}
