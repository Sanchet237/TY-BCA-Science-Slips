/*Write  a  program  in  GO  language  to  create  a  buffered  channel,
store few values in it and find channel capacity and length. Read
values from channel and find modified length of a channel*/

package main

import "fmt"

func main() {
	ch := make(chan int, 5)

	// store values
	ch <- 10
	ch <- 20
	ch <- 30

	fmt.Println("Channel Capacity:", cap(ch))
	fmt.Println("Channel Length:", len(ch))

	// read values
	fmt.Println("Reading values:")
	fmt.Println(<-ch)
	fmt.Println(<-ch)

	fmt.Println("Modified Channel Length:", len(ch))
}
