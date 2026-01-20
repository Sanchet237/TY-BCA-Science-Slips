// Go program to implement checkpoint synchronization problem.

/*Write a go program to implement the checkpoint synchronization problem which is a problem of
synchronizing multiple tasks. Consider a workshop where several workers assembling details of some
mechanism. When each of them completes his work, they put the details together. There is no store, so a
worker who finished its part first must wait for others before starting another one. Putting details
together is the checkpoint at which tasks synchronize themselves before going their paths apart.*/

package main

import (
	"fmt"
	"sync"
	"time"
)

func worker(id int, wg *sync.WaitGroup, barrier *sync.WaitGroup) {
	defer wg.Done()

	fmt.Println("Worker", id, "working")
	time.Sleep(time.Second)

	barrier.Done()
	barrier.Wait() // checkpoint

	fmt.Println("Worker", id, "moving ahead")
}

func main() {
	var wg sync.WaitGroup
	var barrier sync.WaitGroup

	workers := 3
	barrier.Add(workers)
	wg.Add(workers)

	for i := 1; i <= workers; i++ {
		go worker(i, &wg, &barrier)
	}

	wg.Wait()
}
