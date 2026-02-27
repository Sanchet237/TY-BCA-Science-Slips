package main

import "fmt"

func main() {
	p := new(int)
	*p = 5
	fmt.Println("Value stored at allocated memory:", *p)
}
