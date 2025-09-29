/*.2 Write the simulation program to implement demand paging and show the page scheduling 
and total number of page faults for the following given page reference string. Give input n as the 
number of memory frames. 
Reference String :3, 4, 5, 6, 3, 4, 7, 3, 4, 5, 6, 7, 2, 4, 6 
Implement FIFO [20 marks] */

#include<stdio.h>

int nor, nof, refstring[30], F[10]; 

void accept() {
    int i;
    printf("\nEnter the length of reference string: ");
    scanf("%d", &nor);

    printf("\nEnter the Reference String:\n");
    for(i = 0; i < nor; i++) {
        printf("[%d]: ", i); 
        scanf("%d", &refstring[i]);
    }

    printf("\nEnter number of frames: ");
    scanf("%d", &nof);

    // Initialize frames to -1
    for(i = 0; i < nof; i++)
        F[i] = -1;
}

int search(int page) {
    int i;
    for(i = 0; i < nof; i++)
        if(page == F[i])
            return i;
    return -1;
}

void FIFO() {
    int i, j, k, fno = 0, fault = 0;

    printf("\nFIFO Page Replacement Process:\n");
    printf("Page\tFrames\n");

    for(i = 0; i < nor; i++) {
        printf("%d\t", refstring[i]);
        k = search(refstring[i]);

        if(k == -1) { // Page fault
            F[fno] = refstring[i];
            fno = (fno + 1) % nof;
            fault++;
        }

        // Display current frame content
        for(j = 0; j < nof; j++) {
            if(F[j] != -1)
                printf("%d\t", F[j]);
            else
                printf("-\t");
        }
        printf("\n");
    }

    printf("\nTotal number of page faults: %d\n", fault);
}

int main() {
    accept();
    FIFO();
    return 0;
}
