// Write a program in Go language to create an interface and display values using type assertion.

package main

import "fmt"

func main() {
	var i interface{} = "Hello Go"

	str := i.(string)
	fmt.Println("Value:", str)
}
