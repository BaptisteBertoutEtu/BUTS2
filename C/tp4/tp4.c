#include <stdio.h>
#include <stdlib.h>

typedef struct liste_t{
    char car;
    struct liste_t* queue;
} liste_t;

liste_t* ajoute_element_a_la_fin (liste_t* liste, char car);
void affiche_liste(liste_t* liste);
liste_t* ajoute_element(char car, liste_t* liste);
char tete_de_liste(liste_t* liste);
liste_t* queue_de_liste(liste_t* liste);
int est_vide(liste_t* liste);
int taille_de_liste(liste_t* liste);
liste_t* supprime_premier_element (liste_t* liste);
void libere_la_liste (liste_t* liste);
liste_t* insert_caractere (liste_t* liste, char car, int position);
liste_t* supprime_element (liste_t* liste, int position);





liste_t* nouvelle_liste (char car){
    liste_t* liste;
    liste = malloc(sizeof(liste_t));
    liste->car = car;
    liste->queue = NULL;
    return liste;
}

liste_t* ajoute_element_a_la_fin (liste_t* liste, char car){
    if(liste == NULL){
        return nouvelle_liste(car);
    }
    if(liste->queue==NULL){
        liste->queue = nouvelle_liste(car);
        return liste;
    }
    return ajoute_element_a_la_fin(liste->queue,car);   
}

void affiche_liste(liste_t* liste){
    printf("%c",liste->car);
    if(liste->queue!=NULL){
        affiche_liste(liste->queue);
    }
    printf("\n");
}

liste_t* ajoute_element(char car, liste_t* liste){
    liste_t* new_liste = nouvelle_liste(car);
    new_liste->queue = liste->queue;
    liste->queue = new_liste;
    return liste;
}

char tete_de_liste(liste_t* liste){
    return liste->car;
}

liste_t* queue_de_liste(liste_t* liste){
    return liste->queue;
}

int est_vide(liste_t* liste){
    if(liste==NULL) return 1;
    return 0;
}

int taille_de_liste(liste_t* liste){
    if(liste==NULL){
        return 0;
    }
    return 1 + taille_de_liste(liste->queue);
}

liste_t* supprime_premier_element (liste_t* liste){
    return liste->queue;
}

void libere_la_liste (liste_t* liste){
    if(liste->queue!=NULL){
        libere_la_liste(liste->queue);
    }
    free(liste);
}

liste_t* insert_caractere (liste_t* liste, char car, int position){
    if(position==0){
        liste->car = car;
    }
    return insert_caractere(liste,car,position-1);
}

liste_t* supprime_element (liste_t* liste, int position){
    if(position==1){
        liste->queue = supprime_premier_element(liste);
    }
    return liste;
}






int main(void){
    
    liste_t* liste;
    liste=nouvelle_liste('a');
    liste = ajoute_element_a_la_fin(liste,'b');
    affiche_liste(liste);




}