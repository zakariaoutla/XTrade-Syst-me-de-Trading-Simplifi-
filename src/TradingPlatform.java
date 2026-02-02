import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
        System.out.println("==== LISTE DES ACTIFS ====");
        for (Asset a : assets) {
            System.out.println(a);
        }
    }


    public void passerOrdreAchat(Scanner input) {
        Trader t = loginTrader(input);
        if (t == null) return;

        afficherActifs();
        System.out.println("Entre code actifs: ");
        String code = input.nextLine();
        Asset a = findAsset(code);
        if (a == null) return;
        System.out.println("Entre qty: ");
        double qty = input.nextDouble();
        double total = qty * a.getPrice();

        if(t.getBalance()<total){
            System.out.println("Sold insuffisant");
        }else {
            t.withdraw(total);
            t.getPortfolio().addAsset(code, qty);
            history.add(new Transaction("Achat", code, qty, a.getPrice(), new Date()));
            System.out.println("L'opération s'est déroulée avec succés");
            System.out.println("new balance: "+ t.getBalance());
        }
    }

    public void passerOrdreVente(Scanner input) {
        Trader t = loginTrader(input);
        if (t == null) return;

        System.out.println("--- Votre Portefeuille ---");
        t.getPortfolio().afficher();

        System.out.print("Code de l'actif à vendre: ");
        String code = input.next();

        Asset a = findAsset(code);
        if (a == null) {
            System.out.println("Erreur: Cet actif n'existe pas sur le marché.");
            return;
        }

        System.out.print("Quantité: ");
        int qty = input.nextInt();

        boolean success = t.getPortfolio().removeAsset(code, qty);

        if (success) {
            // Calcul du montant gagné
            double totalGain = qty * a.getPrice();

            t.deposit(totalGain);

            history.add(new Transaction("Vente", code, qty, a.getPrice(), new Date()));

            System.out.println("Vente réussie !");
            System.out.println("   Nouveau Solde: " + t.getBalance() + " DH");
        } else {
            System.out.println("Vous ne possédez pas assez de quantité pour cet actif.");
        }
    }

    public void consulterPortefeuille(Scanner input) {
        Trader t = loginTrader(input);
        if (t != null) {
            System.out.println("Solde Cash: " + t.getBalance() + " DH");
            t.getPortfolio().afficher();
        }
    }

    public void afficherHistorique() {
        System.out.println("==== HISTORIQUE GLOBAL ====");
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
        input.nextLine();
        Trader t = findTrader(id);
        if (t == null) System.out.println("Trader introuvable.");
        return t;
    }

    public void transactionsTrader(Scanner input){
        System.out.println("===Recherche de trader===");
        Trader tr = loginTrader(input);
        if(tr == null) return;
        System.out.println("=== transaction Trader ===");
        traders.stream()
                .filter(t -> t.getId() == tr.getId())
                .forEach(System.out::println);

    }

    public void transactionsType(Scanner input){
        System.out.println("===Recherche de trader===");
        System.out.println("Entre code : ");
        String code = input.nextLine();
        Asset asset = findAsset(code);
        if(asset == null) return;
        System.out.println("=== transaction Trader ===");
        assets.stream()
                .filter(as -> as.getCode().equals(code) )
                .forEach(System.out::println);

    }
}