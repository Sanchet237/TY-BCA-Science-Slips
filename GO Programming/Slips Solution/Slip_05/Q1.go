// Write a program in GO language to create a Text file and write some text into it.

package main

import (
	"fmt"
	"os"
)

func main() {

	// Create a text file
	file, err := os.Create("myfile.txt")
	if err != nil {
		fmt.Println("Error creating file:", err)
		return
	}
	defer file.Close()

	// Text to write into file
	text := "Hello! This is a sample text written into a file using Go language.\n"

	// Write text into file
	_, err = file.WriteString(text)
	if err != nil {
		fmt.Println("Error writing to file:", err)
		return
	}

	fmt.Println("Text written successfully into myfile.txt")
}
