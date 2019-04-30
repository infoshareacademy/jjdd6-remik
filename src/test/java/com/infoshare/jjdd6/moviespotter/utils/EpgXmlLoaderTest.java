/*
package com.infoshare.jjdd6.moviespotter.utils;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.*;
import org.w3c.dom.Document;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class EpgXmlLoaderTest {


    EpgXmlLoader epgXmlLoader = new EpgXmlLoader();

    Document doc =epgXmlLoader.loadEpgData();
    @Disabled
    @Test
    public void testIfDataConsistent(){

        Assertions.assertThat(doc.getDocumentElement().getElementsByTagName("programme"))
                .isNotNull()
                .hasFieldOrProperty("channel")
                .hasFieldOrProperty("title")
                .hasFieldOrProperty("start");
    }
}
*/