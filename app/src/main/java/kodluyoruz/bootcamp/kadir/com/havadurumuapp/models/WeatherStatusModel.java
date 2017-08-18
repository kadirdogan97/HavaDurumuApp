package kodluyoruz.bootcamp.kadir.com.havadurumuapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by KadirDogan on 8/15/2017.
 */

public class WeatherStatusModel {

    @SerializedName("weather")
    public ArrayList<Weather> weather;

    @SerializedName("main")
    public Main main;

    @SerializedName("wind")
    public Wind wind;

    @SerializedName("name")
    public String name;


}
