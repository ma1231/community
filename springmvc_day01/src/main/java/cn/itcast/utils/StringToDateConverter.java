package cn.itcast.utils;

import javafx.scene.input.DataFormat;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {


    @Override
    public Date convert(String s) {
        if(s==null){
            throw new RuntimeException("错误");
        }
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

}
