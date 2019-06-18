package com.webee.challange.utils;

import com.webee.challange.common.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Tools related to Dates
 *
 **/

public class DateUtils {

    public static long getMinLimitDate(){
        long min_limit_date=0;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(Constants.MIN_LIMIT_DATE);
            min_limit_date = date.getTime();

        }catch (Exception e){

        }

        return min_limit_date;
    }
}
