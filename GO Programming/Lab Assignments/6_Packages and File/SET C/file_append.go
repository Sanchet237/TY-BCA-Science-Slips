// WAP in Go language to add or append content at the end of a text file.

package main

import "os"

func main() {
	file, _ := os.OpenFile("test.txt", os.O_APPEND|os.O_WRONLY, 0644)
	file.WriteString("\nAppended Content")
	file.Close()
}
