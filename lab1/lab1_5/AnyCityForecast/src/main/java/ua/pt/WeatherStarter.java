package ua.pt;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Toolkit;
import java.util.Random;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    public static void  main(String[] args ) {

        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);        

        // prepare the call to remote endpoint
        new MainTime();

        int[] citiesID = {1010500, 1020500, 1030300};
        Random rand = new Random(); 
        int cityID = rand.nextInt(citiesID.length);

        Call<IpmaCityForecast> callSync = service.getForecastForACity(citiesID[cityID]);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                var firstDay = forecast.getData().listIterator().next();

                System.out.printf( "City ID: %s%nMax temperature for today is %4.1f %nMin temperature is %4.1f",
                        args[0],
                        Double.parseDouble(firstDay.getTMax()),
                        Double.parseDouble(firstDay.getTMin()));
            } else {
                System.out.println( "No results for this request!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    // Periodic API weather calls

    Toolkit toolkit;

    Timer timer;

    public void MainTime(){
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(), 0, 1 * 1000);
    }

    class RemindTask extends TimerTask{
        int numWarningBeeps = 3;

        public void run(){
            if (numWarningBeeps-- > 0){
                long time = System.currentTimeMillis();
                if (time - scheduledExecutionTime() > 5){
                    return;
                }
                toolkit.beep();
                System.out.println("Beep!");
            }
            else{
                toolkit.beep();
                System.out.println("Time's up!");
                System.exit(0);
            }
        }
    }
}
