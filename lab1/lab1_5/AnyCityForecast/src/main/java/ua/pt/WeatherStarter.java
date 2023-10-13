package ua.pt;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

/**
 * Tried to create logs onto a log file but couldn't make it work in the end
 */
public class WeatherStarter {

    public static void  main(String[] args ) {

        int[] citiesID = {1010500, 1020500, 1030300};
        Random rand = new Random(); 
        int cityID = rand.nextInt(citiesID.length);

        WeatherCall weatherCall = new WeatherCall();
        Logger logger = LogManager.getLogger(WeatherStarter.class);

        System.out.println(logger.isErrorEnabled());
        System.out.println(logger.isWarnEnabled());
        System.out.println(logger.isInfoEnabled());
        System.out.println(logger.isDebugEnabled());
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
