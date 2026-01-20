// Write a program in Go language to demonstrate working of embedded interfaces.

package main

import "fmt"

type Reader interface {
	read()
}

type Writer interface {
	write()
}

type ReadWrite interface {
	Reader
	Writer
}

type File struct{}

func (f File) read() {
	fmt.Println("Reading file")
}

func (f File) write() {
	fmt.Println("Writing file")
}

func main() {
	var rw ReadWrite = File{}
	rw.read()
	rw.write()
}
