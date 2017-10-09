package controller;
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
        model.getTemperatureInfo(TextConstants.URL_FOR_PARSE, TextConstants.DIV_WTH_STRING, TextConstants.DAY_FREE_STRING,TextConstants.OTHER_DAY_IN_WEEK_STRING, TextConstants.WTH_PER_WEEK_STRING, TextConstants.DAY_FREE_STRING, TextConstants.DAY_WORK_STRING, TextConstants.MONTH_STRING, TextConstants.MIN_TEMPERATURE_STRING, TextConstants.MAX_TEMPERATURE_STRING);
    }

}
