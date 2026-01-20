package main

import "fmt"

func main() {
	var a, b int
	print("Enter n1 and n2 :")
	fmt.Scan(&a, &b)
	a = a + b
	b = a - b
	a = a - b
	fmt.Println(a, b)
}
