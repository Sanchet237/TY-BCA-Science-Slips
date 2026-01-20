// WAP in Go language to demonstrate use of named return variables.

package main

import "fmt"

func calculate(a int, b int) (sum int, diff int) {
	sum = a + b
	diff = a - b
	return
}

func main() {
	var x, y int

	fmt.Print("Enter two numbers: ")
	fmt.Scan(&x, &y)

	s, d := calculate(x, y)
	fmt.Println("Sum is:", s)
	fmt.Println("Difference is:", d)
}
