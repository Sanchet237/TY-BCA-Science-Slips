/*Q.1 Write a C program to accept the number of process and resources and find the need matrix 
content and display it. [10 marks]*/

#include <stdio.h>

int main() {
    int P, R;

    printf("Enter the number of processes: ");
    scanf("%d", &P);
    printf("Enter the number of resources: ");
    scanf("%d", &R);

    int alloc[P][R], max[P][R], need[P][R];

    printf("\nEnter the Allocation Matrix :\n");
    for (int i = 0; i < P; i++) {
        printf(" For Process P%d: ", i);
        for (int j = 0; j < R; j++) {
            scanf("%d", &alloc[i][j]);
        }
    }

    printf("\nEnter the  Need Matrix:\n");
    for (int i = 0; i < P; i++) {
        printf(" For Process P%d: ", i);
        for (int j = 0; j < R; j++) {
            scanf("%d", &max[i][j]);
        }
    }

    // Need = Max - Allocation
    for (int i = 0; i < P; i++) {
        for (int j = 0; j < R; j++) {
            need[i][j] = max[i][j] - alloc[i][j];
        }
    }

    printf("\n--- Calculated Need Matrix ---\n");

    printf("\t");
    for (int j = 0; j < R; j++) {
        printf("R%d\t", j);
    }
    printf("\n");

    for (int i = 0; i < P; i++) {
        printf("P%d\t", i);
        for (int j = 0; j < R; j++) {
            printf("%d\t", need[i][j]);
        }
        printf("\n");
    }

    return 0;
}