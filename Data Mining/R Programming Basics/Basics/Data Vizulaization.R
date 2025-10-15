
# ( Data Visualization )

data(mtcars)

# 1. Scatter plot 
input <- mtcars[, c('wt', 'mpg')]
plot(x = input$wt, y = input$mpg,
     xlab = "Weight",
     ylab = "Mileage",
     xlim = c(2.5, 5),
     ylim = c(15, 30),
     main = "Weight vs Mileage")


# 2. Pie Chart

Cities <- c("New York", "Los Angeles", "Chicago", "Houston", "Phoenix",
            "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose")
Population <- c(8.60, 4.06, 2.68, 2.40, 2.71, 1.58, 1.57, 1.45, 1.40, 1.03)

# Percentage calculation 
pct <- round(100 * Population / sum(Population))

pie(Population,
    labels = paste(Cities, pct, "%"),
    col = rainbow(length(Population)),
    main = "Most Populous US Cities in 2019 (in millions)")


# 3. Bar Plot 
IB <- data.frame(Browser = c("Chrome", "Firefox", "Edge", "Safari"),
                 Users = c(1200, 500, 300, 200))

barplot(height = IB$Users,
        main = "2018 Internet Browser Users (in million)",
        xlab = "Internet Browser",
        ylab = "Users",
        names.arg = IB$Browser,
        border = "dark blue",
        col = "pink")

