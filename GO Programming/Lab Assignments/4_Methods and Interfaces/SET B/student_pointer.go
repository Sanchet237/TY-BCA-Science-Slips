// Write a program in Go language to create structure student.
// Write a method show() whose receiver is pointer of struct student.

package main

import "fmt"

type Student struct {
	roll int
	name string
}

func (s *Student) show() {
	fmt.Println("Roll No:", s.roll)
	fmt.Println("Name:", s.name)
}

func main() {
	s := Student{1, "Amit"}
	s.show()
}
