import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TradingPlatform plat = new TradingPlatform();

        int choice = 0;

        do {
            try {
            System.out.println("\n===========================================");
            System.out.println("       Bienvenue sur XTrade");
            System.out.println("===========================================");
            System.out.println("1.TRADER");
            System.out.println("2.ADMIN");
            System.out.println("0. QUITTER");
            System.out.print("Votre choix: ");

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                int choiceTrader = 0;
                do {
                    System.out.println("\n--- MENU TRADER ---");
                    System.out.println("1. Passer un ordre d'ACHAT");
                    System.out.println("2. Passer un ordre de VENTE");
                    System.out.println("3. Consulter le portefeuille");
                    System.out.println("4. Historique Global");
                    System.out.println("5. Transactions d’un trader");
                    System.out.println("6. Recherche de trader par type");
                    System.out.println("7. Recherche de trader par code");
                    System.out.println("8. Trier les transactions par : date, montant");
                    System.out.println("9. Afficher le bilan (Volume & Totaux)");
                    System.out.println("10. volume total échangé par trader");
                    System.out.println("11. nombre total d’ordres passés");
                    System.out.println("12. Classement des traders par volume (top N traders)");
                    System.out.println("0. Retour");
                    System.out.print("Choix: ");

                    choiceTrader = input.nextInt();
                    input.nextLine();

                    switch (choiceTrader) {
                        case 1:
                            plat.passerOrdreAchat(input);
                            break;
                        case 2:
                            plat.passerOrdreVente(input);
                            break;
                        case 3:
                            plat.consulterPortefeuille(input);
                            break;
                        case 4:
                            plat.afficherHistorique();
                            break;
                        case 5:
                            plat.transactionsTrader(input);
                            break;
                        case 6:
                            plat.transactionsType(input);
                            break;
                        case 7:
                            plat.transactionsByActifs(input);
                            break;
                        case 8:
                            plat.sortHistoryAndDisplay();
                            break;
                        case 9:
                            plat.afficherBilanGlobal();
                            break;
                        case 10:
                            plat.volumeParTrader(input);
                            break;
                        case 11:
                            plat.nombreTotalOrdres();
                            break;
                        case 12:
                            plat.topTradersParVolume(input);
                        case 0:
                            break;
                        default: System.out.println("Choix invalide.");
                    }
                } while (choiceTrader != 0);

            } else if (choice == 2) {
                int choiceAdmin = 0;
                do {
                    System.out.println("\n--- MENU ADMIN ---");
                    System.out.println("1. Créer un compte Trader");
                    System.out.println("2. Ajouter un nouvel Actif");
                    System.out.println("3. Afficher les Actifs disponibles");
                    System.out.println("0. Retour");
                    System.out.print("Choix: ");

                    choiceAdmin = input.nextInt();
                    input.nextLine();

                    switch (choiceAdmin) {
                        case 1:
                            plat.ajouteTrader(input);
                            break;
                        case 2:
                            plat.ajouterActif(input);
                        break;
                        case 3:
                            plat.afficherActifs();
                        break;
                        case 0:
                            break;
                        default: System.out.println("Choix invalide.");
                    }
                } while (choiceAdmin != 0);
            }else {
                System.out.println("Au revoir !");
            }
        }catch (InputMismatchException exception){
                System.out.println("Input invalid");
                input.nextLine();
            }

        } while (choice != 0);


    }
}