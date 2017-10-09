package view;

public class View {



    public void printMessage(String message){
        System.out.println(message);
    }
    public void printInfoAboutTemperature(String dayWorking, String dayFree, String month, String minTemperature, String maxTemperature){
        System.out.println("Дата: " + dayWorking + dayFree + " месяц: " + month + " Температура: " + minTemperature + maxTemperature);
    }

}
