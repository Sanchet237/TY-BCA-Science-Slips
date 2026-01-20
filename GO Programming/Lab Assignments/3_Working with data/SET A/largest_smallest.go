// WAP in Go language to find the largest and smallest number in an array.

package main

import "fmt"

func main() {
	var n int
	fmt.Print("Enter size of array: ")
	fmt.Scan(&n)

	arr := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&arr[i])
	}

	max, min := arr[0], arr[0]
	for i := 1; i < n; i++ {
		if arr[i] > max {
			max = arr[i]
		}
		if arr[i] < min {
			min = arr[i]
		}
	}

	fmt.Println("Largest:", max)
	fmt.Println("Smallest:", min)
}
