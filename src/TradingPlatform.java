import java.util.ArrayList;
import java.util.Scanner;

public class TradingPlatform {
    private ArrayList<Trader> traders = new ArrayList<>();
    private ArrayList<Asset> assets = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();


    public Trader findTrader(int acc ){
        for (Trader trader : traders){
           if(trader.getId() == acc){
               return trader;

           }
        }
        return null;
    }


    public void ajouteTrader(Scanner input){
        System.out.println("=========Créer un compte=========");
        System.out.println("Ecrivez id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Ecrivez votre nom: ");
        String name = input.nextLine();
        System.out.println("Ecrivez votre sold: ");
        double sold = input.nextDouble();
        input.nextLine();

        Trader trader = new Trader(name, id, sold);
        traders.add(trader);
        System.out.println("tzad binajah");
    }



}
