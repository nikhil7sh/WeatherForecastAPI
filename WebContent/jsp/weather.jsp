

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Weather Report API</title>
   </head>
<body bgcolor="#CDCDCC" font-family="cursive" font-size="20px;" font-weight="bold">



    <h2>Weather Report API </h2>
   
        <hr>
        City :: ${weather.getCurrentObservation().getDisplay_location().getCity()}<br>
        
        State :: ${weather.getCurrentObservation().getDisplay_location().getState()} <br>
        Country :: ${weather.getCurrentObservation().getDisplay_location().getCountry()} <br>
        Temperature :: ${weather.getCurrentObservation().getTempF()}<br>
        </hr>

</body>