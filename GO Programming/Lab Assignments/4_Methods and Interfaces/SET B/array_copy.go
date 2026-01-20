// Write a program in Go language to copy all elements of one array into another using method.

package main

import "fmt"

type ArrayOps struct{}

func (a ArrayOps) copyArray(src []int) []int {
	dest := make([]int, len(src))
	copy(dest, src)
	return dest
}

func main() {
	src := []int{1, 2, 3, 4}
	var a ArrayOps

	dest := a.copyArray(src)
	fmt.Println("Copied Array:", dest)
}
