
import java.util.*;
import java.util.stream.Collectors;

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
            history.add(new Transaction("Achat", a,t, qty, a.getPrice(), new Date()));
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
            double totalGain = qty * a.getPrice();

            t.deposit(totalGain);

            history.add(new Transaction("Vente", a, t,qty, a.getPrice(), new Date()));

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
            System.out.println("Name : "+ t.getTrader().name);
            System.out.println("Labale: "+ t.getAsset().getLabel());
            System.out.println("qty: "+ t.getQty());
            System.out.println("price: " +t.getPrice());
            System.out.println("Type: "+ t.getType());
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
        System.out.println("Entre type: ");
        String type = input.nextLine();
        System.out.println("=== transaction Trader ===");
        history.stream()
                .filter(as -> as.getType().equals(type) )
                .forEach(System.out::println);
    }

    public void transactionsByActifs(Scanner input){
        System.out.println("===Recherche de asset===");
        System.out.println("Entre code: ");
        String code = input.nextLine();
        Asset asset = findAsset(code);
        if (asset == null) return;
        System.out.println("=== transaction asset ===");
        assets.stream().filter(as -> as.getCode().equals(code) )
                .forEach(System.out::println);
    }

    public void sortHistoryAndDisplay() {
        System.out.println("==== HISTORIQUE TRIÉ (DATE & MONTANT) ====");

        history.stream()
                .sorted(Comparator
                        .comparing(Transaction::getDate)
                        .thenComparingDouble(Transaction::getPrice))
                .forEach(t -> {
                    System.out.println(t.getDate() + " | " + t.getAsset().getLabel() +
                            " | " + t.getPrice() + " DH | " + t.getType());
                });
    }

    public void afficherBilanGlobal() {
        System.out.println("========== BILAN GLOBAL DE LA PLATEFORME ==========");
        double totalAchats = history.stream()
                .filter(t -> t.getType().equalsIgnoreCase("Achat"))
                .mapToDouble(t -> t.getQty() * t.getPrice())
                .sum();

        double totalVentes = history.stream()
                .filter(t -> t.getType().equalsIgnoreCase("Vente"))
                .mapToDouble(t -> t.getQty() * t.getPrice())
                .sum();

        Map<String, Double> volumeMap = history.stream()
                .collect(Collectors.groupingBy(
                        t -> t.getAsset().getLabel(),
                        Collectors.summingDouble(Transaction::getQty)
                ));
        System.out.println(">> Montant Total des ACHATS : " + totalAchats + " DH");
        System.out.println(">> Montant Total des VENTES : " + totalVentes + " DH");
        System.out.println("---------------------------------------------------");
        System.out.println(">> Volume échangé par Actif :");
        volumeMap.forEach((label, vol) -> System.out.println("   - " + label + " : " + vol));
        System.out.println("===================================================");
    }

    public void volumeParTrader(Scanner input) {
        Trader trader = loginTrader(input);
        if (trader == null) return;
        double totalVolume = history.stream()
                .filter(t -> t.getTrader().getId() == trader.getId())
                .mapToDouble(Transaction::getQty)
                .sum();
        System.out.println("Volume total pour le Trader ID " + trader.getId() + " : " + totalVolume);
    }

    public void nombreTotalOrdres() {
        long count = history.stream().count();
        System.out.println("Nombre total d'ordres passés sur la plateforme : " + count);
    }

    public void topTradersParVolume(Scanner input) {
        System.out.print("Combien de top traders afficher ? ");
        int n = input.nextInt();

        System.out.println("==== TOP " + n + " TRADERS PAR VOLUME ====");

        Map<String, Double> traderVolumeMap = history.stream()
                .collect(Collectors.groupingBy(
                        t -> t.getTrader().name,
                        Collectors.summingDouble(Transaction::getQty)
                ));

        traderVolumeMap.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(n)
                .forEach(entry -> System.out.println("- " + entry.getKey() + " : " + entry.getValue() + " unités"));
    }
}