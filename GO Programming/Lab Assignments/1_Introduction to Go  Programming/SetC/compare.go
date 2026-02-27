package main

import "fmt"

func main() {
	var a, b string
	fmt.Print("Enter two strings a and b: ")
	fmt.Scan(&a, &b)

	if a == b {
		fmt.Println("Strings are equal")
	} else {
		fmt.Println("Strings are not equal")
	}
}
