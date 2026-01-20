// Write a program in GO language to create an interface and display its values with the help of type assertion.

package main

import "fmt"

func main() {
	var i interface{} = 5.2

	if v, result := i.(string); result {
		fmt.Println("Value is :", v, "\nIt is a String")
	} else if v, result := i.(int); result {
		fmt.Println("Value is :", v, "\nIt is a Integer")
	} else if v, result := i.(float64); result {
		fmt.Println("Value is :", v, "\nIt is a Float")
	}
}
