// WAP in Go language to illustrate returning multiple values from a function.

package main

import "fmt"

func getData() (int, string) {
	return 25, "Go Programming"
}

func main() {
	num, text := getData()

	fmt.Println("Number:", num)
	fmt.Println("Text:", text)
}
