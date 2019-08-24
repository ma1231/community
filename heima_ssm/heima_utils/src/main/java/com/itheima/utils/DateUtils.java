package com.itheima.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    //日期转字符串
    public static String date2Sring(Date date, String pattern){
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        String format = sdf.format(date);
        return format;
    }

    //字符串转日期
    public static Date string2Date(String str, String pattern) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        Date date = sdf.parse(pattern);
        return date;
    }
}
