//package com.infoshare.jjdd6.moviespotter.XmlTools;
//
//import com.infoshare.jjdd6.moviespotter.dao.ChannelDao;
//import com.infoshare.jjdd6.moviespotter.dao.ProgrammeDao;
//import com.infoshare.jjdd6.moviespotter.models.Channel;
//import com.infoshare.jjdd6.moviespotter.models.Programme;
//import com.infoshare.jjdd6.moviespotter.services.EpgDateConverter;
//import org.apache.commons.lang3.math.NumberUtils;
//import org.hibernate.Hibernate;
//import org.hibernate.Session;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.w3c.dom.Document;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//
//import javax.ejb.Stateful;
//import javax.ejb.Stateless;
//import javax.enterprise.context.RequestScoped;
//import javax.inject.Inject;
//
//@Stateful
//public class ProgrammesParser implements Runnable {
//
//    private static final Logger log = LoggerFactory.getLogger(ProgrammesParser.class.getName());
//
////    @Inject
////    private Programme programme;
////
////    @Inject
////    private Channel channel;
//
//    @Inject
//    private ProgrammeDao programmeDao;
//
//    @Inject
//    private ChannelDao channelDao;
//
//    @Inject
//    private ShouldLoadChannel shouldLoadChannel;
//
//    private Document document;
//
//    public void ProgrammesParser(Document doc) {
//        this.document = doc;
//
//
//
////     void doParseProgrammes(Document doc, ProgrammeDao programmeDao){
//
//        EpgDateConverter epgDateConverter = new EpgDateConverter();
//        NodeList programmesList = doc.getDocumentElement().getElementsByTagName("programme");
//
//        for (int i = 0; i < programmesList.getLength(); i++) {
//
//            Programme programme = new Programme();
//            Channel channel = new Channel();
//            Node node = programmesList.item(i);
//
//            String channelName = node.getAttributes().getNamedItem("channel").getNodeValue();
//
//
//            if (channelDao.findByName(channelName).isEmpty()) {
////                Channel channel = new Channel();
//                channel.setName(channelName);
//
//                try {
//                    channelDao.save(channel);
//                    programme.setChannel(channel);
//                    log.info("Programme channel created and set: " + programme.getChannel().getName());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    continue;
//                }
//
//            } else {
//
//                programme.setChannel(channelDao.findByName(channelName).orElse(null));
//                log.info("Programme channel found and set: " + programme.getChannel().getName());
//            }
//
//
//
//            if (shouldLoadChannel.checkShouldBeLoaded(channelName)) {
//                continue;
//            }
//
////
////
////            try {
////                programme.setChannel((channelDao.findByName(channelName)));
////            } catch (Exception e) {
////                log.error("Error setting channel: " + channelName);
////                continue;
////            }
//
////            log.info("Programme channel: "+ programme.getChannel().getName());
//
//            programme
//                    .setStart(epgDateConverter
//                            .toLocalDateTime(node.getAttributes()
//                                    .getNamedItem("start")
//                                    .getNodeValue()
//                            )
//                    );
//
//
//            programme
//                    .setStop(epgDateConverter
//                            .toLocalDateTime(node.getAttributes()
//                                    .getNamedItem("stop")
//                                    .getNodeValue()
//                            )
//                    );
//
//
//            NodeList childnodes = node.getChildNodes();
//
//            for (int j = 0; j < childnodes.getLength(); j++) {
//
//                Node child = childnodes.item(j);
//
//                if (child.getNodeName().equalsIgnoreCase("title")) {
//
//                    if (child.getAttributes().getNamedItem("lang").getNodeValue().equals("pl") && programme.getTitlePl() == null) {
//                        programme.setTitlePl(child.getTextContent());
//                    } else if (child.getAttributes().getNamedItem("lang").getNodeValue().equals("en") && programme.getTitleEn() == null) {
//                        programme.setTitleEn(child.getTextContent());
//                    } else if (child.getAttributes().getNamedItem("lang").getNodeValue().equals("xx") && programme.getTitleXx() == null) {
//                        programme.setTitleXx(child.getTextContent());
//                    } else {
//                        log.info("Title: new language code found: " + programme.getChannel() + ", " + programme.getStart() + " :: " + child.getAttributes().getNamedItem("lang").getNodeValue());
//                    }
//                }
//                if (child.getNodeName().equalsIgnoreCase("sub-title")) {
//                    if (child.getAttributes().getNamedItem("lang").getNodeValue().equals("pl") && programme.getSubtitlePl() == null) {
//                        programme.setSubtitlePl(child.getTextContent());
//                    } else {
//                        log.info("Sub-title: new language code found: " + programme.getChannel() + ", " + programme.getStart() + " :: " + child.getAttributes().getNamedItem("lang").getNodeValue());
//                    }
//                }
//                if (child.getNodeName().equalsIgnoreCase("desc")) {
//                    if (child.getAttributes().getNamedItem("lang").getNodeValue().equals("pl") && programme.getDescPl() == null) {
//                        programme.setDescPl(child.getTextContent());
//                    } else {
//                        log.info("Desc: new language code found: " + programme.getChannel() + ", " + programme.getStart() + " :: " + child.getAttributes().getNamedItem("lang").getNodeValue());
//                    }
//                }
//
//                if (child.getNodeName().equalsIgnoreCase("credits")) {
//                    for (int k = 0; k < child.getChildNodes().getLength(); k++) {
//                        if (child.getChildNodes().item(k).getNodeName().equalsIgnoreCase("director")) {
//                            programme.addDirector(child.getChildNodes().item(k).getTextContent());
//                        }
//                        if (child.getChildNodes().item(k).getNodeName().equalsIgnoreCase("actor")) {
//                            programme.addActor(child.getChildNodes().item(k).getTextContent());
//                        }
//                    }
//                }
//
//                if (child.getNodeName().equalsIgnoreCase("date")) {
//                    if (NumberUtils.isDigits(child.getTextContent())) {
//                        programme.setDate(Integer.parseInt(child.getTextContent()));
//                    }
//                }
//
//                if (child.getNodeName().equalsIgnoreCase("category")) {
//                    programme.addCategoryPl(child.getTextContent());
//                }
//
//                if (child.getNodeName().equalsIgnoreCase("episode-num")) {
//
//                    if (child.getAttributes().getNamedItem("system").getNodeValue().equals("xmltv_ns")) {
//                        programme.setEpisodeXmlNs(child.getTextContent());
//                    } else if (child.getAttributes().getNamedItem("system").getNodeValue().equals("onscreen")) {
//                        programme.setEpisodeXmlNs(child.getTextContent());
//                    } else {
//                        log.info("New episode number format found: " + child.getAttributes().getNamedItem("system").getNodeValue());
//                    }
//                }
//
//                if (child.getNodeName().equalsIgnoreCase("country")) {
//                    programme.addCountry(child.getTextContent());
//                }
//            }
//
//
////
////            log.info(programme.getChannel().getName());
////            log.info(""+programme.getChannel().getId());
////            log.info(programme.getTitlePl());
////            log.info(programme.getDescPl());
////            log.info(programme.getCategoriesPl());
//
//
//            if ((programmeDao.findByChannelAndDate(programme.getChannel().getName(), programme.getStart(), programme.getStop()).isEmpty()
//                    || (programmeDao.findByChannelAndDate(programme.getChannel().getName(), programme.getStart(), programme.getStop())) == null)
//            ) {
//
//                try {
//
//                    programmeDao.save(programme);
//                } catch (javax.persistence.PersistenceException e) {
//
//                    log.error("SQL transaction error: " + e);
//                }
//            } else {
//                log.debug("PROGRAMME table::duplicate found::" + programme.getStart() +programme.getChannel());
//            }
//
//        }
//        log.info("Number of programmes in XML file: " + programmesList.getLength());
//    }
//
//
//    public void run(){}
//
//}
