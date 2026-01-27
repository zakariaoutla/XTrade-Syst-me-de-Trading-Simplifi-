import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        TradingPlatform plat = new TradingPlatform();


        int choice = 0;
        System.out.println("===========================================");
        System.out.println("Welcom to Xtrader");
        System.out.println("===========================================");
        System.out.println("1.Créer un compte");
        System.out.println("2.Se connecter");
        System.out.println("Ecrivez votre choice: ");
        choice = input.nextInt();
        input.nextLine();

        if (choice == 1){
            System.out.println("=========Créer un compte=========");
            plat.ajouteTrader(input);
            plat.verifyLogin(input);



        }else if(choice == 2){
            System.out.println("=========Content de te revoir=========");
            plat.verifyLogin(input);

        }else {
            System.out.println("choice Invalid");
        }


    }

    public static void traderMenu(Scanner input){
        int choice = 0;
        do {
            System.out.println("1.Passer un ordre d'ACHAT");
            System.out.println("2.Passer un ordre de VENTE");
            System.out.println("3.Consulter le portefeuille d'un trader");
            System.out.println("4.Afficher l'historique des transactions");
            System.out.println("0.QUITTER");

            System.out.println("Entre un choice: ");
            choice = input.nextInt();
            input.nextLine();

        }while (choice !=0);
    }

    public static void adminMenu(Scanner input){
        int choice = 0;
        do {
            System.out.println("1.Ajouter un nouvel actif");
            System.out.println("2.Afficher la liste des actifs disponibles");
            System.out.println("0.QUITTER");

            System.out.println("Entre un choice: ");
            choice = input.nextInt();
            input.nextLine();

        }while (choice !=0);
    }




}