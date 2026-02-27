// WAP in Go language to add or append content at the end of a text file.

package main

import (
	"fmt"
	"os"
)

func main() {
	file, err := os.OpenFile("test.txt", os.O_APPEND|os.O_WRONLY|os.O_CREATE, 0644)
	if err != nil {
		fmt.Println("Error opening file:", err)
		return
	}
	defer file.Close()

	if _, err := file.WriteString("\nAppended Content"); err != nil {
		fmt.Println("Error writing to file:", err)
		return
	}

	fmt.Println("Content appended successfully to test.txt")
}
