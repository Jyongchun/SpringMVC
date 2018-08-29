package com.neuedu.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String,Date>{

    @Override
    public Date convert(String s) {
        //将字符串转为Date类型
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
           return dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
