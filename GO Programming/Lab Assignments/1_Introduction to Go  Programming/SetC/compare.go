package main

import "fmt"

func main() {
	var a, b string
	fmt.Print("Enter two strings a and b: ")
	fmt.Scan(&a, &b)

	if a == b {
		fmt.Println("Equal")
	} else {
		fmt.Println("Not Equal")
	}
}
