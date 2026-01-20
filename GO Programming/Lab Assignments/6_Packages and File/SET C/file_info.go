// WAP in Go language to print file information.

package main

import (
	"fmt"
	"os"
)

func main() {
	info, _ := os.Stat("test.txt")
	fmt.Println("File Name:", info.Name())
	fmt.Println("File Size:", info.Size())
}
