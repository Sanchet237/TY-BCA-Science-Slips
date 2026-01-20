// WAP in Go language to multiply two matrices.

package main

import "fmt"

func main() {
	var a, b int
	fmt.Scan(&a, &b)

	m1 := make([][]int, a)
	m2 := make([][]int, a)
	res := make([][]int, a)

	for i := 0; i < a; i++ {
		m1[i] = make([]int, b)
		m2[i] = make([]int, b)
		res[i] = make([]int, b)
	}

	for i := 0; i < a; i++ {
		for j := 0; j < b; j++ {
			fmt.Scan(&m1[i][j])
		}
	}

	for i := 0; i < a; i++ {
		for j := 0; j < b; j++ {
			fmt.Scan(&m2[i][j])
		}
	}

	for i := 0; i < a; i++ {
		for j := 0; j < b; j++ {
			res[i][j] = m1[i][j] * m2[i][j]
		}
	}

	fmt.Println(res)
}
