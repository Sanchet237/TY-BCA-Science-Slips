/*Q.1 Write the program to calculate minimum number of resources needed to avoid 
deadlock. [10 marks] */

#include <stdio.h>

int main() {
    int P;
    printf("Enter the number of processes: ");
    scanf("%d", &P);

    int max_needs[P];
    int sum = 0;

    printf("Enter maximum resources needed by each process:\n");
    for (int i = 0; i < P; i++) {
        printf("Process P%d: ", i);
        scanf("%d", &max_needs[i]);
        sum += (max_needs[i] - 1);
    }

    int min_resources = sum + 1;
    printf("\nMinimum resources required to avoid deadlock: %d\n", min_resources);

    return 0;
}
