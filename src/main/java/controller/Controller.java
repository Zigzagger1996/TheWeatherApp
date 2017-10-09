package controller;
import org.jsoup.nodes.Element;
import view.*;
import model.*;

import java.io.IOException;


public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void processUser() throws IOException{
        getTemperatureInfoAsString(TextConstants.URL_FOR_PARSE, TextConstants.DIV_WTH_STRING, TextConstants.DAY_FREE_STRING,TextConstants.OTHER_DAY_IN_WEEK_STRING, TextConstants.WTH_PER_WEEK_STRING, TextConstants.DAY_FREE_STRING, TextConstants.DAY_WORK_STRING, TextConstants.MONTH_STRING, TextConstants.MIN_TEMPERATURE_STRING, TextConstants.MAX_TEMPERATURE_STRING);
    }

    private void getTemperatureInfoAsString(String urlToParse, String divWthString, String todayDayString, String otherDayInWeekString, String wthPerWeekString, String dayFreeString, String dayWorkString, String monthString, String minTemperatureString, String maxTemperatureString) throws IOException{
        for (Element name : model.getTemperatureInfoAsObject(urlToParse, divWthString, todayDayString, otherDayInWeekString, wthPerWeekString)){
            String dayFree = name.select(dayFreeString).text();
            String dayWorking = name.select(dayWorkString).text();
            String month = name.select(monthString).text();
            String minTemperature = name.select(minTemperatureString).text();
            String maxTemperature = name.select(maxTemperatureString).text();
            view.printInfoAboutTemperature(dayWorking, dayFree, month, minTemperature, maxTemperature);
        }
    }
}
