// Write a program in Go language to store n student info and display in descending order of percentage.

package main

import (
	"fmt"
	"sort"
)

type Student struct {
	roll int
	name string
	per  float64
}

func main() {
	var n int
	fmt.Print("Enter number of students: ")
	fmt.Scan(&n)

	students := make([]Student, n)
	for i := 0; i < n; i++ {
		fmt.Printf("Enter student %d details (roll name percentage): ", i+1)
		fmt.Scan(&students[i].roll, &students[i].name, &students[i].per)
	}

	sort.Slice(students, func(i, j int) bool {
		return students[i].per > students[j].per
	})

	for _, s := range students {
		fmt.Printf("Roll:%d Name:%s Percentage:%.2f\n", s.roll, s.name, s.per)
	}
}
