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
	students := []Student{
		{"Amit", 78},
		{"Riya", 92},
		{"Sonal", 85},
	}

	sort.Slice(students, func(i, j int) bool {
		return students[i].marks > students[j].marks
	})

	for _, s := range students {
		fmt.Println(s.name, s.marks)
	}
}
