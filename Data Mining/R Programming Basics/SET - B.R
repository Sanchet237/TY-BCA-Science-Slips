# 1. Write a R program to reverse a number and also calculate the sum of digits of that number.  

n <- as.integer(readline("Enter a number: "))
tmp <- n; rev <- 0; s <- 0
while (tmp > 0) {
  d <- tmp %% 10
  rev <- rev * 10 + d
  s <- s + d
  tmp <- tmp %/% 10
}
cat("Reversed:", rev, "\nSum of digits:", s, "\n\n")

# ------------------------------------------------------------------------------------------------------------------------
# 2.Write a R program to calculate the sum of two matrices of given size.  

r <- as.integer(readline("Enter rows: "))
c <- as.integer(readline("Enter cols: "))

cat("Enter elements of Matrix 1:\n")
m1 <- matrix(scan(n = r * c), nrow = r, ncol = c)
cat("Enter elements of Matrix 2:\n")
m2 <- matrix(scan(n = r * c), nrow = r, ncol = c)

cat("Matrix 1:\n"); print(m1)
cat("Matrix 2:\n"); print(m2)
cat("Sum:\n"); print(m1 + m2)

# ------------------------------------------------------------------------------------------------------------------------
# 3.Write a R program to concatenate two given factors.

f1 <- factor(c("Red", "Green", "Blue"))
f2 <- factor(c("Yellow", "Black"))
cat("Concatenated Factors:\n"); print(c(f1, f2))

# ------------------------------------------------------------------------------------------------------------------------
# 4. Write a R program to create a data frame using two given vectors and display the duplicate elements 

nms <- c("Ram", "Shyam", "Sita", "Ram")
ag <- c(21, 22, 23, 21)
df <- data.frame(Name = nms, Age = ag)
cat("Data Frame:\n"); print(df)
cat("Duplicate Rows:\n"); print(df[duplicated(df), ])

# ------------------------------------------------------------------------------------------------------------------------
# 5. Write a R program to perform the following:  
    #a. Display all rows of the data set having weight greater than 120.  
    #b. Display all rows of data set in ascending order of weight.  (Use inbuilt data set woman)  

data(women)
cat("Rows with weight > 120:\n")
print(women[women$weight > 120, ])

cat("Rows sorted by weight:\n")
print(women[order(women$weight), ])

# ------------------------------------------------------------------------------------------------------------------------
# 6. Write a R program to perform the following:  
      #a. Display all the cars having mpg more than 20.  
      #b. Subset the data set by mpg column for values greater than 15.0  
      #c. Display all cars having four gears.  (Use inbuilt data set mtcar)  

data(mtcars)

cat("Cars with mpg > 20:\n")
print(mtcars[mtcars$mpg > 20, ])

cat("Subset with mpg > 15:\n")
print(subset(mtcars, mpg > 15))

cat("Cars with 4 gears:\n")
print(mtcars[mtcars$gear == 4, ])
