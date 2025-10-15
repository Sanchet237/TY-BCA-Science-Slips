# Matrix Creation

# Creating a 2x3 matrix
m1 <- matrix(1:6, nrow = 2, ncol = 3)
print(m1)

# Creating a 3x2 matrix
m2 <- matrix(1:6, nrow = 3, ncol = 2)
print(m2)

# Accessing elements in a matrix
print(m1[1, 2]) 
print(m2[2, 1])

# Modifying elements in a matrix
m1[1, 1] <- 100
print(m1)

# Adding rows and columns to a matrix
m3 <- rbind(m1, c(7, 8, 9))
print(m3)
m4 <- cbind(m2, c(7, 8, 9))
print(m4)

# Removing rows and columns from a matrix
m5 <- m3[-1, ]  # Remove first row
print(m5)
m6 <- m4[, -2]  # Remove second column
print(m6)

# Converting a matrix to a vector
m_vector <- as.vector(m1)
print(m_vector)

# Merging matrices
m7 <- matrix(1:6, nrow = 2, ncol = 3)
m8 <- matrix(7:12, nrow = 2, ncol = 3)
merged_matrix <- rbind(m7, m8)
print(merged_matrix)

# Matrix Computations

m9 <- matrix(1:4, nrow = 2, ncol = 2)
m10 <- matrix(5:8, nrow = 2, ncol = 2)

print(m9 + m10)
print(m9 - m10)
print(m9 * m10) 
print(m9 / m10)