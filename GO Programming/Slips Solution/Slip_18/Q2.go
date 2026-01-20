/*Write  a  program  in  GO  language  using  a  user  defined  package
calculator that performs one calculator operation as per the user's
choice.*/

package main

import (
	"calculator/calculator"
	"fmt"
)

func main() {
	var a, b, ch int

	fmt.Print("Enter two numbers: ")
	fmt.Scan(&a, &b)

	fmt.Println("\n1.Add  2.Sub  3.Mul  4.Div")
	fmt.Print("Enter choice: ")
	fmt.Scan(&ch)

	switch ch {
	case 1:
		fmt.Println("Result =", calculator.Add(a, b))
	case 2:
		fmt.Println("Result =", calculator.Sub(a, b))
	case 3:
		fmt.Println("Result =", calculator.Mul(a, b))
	case 4:
		fmt.Println("Result =", calculator.Div(a, b))
	default:
		fmt.Println("Invalid choice")
	}
}
