#include <stdio.h>
#include "awk_sem.h"

main() {
    int i = 0 ;
    // *** please insert proper semaphore initialization here
    int semid1 = get_sem(".", 'a');       // Get semaphore for p1
    int semid2 = get_sem(".", 'b');       // Get semaphore for p2
    int semid3 = get_sem(".", 'c');       // get semaphore for p3
   
    do {
       // *** this is where you should place semaphore 
       P(semid3);     // semid3 = 2 -> 1，p3 進入CS 
       
       // Wait for its turn
       printf("P3333333 is here\n"); i++;  
       
       // *** this is where you should place semaphore 
       V(semid1);     // semid1 = 0 -> 1，p1 可以開始新的一輪
   
    }  while (i< 200);
}
