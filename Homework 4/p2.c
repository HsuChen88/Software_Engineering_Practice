#include <stdio.h>
#include "awk_sem.h"

main() {
    int i = 0 ;
    // *** please insert proper semaphore initialization here
    int semid1 = get_sem(".", 'a'); 
    int semid2 = get_sem(".", 'b'); 
    int semid3 = get_sem(".", 'c');   
    
    do {
       // *** this is where you should place semaphore 
       P(semid2);   // semid2 = 1 -> 0，p2 進入臨界區
    
       printf("P222222222 is here\n"); i++ ;
      
       // *** this is where you should place semaphore
       V(semid3);   // semid3 = 0 -> 1，p3 (First time)
       V(semid3);   // semid3 = 0 -> 1，p3 (Second time)
        
    }  while (i < 100);
}
