/*Q.2 Write a C program to simulate Banker's algorithm for the purpose of deadlock avoidance.
 Consider the following snapshot of system, A, B, C and D are the resource type.[20 marks]

 ==========================================================
            ALLOCATION          MAX             AVAILABLE
 Process    A B C D         A B C D             A B C D
 ----------------------------------------------------------
   P0       0 0 1 2         0 0 1 2             1 5 2 0
   P1       1 0 0 0         1 7 5 0
   P2       1 3 5 4         2 3 5 6
   P3       0 6 3 2         0 6 5 2
   P4       0 0 1 4         0 6 5 6
 ==========================================================
 
 a) Calculate and display the content of the need matrix.

 b) Is the system in a safe state? If yes, display the safe sequence.

 c) If a request from process P1 arrives for (0, 4, 2, 0), can it be granted
    immediately while keeping the system in a safe state? Print a message
    indicating whether the request can be granted or not.
*/

#include <stdio.h>
#include <stdbool.h>

int main() {
    int P, R;
    printf("Enter number of processes: ");
    scanf("%d", &P);
    printf("Enter number of resources: ");
    scanf("%d", &R);

    int alloc[P][R], max[P][R], aval[R], need[P][R];

    // Input Allocation matrix
    printf("\nEnter Allocation matrix:\n");
    for (int i = 0; i < P; i++) {
        printf("P%d: ", i);
        for (int j = 0; j < R; j++) scanf("%d", &alloc[i][j]);
    }

    // Input Maximum matrix
    printf("\nEnter Maximum matrix:\n");
    for (int i = 0; i < P; i++) {
        printf("P%d: ", i);
        for (int j = 0; j < R; j++) scanf("%d", &max[i][j]);
    }

    // Input Available resources
    printf("\nEnter Available resources:\n");
    for (int i = 0; i < R; i++) {
        printf("R%d: ", i);
        scanf("%d", &aval[i]);
    }

    // Calculate Need matrix
    for (int i = 0; i < P; i++)
        for (int j = 0; j < R; j++)
            need[i][j] = max[i][j] - alloc[i][j];

    // Display matrices in table format
    printf("--------------------------------------------------------\n");
    printf("Process   Allocation       Maximum        Need\n");
    printf("--------------------------------------------------------\n");
    for (int i = 0; i < P; i++) {
        printf("P%-8d", i);
        for (int j = 0; j < R; j++) printf("%-3d", alloc[i][j]);
        printf("      ");
        for (int j = 0; j < R; j++) printf("%-3d", max[i][j]);
        printf("      ");
        for (int j = 0; j < R; j++) printf("%-3d", need[i][j]);
        printf("\n");
    }
    printf("--------------------------------------------------------\n");

    // Safe state check
    int work[R], safeSeq[P];
    bool finish[P];
    for (int i = 0; i < R; i++) work[i] = aval[i];
    for (int i = 0; i < P; i++) finish[i] = false;

    int count = 0;
    while (count < P) {
        bool found = false;
        for (int i = 0; i < P; i++) {
            if (!finish[i]) {
                int j;
                for (j = 0; j < R; j++)
                    if (need[i][j] > work[j]) break;
                if (j == R) {
                    for (int k = 0; k < R; k++) work[k] += alloc[i][k];
                    safeSeq[count++] = i;
                    finish[i] = true;
                    found = true;
                }
            }
        }
        if (!found) break;
    }

    if (count == P) {
        printf("\nSystem is SAFE.\nSafe sequence: ");
        for (int i = 0; i < P; i++) {
            printf("P%d", safeSeq[i]);
            if (i != P - 1) printf(" -> ");
        }
        printf("\n");
    } else {
        printf("\nSystem is NOT SAFE.\n");
    }

    // Check request from user
    int process, request[R];
    printf("\nEnter process number for request: ");
    scanf("%d", &process);
    printf("Enter request for P%d:\n", process);
    for (int i = 0; i < R; i++) {
        printf("R%d: ", i);
        scanf("%d", &request[i]);
    }

    bool canGrant = true;
    for (int i = 0; i < R; i++)
        if (request[i] > need[process][i] || request[i] > aval[i])
            canGrant = false;

    printf("Request (");
    for (int i = 0; i < R; i++) {
        printf("%d", request[i]);
        if (i != R - 1) printf(", ");
    }
    printf(") for P%d ", process);

    if (canGrant) printf("can be granted safely.\n");
    else printf("cannot be granted immediately.\n");

    return 0;
}
