package com.weather.util;


/**
* This CurrentObservation class which will give information of current forecast will mapped to the retrieved json object.
*
* @author Nikhil
*/

public class CurrentObservation {
	private String weather;
	private double temp_f;
	private double wind_mph;
	private Location display_location;
	private Location observation_location;
	/**
	 * 
	 * @return
	 */
	public Location getDisplay_location() {
		return display_location;
	}
	public String getWeather() {return weather;	}
	public double getTempF() {	return temp_f;	}
	public double getWindMph() {return wind_mph;}
	public Location getObservation_location() {
		return observation_location;
	}
	public void setObservation_location(Location observation_location) {
		this.observation_location = observation_location;
	}
}
