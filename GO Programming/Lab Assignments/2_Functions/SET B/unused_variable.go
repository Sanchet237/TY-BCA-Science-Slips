// WAP in Go language to show compiler error if a variable is declared but not used.

package main

import "fmt"

func main() {
	var x int
	fmt.Println("Declared variable x to avoid unused error. Value:", x)
}
