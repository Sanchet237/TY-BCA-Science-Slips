// WAP in Go language to accept student details and calculate total and average.

package main

import "fmt"

type Student struct {
	roll       int
	name       string
	m1, m2, m3 int
}

func main() {
	var s Student
	fmt.Print("Enter student details (roll name m1 m2 m3): ")
	fmt.Scan(&s.roll, &s.name, &s.m1, &s.m2, &s.m3)

	total := s.m1 + s.m2 + s.m3
	avg := total / 3

	fmt.Println("Student:", s.name, "(Roll:", s.roll, ")")
	fmt.Println("Total:", total)
	fmt.Println("Average:", avg)
}
