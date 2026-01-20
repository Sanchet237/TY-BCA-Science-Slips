// WAP in Go language to demonstrate slice operations.

package main

import "fmt"

func main() {
	s := []int{1, 2, 3}

	s = append(s, 4)
	fmt.Println("After append:", s)

	copySlice := make([]int, len(s))
	copy(copySlice, s)
	fmt.Println("Copied slice:", copySlice)

	s = append(s[:1], s[2:]...)
	fmt.Println("After remove:", s)
}
