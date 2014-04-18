package com.weather.services;

import com.weather.util.WUndergroundData;
/**
 * This WeatherService interface
 *
 * @author Nikhil
 */
public interface WeatherService {
	public void retrieveForecast(String zip);
	public WUndergroundData getWeatherData();
	
}
