package main
import "fmt"
func main() {
    var a,b,c int
    fmt.Scan(&a,&b,&c)
    switch c {
    case 1: fmt.Println(a+b)
    case 2: fmt.Println(a-b)
    case 3: fmt.Println(a*b)
    case 4: fmt.Println(a/b)
    }
}