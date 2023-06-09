#include <stdio.h>

int main(void){
    float devise =  60;
    float taux_change = 1.1226;
    float result = devise*taux_change;
    float result_chaque = result / 2;
    
    printf("Alice et Bob ont %f euros apres conversion\n",result);
    printf("Ils gardent donc %f euros chacun\n",result_chaque);
}