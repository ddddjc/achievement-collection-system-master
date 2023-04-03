package com.emc.achievement.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataLat {
        public static Date set(Date date){
            // 获取当前时间
            if (null==date)
                return null;
            Date d = date;
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(d);
            // 把日期往后增加一天,整数  往后推,负数往前移动
            calendar.add(Calendar.DATE, 1);
            // 这个时间就是日期往后推一天的结果
            d = calendar.getTime();
            return d;
        }
    }

