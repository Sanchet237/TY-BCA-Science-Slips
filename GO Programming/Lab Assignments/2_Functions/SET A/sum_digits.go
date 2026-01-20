// WAP in Go language to print recursive sum of digits of given number.

package main

import "fmt"

func sumDigits(n int) int {
	if n == 0 {
		return 0
	}
	return n%10 + sumDigits(n/10)
}

func main() {
	var num int

	fmt.Print("Enter number: ")
	fmt.Scan(&num)

	fmt.Println("Sum of digits is:", sumDigits(num))
}
