package main

import "fmt"

func main() {
	var r int
	fmt.Print("Enter the row count: ")
	fmt.Scan(&r)
	for i := 0; i < r; i++ {
		num := 1
		for j := 0; j <= i; j++ {
			fmt.Print(num, " ")
			num = num * (i - j) / (j + 1)
		}
		fmt.Println()
	}
}
