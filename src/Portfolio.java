import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private class PortfolioLine {
        String code;
        double quantity;

        public PortfolioLine(String code, double quantity) {
            this.code = code;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "PortfolioLine{" +
                    "code='" + code + '\'' +
                    ", quantity=" + quantity +
                    '}';
        }
    }

    private List<PortfolioLine> lines = new ArrayList<>();

    public void addAsset(String code, double qty) {
        for (PortfolioLine line : lines) {
            if (line.code.equals(code)) {
                line.quantity += qty;
                return;
            }
        }
        lines.add(new PortfolioLine(code, qty));
    }

    public boolean removeAsset(String code, double qty) {
        for (int i = 0; i < lines.size(); i++) {
            PortfolioLine line = lines.get(i);

            if (line.code.equals(code)) {
                if (line.quantity < qty) {
                    return false;
                }

                line.quantity -= qty;

                if (line.quantity == 0) {
                    lines.remove(i);
                }
                return true;
            }
        }
        return false;
    }

    public void afficher() {
        if (lines.isEmpty()) {
            System.out.println("   (Portefeuille vide)");
            return;
        }
        for (PortfolioLine line : lines) {
            System.out.println("   - Actif: " + line.code + " | Qte: " + line.quantity);
        }
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "lines=" + lines +
                '}';
    }
}