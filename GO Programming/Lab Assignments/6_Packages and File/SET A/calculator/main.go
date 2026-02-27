// WAP in Go language using user defined package calculator that performs one calculator operation as per user's choice.

package main

import (
	"calculator"
	"fmt"
)

func main() {
	var a, b, choice int
	fmt.Print("Enter two numbers: ")
	fmt.Scan(&a, &b)
	fmt.Print("Choose operation 1:Add 2:Sub 3:Mul 4:Div : ")
	fmt.Scan(&choice)

	switch choice {
	case 1:
		fmt.Println("Addition:", calculator.Add(a, b))
	case 2:
		fmt.Println("Subtraction:", calculator.Sub(a, b))
	case 3:
		fmt.Println("Multiplication:", calculator.Mul(a, b))
	case 4:
		if b == 0 {
			fmt.Println("Division by zero is not allowed")
			return
		}
		fmt.Println("Division:", calculator.Div(a, b))
	default:
		fmt.Println("Invalid choice")
	}
}
