//Write  a program in GO language to print file information.

package main

import (
	"fmt"
	"os"
)

func main() {
	var fname string
	fmt.Print("Enter file name: ")
	fmt.Scan(&fname)

	info, err := os.Stat(fname)
	if err != nil {
		fmt.Println("Error:", err)
		return
	}

	fmt.Println("\n--- File Information ---")
	fmt.Println("File Name:", info.Name())
	fmt.Println("File Size:", info.Size(), "bytes")
	fmt.Println("Permissions:", info.Mode())
	fmt.Println("Last Modified:", info.ModTime())
	fmt.Println("Is Directory:", info.IsDir())
}
