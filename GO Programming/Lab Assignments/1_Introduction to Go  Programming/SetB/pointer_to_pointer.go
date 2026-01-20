package main
import "fmt"
func main() {
    a:=10
    p:=&a
    pp:=&p
    fmt.Println(**pp)
}