import java.io.IOException;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {

    private static Document getPage() throws IOException {
        String url = "https://ua.sinoptik.ua/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }
    public static void main(String[] args) throws IOException {
        Document page = getPage();
        //css query language
        Element divWth = page.select("div[class = tabs]").first();
        Element todayDate = divWth.select("div[class = main loader]").first();
        Elements otherDayInWeekDate = divWth.select("div[class = main]");
        Elements wthPerWeek = divWth.select("div[class = temperature]");

        for (Element name : otherDayInWeekDate ) {
            String dayFree = name.select("p[class=date dateFree]").text();
            String dayWorking = name.select("p[class=date]").text();
            String month = name.select("p[class=month]").text();
            String minTemperature = name.select("div[class = min]").text();
            String maxTemperature = name.select("div[class = max]").text();
            System.out.println("Дата: " + dayWorking + dayFree + " месяц: " + month + " Температура: " + minTemperature + maxTemperature);
        }
        System.out.println("");
    }
}
