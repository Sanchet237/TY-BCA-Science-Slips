/*.1 Write a program that demonstrates the use of nice () system call. After a child process is 
started using fork (), assign higher priority to the child using nice () system call. [10 marks] */

#include <stdio.h>
#include <unistd.h>
main()
{
    int pid;
    int retnice;
    pid = fork();
    if (pid == 0)
    {
        retnice = nice(-1);
        printf("Child process id is %d\n", getpid());
        printf("Priority value is %d\n", retnice);
    }
    else
    {
        retnice = nice(15);
        printf("Child process id is %d\n", getpid());
        printf("Priority value is %d\n", retnice);
    }
    return 0;
}