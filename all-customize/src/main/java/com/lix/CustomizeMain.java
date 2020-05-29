package com.lix;

import com.alibaba.fastjson.JSON;

import javax.lang.model.element.NestingKind;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 12547
 */
public class CustomizeMain {
    public static void main(String[] args) throws IOException, ParseException {
        String sd = "2020-05-01";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = simpleDateFormat.parse(sd);
            Calendar cal = Calendar.getInstance();
            cal.setTime(parse);
            cal.add(Calendar.DAY_OF_MONTH, +1);
            System.out.println(simpleDateFormat.format(cal.getTime()));
            return ;
        } catch (ParseException e) {
            e.printStackTrace();
            return ;
        }
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date parse = simpleDateFormat.parse(sd);
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(parse);
//        cal.add(Calendar.DAY_OF_MONTH,-1);
//
//        cal.set(Calendar.HOUR_OF_DAY, 0);
//        cal.set(Calendar.SECOND, 0);
//        cal.set(Calendar.MINUTE, 0);
//        cal.set(Calendar.MILLISECOND, 0);
//        System.out.println(simpleDateFormat.format(cal.getTime()));
    }
}
