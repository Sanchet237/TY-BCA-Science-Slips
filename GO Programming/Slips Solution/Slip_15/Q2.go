//Write a program in GO language to read  XML file into structure and display structure

package main

import (
	"encoding/xml"
	"fmt"
	"os"
)

type Student struct {
	XMLName xml.Name `xml:"student"`
	RollNo  int      `xml:"rollno"`
	Name    string   `xml:"name"`
	Marks   int      `xml:"marks"`
}

func main() {
	data, err := os.ReadFile("student.xml")
	if err != nil {
		fmt.Println("Error:", err)
		return
	}

	var s Student
	err = xml.Unmarshal(data, &s)
	if err != nil {
		fmt.Println("Error:", err)
		return
	}

	fmt.Println("Student Details:")
	fmt.Println("Roll No:", s.RollNo)
	fmt.Println("Name   :", s.Name)
	fmt.Println("Marks  :", s.Marks)
}
