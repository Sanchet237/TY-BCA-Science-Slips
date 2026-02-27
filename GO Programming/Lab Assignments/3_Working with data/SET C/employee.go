// WAP in Go language to display employee with maximum salary.

package main

import "fmt"

type Emp struct {
	no   int
	name string
	sal  int
}

func main() {
	var n int
	fmt.Print("Enter number of employees: ")
	fmt.Scan(&n)

	emps := make([]Emp, n)
	for i := 0; i < n; i++ {
		fmt.Printf("Enter employee %d details (no name salary): ", i+1)
		fmt.Scan(&emps[i].no, &emps[i].name, &emps[i].sal)
	}

	max := emps[0]
	for _, e := range emps {
		if e.sal > max.sal {
			max = e
		}
	}

	fmt.Printf("Employee with max salary -> No:%d Name:%s Salary:%d\n", max.no, max.name, max.sal)
}
