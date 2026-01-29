import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TradingPlatform {
    private List<Trader> traders = new ArrayList<>();
    private List<Asset> assets = new ArrayList<>();
    private List<Transaction> history = new ArrayList<>();


    public void ajouteTrader(Scanner input) {
        System.out.print("Entrez ID: ");
        int id = input.nextInt();

        if (findTrader(id) != null) {
            System.out.println("ID existe déjà !");
            return;
        }

        System.out.print("Entrez Nom: ");
        String name = input.next();
        System.out.print("Solde initial: ");
        double balance = input.nextDouble();

        traders.add(new Trader(id, name, balance));
        System.out.println("Trader ajouté avec succès !");
    }

    public void ajouterActif(Scanner input) {
        System.out.println("Type?");
        System.out.println("1.Action(Stock)");
        System.out.println("2.Crypto");
        int type = input.nextInt();
        System.out.print("Code: ");
        String code = input.next();
        System.out.print("Label: ");
        String label = input.next();
        System.out.print("Prix: ");
        double price = input.nextDouble();

        if (type == 1) {
            assets.add(new Stock(code, label, price));
        } else {
            assets.add(new CryptoCurrency(code, label, price));
        }
        System.out.println("Actif ajouté !");
    }

    public void afficherActifs() {
        System.out.println("--- LISTE DES ACTIFS ---");
        for (Asset a : assets) {
            System.out.println(a);
        }
    }


    public void passerOrdreAchat(Scanner input) {

    }

    public void passerOrdreVente(Scanner input) {

    }

    public void consulterPortefeuille(Scanner input) {

    }

    public void afficherHistorique() {
        System.out.println("--- HISTORIQUE GLOBAL ---");
        for (Transaction t : history) {
            System.out.println(t);
        }
    }

    private Trader findTrader(int id) {
        for (Trader t : traders) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    private Asset findAsset(String code) {
        for (Asset a : assets) {
            if (a.getCode().equals(code)) return a;
        }
        return null;
    }

    private Trader loginTrader(Scanner input) {
        System.out.print("Entrez votre ID Trader: ");
        int id = input.nextInt();
        Trader t = findTrader(id);
        if (t == null) System.out.println("Trader introuvable.");
        return t;
    }
}