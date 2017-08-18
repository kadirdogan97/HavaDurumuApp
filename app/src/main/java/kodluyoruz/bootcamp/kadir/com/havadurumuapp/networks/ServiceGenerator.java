package kodluyoruz.bootcamp.kadir.com.havadurumuapp.networks;

import kodluyoruz.bootcamp.kadir.com.havadurumuapp.models.WeatherStatusModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by KadirDogan on 8/15/2017.
 */

public interface ServiceGenerator {
    @GET("/data/2.5/weather")
    Call<WeatherStatusModel> getWeatherStatus(@Query("q") String cityCountry, @Query("units") String units, @Query("APPID") String api);
}
