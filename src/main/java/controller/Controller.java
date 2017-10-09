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
        TextConstants textConstants = new TextConstants();
        model.getTemperatureInfo(textConstants.URL_FOR_PARSE, textConstants.DIV_WTH_STRING, textConstants.DAY_FREE_STRING,textConstants.OTHER_DAY_IN_WEEK_STRING, textConstants.WTH_PER_WEEK_STRING, textConstants.DAY_FREE_STRING, textConstants.DAY_WORK_STRING, textConstants.MONTH_STRING, textConstants.MIN_TEMPERATURE_STRING, textConstants.MAX_TEMPERATURE_STRING);
    }

}
