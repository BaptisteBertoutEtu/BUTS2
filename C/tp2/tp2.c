#include <stdio.h>

void afficher_entier (int n);
int produit(int a,int b);
void modifie_a(int a);
void test_pointeur (void);
int plus_egal(int* pt_a, int b);
int fois_egal(int* pt_a, int b);
void somme_et_produit (int a, int b, int* pt_somme, int* pt_produit);
void affiche_tableau (char* tableau, int taille);
void affiche_tableau_pointeur (char* tableau, int taille);
void change_lettre (char* pt_lettre, char nouvelle_lettre);
void affiche_caractere (char car);
void alphabet (char* tableau, int taille);
void alphabet_renverse (char* tableau, int taille);
char valeur_tableau_2d (char* tableau, int nb_ligne, int nb_colonne,int pos_ligne, int pos_colonne);
void affiche_tableau_2d (char* tableau, int nb_ligne, int nb_colonne);


void afficher_entier (int n){
    printf("La fonction vous affiche l’entier : %d\n", n);
}

int produit(int a, int b){
    return a * b;
}

void modifie_a(int a){
    a=a+1;
    printf("%d, addresse : %p\n",a, &a);
}

void test_pointeur (void){
    int a = 2;
    int* pt_a = &a;

    printf("valeur de a : %d, adresse de a : %p \n",a,&a);
    printf("valeur de pt_a : %p, contenu de la case mémoire : %d\n",pt_a,*pt_a);
}

int plus_egal(int* pt_a, int b){
    *pt_a = *pt_a + b;
    return 0;
}

int fois_egal(int* pt_a, int b){
    *pt_a = *pt_a * b;
    return 0;
}

void somme_et_produit (int a, int b, int* pt_somme, int* pt_produit){
    *pt_somme = a+b;
    *pt_produit = a * b;
}

void affiche_tableau (char* tableau, int taille){
    for(int i = 0; i < taille; i++){
        printf("%c ",tableau[i]);
    }
    printf("\n");
}

void affiche_tableau_pointeur (char* tableau, int taille){
    for(int i = 0; i < taille; i++){
        printf("%c ",*tableau+i);
    }
    printf("\n");
}

void change_lettre (char* pt_lettre, char nouvelle_lettre){
    *pt_lettre = nouvelle_lettre;
    printf("%c\n",*pt_lettre);
}

void affiche_caractere (char car){
    printf("%c\n",car);
    printf("%d\n",car);
}

void alphabet (char* tableau, int taille){
    for(int i=0; i<taille;i++){
        tableau[i]='a'+i;
    }
    affiche_tableau(tableau,6);
}

void alphabet_renverse (char* tableau, int taille){
    for(int i=0; i<taille;i++){
        tableau[i]='z'-i;
    }
    affiche_tableau(tableau,6);
}

char valeur_tableau_2d (char* tableau, int nb_ligne, int nb_colonne,int pos_ligne, int pos_colonne){
    return tableau[pos_ligne * nb_colonne + pos_colonne];
}

void affiche_tableau_2d (char* tableau, int nb_ligne, int nb_colonne){
    for(int i=0; i<nb_ligne;i++){
        for(int j=0; j<nb_colonne;j++){
            printf(tableau,nb_ligne,nb_colonne,i,j);
        }
    }
}

int main(void){
    //int a =2;

    /*
    //Q1
    afficher_entier(3);
    //Q2
    printf("%d\n",produit(3,8));
    //Q3
    modifie_a(a);
    printf("%d, addresse : %p\n",a, &a);
    //Q1_exo2
    test_pointeur();
    //Q2_exo2
    int* pt_a =  &a;
    printf("pt_a avant fonction : %p\n",pt_a);
    printf("valeur pt_a avant fonction : %d\n",*pt_a);
    plus_egal(pt_a, 2);
    printf("pt_a après fonction : %p\n",pt_a);
    printf("valeur pt_a avant fonction : %d\n",*pt_a);
    //Q3_exo2
    int* pt_a =  &a;
    printf("pt_a avant fonction : %p\n",pt_a);
    printf("valeur pt_a avant fonction : %d\n",*pt_a);
    fois_egal(pt_a, 18);
    printf("pt_a après fonction : %p\n",pt_a);
    printf("valeur pt_a avant fonction : %d\n",*pt_a);
    //Q1_exo3
    int somme = 0;
    int produit = 0;
    int* pt_somme = &somme;
    int* pt_produit = &produit;

    printf("pt_somme avant fonction : %p\n",pt_somme);
    printf("pt_produit avant fonction : %p\n",pt_produit);
    printf("valeur pt_somme avant fonction : %d\n",*pt_somme);
    printf("valeur pt_produit avant fonction : %d\n",*pt_produit);
    somme_et_produit(3,5,pt_somme,pt_produit);
    printf("pt_somme après fonction : %p\n",pt_somme);
    printf("pt_produit après fonction : %p\n",pt_produit);
    printf("valeur pt_somme après fonction : %d\n",*pt_somme);
    printf("valeur pt_produit après fonction : %d\n",*pt_produit);
    //Q1_exo4
    char tableau[6] = {'a','z','e','r','t','y'};
    affiche_tableau(tableau, 6);
    //Q2_exo4
    char tableau[6] = {'a','z','e','r','t','y'};
    affiche_tableau_pointeur(tableau, 6);
    //Q3_exo4
    char tableau[6] = {'a','z','e','r','t','y'};
    char* pt_lettre = &tableau[1];
    change_lettre(pt_lettre,'P');
    affiche_tableau(tableau,6);
    //Q1_exo5
    affiche_caractere('a');
    //Q2_exo5
    char tableau[6] = {};
    alphabet(tableau, 5);
    //Q3_exo5
    char tableau[6] = {};
    alphabet_renverse(tableau, 5);
    //Q4_exo5
    char tableau[6] = {};
    alphabet(tableau, 5);
    tableau[2]='\0';
    affiche_tableau(tableau,6);
    //Q5_exo5
    char tableau[6] = {};
    alphabet(tableau, 5);
    tableau[1]='\0';
    tableau[2]='\0';
    tableau[3]='\0';
    affiche_tableau(tableau,6);
    //Q1_exo6
    char tableau[16]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p'};
    printf("%c\n",valeur_tableau_2d(tableau,4,4,3,2));
    */
    //Q3_exo6
    char tableau[16]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p'};
    printf("%c\n",valeur_tableau_2d(tableau,4,4,3,2));








    return 0;
}