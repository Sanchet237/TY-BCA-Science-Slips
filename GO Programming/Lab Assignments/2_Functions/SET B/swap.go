// WAP in Go language to swap two numbers using call by reference concept.

package main

import "fmt"

func swap(a *int, b *int) {
	temp := *a
	*a = *b
	*b = temp
}

func main() {
	var x, y int

	fmt.Print("Enter first number: ")
	fmt.Scan(&x)

	fmt.Print("Enter second number: ")
	fmt.Scan(&y)

	swap(&x, &y)

	fmt.Println("After swapping:")
	fmt.Println("x =", x)
	fmt.Println("y =", y)
}
