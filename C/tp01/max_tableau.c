#include <stdio.h>

int main(void){
    int tableau[6] = {5,4,7,14,2,3};
    int max = tableau[0];
    int pos = 0;

    for (int i = 1; i < 6; i++)
    {
        if (tableau[i]>max)
        {
            max = tableau[i];
            pos = i;
        }
        
    }
    printf("le max est : %d\n",max);
    printf("Sa position est : %d",pos);
}