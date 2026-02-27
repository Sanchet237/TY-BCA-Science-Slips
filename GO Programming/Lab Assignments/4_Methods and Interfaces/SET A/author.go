// Write a program in Go language to create structure author and method show().

package main

import "fmt"

type Author struct {
	name string
	book string
}

func (a Author) show() {
	fmt.Println("Author Name:", a.name)
	fmt.Println("Book:", a.book)
}

func main() {
	var a Author
	fmt.Print("Enter author name: ")
	fmt.Scan(&a.name)
	fmt.Print("Enter book title: ")
	fmt.Scan(&a.book)
	a.show()
}
