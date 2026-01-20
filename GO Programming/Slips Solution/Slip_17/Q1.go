/*Write  a  program  in  GO  language  to  illustrate  the  concept  of
returning  multiple values  from  a  function. (  Add,  Subtract,
Multiply, Divide)*/

package main

import "fmt"

func calc(a, b float64) (float64, float64, float64, float64) {
	add := a + b
	sub := a - b
	mul := a * b
	div := a / b
	return add, sub, mul, div
}

func main() {
	var x, y float64

	fmt.Print("Enter two numbers: ")
	fmt.Scan(&x, &y)

	add, sub, mul, div := calc(x, y)

	fmt.Println("Addition =", add)
	fmt.Println("Subtraction =", sub)
	fmt.Println("Multiplication =", mul)
	fmt.Println("Division =", div)
}
