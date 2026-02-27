// WAP in Go language to multiply two matrices.

package main

import "fmt"

func main() {
	var r1, c1, r2, c2 int
	fmt.Print("Enter rows and columns of matrix 1 (r c): ")
	fmt.Scan(&r1, &c1)
	fmt.Print("Enter rows and columns of matrix 2 (r c): ")
	fmt.Scan(&r2, &c2)

	if c1 != r2 {
		fmt.Println("Matrix multiplication not possible: columns of matrix 1 must equal rows of matrix 2")
		return
	}

	m1 := make([][]int, r1)
	m2 := make([][]int, r2)
	res := make([][]int, r1)

	for i := 0; i < r1; i++ {
		m1[i] = make([]int, c1)
		res[i] = make([]int, c2)
	}
	for i := 0; i < r2; i++ {
		m2[i] = make([]int, c2)
	}

	fmt.Println("Enter elements of matrix 1:")
	for i := 0; i < r1; i++ {
		for j := 0; j < c1; j++ {
			fmt.Scan(&m1[i][j])
		}
	}

	fmt.Println("Enter elements of matrix 2:")
	for i := 0; i < r2; i++ {
		for j := 0; j < c2; j++ {
			fmt.Scan(&m2[i][j])
		}
	}

	for i := 0; i < r1; i++ {
		for j := 0; j < c2; j++ {
			sum := 0
			for k := 0; k < c1; k++ {
				sum += m1[i][k] * m2[k][j]
			}
			res[i][j] = sum
		}
	}

	fmt.Println("Resultant matrix:")
	for i := 0; i < r1; i++ {
		for j := 0; j < c2; j++ {
			fmt.Printf("%d ", res[i][j])
		}
		fmt.Println()
	}
}
