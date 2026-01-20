//Write a program in GO language to copy all elements of one array into another using a method.

package main

import "fmt"

type Array []int

func (a Array) copyTo(b Array) {
	for i, v := range a {
		b[i] = v
	}
}

func main() {
	var n int
	fmt.Println("Enter size:")
	fmt.Scan(&n)

	a := make(Array, n)

	fmt.Println("Enter elements:")
	for i := 0; i < n; i++ {
		fmt.Scan(&a[i])
	}

	b := make(Array, len(a))

	a.copyTo(b)

	fmt.Println("Array a :", a)
	fmt.Println("Array b :", b)
}
