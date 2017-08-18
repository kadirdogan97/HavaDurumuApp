package kodluyoruz.bootcamp.kadir.com.havadurumuapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by KadirDogan on 8/15/2017.
 */

public class Weather {
    @SerializedName("description")
    public String description;
    @SerializedName("icon")
    public String icon;
}
