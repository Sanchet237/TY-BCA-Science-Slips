# 1: Basic function with no arguments
say_hello <- function() {
  cat("Hello Sanchet! Welcome to the world of R functions.\n")
}
say_hello()

# ------------------------------------------------------------------------------------------------------------------------
# 2: Function with one argument
greet <- function(name) {
  cat("Hello", name, "! Great to have you here.\n")
}
greet("Sanchet")
greet("Rohit")

# ------------------------------------------------------------------------------------------------------------------------
# 3: Function with multiple arguments
add_nums <- function(a, b) {
  return(a + b)
}
cat("Sum of 10 and 5:", add_nums(10, 5), "\n")

# ------------------------------------------------------------------------------------------------------------------------
# 4: Function without return (just printing inside)
multiply_nums <- function(a, b) {
  cat("Multiplication:", a * b, "\n")
}
multiply_nums(4, 6)

# ------------------------------------------------------------------------------------------------------------------------
# 5: Function with default argument values
power <- function(x, y = 2) {
  return(x^y)
}
cat("5 squared:", power(5), "\n")
cat("2 raised to 5:", power(2, 5), "\n")

# ------------------------------------------------------------------------------------------------------------------------
# 6: Function returning multiple values (as list)
math_ops <- function(x, y) {
  s <- x + y
  d <- x - y
  p <- x * y
  q <- x / y
  return(list(Sum = s, Diff = d, Prod = p, Div = q))
}
res <- math_ops(20, 5)
cat("Sum:", res$Sum, "\n")
cat("Diff:", res$Diff, "\n")
cat("Product:", res$Prod, "\n")
cat("Division:", res$Div, "\n")

# ------------------------------------------------------------------------------------------------------------------------
# 7: Recursive function – Factorial
fact <- function(n) {
  if (n == 0) return(1)
  else return(n * fact(n - 1))
}
cat("Factorial of 5:", fact(5), "\n")

# ------------------------------------------------------------------------------------------------------------------------
# 8: Function to check even or odd using if-else
check_even_odd <- function(n) {
  if (n %% 2 == 0)
    cat(n, "is Even\n")
  else
    cat(n, "is Odd\n")
}
check_even_odd(8)
check_even_odd(13)

# ------------------------------------------------------------------------------------------------------------------------
# 9: Function using a loop – Sum of N natural numbers
sum_n <- function(n) {
  s <- 0
  for (i in 1:n) {
    s <- s + i
  }
  return(s)
}
cat("Sum of first 10 natural numbers:", sum_n(10), "\n")

# ------------------------------------------------------------------------------------------------------------------------
# 10: Anonymous (lambda-like) function using `sapply`
nums <- 1:5
squares <- sapply(nums, function(x) x^2)
cat("Squares from 1 to 5:\n"); print(squares)

# ------------------------------------------------------------------------------------------------------------------------
# 11: Function with conditional return
grade <- function(marks) {
  if (marks >= 90) return("A+")
  else if (marks >= 75) return("A")
  else if (marks >= 60) return("B")
  else return("Needs Improvement")
}
cat("Grade for 85 marks:", grade(85), "\n")
cat("Grade for 50 marks:", grade(50), "\n")