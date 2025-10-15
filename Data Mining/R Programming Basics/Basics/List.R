#  Create a list
my_list <- list(name = "sanchet", age = 30, scores = c(90, 85, 88), is_student = FALSE)
print(my_list)

#Giving a name to list elements 
list_data <- list(c("Ram","Sham","Raj"), matrix(c(40,80,60,70,90,80), nrow = 2),list("BCA","MCA","BSc"))
print(list_data)

# Accessing elements in a list
print(my_list$name)  
print(my_list[[2]])  
print(my_list$scores[1])  

# Modifying elements in a list
my_list$age <- 31
my_list$scores[2] <- 90
print(my_list)

# Adding elements to a list
my_list$city <- "New York"
print(my_list)

# Removing elements from a list
my_list$is_student <- NULL
print(my_list)

# Converting list to vector
my_vector <- unlist(my_list)
print(my_vector)

# Merge lists
lst1 <- list(name = "sancte", age = 30, scores = c(90, 85, 88), is_student = FALSE)
lst2 <- list(c("Ram","Sham","Raj"), matrix(c(40,80,60,70,90,80), nrow = 2), list("BCA","MCA","BSc"))

merged_list <- c(lst1, lst2)
print(merged_list)