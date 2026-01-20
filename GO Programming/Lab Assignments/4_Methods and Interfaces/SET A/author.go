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
	a := Author{"Chetan", "Go Basics"}
	a.show()
}
