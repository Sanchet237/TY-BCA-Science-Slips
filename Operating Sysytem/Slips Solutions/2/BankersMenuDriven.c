/*Q2.Partially implement a Menu-driven Banker's Algorithm for accepting Allocation and Max from the user.

[20 Marks]

Menu Options:
a) Accept Available resources.
b) Display Allocation and Max matrices.
c) Calculate Need matrix and display it.
d) Display Available resources.

Consider a system with 3 resource types: A, B, and C with 7, 2, and 6 instances respectively.

Snapshot:

           ALLOCATION     REQUEST    TOTAL RESOURCES
Process     A B C          A B C         A B C
P0          0 1 0          0 0 0         7 2 6
P1          2 0 0          2 0 0         
P2          3 0 3          0 0 1         
P3          2 1 1          1 0 0         
P4          0 0 2          0 0 2         

Tasks:
a) Display the contents of the Available array.
b) Check if there is any deadlock in the system and print an appropriate message.
*/
