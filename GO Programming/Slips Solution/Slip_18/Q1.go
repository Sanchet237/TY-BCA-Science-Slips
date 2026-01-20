//Write a program in GO language to print a multiplication table of number using function.

package main

import "fmt"

func table(n int) {
	for i := 1; i <= 10; i++ {
		fmt.Println(n, "x", i, "=", n*i)
	}
}

func main() {
	var n int
	fmt.Print("Enter number: ")
	fmt.Scan(&n)

	table(n)
}
