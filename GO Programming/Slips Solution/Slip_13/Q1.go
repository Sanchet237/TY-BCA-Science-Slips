//Write a  program  in  GO  language  to  print  sum  of  all  even  and  odd numbers separately between 1 to 100.

package main

import "fmt"

func main() {
	evenSum := 0
	oddSum := 0

	for i := 1; i <= 100; i++ {
		if i%2 == 0 {
			evenSum += i
		} else {
			oddSum += i
		}
	}

	fmt.Println("Sum of Even numbers (1 to 100):", evenSum)
	fmt.Println("Sum of Odd numbers  (1 to 100):", oddSum)
}
