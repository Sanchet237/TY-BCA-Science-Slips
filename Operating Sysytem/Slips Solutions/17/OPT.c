/*Q.2. Write the simulation program to implement demand paging and show the page scheduling 
and total number of page faults for the following given page reference string. Give input n =3 as 
the number of memory frames. 
Reference String : 12,15,12,18,6,8,11,12,19,12,6,8,12,15,19,8 
Implement OPT [20 marks]*/

#include <stdio.h>

int nor, nof, refstring[30], F[10];

// Accept reference string
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

// Find the frame to replace using Optimal algorithm
int getOptimal(int current) {
    int farthest = current, fpos = -1;
    for(int i = 0; i < nof; i++) {
        int j;
        for(j = current + 1; j < nor; j++) {
            if(F[i] == refstring[j])
                break;
        }
        if(j == nor) // Page not used in future
            return i;
        if(j > farthest) {
            farthest = j;
            fpos = i;
        }
    }
    return (fpos == -1) ? 0 : fpos;
}

// Optimal Page Replacement
void optimal() {
    int fault = 0;

    printf("\nPage\tFrames\t\tStatus\n");

    for(int i = 0; i < nor; i++) {
        printf("%d\t", refstring[i]);
        int k = search(refstring[i]);

        if(k != -1) {
            // Page hit
            for(int j = 0; j < nof; j++)
                printf("%d\t", F[j] != -1 ? F[j] : -);
            printf("\tHit\n");
        } else {
            // Page fault
            int fno = 0;
            for(fno = 0; fno < nof; fno++)
                if(F[fno] == -1) break;

            if(fno == nof) // Frames full, replace optimal
                fno = getOptimal(i);

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
    optimal();
    return 0;
}
