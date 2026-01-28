import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        TradingPlatform plat = new TradingPlatform();

        int choice = 0;

        do {
            System.out.println("===========================================");
            System.out.println("Welcom to Xtrader");
            System.out.println("===========================================");
            System.out.println("1.Trader");
            System.out.println("2.Admin");
            System.out.println("0.QUITTER");
            System.out.println("Ecrivez votre choice: ");
            choice = input.nextInt();
            input.nextLine();




        if(choice == 1){
            int choiceTrader = 0;
            do {
                System.out.println("1.Passer un ordre d'ACHAT");
                System.out.println("2.Passer un ordre de VENTE");
                System.out.println("3.Consulter le portefeuille d'un trader");
                System.out.println("4.Afficher l'historique des transactions");
                System.out.println("0.QUITTER");

                System.out.println("Entre un choice: ");
                choiceTrader = input.nextInt();
                input.nextLine();

                switch (choiceTrader){
                    case 1:
                        System.out.println("=========Passer un ordre d'ACHAT==========");
                        break;
                    case 2:
                        System.out.println("=========Passer un ordre de VENTE==========");
                        break;
                    case 3:
                        System.out.println("=========Consulter le portefeuille d'un trader==========");
                        break;
                    case 4:
                        System.out.println("=========Afficher l'historique des transactions==========");
                        break;
                    default:
                        System.out.println("QUITTER");

                }

            }while (choiceTrader !=0);
        }else if (choice == 2){
            int choiceAdmin = 0;
            do {
                System.out.println("1.Créer un compte");
                System.out.println("2.Ajouter un nouvel actif");
                System.out.println("3.Afficher la liste des actifs disponibles");
                System.out.println("0.QUITTER");

                System.out.println("Entre un choice: ");
                choiceAdmin = input.nextInt();
                input.nextLine();

                switch (choiceAdmin){
                    case 1:
                        System.out.println("=========Créer un compte==========");
                        plat.ajouteTrader(input);
                        break;
                    case 2:
                        System.out.println("=========Ajouter un nouvel actif==========");
                        break;
                    case 3:
                        System.out.println("=========Afficher la liste des actifs disponibles==========");
                        break;
                    default:
                        System.out.println("QUITTER");


                }

            }while (choiceAdmin !=0);
        }
        }while (choice !=0);
        }


    }