/*Q.2 Write the program to simulate Non-preemptive Priority scheduling. The arrival time and first 
CPU burst and priority for different n number of processes should be input to the algorithm. 
Assume the fixed IO waiting time (2 units). The next CPU-burst should be generated randomly. 
The output should give Gantt chart, turnaround time and waiting time for each process. Also find 
the average waiting time and turnaround time.. [20 marks] */

#include <stdio.h>
#include <string.h>

struct process {
    char pname[10];
    int at, bt, ft, wt, tat, priority, done;
} tab[10];

struct gantt {
    char pname[10];
    int start, end;
} g[50];

int n, k = 0, time = 0;

void getinput() {
    printf("Enter number of processes: ");
    scanf("%d", &n);
    for(int i = 0; i < n; i++) {
        printf("\nProcess name: ");
        scanf("%s", tab[i].pname);
        printf("Arrival time: ");
        scanf("%d", &tab[i].at);
        printf("Burst time: ");
        scanf("%d", &tab[i].bt);
        printf("Priority (lower number = higher priority): ");
        scanf("%d", &tab[i].priority);
        tab[i].done = 0;
    }
}

// Find next process to execute (arrived & highest priority)
int nextProcess() {
    int idx = -1;
    int highest = 9999;
    for(int i = 0; i < n; i++) {
        if(tab[i].done == 0 && tab[i].at <= time) {
            if(tab[i].priority < highest) {
                highest = tab[i].priority;
                idx = i;
            } else if(tab[i].priority == highest) {
                if(tab[i].at < tab[idx].at)
                    idx = i; // tie breaker: earlier arrival
            }
        }
    }
    return idx;
}

void schedule() {
    int finish = 0;
    while(finish < n) {
        int idx = nextProcess();
        if(idx != -1) {
            g[k].start = time;
            time += tab[idx].bt;
            g[k].end = time;
            strcpy(g[k].pname, tab[idx].pname);
            k++;

            tab[idx].ft = time;
            tab[idx].tat = tab[idx].ft - tab[idx].at;
            tab[idx].wt = tab[idx].tat - tab[idx].bt;
            tab[idx].done = 1;
            finish++;
        } else {
            // CPU idle
            time++;
        }
    }
}

void printoutput() {
    int TWT = 0, TTAT = 0;
    printf("\nProcess\tAT\tBT\tPriority\tFT\tWT\tTAT\n");
    for(int i = 0; i < n; i++) {
        printf("%s\t%d\t%d\t%d\t\t%d\t%d\t%d\n", tab[i].pname, tab[i].at, tab[i].bt,
               tab[i].priority, tab[i].ft, tab[i].wt, tab[i].tat);
        TWT += tab[i].wt;
        TTAT += tab[i].tat;
    }
    printf("\nTotal WT: %d  Total TAT: %d\n", TWT, TTAT);
    printf("Average WT: %.2f  Average TAT: %.2f\n", (float)TWT/n, (float)TTAT/n);

    printf("\nGantt Chart:\nStart\tProcess\tEnd\n");
    for(int i = 0; i < k; i++)
        printf("%d\t%s\t%d\n", g[i].start, g[i].pname, g[i].end);
}

int main() {
    getinput();
    schedule();
    printoutput();
    return 0;
}
