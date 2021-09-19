package projet.sio;

public class Demineur {

    /**
     * Procedure d'initialisation de la Grille ENTREE : tPrincipal, tValeur
     * UPDATE : ajout de paramettre pour definir le nombre de mines selon
     * leniveau
     *
     * @param tPrincital
     * @param tval
     * @param nbMines
     */
    public static void initialisationTableau(char tPrincital[], char tval[], int nbMines) {
        int nbM = 0;
        for (int i = 0; i < tPrincital.length; ++i) {
            int positionValeur = (int) (Math.random() * (double) tval.length);

            /*nbM : création de niveau possible*/
            if (nbM < nbMines & tval[positionValeur] == 'M') {
                tPrincital[i] = 'M';
                nbM += 1;
            } else {
                tPrincital[i] = ' ';
            }
        }
    }

    /**
     * Procdure affichant la Grille du Jeu Demineur à la fin du jeu GRILLE : 10
     * x 10 ENTREE : TDemineur, TLettres, tChiffres
     *
     * @param tDemineur
     * @param tLettres
     * @param tChiffres
     */
    public static void afficheGrilleDemineurBombe(char tDemineur[], char tLettres[], String tChiffres[]) {

        //Affichage des lettres
        for (int i = 0; i < tLettres.length; i++) {
            System.out.print(tLettres[i] + " ");
        }

        //Affichage du reste du tableau
        int indices = 0;
        for (int i = 0; i < tDemineur.length; i++) {

            //Affiche les chiffres verticales de la Grille
            if ((float) i % 10 == 0.0 & indices < tChiffres.length) {
                System.out.print('\n');
                System.out.print(tChiffres[indices] + ' ');
                indices++;
            }

            //Affichage des Mines
            if (tDemineur[i] == 'M') {
                System.out.print("M ");
            } else //affichage des nombre de bombe
            switch(tDemineur[i]){
                case 1 :
                case 2 :
                case 3 :
                case 4 :
                case 5 :
                case 6 :
                case 7 :
                case 8 :
                    System.out.print(tDemineur[i] + " ");
                    break;
                default :
                    System.out.print("- ");   
            }
        }
        System.out.println('\n');
    }

    /**
     * Procdure affichant la Grille du Jeu Demineur pour les utilisateurs GRILLE
     * : 10 x 10 ENTREE : TDemineurUtilisateur, tLettres, tChiffres
     *
     * @param tDemineurUtilisateur
     * @param tLettres
     * @param tChiffres
     */
    public static void afficheGrilleDemineurUtilisateur(int tDemineurUtilisateur[], char tLettres[], String tChiffres[]) {

        //Affichage des lettres
        for (int i = 0; i < tLettres.length; i++) {
            //Decalage des lettres pour un bon affichage
            System.out.print(" " + tLettres[i]);
        }

        //Affichage du reste du tableau
        int indices = 0;
        for (int i = 0; i < tDemineurUtilisateur.length; i++) {

            //Affiche les chiffres verticales de la Grille
            if ((float) i % 10 == 0.0 & indices < tChiffres.length) {
                System.out.print('\n');
                if (tChiffres[indices].equals("10")) {
                    System.out.print(tChiffres[indices] + " ");
                } else {
                    System.out.print(tChiffres[indices] + "  ");
                }
                indices++;
            }
            //affichage des nombre de bombe
            switch(tDemineurUtilisateur[i]){
                case 1 :
                case 2 :
                case 3 :
                case 4 :
                case 5 :
                case 6 :
                case 7 :
                case 8 :
                    System.out.print(tDemineurUtilisateur[i] + " ");
                    break;
                default :
                    System.out.print("- ");   
            }
        }
        System.out.println('\n');
    }

    /**
     * Procedure permettant de convertir les lettre et les chiffres des
     * coordonnees
     *
     * @param position
     * @return
     */
    public static int convertionLettreEtChiffre(char position) {
        int resultat = 0;
        switch (position) {
            case 'A':
                resultat = 1;
                break;
            case 'B':
                resultat = 2;
                break;
            case 'C':
                resultat = 3;
                break;
            case 'D':
                resultat = 4;
                break;
            case 'E':
                resultat = 5;
                break;
            case 'F':
                resultat = 6;
                break;
            case 'G':
                resultat = 7;
                break;
            case 'H':
                resultat = 8;
                break;
            case 'I':
                resultat = 9;
                break;
            case 'J':
                resultat = 10;
                break;

            case '1':
                resultat = 0;
                break;
            case '2':
                resultat = 10;
                break;
            case '3':
                resultat = 20;
                break;
            case '4':
                resultat = 30;
                break;
            case '5':
                resultat = 40;
                break;
            case '6':
                resultat = 50;
                break;
            case '7':
                resultat = 60;
                break;
            case '8':
                resultat = 70;
                break;
            case '9':
                resultat = 80;
                break;
            case '0':
                resultat = 90;
                break;
        }
        return resultat;
    }

    /**
     * Fonction qui convertie la position entree par l'utilisateur en celui du
     * tableau ENTREE : Coordonee untilisateur SORTIE : Index tableau (position)
     *
     * @param coordonnee
     * @return
     */
    public static int convertionPosition(String coordonnee) {
        int coordo1;
        int coordo2;
        int coordo3;
        // -1 : pour les cas d'erreur
        int position = -1;
        if (coordonnee.length() == 2) {
            coordo1 = convertionLettreEtChiffre(coordonnee.charAt(0));
            coordo2 = convertionLettreEtChiffre(coordonnee.charAt(1));
            position = coordo1 + coordo2;
        } else if (coordonnee.length() == 3) {
            coordo1 = convertionLettreEtChiffre(coordonnee.charAt(0));
            coordo2 = convertionLettreEtChiffre(coordonnee.charAt(1));
            coordo3 = convertionLettreEtChiffre(coordonnee.charAt(2));
            position = coordo1 + coordo2 + coordo3;
        }

        //(-1) pour l'index du tableau
        return position - 1;
    }

    /**
     * Fonction retournant un booléen pour savoir si la position est un coin de
     * la grille
     *
     * @param position
     * @return
     */
    public static boolean estUnCoin(int position) {
        return position == 0 | position == 9 | position == 90 | position == 99;
    }

    /**
     * Fonction retournant un booléen pour savoir si la position fait partie des
     * extrémité de la grille
     *
     * @param position
     * @return
     */
    public static boolean estUneExtremite(int position) {
        return position > 1 && position < 8 || position % 10 == 0
                || position % 10 == 9 || position > 91 && position < 98;
    }

    /**
     * Fonction qui compte le nombre de bombe autour du nombre choisi
     *
     * @param tDemineur
     * @param position
     * @return le nombre de bombes
     */
    public static int nombreBombesAutourPosition(char tDemineur[], int position) {
        boolean coin = estUnCoin(position);
        boolean extremite = estUneExtremite(position);
        int compteBombes = 0;

        //selon les coins, et les extrimités du tableau
        if (coin) {
            switch (position) {
                // coin haut-gauche
                case 0:
                    if (tDemineur[position + 1] == 'M') {
                        compteBombes++;
                    } else if (tDemineur[position + 10] == 'M') {
                        compteBombes++;
                    } else if (tDemineur[position + 11] == 'M') {
                        compteBombes++;
                    }
                    return compteBombes;

                // coin haut-droite
                case 9:
                    if (tDemineur[position - 1] == 'M') {
                        compteBombes++;
                    } else if (tDemineur[position + 9] == 'M') {
                        compteBombes++;
                    } else if (tDemineur[position + 10] == 'M') {
                        compteBombes++;
                    }
                    return compteBombes;

                // coin bas-droite
                case 90:
                    if (tDemineur[position - 10] == 'M') {
                        compteBombes++;
                    } else if (tDemineur[position - 9] == 'M') {
                        compteBombes++;
                    } else if (tDemineur[position + 1] == 'M') {
                        compteBombes++;
                    }
                    return compteBombes;

                // coin en bas-gauche
                case 99:
                    if (tDemineur[position - 1] == 'M') {
                        compteBombes++;
                    } else if (tDemineur[position - 10] == 'M') {
                        compteBombes++;
                    } else if (tDemineur[position - 11] == 'M') {
                        compteBombes++;
                    }
                    return compteBombes;
            }
        } else if (extremite) {

            //Position extremite haute
            if (position > 1 && position < 8) {
                if (tDemineur[position - 1] == 'M') {
                    compteBombes++;
                } else if (tDemineur[position + 1] == 'M') {
                    compteBombes++;
                } else if (tDemineur[position + 9] == 'M') {
                    compteBombes++;
                } else if (tDemineur[position + 10] == 'M') {
                    compteBombes++;
                } else if (tDemineur[position + 11] == 'M') {
                    compteBombes++;
                }
                return compteBombes;

                //Position extremite gauche
            } else if (position % 10 == 0) {
                if (tDemineur[position - 10] == 'M') {
                    compteBombes++;
                } else if (tDemineur[position - 9] == 'M') {
                    compteBombes++;
                } else if (tDemineur[position + 1] == 'M') {
                    compteBombes++;
                } else if (tDemineur[position + 10] == 'M') {
                    compteBombes++;
                } else if (tDemineur[position + 11] == 'M') {
                    compteBombes++;
                }
                return compteBombes;

                //Position extremite droite
            } else if (position % 10 == 9) {
                if (tDemineur[position - 11] == 'M') {
                    compteBombes++;
                } else if (tDemineur[position - 10] == 'M') {
                    compteBombes++;
                } else if (tDemineur[position - 1] == 'M') {
                    compteBombes++;
                } else if (tDemineur[position + 9] == 'M') {
                    compteBombes++;
                } else if (tDemineur[position + 10] == 'M') {
                    compteBombes++;
                }
                return compteBombes;

                // Position extremite bas
            } else if (position > 91 && position < 98) {
                if (tDemineur[position - 11] == 'M') {
                    compteBombes++;
                } else if (tDemineur[position - 10] == 'M') {
                    compteBombes++;
                } else if (tDemineur[position - 9] == 'M') {
                    compteBombes++;
                } else if (tDemineur[position - 1] == 'M') {
                    compteBombes++;
                } else if (tDemineur[position + 10] == 'M') {
                    compteBombes++;
                }
                return compteBombes;
            }
        }

        if (coin == false & extremite == false) {
            if (tDemineur[position - 11] == 'M') {
                compteBombes++;
            } else if (tDemineur[position - 10] == 'M') {
                compteBombes++;
            } else if (tDemineur[position - 9] == 'M') {
                compteBombes++;
            } else if (tDemineur[position - 1] == 'M') {
                compteBombes++;
            } else if (tDemineur[position + 1] == 'M') {
                compteBombes++;
            } else if (tDemineur[position + 9] == 'M') {
                compteBombes++;
            } else if (tDemineur[position + 10] == 'M') {
                compteBombes++;
            } else if (tDemineur[position + 11] == 'M') {
                compteBombes++;
            }
            return compteBombes;
        }
        return -1;
    }

    /**
     * Affivhage grille utilisateur en cours de partie
     *
     * @param tDemineurUtilisateur
     * @param tLettres
     * @param tChiffres
     */
    public static void afficheGrilleUtilisateurEntamee(int tDemineurUtilisateur[], char tLettres[], String tChiffres[]) {

        //Affichage des lettres
        for (int i = 0; i < tLettres.length; i++) {
            //Decalage des lettres pour un bon affichage
            System.out.print(" " + tLettres[i]);
        }

        //Affichage du reste du tableau
        int indices = 0;
        for (int i = 0; i < tDemineurUtilisateur.length; i++) {

            //Affiche les chiffres verticales de la Grille
            if ((float) i % 10 == 0.0 & indices < tChiffres.length) {
                System.out.print('\n');
                if (tChiffres[indices].equals("10")) {
                    System.out.print(tChiffres[indices] + " ");
                } else {
                    System.out.print(tChiffres[indices] + "  ");
                }
                indices++;
            }
            

            //affichage des nombre de bombe
            switch(tDemineurUtilisateur[i]){
                case 1 :
                case 2 :
                case 3 :
                case 4 :
                case 5 :
                case 6 :
                case 7 :
                case 8 :
                    System.out.print(tDemineurUtilisateur[i] + " ");
                    break;
                default :
                    System.out.print("- ");   
            }
        }
        System.out.println('\n');
    }
    
    
}
