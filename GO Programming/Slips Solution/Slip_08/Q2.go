/*Write a  program  in  GO language to  create an  interface shape that
includes area and perimeter. Implements these methods in circle
and rectangle type.*/

package main

import (
	"fmt"
	"math"
)

type shape interface {
	area() float64
	perimeter() float64
}

type circle struct {
	r float64
}

func (c circle) area() float64 {
	return math.Pi * c.r * c.r
}
func (c circle) perimeter() float64 {
	return 2 * math.Pi * c.r
}

type rectangle struct {
	l, b float64
}

func (r rectangle) area() float64 {
	return r.l * r.b
}
func (r rectangle) perimeter() float64 {
	return 2 * (r.l + r.b)
}

func main() {
	var r, l, b float64

	fmt.Print("Enter radius: ")
	fmt.Scan(&r)

	fmt.Print("Enter length and breadth: ")
	fmt.Scan(&l, &b)

	var s shape

	s = circle{r}
	fmt.Println("\nCircle Area:", s.area())
	fmt.Println("Circle Perimeter:", s.perimeter())

	s = rectangle{l, b}
	fmt.Println("\nRectangle Area:", s.area())
	fmt.Println("Rectangle Perimeter:", s.perimeter())
}
