package com.infoshare.jjdd6.moviespotter;


import com.infoshare.jjdd6.moviespotter.models.Programme;
import com.infoshare.jjdd6.moviespotter.services.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ServicesTests {


    ConfigLoader configLoader = new ConfigLoader();
    StarRating starRating = new StarRating();
    EpgDateConverter epgDateConverter = new EpgDateConverter();


    @Test
    public void starRatingTest() {

        assertEquals("★★☆☆☆", starRating.toStars("2"));
    }

    @Test
    public void generalPropertiesTest() {

        assertNotNull(configLoader.getProperties());
    }

    @Test
    public void xmlFilePropertiesTest() {

        assertNotNull(configLoader.getProperties().getProperty("xmlfile"));
    }

}
