// Write a program  in GO language to add or append content at the end of a text file.
package main

import (
	"fmt"
	"os"
)

func main() {
	var msg string

	fmt.Print("Enter text to append: ")
	fmt.Scanln(&msg)

	f, err := os.OpenFile("data.txt", os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0644)
	if err != nil {
		fmt.Println("Error:", err)
		return
	}
	defer f.Close()

	f.WriteString(msg + "\n")
	fmt.Println("Text appended successfully!")
}
