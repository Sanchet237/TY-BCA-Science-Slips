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
	data, err := os.ReadFile("student.xml")
	if err != nil {
		fmt.Println("Error reading XML file:", err)
		return
	}
	var s Student
	if err := xml.Unmarshal(data, &s); err != nil {
		fmt.Println("Error parsing XML:", err)
		return
	}
	fmt.Printf("Student -> Name:%s Age:%d\n", s.Name, s.Age)
}
