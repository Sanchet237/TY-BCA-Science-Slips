package main

import "fmt"

func main() {
	var a, b int
	fmt.Print("Enter two numbers (n1 n2): ")
	fmt.Scan(&a, &b)
	a = a + b
	b = a - b
	a = a - b
	fmt.Println("After swapping:", a, b)
}
