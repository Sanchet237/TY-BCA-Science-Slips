package main

import (
	"fmt"
	"strings"
)

func main() {
	var a, b string
	fmt.Print("Enter two strings a and b: ")
	fmt.Scan(&a, &b)
	if strings.Contains(a, b) {
		fmt.Println("Substring Found")
	} else {
		fmt.Println("Not Found")
	}
}
