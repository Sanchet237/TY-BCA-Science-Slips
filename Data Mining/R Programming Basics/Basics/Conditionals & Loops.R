# 1: if-else statement (voting age check)
age <- 17
if (age >= 18) {
  cat("You are eligible to vote.\n")
} else {
  cat("You are not eligible to vote.\n")
}

# ------------------------------------------------------------------------------------------------------------------------
# 2: if-else-if ladder (grading system)
score <- 78
if (score >= 90) {
  cat("Grade: A+\n")
} else if (score >= 75) {
  cat("Grade: A\n")
} else if (score >= 60) {
  cat("Grade: B\n")
} else {
  cat("Grade: Fail\n")
}

# ------------------------------------------------------------------------------------------------------------------------
# 3: switch statement (day name from number)
day <- "3"
day_name <- switch(day,
                   "1" = "Sunday",
                   "2" = "Monday",
                   "3" = "Tuesday",
                   "4" = "Wednesday",
                   "5" = "Thursday",
                   "6" = "Friday",
                   "7" = "Saturday",
                   "Invalid day"
)
cat("Day:", day_name, "\n")

# ------------------------------------------------------------------------------------------------------------------------
# 4: for loop (print 1 to 5)
cat("For loop:\n")
for (i in 1:5) {
  cat(i, " ")
}
cat("\n")

# ------------------------------------------------------------------------------------------------------------------------
# 5: while loop (print 1 to 5)
cat("While loop:\n")
i <- 1
while (i <= 5) {
  cat(i, " ")
  i <- i + 1
}
cat("\n")

# ------------------------------------------------------------------------------------------------------------------------
# 6: repeat loop (print 1 to 5)
cat("Repeat loop:\n")
j <- 1
repeat {
  cat(j, " ")
  j <- j + 1
  if (j > 5) {
    break
  }
}
cat("\n")

# ------------------------------------------------------------------------------------------------------------------------
# 7: even/odd check inside loop (1 to 10)
cat("Even/Odd Check from 1 to 10:\n")
for (k in 1:10) {
  if (k %% 2 == 0) {
    cat(k, "is Even\n")
  } else {
    cat(k, "is Odd\n")
  }
}

# ------------------------------------------------------------------------------------------------------------------------
# 8: factorial using for loop (no function)
num <- 5
fact <- 1
for (i in 1:num) {
  fact <- fact * i
}
cat("Factorial of", num, "is", fact, "\n")

# ------------------------------------------------------------------------------------------------------------------------
# 9: anonymous function using sapply (squares)
nums <- 1:5
squares <- sapply(nums, function(x) x^2)
cat("Squares from 1 to 5:\n"); print(squares)
