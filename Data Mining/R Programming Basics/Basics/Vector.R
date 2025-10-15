# Creation of vectors using c() function
v1 <- c(1,2,3,4,5,6,7,8,9,10) 
typeof(v1)
print(v1)

# Creation of vectors using seq() function
v2 <- seq(1, 10, by = 1)
print(v2)

# Creation of vectors using rep() function
v3 <- rep(1:10, times = 1)
print(v3)

# Using colon operator to create a vector
V3 <- 1:5 
cat('using colon', V3) 

# L integer values
v4 <- c(1L, 2L, 3L, 4L) 
typeof(v3) 

# Character Vectors 
v5 <- c('Lab', '357', 'data mining', '35') 
typeof(v5) 

# Logical Vectors
v6 <- c(TRUE, FALSE, TRUE, FALSE)
typeof(v6)

#  Combining vector in R 
v7 = c(1, 2, 3, 4) 
str = c("R", "Python", "Java", "C++")
c(v7, str)

# Arithmetic Operation on Vectors
v8 <- c(1, 2, 3, 4, 5)
v9 <- c(6, 7, 8, 9, 10)

v8-v9 # Subtraction
v8+v9 # Addition
v8*v9 # Multiplication
v8/v9 # Division
v8^v9 # Exponentiation
v8%%v9 # Modulus

# Numeric Index
names<-c("Ram","Aryan","Nisha","Siya","Radha","Gunjan")   
names[2]  
names[-4] 
names[15] 

# Duplicate Index
names[c(2,4,4,3)]

#Range Index
names[2:4]

# Sorting element of the vector: sort()
num <- c(25, 3, 18, 7, 50, 12, 3) 

# ascending order 
Asc <- sort(num) 
cat('ascending order:', Asc, '\n') 

# descending order 
Desc_num_new <- sort(num, decreasing = TRUE) 
cat('descending order:', Desc, '\n')