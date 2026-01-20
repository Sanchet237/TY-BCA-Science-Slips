// Write a program in GO language to accept two matrices and display its multiplication.

package main

import "fmt"

func main() {
	var r1, c1, r2, c2 int

	fmt.Print("Enter rows and columns of first matrix: ")
	fmt.Scan(&r1, &c1)

	fmt.Print("Enter rows and columns of second matrix: ")
	fmt.Scan(&r2, &c2)

	// Condition for multiplication
	if c1 != r2 {
		fmt.Println("Matrix multiplication not possible (columns of first must equal rows of second).")
		return
	}

	// Declare matrices
	A := make([][]int, r1)
	B := make([][]int, r2)
	C := make([][]int, r1)

	for i := 0; i < r1; i++ {
		A[i] = make([]int, c1)
		C[i] = make([]int, c2)
	}

	for i := 0; i < r2; i++ {
		B[i] = make([]int, c2)
	}

	// Accept first matrix
	fmt.Println("\nEnter elements of first matrix:")
	for i := 0; i < r1; i++ {
		for j := 0; j < c1; j++ {
			fmt.Scan(&A[i][j])
		}
	}

	// Accept second matrix
	fmt.Println("\nEnter elements of second matrix:")
	for i := 0; i < r2; i++ {
		for j := 0; j < c2; j++ {
			fmt.Scan(&B[i][j])
		}
	}

	// Matrix multiplication
	for i := 0; i < r1; i++ {
		for j := 0; j < c2; j++ {
			C[i][j] = 0
			for k := 0; k < c1; k++ {
				C[i][j] = C[i][j] + (A[i][k] * B[k][j])
			}
		}
	}

	// Display result matrix
	fmt.Println("\nMultiplication of two matrices is:")
	for i := 0; i < r1; i++ {
		for j := 0; j < c2; j++ {
			fmt.Print(C[i][j], "\t")
		}
		fmt.Println()
	}
}
