/*Write a program in GO language to create structure student. Write a
method show() whose receiver is a pointer of struct student.*/

package main

import "fmt"

type Student struct {
	rollNo int
	name   string
	marks  float64
}

func (s *Student) show() {
	fmt.Println("----- Student Details -----")
	fmt.Println("Roll No :", s.rollNo)
	fmt.Println("Name    :", s.name)
	fmt.Println("Marks   :", s.marks)
}

func main() {
	var s Student

	fmt.Print("Enter Roll No: ")
	fmt.Scan(&s.rollNo)

	fmt.Print("Enter Name: ")
	fmt.Scan(&s.name)

	fmt.Print("Enter Marks: ")
	fmt.Scan(&s.marks)

	s.show()
}
