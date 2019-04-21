package com.infoshare.jjdd6.moviespotter.utils;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class EpgDateConverter {

    public LocalDateTime ToLocalDateTime(String EpgDate) {

        //2019 04 21 18 05 00 +0200

        String BaseDateTime=(EpgDate.split(" ")[0]);
        //Integer TimeZoneDiff=Integer.parseInt((EpgDate.split(" ")[1]).substring(1,5));

        ZoneOffset zoneOffset = ZoneOffset.of(EpgDate.split(" ")[1]);
        TimeZone timezone = TimeZone.getTimeZone(zoneOffset);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        LocalDateTime localDateTime = LocalDateTime.parse(BaseDateTime, dtf);


        System.out.println(localDateTime);
        System.out.println(localDateTime+" "+timezone);

        return null;
    }

}
