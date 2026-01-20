// WAP in Go language to read an XML file into structure and display it.

package main

import (
	"encoding/xml"
	"fmt"
	"os"
)

type Student struct {
	Name string `xml:"name"`
	Age  int    `xml:"age"`
}

func main() {
	data, _ := os.ReadFile("student.xml")
	var s Student
	xml.Unmarshal(data, &s)
	fmt.Println(s)
}
