//Write a program in GO language to demonstrate function return multiple values.

package main

import "fmt"

func calc(a int, b int) (int, int, int) {
	sum := a + b
	sub := a - b
	mul := a * b
	return sum, sub, mul
}

func main() {
	var x, y int
	fmt.Print("Enter two numbers: ")
	fmt.Scan(&x, &y)

	s, d, m := calc(x, y)

	fmt.Println("Sum =", s)
	fmt.Println("Sub =", d)
	fmt.Println("Mul =", m)
}
