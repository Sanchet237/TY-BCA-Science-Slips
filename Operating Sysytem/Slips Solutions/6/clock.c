/*Q.1 Write a program to find the execution time taken for execution of a given set of instructions 
(use clock() function) [10 marks] */

#include <stdio.h>
#include <time.h>

int main() {
    clock_t start, end;
    double cpu_time_used;

    start = clock();

    // Simulate a set of instructions
    for (long i = 0; i < 100000000; i++);

    end = clock();
    cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;

    printf("Execution time: %f seconds\n", cpu_time_used);
    return 0;
}