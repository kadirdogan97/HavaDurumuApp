package kodluyoruz.bootcamp.kadir.com.havadurumuapp.networks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by KadirDogan on 8/15/2017.
 */

public class Factory {
    public static ServiceGenerator serviceGenerator;

    public static ServiceGenerator getInstance() {
        if (serviceGenerator == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Contanst.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            serviceGenerator = retrofit.create(ServiceGenerator.class);
            return serviceGenerator;
        } else {
            return serviceGenerator;
        }
    }
}
