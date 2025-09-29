/*.1 Create a child process using fork(), display parent and child process id. Child process will 
display the message   and the parent process should display [10 marks] */

#include <stdio.h>
#include <unistd.h>
int main()
{
    int pid;
    pid = fork();
    if (pid == 0)
    {
        printf("This is Child Process\n");
        printf("Hello World\n");
        printf("Child process id is %d\n", getpid());
    }
    else
    {
        printf("This is Parent Process\n");
        printf("Hii\n");
        printf("Parent process id is %d\n", getpid());
    }
    return 0;
}
