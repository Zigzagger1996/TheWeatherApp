package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class Model {

    private static Document getPage(String url) throws IOException {
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public Elements getTemperatureInfoAsObject(String urlToParse, String divWthString, String todayDayString, String otherDayInWeekString, String wthPerWeekString) throws IOException {
        Document page = getPage(urlToParse);
        Element divWth = page.select(divWthString).first();
        Element todayDate = divWth.select(todayDayString).first();
        Elements otherDayInWeekDate = divWth.select(otherDayInWeekString);
        Elements wthPerWeek = divWth.select(wthPerWeekString);
        return otherDayInWeekDate;
    }
}
