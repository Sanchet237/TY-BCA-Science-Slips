# Factors Creation
f1 <- factor(c("Low", "Medium", "High", "Medium", "Low"))
print(f1)

# Accessing levels of a factor
print(levels(f1))

# Modifying levels of a factor
levels(f1) <- c("Low", "Medium", "High", "Very High")
print(f1)

# Adding new levels to a factor
f2 <- factor(c("A", "B", "C"), levels = c("A", "B", "C", "D"))
print(f2)

# Removing levels from a factor
f3 <- factor(c("A", "B", "C", "A"), levels = c("A", "B", "C"))
print(f3)

# Converting a factor 
f_char <- as.character(f1)
print(f_char)

f_num <- as.numeric(f1)
print(f_num)

#Convert vector into factor 
stud_name<-c("Ram","Siya","Raj","Sham","Ram","Siya","Raj","Sham") 
factor(stud_name, levels=c("Ram","Siya","Raj","Sham"),labels = c("R1","S1","R2","S2")) 

# Check if a vector is a factor
chr <- c("Red", "Blue", "Green", "Red")
is.factor(chr)       
my_factor <- as.factor(chr)
is.factor(my_factor) 

# Check if a factor is ordered
ordered_factor <- factor(c("Low", "Medium", "High"), ordered = TRUE)
print(ordered_factor)
is.ordered(ordered_factor)