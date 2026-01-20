// Go program to check even/odd using goroutines and channels.

package main

import "fmt"

func even(ch chan int) {
	for v := range ch {
		fmt.Println("Even:", v)
	}
}

func odd(ch chan int) {
	for v := range ch {
		fmt.Println("Odd:", v)
	}
}

func main() {
	nums := []int{1, 2, 3, 4, 5, 6}
	evenCh := make(chan int)
	oddCh := make(chan int)

	go even(evenCh)
	go odd(oddCh)

	for _, n := range nums {
		if n%2 == 0 {
			evenCh <- n
		} else {
			oddCh <- n
		}
	}

	close(evenCh)
	close(oddCh)
}
