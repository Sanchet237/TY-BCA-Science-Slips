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
	var n int
	fmt.Print("How many numbers? ")
	fmt.Scan(&n)

	nums := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Printf("Enter number %d: ", i+1)
		fmt.Scan(&nums[i])
	}
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
