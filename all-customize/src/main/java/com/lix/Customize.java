package com.lix;

import com.lix.domain.Dish;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Customize {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = simpleDateFormat.parse("2020-05-02 00:00:00");
        Calendar cal = Calendar.getInstance();
        cal.setTime(parse);

        for (int i = 1; i <= 26; i++) {

            System.out.println(simpleDateFormat.format(cal.getTime()));
            cal.add(Calendar.DAY_OF_MONTH, +1);
        }



    }

}
