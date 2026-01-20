// Write a program in GO language to check whether the accepted number is two digit or not.
package main

import "fmt"

func main() {
	var n int
	fmt.Print("Enter a number: ")
	fmt.Scan(&n)

	if n < 0 {
		n = -n
	}

	if n >= 10 && n <= 99 {
		fmt.Println("It is a two digit number")
	} else {
		fmt.Println("It is NOT a two digit number")
	}
}
