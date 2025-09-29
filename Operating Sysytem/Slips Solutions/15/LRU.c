/*Q.2 Write the simulation program to implement demand paging and show the page scheduling 
and total number of page faults for the following given page reference string. Give input n as the 
number of memory frames. 
Reference String: 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2 
Implement LRU [20 marks] */

#include <stdio.h>

int nor, nof, refstring[30], F[10];

void accept() {
    printf("Enter the length of the reference string: ");
    scanf("%d", &nor);

    printf("Enter the reference string:\n");
    for(int i = 0; i < nor; i++) {
        printf("[%d]: ", i);
        scanf("%d", &refstring[i]);
    }

    printf("Enter number of frames: ");
    scanf("%d", &nof);

    for(int i = 0; i < nof; i++)
        F[i] = -1; // Initialize frames
}

// Search page in frames
int search(int page) {
    for(int i = 0; i < nof; i++)
        if(F[i] == page)
            return i;
    return -1;
}

// Find least recently used frame
int getLRU(int current) {
    int lru = 0, oldest = current;
    for(int i = 0; i < nof; i++) {
        for(int j = current - 1; j >= 0; j--) {
            if(F[i] == refstring[j]) {
                if(j < oldest) {
                    oldest = j;
                    lru = i;
                }
                break;
            }
        }
    }
    return lru;
}

// LRU Page Replacement
void LRU() {
    int fault = 0;

    printf("\nPage\tFrames\t\tStatus\n");

    for(int i = 0; i < nor; i++) {
        printf("%d\t", refstring[i]);
        int k = search(refstring[i]);

        if(k != -1) {
            // Page hit
            for(int j = 0; j < nof; j++)
                printf("%d\t", F[j] != -1 ? F[j] : - );
            printf("\tHit\n");
        } else {
            // Page fault
            int fno = 0;
            for(fno = 0; fno < nof; fno++)
                if(F[fno] == -1) break;

            if(fno == nof) // Frames full, replace LRU
                fno = getLRU(i);

            F[fno] = refstring[i];
            for(int j = 0; j < nof; j++)
                printf("%d\t", F[j] != -1 ? F[j] : -);
            printf("\tFault\n");
            fault++;
        }
    }

    printf("\nTotal number of page faults: %d\n", fault);
}

int main() {
    accept();
    LRU();
    return 0;
}
