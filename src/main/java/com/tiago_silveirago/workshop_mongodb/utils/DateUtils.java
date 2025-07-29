package com.tiago_silveirago.workshop_mongodb.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static final String ZONE_ID_GMT = "GMT";
    public static final String YEAR_MONTH_DAY_PATTERN = "yyyy/MM/dd";

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YEAR_MONTH_DAY_PATTERN).withZone(ZoneId.of(ZONE_ID_GMT));

    public static Instant convertToInstant(String date) {
        return LocalDate.parse(date, formatter).atStartOfDay(ZoneId.of(ZONE_ID_GMT)).toInstant();
    }
}
