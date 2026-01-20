package main

import "fmt"

func main() {
	var a, b string
	fmt.Print("Enter two strings a and b: ")
	fmt.Scan(&a, &b)
	pa := &a
	pb := &b
	fmt.Println(*pa + *pb)
}
