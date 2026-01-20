/*Write  a  program  in  GO  language  using  go  routine  and  channel  that
will print the sum of the squares  and cubes of the  individual digits
of a number. Example if number is 123 then
squares = (1 * 1) + (2 * 2) + (3 * 3)
cubes = (1 * 1 * 1) + (2 * 2 * 2) + (3 * 3 * 3).*/

package main

import "fmt"

func sumSquares(n int, ch chan int) {
	sum := 0
	for n > 0 {
		d := n % 10
		sum += d * d
		n = n / 10
	}
	ch <- sum
}

func sumCubes(n int, ch chan int) {
	sum := 0
	for n > 0 {
		d := n % 10
		sum += d * d * d
		n = n / 10
	}
	ch <- sum
}

func main() {
	var num int
	fmt.Print("Enter number: ")
	fmt.Scan(&num)

	sqCh := make(chan int)
	cbCh := make(chan int)

	go sumSquares(num, sqCh)
	go sumCubes(num, cbCh)

	squares := <-sqCh
	cubes := <-cbCh

	fmt.Println("Sum of squares of digits:", squares)
	fmt.Println("Sum of cubes of digits  :", cubes)
}
