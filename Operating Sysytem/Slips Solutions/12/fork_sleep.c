/*Q.1 Write a program to illustrate the concept of orphan process ( Using fork() and sleep()) [10 marks]*/

#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>

int main() {
    pid_t pid = fork();

    if (pid > 0) {
        printf("Parent process\nID: %d\n\n", getpid());
        exit(0); // Parent exits so child becomes orphan
    } 
    else if (pid == 0) {
        sleep(5); // Give parent time to exit
        printf("Child process\nID: %d\nParent ID after parent exit: %d\n\n", getpid(), getppid());
    } 
    else {
        printf("Failed to create child process\n");
    }

    return 0;
}
