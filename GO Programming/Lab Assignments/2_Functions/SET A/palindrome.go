// WAP in Go language using function to check whether accepted number is palindrome or not.

package main

import "fmt"

func isPalindrome(n int) bool {
	rev := 0
	temp := n

	for temp != 0 {
		rev = rev*10 + temp%10
		temp = temp / 10
	}
	return rev == n
}

func main() {
	var num int

	fmt.Print("Enter number: ")
	fmt.Scan(&num)

	if isPalindrome(num) {
		fmt.Println("Number is Palindrome")
	} else {
		fmt.Println("Number is Not Palindrome")
	}
}
