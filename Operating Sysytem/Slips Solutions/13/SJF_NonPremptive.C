/*Q2. Write the simulation program using SJF (non-preemptive). The arrival time and first CPU 
bursts of different jobs should be input to the system. Assume the fixed I/O waiting time (2 units). 
The next CPU burst should be generated using random function. The output should give the Gantt 
chart,   Turnaround   Time   and   Waiting   time   for   each    process    and    average    times. [20 marks] */

#include <stdio.h>
#include <string.h>

struct process {
    char pname[10];
    int at, bt, ft;
    int flag; // flag to check if process is done
} tab[10];

struct gantt {
    char pname[10];
    int start, end;
} g[50];

int n, time = 0, k = 0;

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
        tab[i].flag = 0;
    }
}

int all_completed() {
    for(int i = 0; i < n; i++)
        if(tab[i].flag == 0)
            return 0;
    return 1;
}

void sjf_nonpreemptive() {
    k = 0;
    time = 0;
    while(!all_completed()) {
        int idx = -1;
        int min_bt = 100000; // large value
        for(int i = 0; i < n; i++) {
            if(tab[i].at <= time && !tab[i].flag) {
                if(tab[i].bt < min_bt) {
                    min_bt = tab[i].bt;
                    idx = i;
                }
            }
        }
        if(idx == -1) {
            // CPU idle
            strcpy(g[k].pname, "idle");
            g[k].start = time;
            time++;
            g[k].end = time;
            k++;
        } else {
            g[k].start = time;
            time += tab[idx].bt;
            g[k].end = time;
            strcpy(g[k].pname, tab[idx].pname);
            tab[idx].ft = time;
            tab[idx].flag = 1;
            k++;
        }
    }
}

void printoutput() {
    printf("\nSJF Non-preemptive Scheduling Output\n");
    
    printf("\nProcess\tAT\tBT\tFT\tTAT\tWT\n");
    int totalTAT = 0, totalWT = 0;
    for(int i = 0; i < n; i++) {
        int tat = tab[i].ft - tab[i].at;
        int wt = tat - tab[i].bt;
        printf("%s\t%d\t%d\t%d\t%d\t%d\n", tab[i].pname, tab[i].at, tab[i].bt, tab[i].ft, tat, wt);
        totalTAT += tat;
        totalWT += wt;
    }
    printf("\nTotal WT: %d  Total TAT: %d\n", totalWT, totalTAT);
    printf("Average WT: %.2f  Average TAT: %.2f\n", (float)totalWT/n, (float)totalTAT/n);

    printf("\nGantt Chart:\nStart\tProcess\tEnd\n");
    for(int i = 0; i < k; i++)
        printf("%d\t%s\t%d\n", g[i].start, g[i].pname, g[i].end);
}

int main() {
    getinput();
    sjf_nonpreemptive();
    printoutput();
    return 0;
}
