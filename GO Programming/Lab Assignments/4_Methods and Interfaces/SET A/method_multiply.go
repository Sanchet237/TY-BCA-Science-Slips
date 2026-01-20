// Write a program in Go language to print multiplication of two numbers using method.

package main

import "fmt"

type Numbers struct {
	a, b int
}

func (n Numbers) multiply() int {
	return n.a * n.b
}

func main() {
	var n Numbers
	fmt.Print("Enter two numbers: ")
	fmt.Scan(&n.a, &n.b)

	fmt.Println("Multiplication:", n.multiply())
}
