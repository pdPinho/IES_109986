package ua.pt;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherCall {
    static int CITYID;

    public String[] getWeather(int cityID){
        CITYID = cityID;


        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);

        Call<IpmaCityForecast> callSync = service.getForecastForACity(CITYID);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null){
            CityForecast firstDay = forecast.getData().listIterator().next();

            String[] data = {firstDay.getTMax(), firstDay.getTMin()};
            return data;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null; // bad PDS practice to return NULL
        
    }
}
