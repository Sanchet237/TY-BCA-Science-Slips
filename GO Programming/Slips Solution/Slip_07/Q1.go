// Write a program in GO language to accept one matrix and display its transpose.

package main

import "fmt"

func main() {
	var r, c int

	fmt.Print("Enter number of rows: ")
	fmt.Scan(&r)

	fmt.Print("Enter number of columns: ")
	fmt.Scan(&c)

	// Create matrix
	mat := make([][]int, r)
	for i := 0; i < r; i++ {
		mat[i] = make([]int, c)
	}

	// Input matrix
	fmt.Println("Enter matrix elements:")
	for i := 0; i < r; i++ {
		for j := 0; j < c; j++ {
			fmt.Scan(&mat[i][j])
		}
	}

	// Display original matrix
	fmt.Println("\nOriginal Matrix:")
	for i := 0; i < r; i++ {
		for j := 0; j < c; j++ {
			fmt.Print(mat[i][j], " ")
		}
		fmt.Println()
	}

	// Display transpose
	fmt.Println("\nTranspose Matrix:")
	for j := 0; j < c; j++ {
		for i := 0; i < r; i++ {
			fmt.Print(mat[i][j], " ")
		}
		fmt.Println()
	}
}
