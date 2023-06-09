#include <stdio.h> 

int main(void){
    int n = 10;
    
    for (int i = 1; i <= n; i++)
    {
        if (n%i==0)
        {
            printf("%d\n",i);
        }
        
    }
    
}