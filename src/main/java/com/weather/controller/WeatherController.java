package com.weather.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.weather.services.WeatherService;
import com.weather.util.WUndergroundData;

/**
 * This WeatherController class is a controller of this app 
 *
 * @author Nikhil
 */
@Controller
public class WeatherController {
	private WeatherService weatherService;
	@Autowired
	public WeatherController(WeatherService weatherService){
		this.weatherService=weatherService;

	}
	
	/**
	 * method to handle request coming from the app
	 * @param request, response.
	 * @return ModelandView object
	 */
	@RequestMapping(method=RequestMethod.GET, value="/weather")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String zip = request.getParameter("zip");
		weatherService.retrieveForecast(zip);
		WUndergroundData weather= weatherService.getWeatherData();
		System.out.println("i am in handle request"+weather);
		if(weather.getCurrentObservation()==null){
			String errorMsg="Zip code doesn't exists";
			return new ModelAndView("error", "errorMsg", errorMsg);
		}
		else{
			return new ModelAndView("weatherPage", "weather", weather);
		}


	}

	public WeatherService getWeatherService() {
		return weatherService;
	}

	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
}
