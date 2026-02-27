// WAP in Go language to create a user defined package to find out the area of a rectangle.

package main

import (
	"area"
	"fmt"
)

func main() {
	var l, b int
	fmt.Print("Enter length and breadth of rectangle: ")
	fmt.Scan(&l, &b)
	fmt.Println("Area of Rectangle:", area.Rectangle(l, b))
}
