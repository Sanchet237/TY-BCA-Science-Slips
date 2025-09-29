/* Q.1 Creating a child process using the command exec(). 
Note down process ids of the parent and the child processes, 
check whether the control is given back to the parent after the 
child process terminates. [10 marks] 
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    pid_t pid = fork();

    if (pid < 0) {
        perror("Fork failed");
        return 1;
    }

    if (pid == 0) {   // Child process

        printf("Child PID: %d, Parent PID: %d\n", getpid(), getppid());
        execlp("ls", "ls", "-l", NULL); // Replace child process with 'ls -l'
        perror("execlp failed");
        exit(1);

    } else {// Parent process

        printf("Parent PID: %d, Child PID: %d\n", getpid(), pid);
        wait(NULL); // Wait for the child to finish
        printf("Child terminated. Control returned to parent.\n");
    }

    return 0;
}
