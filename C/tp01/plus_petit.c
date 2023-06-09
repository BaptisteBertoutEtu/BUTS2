#include <stdio.h>

int main(void){
    int a = 3;
    int b = 5;
    int c = 4;

    if (a < b && a<c)
    {
        printf("a");
    }
    else if (b < a && b <c)
    {
        printf("b");
    }
    else{
        printf("c");
    }

    return 0;
    
    
}