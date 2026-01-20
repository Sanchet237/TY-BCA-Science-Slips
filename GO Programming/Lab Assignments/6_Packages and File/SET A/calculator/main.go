// WAP in Go language using user defined package calculator that performs one calculator operation as per user's choice.

package main

import (
	"calculator"
	"fmt"
)

func main() {
	var a, b int
	fmt.Print("Enter two numbers: ")
	fmt.Scan(&a, &b)

	fmt.Println("Addition:", calculator.Add(a, b))
}
