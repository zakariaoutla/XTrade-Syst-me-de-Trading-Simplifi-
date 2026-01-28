public class Asset {
    private int code;
    private String nomAsset;
    private double prix;

    public Asset(int code, String nomAsset, double prix) {
        this.code = code;
        this.nomAsset = nomAsset;
        this.prix = prix;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNomAsset() {
        return nomAsset;
    }

    public void setNomAsset(String nomAsset) {
        this.nomAsset = nomAsset;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }


    @Override
    public String toString() {
        return "Asset{" +
                "code=" + code +
                ", nomAsset='" + nomAsset + '\'' +
                ", prix=" + prix +
                '}';
    }
}
