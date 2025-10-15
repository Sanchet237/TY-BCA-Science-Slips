#  Array Creation

# Creating a 1D array
a1 <- array(1:10, dim = c(10))
print(a1)

# Creating a 2D array
a2 <- array(1:12, dim = c(3, 4))
print(a2)

# Creating a 3D array
a3 <- array(1:24, dim = c(2, 3, 4))
print(a3)

# Accessing elements in an array
print(a2[2, 3]) 
print(a3[1, 2, 3])

# Modifying elements in an array
a2[1, 1] <- 100
print(a2)

# Adding dimensions to an array
a4 <- array(1:24, dim = c(2, 3, 4))
print(a4)

# Removing dimensions from an array
a5 <- a4[,,1]
print(a5)

# Converting an array to a vector
a_vector <- as.vector(a2)
print(a_vector)

# Merging arrays
a6 <- array(1:12, dim = c(3, 4))
a7 <- array(13:24, dim = c(3, 4))
merged_array <- abind::abind(a6, a7, along = 3)
print(merged_array)