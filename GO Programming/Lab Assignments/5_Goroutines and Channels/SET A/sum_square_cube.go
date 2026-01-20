// Go program using goroutine and channel to print sum of squares and cubes of digits.

package main

import "fmt"

func calc(n int, sq chan int, cu chan int) {
	sumSq, sumCu := 0, 0
	for n > 0 {
		d := n % 10
		sumSq += d * d
		sumCu += d * d * d
		n /= 10
	}
	sq <- sumSq
	cu <- sumCu
}

func main() {
	var num int
	fmt.Print("Enter number: ")
	fmt.Scan(&num)

	sq := make(chan int)
	cu := make(chan int)

	go calc(num, sq, cu)

	sumSq := <-sq
	sumCu := <-cu

	fmt.Println("Sum of squares =", sumSq)
	fmt.Println("Sum of cubes =", sumCu)
	fmt.Println("Final sum =", sumSq+sumCu)
}
