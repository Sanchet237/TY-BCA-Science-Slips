package main

import "fmt"

func main() {
	var n int
	fmt.Print("Enter the number: ")
	fmt.Scan(&n)
	if n >= -9 && n <= 9 {
		fmt.Println("Single Digit")
	} else {
		fmt.Println("Not Single Digit")
	}
}
