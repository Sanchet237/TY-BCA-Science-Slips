//Write a program  in GO language  to read and write Fibonacci series to the using channel.

package main

import "fmt"

func fibonacci(n int, ch chan int) {
	a, b := 0, 1
	for i := 0; i < n; i++ {
		ch <- a
		a, b = b, a+b
	}
	close(ch)
}

func main() {
	var n int
	fmt.Print("Enter number of terms: ")
	fmt.Scan(&n)

	ch := make(chan int)

	go fibonacci(n, ch)

	fmt.Println("Fibonacci Series:")
	for v := range ch {
		fmt.Print(v, " ")
	}
}
