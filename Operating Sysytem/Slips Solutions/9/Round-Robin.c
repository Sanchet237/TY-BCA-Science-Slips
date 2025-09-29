/*Q.2 Write the program to simulate Round Robin (RR) scheduling. The arrival time and first CPU- 
burst for different n number of processes should be input to the algorithm. Also give the time 
quantum as input. Assume the fixed IO waiting time (2 units). The next CPU-burst should be 
generated randomly. The output should give Gantt chart, turnaround time and waiting time for each 
process. Also find the average waiting time and turnaround time. [20 marks]*/

#include <stdio.h>
#include <string.h>

struct process {
    char pname[10];
    int at, bt, tbt, ft;
} tab[10];

int n, tq, time = 0, k = 0;

struct gantt {
    char pname[10];
    int start, end;
} g[50];

void getinput() {
    printf("Enter number of processes: ");
    scanf("%d", &n);
    printf("Enter time quantum: ");
    scanf("%d", &tq);
    for(int i = 0; i < n; i++) {
        printf("\nProcess name: ");
        scanf("%s", tab[i].pname);
        printf("Arrival time: ");
        scanf("%d", &tab[i].at);
        printf("Burst time: ");
        scanf("%d", &tab[i].bt);
        tab[i].tbt = tab[i].bt;
    }
}

void sort() {
    for(int i = 0; i < n-1; i++)
        for(int j = 0; j < n-i-1; j++)
            if(tab[j].at > tab[j+1].at) {
                struct process temp = tab[j];
                tab[j] = tab[j+1];
                tab[j+1] = temp;
            }
}

void roundrobin() {
    int finish = 0;
    k = 0;
    while(finish < n) {
        int executed = 0;
        for(int i = 0; i < n; i++) {
            if(tab[i].tbt > 0 && tab[i].at <= time) {
                int exec = (tab[i].tbt > tq) ? tq : tab[i].tbt;
                g[k].start = time;
                time += exec;
                tab[i].tbt -= exec;
                g[k].end = time;
                strcpy(g[k].pname, tab[i].pname);
                tab[i].ft = time;
                k++;
                executed = 1;
                if(tab[i].tbt == 0)
                    finish++;
            }
        }
        if(!executed) time++; // CPU idle
    }
}

void printoutput() {
    printf("\nRR Scheduling Output\n");


    // Print table
    printf("\nProcess\tAT\tBT\tFT\tTAT\tWT\n");
    int TATsum = 0, WTsum = 0;
    for(int i = 0; i < n; i++) {
        int tat = tab[i].ft - tab[i].at;
        int wt = tat - tab[i].bt;
        printf("%s\t%d\t%d\t%d\t%d\t%d\n", tab[i].pname, tab[i].at, tab[i].bt, tab[i].ft, tat, wt);
        TATsum += tat;
        WTsum += wt;
    }
    printf("\nAverage TAT = %.2f  Average WT = %.2f\n", (float)TATsum/n, (float)WTsum/n);

    printf("\nGantt Chart:\nStart\tProcess\tEnd\n");
    for(int i = 0; i < k; i++)
        printf("%d\t%s\t%d\n", g[i].start, g[i].pname, g[i].end);
}

int main() {
    getinput();
    sort();
    roundrobin();
    printoutput();
    return 0;
}
