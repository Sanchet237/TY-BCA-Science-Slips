/*Write a  program  in  GO language to  create an  interface shape that
includes area and perimeter. Implements these methods in circle
and rectangle type.*/

package main

import "fmt"

type shape interface {
	area() float64
	volume() float64
}

// -------- Square (Cube) --------
type square struct {
	side float64
}

func (s square) area() float64 {
	return s.side * s.side
}
func (s square) volume() float64 {
	return s.side * s.side * s.side
}

// -------- Rectangle (Cuboid) --------
type rectangle struct {
	l, b, h float64
}

func (r rectangle) area() float64 {
	return r.l * r.b
}
func (r rectangle) volume() float64 {
	return r.l * r.b * r.h
}

func main() {
	var side, l, b, h float64

	fmt.Print("Enter side of square: ")
	fmt.Scan(&side)

	fmt.Print("Enter length breadth height of rectangle: ")
	fmt.Scan(&l, &b, &h)

	var sh shape

	sh = square{side}
	fmt.Println("\nSquare Area:", sh.area())
	fmt.Println("Square Volume:", sh.volume())

	sh = rectangle{l, b, h}
	fmt.Println("\nRectangle Area:", sh.area())
	fmt.Println("Rectangle Volume:", sh.volume())
}
