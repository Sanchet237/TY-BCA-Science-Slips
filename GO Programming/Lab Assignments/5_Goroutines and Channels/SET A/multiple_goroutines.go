// Go program that executes 5 goroutines generating numbers 0 to 10.

package main

import (
	"fmt"
	"math/rand"
	"time"
)

func generate(id int) {
	for i := 0; i <= 10; i++ {
		fmt.Println("Goroutine", id, ":", i)
		time.Sleep(time.Millisecond * time.Duration(rand.Intn(250)))
	}
}

func main() {
	rand.Seed(time.Now().UnixNano())
	for i := 1; i <= 5; i++ {
		go generate(i)
	}
	time.Sleep(3 * time.Second)
}
