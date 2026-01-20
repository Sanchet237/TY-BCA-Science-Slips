// Write a program in Go language to add or append content at the end of a text file.
package main

import (
	"fmt"
	"os"
)

func main() {
	f, err := os.OpenFile("shayari.txt", os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0644)
	if err != nil {
		fmt.Println("Error:", err)
		return
	}
	defer f.Close()

	var text string
	fmt.Print("Enter text to append: ")
	fmt.Scanln(&text)

	f.WriteString(text + "\n")
	fmt.Println("Content appended successfully in shyari.txt!")
}
