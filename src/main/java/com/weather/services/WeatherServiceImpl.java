package com.weather.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.google.gson.Gson;
import com.weather.util.CurrentObservation;
import com.weather.util.WUndergroundData;

/**
 * This WeatherServiceImpl implementation of WeatherService class is use to retrieve weather forecast
 *
 * @author Nikhil
 */
public class WeatherServiceImpl implements WeatherService {
	private static final Gson gson = new Gson();
	private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);
	private WUndergroundData wUndergroundData; 

	/**
	 * method to return current WeatherForecast
	 * @param zip code.
	 */
	public void retrieveForecast(String zip){
		Properties props = new Properties();
		URL url = ClassLoader.getSystemResource("config.properties");
		try {
			props.load(url.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fullQuery =props.getProperty("wundergroundApi.URL")+props.getProperty("wundergroundApi.key")+"/conditions/q/"+zip+".json";
		InputStream source = retrieveStream(fullQuery);
		Reader reader = new InputStreamReader(source);
		WUndergroundData weatherData = gson.fromJson(reader, WUndergroundData.class);
		CurrentObservation obs = weatherData.getCurrentObservation();
		System.out.println("Got weather for 94117"  + ": " + obs.getTempF() + " and " + obs.getWeather()+ "location:"+obs.getDisplay_location().getCity());
		this.wUndergroundData = weatherData;
	}
	
	/**
	 * method to return Wunderground data object.
	 * @return WUndergroundData object.
	 */
	public WUndergroundData getWeatherData(){
		return wUndergroundData;
	}
	
	/**
	 * Helper method to retrieve data in the form of json from Wunderground url.
	 * @return InputStream.
	 */
	private static InputStream retrieveStream(String url) {
		HttpClient client = HttpClientBuilder.create().build(); 
		HttpGet getRequest = new HttpGet(url);
		try {
			HttpResponse getResponse = client.execute(getRequest);
			final int statusCode = getResponse.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {

				logger.info("Error " + statusCode
						+ " for URL " + url);
				return null;
			}
			HttpEntity getResponseEntity = getResponse.getEntity();
			return getResponseEntity.getContent();
		}
		catch (IOException e) {
			getRequest.abort();
			logger.info("Error for URL " + url+e);

		}
		return null;
	}
}

