//Write a program in GO language to print a recursive sum of digits of a given number.

package main

import (
	"fmt"
)

func recursiveSum(n int) int {
	if n == 0 {
		return 0
	}
	return n%10 + recursiveSum(n/10)
}

func main() {
	var num int
	fmt.Print("Enter a number: ")
	fmt.Scanln(&num)

	fmt.Printf("Sum of digits: %d\n", recursiveSum(num))
}
