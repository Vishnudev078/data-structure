#include <stdio.h>

void main()
{
    int bt[10], wt[10], tat[10], ct[10], p[10], n, i, j, temp;
    int total_tat = 0, total_wt = 0;

    printf("Enter the number of processes: ");
    scanf("%d", &n);

    printf("Enter the burst times:\n");
    for (i = 0; i < n; i++)
    {
        printf("Process %d: ", i + 1);
        scanf("%d", &bt[i]);
        p[i] = i + 1; // Initialize process IDs
    }

    // Sorting burst times and process IDs using Bubble Sort
    for (i = 0; i < n - 1; i++)
    {
        for (j = 0; j < n - i - 1; j++)
        {
            if (bt[j] > bt[j + 1])
            {
                // Swap burst times
                temp = bt[j];
                bt[j] = bt[j + 1];
                bt[j + 1] = temp;

                // Swap process IDs
                temp = p[j];
                p[j] = p[j + 1];
                p[j + 1] = temp;
            }
        }
    }

    // Calculating completion time, turnaround time, and waiting time
    int sum = 0;
    for (i = 0; i < n; i++)
    {
        sum += bt[i];
        ct[i] = sum;       // Completion time
        tat[i] = ct[i];    // Turnaround time
        wt[i] = tat[i] - bt[i]; // Waiting time

        total_tat += tat[i]; // Accumulating total turnaround time
        total_wt += wt[i];   // Accumulating total waiting time
    }

    // Displaying results
    printf("\nProcess\tBurst Time\tWaiting Time\tTurnaround Time\n");
    for (i = 0; i < n; i++)
    {
        printf("P%d\t%d\t\t%d\t\t%d\n", p[i], bt[i], wt[i], tat[i]);
    }

    // Displaying averages
    printf("\nAverage Turnaround Time: %.2f", (float)total_tat / n);
    printf("\nAverage Waiting Time: %.2f\n", (float)total_wt / n);
}
