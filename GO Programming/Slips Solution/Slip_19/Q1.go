//Write  a  program  in  GO  language    to    illustrate    the    function returning multiple values(add, subtract)

package main

import "fmt"

func addSub(a, b int) (int, int) {
	add := a + b
	sub := a - b
	return add, sub
}

func main() {
	var x, y int
	fmt.Print("Enter two numbers: ")
	fmt.Scan(&x, &y)

	add, sub := addSub(x, y)

	fmt.Println("Addition =", add)
	fmt.Println("Subtraction =", sub)
}
