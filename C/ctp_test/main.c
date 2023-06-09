#include <stdio.h>
#include <stdlib.h>

typedef struct bouquet_t
{
    int roses;
    int tulipes;
    int pivoines;
} bouquet_t;

typedef struct commande_t
{
    int nb_bouquets;
    bouquet_t** tableau;
}commande_t;


void exemple_pointeur (void);
void exemple_tableau(char* tableau, int taille); 
void caractere_suivant (char* pt_car); 
int taille_chaine_de_caracteres(char* chaine);
void affiche_tableau (int* tableau, int taille);
bouquet_t* nouveau_bouquet(void); 
void initialise_bouquet(bouquet_t* bouquet, int nb_roses, int nb_tulipes,int nb_pivoines); 
void affiche_bouquet(bouquet_t* bouquet);
void libere_bouquet(bouquet_t* bouquet);
bouquet_t* combine_bouquets(bouquet_t* bouquet_1, bouquet_t* bouquet_2);
commande_t* nouvelle_commande(int nb_bouquets);
void remplir_commande(commande_t* commande);
void affiche_commande(commande_t* commande);
void libere_commande(commande_t* commande);
void nb_de_fleur(commande_t* commande,int* nb_roses,int* nb_tulipes, int* nb_piboines);
void exemple_de_commande(void);


void exemple_pointeur (void){
    int ma_variable;
    ma_variable = 0;
    printf("%d\n",ma_variable);
    printf("%p\n",&ma_variable);
    int* mon_pointeur = &ma_variable;
    printf("%p\n",mon_pointeur);
    printf("%d\n",*mon_pointeur);
}

void exemple_tableau(char* tableau, int taille){
    printf("La deuxième case du tableau se situe à l’adresse %p\n",tableau+2);
    printf("Elle contient : %c\n",*(tableau+2));
}

void caractere_suivant (char* pt_car){
    *pt_car = *pt_car+1;
}

int taille_chaine_de_caracteres(char* chaine){
    int i = 0;
    while(*(chaine+i)!='\0'){
        i++;
    }
    return i;
}

void affiche_tableau (int* tableau, int taille){
    for (int i = 0; i < taille -1 ; i++)
    {
        printf("%d /",*(tableau+i));
    }
    printf("%d\n",*(tableau+taille));
    
}

bouquet_t* nouveau_bouquet(void){
    bouquet_t* bouquet;
    bouquet = malloc(sizeof(bouquet_t));
    return bouquet;
}

void initialise_bouquet(bouquet_t* bouquet, int nb_roses, int nb_tulipes,int nb_pivoines){
    bouquet->roses=nb_roses;
    bouquet->tulipes=nb_tulipes;
    bouquet->pivoines = nb_pivoines;
} 

void affiche_bouquet(bouquet_t* bouquet){
    if(bouquet->roses > 1){
        printf("%d roses ,",bouquet->roses);
    }
    else{printf("%d rose ,",bouquet->roses);}
    
    if(bouquet->tulipes > 1){
        printf("%d tulipes et ",bouquet->tulipes);
    }
    else{printf("%d tulipe et ",bouquet->tulipes);}

    if(bouquet->tulipes > 1){
        printf("%d pivoines",bouquet->pivoines);
    }
    else{printf("%d pivoine",bouquet->pivoines);}
}

void libere_bouquet(bouquet_t* bouquet){
    free(bouquet);
}

bouquet_t* combine_bouquets(bouquet_t* bouquet_1, bouquet_t* bouquet_2){
    bouquet_t* bouquetF = malloc(sizeof(bouquet_t));
    bouquetF->roses = bouquet_1->roses + bouquet_2->roses;
    bouquetF->tulipes = bouquet_1->tulipes + bouquet_2->tulipes;
    bouquetF->pivoines = bouquet_1->pivoines + bouquet_2->pivoines;
    return bouquetF;
}

commande_t* nouvelle_commande(int nb_bouquets){
    commande_t* commande;
    commande = malloc(sizeof(commande_t));
    commande->nb_bouquets = nb_bouquets;
    commande->tableau = malloc(sizeof(bouquet_t*)*nb_bouquets);
    return commande;
}

void remplir_commande(commande_t* commande){
    for (int i = 0; i < commande->nb_bouquets; i++)
    {
        bouquet_t* b = nouveau_bouquet();
        initialise_bouquet(b,i+1,i+1,i+1);
        *(commande->tableau+i) = b;
    }
    
}

void affiche_commande(commande_t* commande){
    if(commande->nb_bouquets > 1 ){
        printf("La commande contient %d bouqets\n",commande->nb_bouquets);
    }
    else{
        printf("La commande contient %d bouquet\n",commande->nb_bouquets);
    }
    for (int i = 0; i < commande->nb_bouquets; i++)
    {
        printf("Bouquet %d : ",i);
        affiche_bouquet(commande->tableau[i]);
        printf("\n");
    }
    
}

void libere_commande(commande_t* commande){
    for (int  i = 0; i < commande->nb_bouquets  ; i++)
    {
        libere_bouquet(commande->tableau[i]);
    }
    free(commande);
}

void nb_de_fleur(commande_t* commande,int* nb_roses,int* nb_tulipes, int* nb_pivoines){
    for (int  i = 0; i < commande->nb_bouquets  ; i++)
    {
        *nb_roses = *nb_roses + commande->tableau[i]->roses;
        *nb_tulipes = *nb_tulipes + commande->tableau[i]->tulipes;
        *nb_pivoines = *nb_pivoines + commande->tableau[i]->pivoines;
    }
}

void exemple_de_commande(void){
    commande_t* commande;
    commande = nouvelle_commande(3);
    remplir_commande(commande);
    affiche_commande(commande);
    int nb_roses = 0;
    int nb_tulipes= 0;
    int nb_pivoines= 0;

    int* pt_nb_roses = &nb_roses;
    int* pt_nb_tulipes = &nb_tulipes;
    int* pt_nb_pivoines = &nb_pivoines;

    nb_de_fleur(commande,pt_nb_roses,pt_nb_tulipes,pt_nb_pivoines);
    printf("Nous avons besoin de %d roses \n",*(pt_nb_roses));
    printf("Nous avons besoin de %d tulipes \n",*(pt_nb_tulipes));
    printf("Nous avons besoin de %d pivoines \n",*(pt_nb_pivoines));
}







int main(void){
    // exemple_pointeur();
    // char* tableau;
    // tableau = malloc(sizeof(char));
    // *(tableau+1) = 'a';
    // *(tableau+2) = 'b';
    // *(tableau+3) = 'c';
    // exemple_tableau(tableau,3);
    // char c = 'b';
    // char* pt_car = &c;
    // caractere_suivant(pt_car);
    // char* chaine;
    // chaine = malloc(sizeof(char));
    // *(chaine+0) = '1';
    // *(chaine+1) = '2';
    // *(chaine+2) = '3';
    // *(chaine+3) = '4';
    // *(chaine+4) = '5';
    // *(chaine+5) = '6';
    // *(chaine+6) = '7';
    // printf("%d\n",taille_chaine_de_caracteres(chaine));
    // affiche_tableau(chaine,6);

    exemple_de_commande();

    return 0;
}