// Write  a  program  in  the  GO  language  using  function  to  check whether accepts number is palindrome or not.
package main

import "fmt"

func isPalindrome(n int) bool {
	original := n
	rev := 0
	for n > 0 {
		rev = rev*10 + n%10
		n /= 10
	}
	return original == rev
}

func main() {
	var num int

	fmt.Print("Enter a number: ")
	fmt.Scanln(&num)

	if isPalindrome(num) {
		fmt.Println("The number is a palindrome.")
	} else {
		fmt.Println("The number is not a palindrome.")
	}
}
