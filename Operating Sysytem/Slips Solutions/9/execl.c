/*Q.1 Write a program to create a child process using fork(). The parent should goto sleep state and child process should begin its execution. 
In the child process, use execl() to execute the “ls” command.[10 marks]*/

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>

int main() {
    pid_t pid = fork();

    if (pid < 0) {
        perror("Fork failed");
        return 1;
    }

    if (pid == 0) {
        // Child process
        printf("Child process is running (PID: %d)\n", getpid());
        execl("/bin/ls", "ls", NULL);
        perror("execl failed"); // Only prints if execl fails
        exit(1);
    } else {
        // Parent process
        sleep(10);
        printf("Parent process (PID: %d) is terminated\n", getpid());
    }

    return 0;
}
