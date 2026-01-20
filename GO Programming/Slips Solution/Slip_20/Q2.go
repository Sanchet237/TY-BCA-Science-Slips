/*Write  a  program  in  Go  language  how  to  create  a  channel  and
illustrate  how  to close  a channel using for range loop and close
function.*/

package main

import "fmt"

func main() {
	ch := make(chan int)

	go func() {
		for i := 1; i <= 5; i++ {
			ch <- i
		}
		close(ch)
	}()

	fmt.Println("Reading values from channel:")
	for v := range ch {
		fmt.Println(v)
	}
}
