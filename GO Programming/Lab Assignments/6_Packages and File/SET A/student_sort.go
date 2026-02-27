// WAP to create student struct with student name and marks and sort it based on student marks using sort package.

package main

import (
	"fmt"
	"sort"
)

type Student struct {
	name  string
	marks int
}

func main() {
	var n int
	fmt.Print("Enter number of students: ")
	fmt.Scan(&n)

	students := make([]Student, n)
	for i := 0; i < n; i++ {
		fmt.Printf("Enter student %d name and marks: ", i+1)
		fmt.Scan(&students[i].name, &students[i].marks)
	}

	sort.Slice(students, func(i, j int) bool {
		return students[i].marks > students[j].marks
	})

	for _, s := range students {
		fmt.Printf("Name:%s Marks:%d\n", s.name, s.marks)
	}
}
