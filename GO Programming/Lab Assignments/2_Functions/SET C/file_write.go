/*WAP in Go language to create a file and write "Hello World" in it and close the file using defer statement.*/

package main

import (
	"fmt"
	"os"
)

func main() {
	file, err := os.Create("hello.txt")
	if err != nil {
		fmt.Println("Error creating file")
		return
	}

	defer file.Close()
	file.WriteString("Hello World")

	fmt.Println("File created and data written successfully")
}
