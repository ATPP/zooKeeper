package com.singleton;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class PersonChange {
    private Date birthDay;

    private static Date bomerStart = null;
    private static Date bomerEnd = null;

    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        bomerStart = gmtCal.getTime();
        gmtCal.set(1956, Calendar.JANUARY, 1, 0, 0, 0);
        bomerEnd = gmtCal.getTime();
    }

    public boolean isBabyBomer() {
        return birthDay.compareTo(bomerStart) >= 0 && birthDay.compareTo(bomerEnd) < 0;
    }
}
