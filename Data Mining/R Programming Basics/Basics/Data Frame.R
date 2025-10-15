# Data Frame Creation

df <- data.frame(
  Name = c("Ram", "Sham", "Raj"),
  Age = c(25, 30, 28),
  Score = c(90, 85, 88)
)

print(df)

# Accessing elements in a data frame
print(df$Name)
print(df[1, 2])
print(df[2, "Score"])

# Modifying elements in a data frame
df$Age[1] <- 26
df$Score[2] <- 90
print(df)

# Adding rows and columns to a data frame
df <- rbind(df, data.frame(Name = "Nisha", Age = 27, Score = 92))
print(df)
df$City <- c("Delhi", "Mumbai", "Kolkata", "Chennai")
print(df)

# Removing rows and columns from a data frame
df <- df[-1, ] 
print(df)
df$City <- NULL
print(df)

# Converting a data frame to a matrix
df_matrix <- as.matrix(df)
print(df_matrix)

# Merging data frames
df1 <- data.frame(Name = c("Ram", "Sham"), Age = c(25, 30), Score = c(90, 85))
df2 <- data.frame(Name = c("Raj", "Nisha"), Age = c(28, 27), Score = c(88, 92))
merged_df <- rbind(df1, df2)
print(merged_df)