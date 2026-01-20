// WAP in Go language to print addition of two numbers using function.

package main

import "fmt"

func add(a int, b int) int {
	return a + b
}

func main() {
	var x, y int

	fmt.Print("Enter first number: ")
	fmt.Scan(&x)

	fmt.Print("Enter second number: ")
	fmt.Scan(&y)

	fmt.Println("Addition is:", add(x, y))
}
