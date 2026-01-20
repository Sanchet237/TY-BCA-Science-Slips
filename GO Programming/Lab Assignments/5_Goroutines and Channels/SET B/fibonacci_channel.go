// Go program to read and write Fibonacci series using channel.

package main

import "fmt"

func fib(ch chan int, n int) {
	a, b := 0, 1
	for i := 0; i < n; i++ {
		ch <- a
		a, b = b, a+b
	}
	close(ch)
}

func main() {
	ch := make(chan int)
	go fib(ch, 10)

	for v := range ch {
		fmt.Print(v, " ")
	}
}
