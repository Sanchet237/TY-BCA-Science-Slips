/*Write  a  program  in  GO  language  that  creates  a  slice  of  integers,
checks  numbers  from  the  slice  are  even  or  odd  and  further  sent  to
respective go routines through channel and display values
received by goroutines. */

package main

import "fmt"

func even(ch chan int) {
	for v := range ch {
		fmt.Println("Even:", v)
	}
}

func odd(ch chan int) {
	for v := range ch {
		fmt.Println("Odd :", v)
	}
}

func main() {
	nums := []int{10, 15, 22, 33, 40, 55, 60}

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
