#include <stdio.h>
#include <stdlib.h>

typedef struct{
    char* tableau;
    int taille;
} super_tableau_t;

typedef super_tableau_t chaine_t;



void affiche_tableau ();
char* nouveau_tableau (int taille);
void initialise_tableau (char* tableau, int taille, char car);
void affiche_tableau (char* tableau, int taille);
void liberation_du_tableau (char* tableau);
void place_dans_tableau (char* tableau, int taille, int indice, char car);
char lecture_du_tableau (char* tableau, int taille, int indice);
super_tableau_t* nouveau_super_tableau (int taille);
void initialise_super_tableau (super_tableau_t* super_tab, char car);
void liberation_du_super_tableau (super_tableau_t* super_tab);
void place_dans_super_tableau (super_tableau_t* super_tab, int indice, char car);
char lecture_du_super_tableau (super_tableau_t* super_tab, int indice);
void affiche_super_tableau (super_tableau_t* super_tab);
int chaine_est_valide (chaine_t* chaine);
int taille_de_la_chaine (chaine_t* chaine);
void affiche_chaine (chaine_t* chaine);
void ajoute_caractere (chaine_t* chaine, char car);
void allonge_tableau_de_la_chaine (chaine_t* chaine);
chaine_t* ajoute_chaine (chaine_t* chaine1, chaine_t* chaine2);





void affiche_tableau_q1 (){
    char* pt_tableau;
    pt_tableau = malloc(sizeof(char*)*4);

    for(int i =0; i<4; i++){
        *(pt_tableau + i) = 'a'+i;
    }

    for(int i =0; i<4; i++){
        printf("%c\n",*(pt_tableau + i));
    }
}

char* nouveau_tableau (int taille){
    char* pt_tableau;
    pt_tableau = malloc(sizeof(char*)*taille);
    return pt_tableau;
}

void initialise_tableau (char* tableau,int taille, char car){
    for(int i =0; i<taille; i++){
        *(tableau + i) = car;
    }
}

void affiche_tableau (char* tableau, int taille){
    for(int i =0; i<taille; i++){
        printf("%c \n",*(tableau + i));
    }
}

void liberation_du_tableau (char* tableau){
    free(tableau);
}

void place_dans_tableau (char* tableau, int taille, int indice, char car){
    if(indice > taille -1 ){
        printf("indice en dehors du tableau\n");
        exit(1);
    }
    *(tableau + indice) = car;
}

char lecture_du_tableau (char* tableau, int taille, int indice){
    if(indice > taille -1 ){
        printf("indice en dehors du tableau\n");
        exit(1);
    }
    return *(tableau+indice);
}

super_tableau_t* nouveau_super_tableau (int taille){
    super_tableau_t* super_tab;
    super_tab = malloc(sizeof(super_tableau_t));
    super_tab->tableau = nouveau_tableau(taille);
    super_tab->taille = taille;
    return super_tab;
}

void initialise_super_tableau (super_tableau_t* super_tab, char car){
    initialise_tableau(super_tab->tableau, super_tab->taille,car);
}

void liberation_du_super_tableau (super_tableau_t* super_tab){
    liberation_du_tableau(super_tab->tableau);
}

void place_dans_super_tableau (super_tableau_t* super_tab, int indice, char car){
    place_dans_tableau(super_tab->tableau, super_tab->taille, indice, car);
}

char lecture_du_super_tableau (super_tableau_t* super_tab, int indice){
    return lecture_du_tableau(super_tab->tableau, super_tab->taille, indice);
}

void affiche_super_tableau (super_tableau_t* super_tab){
    affiche_tableau (super_tab->tableau, super_tab->taille);
}


int chaine_est_valide (chaine_t* chaine){
    for(int i =0; i<chaine->taille; i++){
        if(*(chaine->tableau+i)=='\0') return 1;
    }
    return 0;
}

int taille_de_la_chaine (chaine_t* chaine){
    if(!chaine_est_valide(chaine)){
        return -1;
    }
    int compt = 0;
    for(int i =0; i < chaine->taille; i++){
        if(*(chaine->tableau+i)!='\0'){
            compt ++;
        }
    }
    return compt;
}

void affiche_chaine (chaine_t* chaine){
    if(!chaine_est_valide(chaine)){
        return;
    }
    int i=0;
    while(*(chaine->tableau+i)!='\0'){
        printf("%c", *(chaine->tableau+i));
        i++;
    }
    printf("\n");

}

void ajoute_caractere (chaine_t* chaine, char car){
    int taille = taille_de_la_chaine(chaine);
    *(chaine->tableau+taille)=car;
    *(chaine->tableau+(taille+1))='\0';
}


void allonge_tableau_de_la_chaine (chaine_t* chaine){
    char* temp_old = chaine->tableau;
    char* temp_new =nouveau_tableau(chaine->taille+1);
    for(int i = 0; i < chaine->taille; i++){
        *(temp_new+i) = *(temp_old+i);
    }
    chaine->taille++;
    chaine->tableau = temp_new;
    liberation_du_tableau(temp_old);
}

chaine_t* ajoute_chaine (chaine_t* chaine1, chaine_t* chaine2){
    chaine_t* new_chaine = nouveau_super_tableau((chaine1->taille + chaine2->taille)+1);
    for(int i = 0; i < chaine1->taille; i ++){
        ajoute_caractere(new_chaine,*(chaine1->tableau+i));
    }
    for(int i = 0; i < chaine1->taille; i ++){
        ajoute_caractere(new_chaine,*(chaine2->tableau+i));
    }
    return new_chaine;
}



int main(void){
    
    // char* tableau;
    // tableau = nouveau_tableau(4);
    // // initialise_tableau(tableau,4,'a');
    // // *(tableau + 2) = 'e';
    // // affiche_tableau(tableau,4);
    // // liberation_du_tableau(tableau);
    // // affiche_tableau(tableau,4);

    // initialise_tableau(tableau,4,'.');
    // place_dans_tableau (tableau,4, 2, 'v');
    // //place_dans_tableau (tableau,4, 4, 'v');
    // printf("%c\n",lecture_du_tableau(tableau,4,2));

    // super_tableau_t* super_tab;
    // super_tab = malloc(sizeof(super_tableau_t));
    // super_tab->taille = 4;
    // super_tab->tableau=nouveau_tableau(super_tab->taille);
    // initialise_tableau(super_tab->tableau,super_tab->taille,'e');
    // affiche_tableau(super_tab->tableau,super_tab->taille);

    // super_tableau_t* super_tab;
    // super_tab = nouveau_super_tableau(4);
    // initialise_super_tableau(super_tab,4);
    // *(super_tab->tableau + 2) = 'e';
    // liberation_du_super_tableau(super_tab);
    // place_dans_super_tableau (super_tab, 2, 'v');
    // printf("%c\n",lecture_du_super_tableau(super_tab,2));

    // chaine_t* chaine;
    // chaine = nouveau_super_tableau(4);
    // initialise_super_tableau(chaine,'a');
    // *(chaine->tableau + 2) = 'e';
    // printf("%d\n",chaine_est_valide(chaine));
    // *(chaine->tableau + 3) = '\0';
    // affiche_super_tableau(chaine);
    // printf("%d\n",chaine_est_valide(chaine));
    // printf("%d\n",taille_de_la_chaine(chaine));
    // affiche_chaine(chaine);

    // chaine_t* chaine;
    // chaine = nouveau_super_tableau(10);
    // *(chaine->tableau + 0) = 't';
    // *(chaine->tableau + 1) = 'o';
    // *(chaine->tableau + 2) = 't';
    // *(chaine->tableau + 3) = '\0';
    // affiche_chaine(chaine);
    // ajoute_caractere (chaine, 'o');
    // affiche_chaine(chaine);

    // chaine_t* chaine;
    // chaine = nouveau_super_tableau(4);
    // *(chaine->tableau + 0) = 't';
    // *(chaine->tableau + 1) = 'o';
    // *(chaine->tableau + 2) = 't';
    // *(chaine->tableau + 3) = '\0';
    // affiche_chaine(chaine);
    // allonge_tableau_de_la_chaine(chaine);
    // ajoute_caractere (chaine, 'o');
    // affiche_chaine(chaine);

    chaine_t* chaine1;
    chaine_t* chaine2;
    chaine_t* chaine3;
    chaine1 = nouveau_super_tableau(3);
    chaine2 = nouveau_super_tableau(3);
    initialise_super_tableau(chaine1,'a');
    initialise_super_tableau(chaine2,'b');
    chaine3 = ajoute_chaine(chaine1, chaine2);
    affiche_chaine(chaine3);

    return 0;
}