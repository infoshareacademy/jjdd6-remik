package com.infoshare.jjdd6.moviespotter.servlets;

import com.infoshare.jjdd6.moviespotter.dao.ChannelDao;
import com.infoshare.jjdd6.moviespotter.freemarker.TemplateProvider;
import com.infoshare.jjdd6.moviespotter.models.Channel;
import com.infoshare.jjdd6.moviespotter.models.ChannelStatUnit;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet("/programme/stats")
public class StatsServlet extends HttpServlet {

    @Inject
    ChannelDao channelDao;

    @Inject
    private TemplateProvider templateProvider;

    private static final Logger log = LoggerFactory.getLogger(StatsServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Channel> channels = channelDao.findAll();

        Map<String, Object> model = new HashMap<>();
        List <ChannelStatUnit> stats = new ArrayList<>();

        int allChannelsCount = channels.size();

        Integer totalClicks = channels
                .stream()
                .map(a -> a.getDisplayCounter())
                .reduce((a, b) -> a + b)
                .orElse(0);

        log.info("totalClicks: "+totalClicks);


        List<Channel> channelsClicked = channels
                .stream()
                .filter(a -> a.getDisplayCounter() > 0)
                .sorted(Comparator.comparing(Channel::getDisplayCounter))
                .collect(Collectors.toList());

        int tmp = 0;
        ChannelStatUnit others = new ChannelStatUnit();
        others.setName("Pozostałe");
        int othersTmp =0;

        for (Channel c : channelsClicked) {

            if (tmp < 10) {

                ChannelStatUnit channelStatUnit = new ChannelStatUnit();
                channelStatUnit.setName(c.getName());
                channelStatUnit.setClickCounterPercentage(countPercentage(totalClicks, c.getDisplayCounter()));
                stats.add(channelStatUnit);

            } else {
                othersTmp+=c.getDisplayCounter();
            }
            tmp++;
        }


        if (tmp >= 10) {

            others.setClickCounterPercentage(countPercentage(totalClicks, othersTmp));
            stats.add(others);
        }

        model.put("Channels", stats);

        Template template = templateProvider.getTemplate(getServletContext(), "stats.ftlh");

        log.info("using freemarker template: " + template.getName());

        try {
            template.process(model, response.getWriter());
        } catch (TemplateException e) {
            log.error("Error processing template: " + e);
        }

    }


    private String countPercentage(Integer total, Integer part) {

        Locale locale  = new Locale("en", "UK");
        String pattern = "###.##";

        DecimalFormat decimalFormat = (DecimalFormat)
                NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);

        String format = decimalFormat.format(
                (((double) part * 100) / total )
        );

        return format;
    }

}
