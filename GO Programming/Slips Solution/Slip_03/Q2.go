/*Write a Program in GO language to accept n records of employee
information (eno,ename,salary) and display record of employees
having maximum salary.*/

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
		fmt.Println("\nEnter details of employee", i+1)

		fmt.Print("Employee No: ")
		fmt.Scan(&E[i].eno)

		fmt.Print("Employee Name: ")
		fmt.Scan(&E[i].ename)

		fmt.Print("Salary: ")
		fmt.Scan(&E[i].salary)
	}

	// Find maximum salary
	maxSalary := E[0].salary
	for i := 1; i < n; i++ {
		if E[i].salary > maxSalary {
			maxSalary = E[i].salary
		}
	}

	// Display employee(s) having maximum salary
	fmt.Println("\n--- Employee(s) with Maximum Salary ---")
	for i := 0; i < n; i++ {
		if E[i].salary == maxSalary {
			fmt.Println("Employee No:", E[i].eno)
			fmt.Println("Employee Name:", E[i].ename)
			fmt.Println("Salary:", E[i].salary)
			fmt.Println("-------------------------")
		}
	}
}
