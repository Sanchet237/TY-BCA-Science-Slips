// Write a program in Go language to demonstrate working of type switch.

package main

import "fmt"

func checkType(i interface{}) {
	switch v := i.(type) {
	case int:
		fmt.Println("Integer:", v)
	case string:
		fmt.Println("String:", v)
	default:
		fmt.Println("Unknown type")
	}
}

func main() {
	checkType(10)
	checkType("Go")
}
