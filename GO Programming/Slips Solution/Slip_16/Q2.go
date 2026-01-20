/*Write a program  in GO language that prints out the numbers from 0
to  10,  waiting  between  0  and  250  ms  after  each  one  using  the
delay function.*/

package main

import (
	"fmt"
	"math/rand"
	"time"
)

func main() {
	rand.Seed(time.Now().UnixNano())

	for i := 0; i <= 10; i++ {
		fmt.Println(i)
		delay := rand.Intn(251) // 0 to 250 ms
		time.Sleep(time.Duration(delay) * time.Millisecond)
	}
}
