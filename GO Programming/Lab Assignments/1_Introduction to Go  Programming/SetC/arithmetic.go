package main

import "fmt"

func main() {
	var a, b, choice int
	fmt.Print("Enter two numbers (a b): ")
	fmt.Scan(&a, &b)
	fmt.Print("Choose operation 1:Add 2:Sub 3:Mul 4:Div : ")
	fmt.Scan(&choice)

	switch choice {
	case 1:
		fmt.Println("Addition:", a+b)
	case 2:
		fmt.Println("Subtraction:", a-b)
	case 3:
		fmt.Println("Multiplication:", a*b)
	case 4:
		fmt.Println("Division:", a/b)
	default:
		fmt.Println("Invalid choice")
	}
}
