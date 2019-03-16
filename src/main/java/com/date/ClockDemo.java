package com.date;

import com.mchange.lang.ShortUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ClockDemo {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        //获取当前的毫秒值
        long millis = clock.millis();
        System.out.println(millis);

        //当前时间线上的时刻
        Instant instant = clock.instant();
        Date date = Date.from(instant);
        System.out.println(date);

        //
        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

        //
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        System.out.println(now1.isBefore(now2));
        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
        System.out.println(hoursBetween);
        System.out.println(minutesBetween);


        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        System.out.println(tomorrow);
        LocalDate yesterday = tomorrow.minusDays(2);
        System.out.println(yesterday);
        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        System.out.println(independenceDay);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);

        //将字符串解析为LocalDate
        DateTimeFormatter germanFormatter =
                DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.MEDIUM)
                        .withLocale(Locale.GERMAN);
        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
        System.out.println(xmas);
    }
}
