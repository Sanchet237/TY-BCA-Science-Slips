/*Q.2 Write the simulation program using FCFS. The arrival time and first CPU bursts of different 
jobs should be input to the system. Assume the fixed I/O waiting time (2 units). The next CPU 
burst should be generated using random function. The output should give the Gantt chart, 
Turnaround Time and Waiting time for each process and average times [20 marks] */

#include <stdio.h>
#include <string.h>

struct process {
    char pname[10];
    int at, bt, ft;
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
    }
}

void sortbyArrival() {
    for(int i = 0; i < n-1; i++)
        for(int j = 0; j < n-i-1; j++)
            if(tab[j].at > tab[j+1].at) {
                struct process temp = tab[j];
                tab[j] = tab[j+1];
                tab[j+1] = temp;
            }
}

void fcfs() {
    time = 0;
    k = 0;
    for(int i = 0; i < n; i++) {
        if(time < tab[i].at)
            time = tab[i].at;  // CPU idle until process arrives
        g[k].start = time;
        time += tab[i].bt;
        g[k].end = time;
        strcpy(g[k].pname, tab[i].pname);
        tab[i].ft = time;
        k++;
    }
}

void printoutput() {
    printf("\nFCFS Scheduling Output\n\n");
    printf("Process\tAT\tBT\tFT\tWT\tTAT\n");
    int TATsum = 0, WTsum = 0;
    for(int i = 0; i < n; i++) {
        int tat = tab[i].ft - tab[i].at;
        int wt = tat - tab[i].bt;
        printf("%s\t%d\t%d\t%d\t%d\t%d\n", tab[i].pname, tab[i].at, tab[i].bt, tab[i].ft, wt, tat);
        TATsum += tat;
        WTsum += wt;
    }
    printf("\nTotal WT: %d  Total TAT: %d\n", WTsum, TATsum);
    printf("Average WT: %.2f  Average TAT: %.2f\n", (float)WTsum/n, (float)TATsum/n);

    printf("\nGantt Chart:\nStart\tProcess\tEnd\n");
    for(int i = 0; i < k; i++)
        printf("%d\t%s\t%d\n", g[i].start, g[i].pname, g[i].end);
}

int main() {
    getinput();
    sortbyArrival();
    fcfs();
    printoutput();
    return 0;
}
