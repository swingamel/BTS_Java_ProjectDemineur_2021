/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.sio;

import plum.console.Clavier;

public class HelloDemineur {

    public static void main(String[] args) {
        System.out.println("Hello Démineur !!");

        //Creation des tableaux
        int TAILLE = 100;
        char tDemineurAdmin[] = new char[TAILLE];
        int tDemineurUtilisateur[] = new int[TAILLE];
        char tLettres[] = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        String tChiffres[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        char tValMines[] = {' ', 'M'};
        int nbMine = 25;
        int nbCaseVide = TAILLE - nbMine;

        //initialisation du tableau Demineur
        Demineur.initialisationTableau(tDemineurAdmin, tValMines, nbMine);

        /**
         * Partie de l'utilisateur
         */
        System.out.println("***** Jouons au Démineur ! *****");
        System.out.println("\n--- Legende ---");
        System.out.println(" * : saisie de tout type pour un MODE\n");
        Demineur.afficheGrilleDemineurUtilisateur(tDemineurUtilisateur, tLettres, tChiffres);

        //Saisir un mode : utilisateur ou admin
        String choixMode = Clavier.lireTexte("Saisir un mode ? (*/admin) : ");

        if (!"admin".equals(choixMode)) {
            
            //Mode utilisateur choisi
            System.out.println("\n");
            int coordonneeConvertie; //pour index dans tableau selon position
            int nbBombes; // pour nombre autour de position choisie
            String choix;

            do {
                choix = Clavier.lireTexte("Voulez-vous continuer? (q : quitter) : ");
                String position = Clavier.lireTexte("Saisir une position : ");
                //Conversion de la position en index de tab
                coordonneeConvertie = Demineur.convertionPosition(position);
                System.out.println("Index : " + coordonneeConvertie);

                if (coordonneeConvertie > -1) {
                    nbBombes = Demineur.nombreBombesAutourPosition(tDemineurAdmin, coordonneeConvertie);
                    tDemineurUtilisateur[coordonneeConvertie] = nbBombes;
                    if (tDemineurAdmin[coordonneeConvertie] != 'M') {
                        nbCaseVide --;
                    }
                    //Affichage grille utilisateur
                    Demineur.afficheGrilleDemineurUtilisateur(tDemineurUtilisateur, tLettres, tChiffres);
                } else {
                    System.out.println("Erreur de saisie!");
                }
            } while (!"q".equals(choix) || tDemineurAdmin[coordonneeConvertie] != 'M' || nbCaseVide == 0);

            if (nbCaseVide == 0) {
                 Demineur.afficheGrilleDemineurBombe(tDemineurAdmin, tLettres, tChiffres);
                System.out.println("Vous avez gagné !");
                System.out.println("A une prochaine !");
            }else{
                Demineur.afficheGrilleDemineurBombe(tDemineurAdmin, tLettres, tChiffres);
                System.out.println("Vous avez perdu !");
                System.out.println("Dommage, à une prochaine !");
            }
                      
        } else {
            Demineur.afficheGrilleDemineurBombe(tDemineurAdmin, tLettres, tChiffres);
        }

    }

}
