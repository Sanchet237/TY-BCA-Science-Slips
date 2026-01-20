//Write a program in GO language to demonstrate working of slices (like append, remove, copy etc.)

package main

import "fmt"

func main() {
	// Create slice using make()
	s := make([]int, 3)
	s[0], s[1], s[2] = 1, 2, 3
	fmt.Println("Slice s:", s)

	// Append one value
	s = append(s, 4)
	fmt.Println("After append 4:", s)

	// Append another slice
	t := []int{5, 6}
	s = append(s, t...)
	fmt.Println("After append slice {5,6}:", s)

	// Copy part of slice into new slice
	c := make([]int, 3)
	copy(c, s[2:5])
	fmt.Println("Copied slice c (from s[2:5]):", c)

	// Remove first element
	s = s[1:]
	fmt.Println("After removing first element:", s)

	// Remove last element
	s = s[:len(s)-1]
	fmt.Println("After removing last element:", s)

	// Update element
	s[1] = 99
	fmt.Println("After updating index 1 to 99:", s)

	// Print length and capacity
	fmt.Println("Length:", len(s))
	fmt.Println("Capacity:", cap(s))
}
