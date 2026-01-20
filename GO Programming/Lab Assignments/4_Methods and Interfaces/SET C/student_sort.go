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
	students := []Student{
		{1, "A", 75.5},
		{2, "B", 82.3},
		{3, "C", 68.0},
	}

	sort.Slice(students, func(i, j int) bool {
		return students[i].per > students[j].per
	})

	for _, s := range students {
		fmt.Println(s.roll, s.name, s.per)
	}
}
