// Write a program in GO language to accept n records of employee information
// (eno, ename, salary) and display records of employees having minimum salary.

package main

import "fmt"

type Employee struct {
	eno    int
	ename  string
	salary float64
}

func main() {
	var n int
	fmt.Print("Enter number of employees: ")
	fmt.Scan(&n)

	E := make([]Employee, n)

	// Accept employee records
	for i := 0; i < n; i++ {
		fmt.Println("\nEnter details of Employee", i+1)
		fmt.Print("Employee No: ")
		fmt.Scan(&E[i].eno)
		fmt.Print("Employee Name: ")
		fmt.Scan(&E[i].ename)
		fmt.Print("Employee Salary: ")
		fmt.Scan(&E[i].salary)
	}

	// Find minimum salary
	minSalary := E[0].salary
	for i := 1; i < n; i++ {
		if E[i].salary < minSalary {
			minSalary = E[i].salary
		}
	}

	// Display employees having minimum salary
	fmt.Println("\nEmployees having Minimum Salary:", minSalary)
	for i := 0; i < n; i++ {
		if E[i].salary == minSalary {
			fmt.Println("Eno:", E[i].eno, "Ename:", E[i].ename, "Salary:", E[i].salary)
		}
	}
}
