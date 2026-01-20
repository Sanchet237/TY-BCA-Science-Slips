// WAP in Go language to create a user defined package to find out the area of a rectangle.

package main

import (
	"area"
	"fmt"
)

func main() {
	fmt.Println("Area of Rectangle:", area.Rectangle(5, 4))
}
