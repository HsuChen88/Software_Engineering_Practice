#include <stdio.h>
#include "awk_sem.h"

main() {
    int i = 0 ;
    // *** Please insert proper semaphore initialization here
    int semid1 = create_sem(".", 'a', 1); // Initialize semaphore for p1 with value 1
    int semid2 = create_sem(".", 'b', 0); // Initialize semaphore for p2 with value 0
    int semid3 = create_sem(".", 'c', 0); // Initialize semaphore for p3 with value 0

    do {
       // *** this is where you should place semaphore 
       P(semid1);   // semid1 = 1 -> 0，p1 進入CS，其他進程需等待

       printf("P1111111111 is here\n"); i++;
       
       // *** this is where you should place semaphore
       V(semid2);   // semid2 = 0 -> 1，p2 可以執行
       P(semid1);   // semid1 = 0，p1 進入等待狀態
		 
    }  while (i < 100) ;
}
