# 1: Add, multiply, divide two vectors (length ≥ 4)
v1 <- seq(10, 40, length.out = 4)
v2 <- c(20, 10, 40, 40)
cat("Sum:", v1 + v2, "\n")
cat("Sub:", v1 - v2, "\n")
cat("Mul:", v1 * v2, "\n")
cat("Div:\n"); print(v1 / v2)

# ------------------------------------------------------------------------------------------------------------------------

# 2: Multiplication table using function & loop
n <- as.integer(readline("Enter a number: "))
for (i in 1:10) {
  cat(n, "x", i, "=", n * i, "\n")
}

# ------------------------------------------------------------------------------------------------------------------------

# 3: Reverse a number and sum of digits
n <- as.integer(readline("Enter a number: "))
s <- 0; r <- 0; t <- n
while (t > 0) {
  d <- t %% 10
  r <- r * 10 + d
  s <- s + d
  t <- t %/% 10
}
cat("Reversed:", r, "\n")
cat("Sum of digits:", s, "\n")

# ------------------------------------------------------------------------------------------------------------------------

# 4: Sum of two matrices
m1 <- matrix(1:6, nrow = 2)
m2 <- matrix(7:12, nrow = 2)
cat("Matrix 1:\n"); print(m1)
cat("Matrix 2:\n"); print(m2)
cat("Sum:\n"); print(m1 + m2)

# ------------------------------------------------------------------------------------------------------------------------

# 5: Concatenate two factors
f1 <- factor(c("Red", "Blue"))
f2 <- factor(c("Green", "Yellow"))
f_cat <- factor(c(as.character(f1), as.character(f2)))
print(f_cat)

# ------------------------------------------------------------------------------------------------------------------------

# 6: Create data frame from two vectors and display duplicates
v1 <- c("John", "Peter", "Alice", "Michael", "Tom")
v2 <- c(25, 30, 22, 25, 35)
df <- data.frame(Name = v1, Age = v2)
cat("Original Data Frame:\n"); print(df)
cat("Duplicate Rows:\n"); print(df[duplicated(df), ])

# ------------------------------------------------------------------------------------------------------------------------

# 7: Create sequence 20–50, find mean (20–60), sum (51–91)
cat("Sequence 20–50:\n"); print(20:50)
cat("Mean of 20–60:", mean(20:60), "\n")
cat("Sum of 51–91:", sum(51:91), "\n")

# ------------------------------------------------------------------------------------------------------------------------

# 8: First 10 Fibonacci numbers
f <- numeric(10)
f[1] <- f[2] <- 1
for (i in 3:10) f[i] <- f[i-1] + f[i-2]
cat("Fibonacci Series:\n"); print(f)

# ------------------------------------------------------------------------------------------------------------------------

# 9: Create a data frame of 5 employees and display summary
emp <- data.frame(
  Name = c("Ram", "Sham", "Swati", "Pooja", "Arun"),
  Gender = c("M", "M", "F", "F", "M"),
  Age = c(23, 22, 25, 26, 32),
  Designation = c("Clerk", "Manager", "Executive", "CEO", "Assistant"),
  SSN = c("123-34-2346", "123-44-779", "556-24-433", "123-98-987", "679-77-576")
)
print(emp)
cat("Summary:\n"); print(summary(emp))

# ------------------------------------------------------------------------------------------------------------------------

# 10: Find max and min of a vector
nums <- c(10, 20, 30, 40, 50)
cat("Max:", max(nums), "\n")
cat("Min:", min(nums), "\n")

# ------------------------------------------------------------------------------------------------------------------------

# 11: Check if item exists in a list
lst <- list("apple", "banana", "cherry")
cat("Is 'apple' in the list? ", "apple" %in% lst, "\n")

# ------------------------------------------------------------------------------------------------------------------------

# 12: Find all elements of list2 not in list1
l1 <- list("x", "y", "z")
l2 <- list("X", "Y", "Z", "x", "y", "z")
v1 <- unlist(l1)
v2 <- unlist(l2)
res <- c()
for (i in v2) {
  if (!(i %in% v1)) {
    res <- c(res, i)
  }
}
cat("Elements in list2 but not in list1:\n"); print(res)

# ------------------------------------------------------------------------------------------------------------------------

# 13: Create a matrix and print it
cat("Matrix with numbers:\n")
m <- matrix(c(1, 2, 3, 4, 5, 6), nrow = 3, ncol = 2)
print(m)

cat("Matrix with fruits:\n")
m2 <- matrix(c("apple", "banana", "cherry", "orange"), nrow = 2, ncol = 2)
print(m2)

# ------------------------------------------------------------------------------------------------------------------------

# 14: Create a factor and print its levels
g <- factor(c("Jazz", "Rock", "Classic", "Classic", "Pop", "Jazz", "Rock", "Jazz"))
cat("Factor:\n"); print(g)
cat("Levels:\n"); print(levels(g))

# ------------------------------------------------------------------------------------------------------------------------

# 15: Create a data frame and display employee details
emp2 <- data.frame(
  Name = c("Anastasia S", "Dima R", "Katherine S", "James A", "Amrish M R"),
  Gender = c("M", "M", "F", "F", "M"),
  Age = c(23, 22, 25, 26, 21),
  Designation = c("Clerk", "Manager", "Executive", "CEO", "Assistant"),
  SSN = c("123-34-2346", "123-44-779", "556-24-433", "123-98-987", "679-77-576")
)
print(emp2)
