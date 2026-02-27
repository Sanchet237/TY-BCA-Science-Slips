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
	var s Student
	fmt.Print("Enter student roll and name: ")
	fmt.Scan(&s.roll, &s.name)
	s.show()
}
