import java.util.ArrayList;
import java.util.Scanner;

public class TradingPlatform {
    private ArrayList<Trader> traders = new ArrayList<>();
    private ArrayList<Asset> assets = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();




    public Trader findTrader(String acc ){
        for (Trader trader : traders){
           if(trader.getEmail().equals(acc)){
               return trader;

           }
        }
        return null;
    }


    public void ajouteTrader(Scanner input){
        System.out.println("Ecrivez id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Ecrivez votre nom: ");
        String name = input.nextLine();
        System.out.println("Ecrivez votre sold: ");
        double sold = input.nextDouble();
        input.nextLine();
        System.out.println("Ecrivez votre email: ");
        String email = input.nextLine();
        System.out.println("Ecrivez votre password: ");
        String password = input.nextLine();

        Trader trader = new Trader(name,email, password, id, sold);
        traders.add(trader);
        System.out.println("tzad binajah");
    }

    public void verifyLogin(Scanner input){
        System.out.println("Ecrivez votre email: ");
        String email = input.nextLine();
        Trader trader = findTrader(email);
        if (trader != null){
            System.out.println("Entre votre password: ");
            String password = input.nextLine();
            Trader trader1 = findTrader(password);
            if (trader1 != null){
                System.out.println("rak dkhalty");
            }
        }


    }






}
