/*Write the program to simulate Preemptive Shortest Job First (SJF) -scheduling. The arrival time and 
first CPU-burst for different n number of processes should be input to the algorithm. Assume the 
fixed IO waiting time (2 units). The next CPU-burst should be generated randomly. The output should 
give Gantt chart, turnaround time and waiting time for each process. Also find the average waiting 
time and turnaround time. [20marks] */

#include <stdio.h>
#include <string.h>

struct process {
    char pname[10];
    int at, bt, rbt, ft; // arrival time, burst time, remaining burst time, finish time
} tab[10];

struct gantt {
    char pname[10];
    int start, end;
} g[100];

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
        tab[i].rbt = tab[i].bt;
    }
}

int all_completed() {
    for(int i = 0; i < n; i++)
        if(tab[i].rbt > 0)
            return 0;
    return 1;
}

void sjf_preemptive() {
    k = 0;
    time = 0;
    char current[10] = "";
    while(!all_completed()) {
        int idx = -1;
        int min_rbt = 100000;
        for(int i = 0; i < n; i++) {
            if(tab[i].at <= time && tab[i].rbt > 0) {
                if(tab[i].rbt < min_rbt) {
                    min_rbt = tab[i].rbt;
                    idx = i;
                }
            }
        }
        if(idx == -1) {
            // CPU idle
            if(strcmp(current, "idle") != 0) {
                strcpy(current, "idle");
                g[k].start = time;
            }
            time++;
            g[k].end = time;
        } else {
            if(strcmp(current, tab[idx].pname) != 0) {
                if(k > 0 && g[k-1].end != time) k++;
                g[k].start = time;
                strcpy(current, tab[idx].pname);
            }
            tab[idx].rbt--;
            time++;
            g[k].end = time;
            if(tab[idx].rbt == 0) {
                tab[idx].ft = time;
            }
        }
    }
    k++; 
}

void printoutput() {
    printf("\nSJF Preemptive (SRTF) Scheduling Output\n");
    
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
    sjf_preemptive();
    printoutput();
    return 0;
}
