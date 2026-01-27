public class Asset {
    private int code;
    private String nomAsset;
    private double prix;
    private String type;

    public Asset(int code, String nomAsset, double prix, String type) {
        this.code = code;
        this.nomAsset = nomAsset;
        this.prix = prix;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "code=" + code +
                ", nomAsset='" + nomAsset + '\'' +
                ", prix=" + prix +
                ", type='" + type + '\'' +
                '}';
    }
}
