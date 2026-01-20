//Write a program in the GO language program to open a file in READ only mode.

package main

import (
	"fmt"
	"os"
)

func main() {
	f, err := os.Open("shayari.txt")
	if err != nil {
		fmt.Println("Error:", err)
		return
	}
	defer f.Close()

	fmt.Println("File opened in READ only mode successfully!")
}
