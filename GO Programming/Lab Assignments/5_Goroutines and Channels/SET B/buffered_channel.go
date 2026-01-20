/*WAP in Go to create buffered channel, store few values in it and find channel capacity and length.
Read values from channel and find modified length of a channel. */

package main

import "fmt"

func main() {

	ch := make(chan int, 5)

	for i := 1; i <= 5; i++ {
		ch <- i
		fmt.Printf("Added %d to channel. Current length: %d, Capacity: %d\n", i, len(ch), cap(ch))
	}

	for i := 1; i <= 5; i++ {
		val := <-ch
		fmt.Printf("Removed %d from channel. Current length: %d, Capacity: %d\n", val, len(ch), cap(ch))
	}
}
