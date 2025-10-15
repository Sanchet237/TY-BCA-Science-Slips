# Load the built-in iris data set
data("iris")

head(iris)              # First 6 rows
tail(iris)              # Last 6 rows
str(iris)               # Structure 
summary(iris)           # Summary statistics

# Accessing Specific Columns 
print(iris$Sepal.Length)       
print(iris[, "Petal.Width"])  
print(iris[["Species"]])       

# Sub-setting Rows 
iris[1:10, ]                   
iris[iris$Species == "setosa", ]  

# Descriptive Statistics 
mean(iris$Sepal.Length)         
median(iris$Petal.Width)        
sd(iris$Sepal.Width)            
range(iris$Petal.Length)        

# Frequency Table 
table(iris$Species)             

# Correlation
cor(iris$Sepal.Length, iris$Petal.Length) 

# Sorting the Data set 
iris_sorted <- iris[order(iris$Sepal.Length), ]
head(iris_sorted)

