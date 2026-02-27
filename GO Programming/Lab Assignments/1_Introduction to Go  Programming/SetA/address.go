package main

import "fmt"

func main() {
	var a int = 10
	fmt.Println("Demonstrating address-of operator on variable a")
	fmt.Printf("Value of a: %d\n", a)
	fmt.Printf("Address of a: %p\n", &a)
}
