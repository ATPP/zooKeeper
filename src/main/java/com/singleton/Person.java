package com.singleton;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person {
    private Date birthDay;

    public boolean isBabyBomer() {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date bomerStart = gmtCal.getTime();
        gmtCal.set(1956, Calendar.JANUARY, 1, 0, 0, 0);
        Date bomerEnd = gmtCal.getTime();
        return birthDay.compareTo(bomerStart) >= 0 && birthDay.compareTo(bomerEnd) < 0;
    }


}
