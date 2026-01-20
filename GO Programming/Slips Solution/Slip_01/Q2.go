/*Write a program in GO language to accept n student details like roll_no,
stud_name,  mark1,mark2,  mark3.  Calculate  the  total  and  average  of
marks using structure.*/

package main

import "fmt"

type Student struct {
	rollNo     int
	name       string
	m1, m2, m3 int
	total      int
	avg        float64
}

func main() {
	var n int
	fmt.Print("Enter number of students: ")
	fmt.Scan(&n)

	var s [50]Student

	for i := 0; i < n; i++ {
		fmt.Printf("\nEnter Roll No: ")
		fmt.Scan(&s[i].rollNo)

		fmt.Printf("Enter Name: ")
		fmt.Scan(&s[i].name)

		fmt.Printf("Enter Mark1 Mark2 Mark3: ")
		fmt.Scan(&s[i].m1, &s[i].m2, &s[i].m3)

		s[i].total = s[i].m1 + s[i].m2 + s[i].m3
		s[i].avg = float64(s[i].total) / 3
	}

	fmt.Println("\nRollNo\tName\tTotal\tAverage")
	for i := 0; i < n; i++ {
		fmt.Printf("%d\t%s\t%d\t%.2f\n", s[i].rollNo, s[i].name, s[i].total, s[i].avg)
	}
}
