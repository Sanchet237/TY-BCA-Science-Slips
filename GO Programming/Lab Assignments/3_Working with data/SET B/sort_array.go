// WAP in Go language to sort array in ascending order.

package main

import "fmt"

func main() {
	arr := []int{5, 2, 9, 1}
	fmt.Println("Original array:", arr)

	for i := 0; i < len(arr); i++ {
		for j := i + 1; j < len(arr); j++ {
			if arr[i] > arr[j] {
				arr[i], arr[j] = arr[j], arr[i]
			}
		}
	}

	fmt.Println("Sorted array:", arr)
}
