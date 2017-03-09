package cn.ctide.pet.Formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Anker on 2016/10/14.
 */
public class DateFormatter implements Formatter<Date> {
    private String datePattern;
    private SimpleDateFormat dateFormat;

    public DateFormatter(String datePattern) {
        this.datePattern = datePattern;
        dateFormat = new SimpleDateFormat(datePattern);
    }

    public Date parse(String s, Locale locale) throws ParseException {
        return dateFormat.parse(s);
    }

    public String print(Date date, Locale locale) {
        return dateFormat.format(date);
    }
}
