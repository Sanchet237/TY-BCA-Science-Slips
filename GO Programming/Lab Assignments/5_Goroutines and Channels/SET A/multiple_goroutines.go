// Go program that executes 5 goroutines generating numbers 0 to 10.

package main

import (
	"fmt"
	"math/rand"
	"sync"
	"time"
)

func generate(id int, wg *sync.WaitGroup) {
	defer wg.Done()
	for i := 0; i <= 10; i++ {
		fmt.Println("Goroutine", id, ":", i)
		time.Sleep(time.Millisecond * time.Duration(rand.Intn(250)))
	}
}

func main() {
	rand.Seed(time.Now().UnixNano())
	var wg sync.WaitGroup
	for i := 1; i <= 5; i++ {
		wg.Add(1)
		go generate(i, &wg)
	}
	wg.Wait()
}
