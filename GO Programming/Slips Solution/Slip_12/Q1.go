//Write a program in GO language to swap two numbers using call by reference concept.

package main

import "fmt"

func swap(a *int, b *int) {
	temp := *a
	*a = *b
	*b = temp
}

func main() {
	var x, y int

	fmt.Print("Enter two numbers: ")
	fmt.Scan(&x, &y)

	fmt.Println("Before Swap:", x, y)

	swap(&x, &y)

	fmt.Println("After Swap :", x, y)
}
