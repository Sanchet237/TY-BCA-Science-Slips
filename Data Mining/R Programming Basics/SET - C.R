#1. Write a R Program to perform the following:  

#a. Create a Scattered plot to compare wind speed and temperature. 

plot(airquality$Wind, airquality$Temp,
     main = "Wind vs Temp",
     xlab = "Wind Speed",
     ylab = "Temperature",
     col = "blue")

#b. Create a Scattered plot to show the relationship between ozone and wind values by giving appropriate values to colour argument.  
plot(airquality$Ozone, airquality$Wind,
     main = "Ozone vs Wind",
     xlab = "Ozone Level",
     ylab = "Wind Speed",
     col = ifelse(airquality$Ozone > 50, "red", "green"))

#c. Create a Bar plot to show the ozone level for all the days having temperature > 70. (Use inbuilt dataset air quality) 

barplot(oz,
        main = "Ozone Levels (Temp > 70)",
        ylab = "Ozone",
        col = "orange",
        names.arg = which(airquality$Temp > 70))