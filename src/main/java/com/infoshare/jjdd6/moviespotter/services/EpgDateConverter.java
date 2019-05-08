package com.infoshare.jjdd6.moviespotter.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EpgDateConverter {

    private static final Logger log = LoggerFactory.getLogger(EpgDateConverter.class.getName());

    public LocalDateTime toLocalDateTime(String EpgDate) {

        String BaseDateTime = (EpgDate.split(" ")[0]);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        try {
            LocalDateTime localDateTime = LocalDateTime.parse(BaseDateTime, dtf);
            return localDateTime;
        } catch (DateTimeException e) {
            log.error("Date formatting error: " + e);
            return LocalDateTime.now().minusYears(1000);
        }
    }
}
