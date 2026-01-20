/*Write a program in GO language to accept the book details such
as BookID, Title, Author, Price. Read and display the details of
‘n’  number of books*/

package main

import "fmt"

type book struct {
	bookID int
	title  string
	author string
	price  float64
}

func main() {
	var n int
	fmt.Print("Enter the number of books to input: ")
	fmt.Scan(&n)

	books := make([]book, n)

	for i := 0; i < n; i++ {
		fmt.Printf("Enter details for book %d:\n", i+1)

		fmt.Print("Book ID: ")
		fmt.Scan(&books[i].bookID)

		fmt.Print("Title: ")
		fmt.Scan(&books[i].title)

		fmt.Print("Author: ")
		fmt.Scan(&books[i].author)

		fmt.Print("Price: ")
		fmt.Scan(&books[i].price)

		fmt.Println()
	}

	fmt.Println("Details for each book:")
	for i := 0; i < n; i++ {
		fmt.Printf("Book ID: %d\n", books[i].bookID)
		fmt.Printf("Title: %s\n", books[i].title)
		fmt.Printf("Author: %s\n", books[i].author)
		fmt.Printf("Price: %.2f\n", books[i].price)
		fmt.Println()
	}
}
