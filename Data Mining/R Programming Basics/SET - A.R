# 1.Write a R program to add, multiply and divide two vectors of integer type.
v1 <- c(2, 4, 6, 8)
v2 <- c(1, 3, 5, 7)

print(v1 + v2)  
print(v1 * v2)  
print(v1 / v2)





# ------------------------------------------------------------------------------------------------------------------------
# 2.Write a R program to calculate the multiplication table using a function.  

print_table <- function(num) {
  cat("Multiplication Table of", num, ":\n")
  for (i in 1:10) {
    cat(num, "x", i, "=", num * i, "\n")
  }
}

n <- as.integer(readline(prompt = "Enter a number: "))
print_table(n)

# ------------------------------------------------------------------------------------------------------------------------
# 3.Write a R program to sort a list of strings in ascending and descending order.

s <- c("Mango", "Apple", "Banana", "Orange", "Grapes")

a <- sort(s)
cat("Ascending Order:\n")
print(a)

d <- sort(s, decreasing = TRUE)
cat("Descending Order:\n")
print(d)

# ------------------------------------------------------------------------------------------------------------------------
# 4. Write a script in R to create a list of employees and perform the following: 

emp <- list("Amit", "Vaishnassvi", "Khusboo", "Priya", "Sanchet")

#a. Display names of employees in the list. 
cat("Employee Names:\n")
print(emp)

#b. Add an employee at the end of the list. 
emp <- c(emp, "Rahul")
cat("After Adding an Employee:\n")
print(emp)

#c. Remove the third element of the list. 
emp <- emp[-3]
cat("After Removing the Third Employee:\n")
print(emp)
