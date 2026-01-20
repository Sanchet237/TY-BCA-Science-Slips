// WAP in Go language to illustrate the concept of call by value.

package main

import "fmt"

func change(n int) {
	n = 100
}

func main() {
	var x int = 10

	fmt.Println("Before function call:", x)
	change(x)
	fmt.Println("After function call:", x)
}
