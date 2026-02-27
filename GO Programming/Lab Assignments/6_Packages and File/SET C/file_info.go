// WAP in Go language to print file information.

package main

import (
	"fmt"
	"os"
)

func main() {
	info, err := os.Stat("test.txt")
	if err != nil {
		fmt.Println("Error reading file info:", err)
		return
	}
	fmt.Println("File Name:", info.Name())
	fmt.Println("File Size:", info.Size())
}
