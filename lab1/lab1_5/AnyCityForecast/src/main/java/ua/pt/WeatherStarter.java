package ua.pt;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.lookup.Log4jLookup;

import java.util.Random;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    public static void  main(String[] args ) {

        int[] citiesID = {1010500, 1020500, 1030300};
        Random rand = new Random(); 
        int cityID = rand.nextInt(citiesID.length);

        WeatherCall weatherCall = new WeatherCall();
        Logger logger = LogManager.getLogger(Log4jLookup.class);

        while(true){
            String[] data = weatherCall.getWeather(citiesID[cityID]);
            logger.info(cityID + "," + data[0] + ", " + data[1] + "\n");

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
