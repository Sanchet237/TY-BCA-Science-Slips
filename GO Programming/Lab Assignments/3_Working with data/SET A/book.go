// WAP in Go language to accept book details and display n books.

package main

import "fmt"

type Book struct {
	id     int
	title  string
	author string
	price  float64
}

func main() {
	var n int
	fmt.Print("Enter number of books: ")
	fmt.Scan(&n)

	books := make([]Book, n)

	for i := 0; i < n; i++ {
		fmt.Printf("Enter book %d details (id title author price): ", i+1)
		fmt.Scan(&books[i].id, &books[i].title, &books[i].author, &books[i].price)
	}

	for _, b := range books {
		fmt.Printf("Book -> ID:%d Title:%s Author:%s Price:%.2f\n", b.id, b.title, b.author, b.price)
	}
}
