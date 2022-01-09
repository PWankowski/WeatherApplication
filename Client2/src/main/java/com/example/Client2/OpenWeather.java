package com.example.Client2;

public class OpenWeather {

    private  Main main;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}

class Main{

    private float temp;
    private int pressure;
    private int humidity;



    public float getTemp() {
        return temp;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }
}
