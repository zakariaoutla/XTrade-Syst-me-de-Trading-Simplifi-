import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TradingPlatform plat = new TradingPlatform();

        int choice = 0;

        do {
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
            }

        } while (choice != 0);

        System.out.println("Au revoir !");
        input.close();
    }
}