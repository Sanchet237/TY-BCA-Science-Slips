//Write a program in GO language to create a user defined package to find out the area of a rectangle.

package main

import (
	"fmt"
	"rect/rect"
)

func main() {
	var l, b float64

	fmt.Print("Enter length: ")
	fmt.Scan(&l)

	fmt.Print("Enter breadth: ")
	fmt.Scan(&b)

	fmt.Println("Area of Rectangle =", rect.Area(l, b))
}
