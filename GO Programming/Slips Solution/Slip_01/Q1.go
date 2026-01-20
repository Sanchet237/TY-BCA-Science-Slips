//Write a program in GO language to accept user choice and print answers using arithmetic operators.

package main

import "fmt"

func main() {
	var a, b, ch int

	fmt.Print("Enter a: ")
	fmt.Scan(&a)
	fmt.Print("Enter b: ")
	fmt.Scan(&b)

	fmt.Print("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\nEnter your choice: ")
	fmt.Scan(&ch)

	switch ch {
	case 1:
		fmt.Printf("Addition = %d\n", a+b)
	case 2:
		fmt.Printf("Subtraction = %d\n", a-b)
	case 3:
		fmt.Printf("Multiplication = %d\n", a*b)
	case 4:
		if b == 0 {
			fmt.Println("Division by zero not allowed\n")
		} else {
			fmt.Printf("Division = %d\n", a/b)
		}
	default:
		fmt.Println("Invalid choice\n")
	}
}
