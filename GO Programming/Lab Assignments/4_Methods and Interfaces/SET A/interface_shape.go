/* Write a program in Go language to create an interface shape with area and perimeter.
Implement these methods for circle and rectangle.*/

package main

import (
	"fmt"
	"math"
)

type Shape interface {
	area() float64
	perimeter() float64
}

type Circle struct {
	r float64
}

func (c Circle) area() float64 {
	return math.Pi * c.r * c.r
}

func (c Circle) perimeter() float64 {
	return 2 * math.Pi * c.r
}

type Rectangle struct {
	l, b float64
}

func (r Rectangle) area() float64 {
	return r.l * r.b
}

func (r Rectangle) perimeter() float64 {
	return 2 * (r.l + r.b)
}

func main() {
	c := Circle{5}
	r := Rectangle{4, 6}

	fmt.Println("Circle Area:", c.area())
	fmt.Println("Circle Perimeter:", c.perimeter())

	fmt.Println("Rectangle Area:", r.area())
	fmt.Println("Rectangle Perimeter:", r.perimeter())
}
