<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<style type="text/css">
* {
	font-family: cursive;
}
</style>
<script type="text/javascript">
            function validate()
            {
                var a = document.getElementById("zip");
                
var c = document.getElementById("zip").value;

                var valid = true;
                if(a.value.length<=0)
                    {
                        alert("Don't leave the field empty!");
                        valid = false;
                    }
                    else if(a.value.length >5 || a.value.length < 5){
                    if(isNaN(c)){
                            alert("Enter a number");
                    valid = false;} else{
                     alert("zip code should be 5 digits!");
                        valid = false;
                        }
                    }
                    else{
                        if(isNaN(c)){
                            alert("Enter a number");
                    valid = false;}
                }
                return valid;
            };

        </script>
</head>
<body bgcolor="#CDCDCC" font-family="cursive" font-size="20px;"
	font-weight="bold">



	<h2>Weather Report APP</h2>
	<form action="weather" onsubmit="return validate();">
		<hr />
		Zip Code <input type="text" name="zip" id="zip" /><br /> <input
			type="submit" value="Submit" />


	</form>


</body>