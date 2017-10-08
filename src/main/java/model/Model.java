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

    public void getTemperatureInfo(String urlToParse, String divWthString, String todayDayString, String otherDayInWeekString, String wthPerWeekString, String dayFreeString, String dayWorkString, String monthString, String minTemperatureString, String maxTemperatureString) throws IOException {
        Document page = getPage(urlToParse);
        Element divWth = page.select(divWthString).first();
        Element todayDate = divWth.select(todayDayString).first();
        Elements otherDayInWeekDate = divWth.select(otherDayInWeekString);
        Elements wthPerWeek = divWth.select(wthPerWeekString);

        for (Element name : otherDayInWeekDate ) {
            String dayFree = name.select(dayFreeString).text();
            String dayWorking = name.select(dayWorkString).text();
            String month = name.select(monthString).text();
            String minTemperature = name.select(minTemperatureString).text();
            String maxTemperature = name.select(maxTemperatureString).text();
            System.out.println("Дата: " + dayWorking + dayFree + " месяц: " + month + " Температура: " + minTemperature + maxTemperature);
        }
    }
}
