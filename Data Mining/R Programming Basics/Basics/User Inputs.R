
# User Input in R


# 1. Numeric Input
n <- as.numeric(readline("Enter a number: "))
cat("You entered:", n, "\n")

# 2. String Input
s <- readline("Enter your name: ")
cat("Hello,", s, "!\n")

# 3. Numeric Vector Input
nv <- readline("Enter numbers (comma-separated): ")
nv <- as.numeric(unlist(strsplit(nv, ",")))
cat("Numeric vector:\n")
print(nv)

# 4. String Vector Input
sv <- readline("Enter words (comma-separated): ")
sv <- unlist(strsplit(sv, ","))
cat("String vector:\n")
print(sv)
