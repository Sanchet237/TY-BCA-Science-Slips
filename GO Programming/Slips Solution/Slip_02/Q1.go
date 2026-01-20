//Write a program in GO language to print Fibonacci series of n terms.

package main

import "fmt"

func main() {
	var n int
	fmt.Print("Enter number of terms: ")
	fmt.Scan(&n)

	a, b := 0, 1

	fmt.Println("Fibonacci Series:")
	for i := 1; i <= n; i++ {
		fmt.Print(a, " ")
		a, b = b, a+b
	}
}
