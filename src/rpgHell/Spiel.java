package rpgHell;

public class Spiel {

    private int level;
    private String name, spielerKlasse;
    private int angriff, praezision, vitalitaet, verteidigung, willenskraft;
    private double maxLebensenergie, aktuelleLebensenergie;
    private double maxZauberenergie, aktuelleZauberenergie;

    public Spiel(String name, String spielerKlasse) {
        this.name = name;
        this.spielerKlasse = spielerKlasse;
        this.level = 1;
        stats();
    }

    private void stats() {
        switch (spielerKlasse) {
            case "Barbar":
                angriff = 5; praezision = 3; vitalitaet = 4; verteidigung = 2; willenskraft = 1;
                break;
            case "Dämonenjäger":
                angriff = 4; praezision = 3; vitalitaet = 2; verteidigung = 2; willenskraft = 5;
                break;
            case "Mönch":
                angriff = 3; praezision = 4; vitalitaet = 3; verteidigung = 5; willenskraft = 5;
                break;
            case "Hexendoktor":
                angriff = 5; praezision = 3; vitalitaet = 2; verteidigung = 1; willenskraft = 5;
                break;
            case "Zauberer":
                angriff = 4; praezision = 4; vitalitaet = 2; verteidigung = 2; willenskraft = 5;
                break;
        }
    }

    // Getter-Methoden
    public String getName() { return name; }
    public String getSpielerKlasse() { return spielerKlasse; }
    public int getAngriff() { return angriff; }
    public int getPraezision() { return praezision; }
    public int getVitalitaet() { return vitalitaet; }
    public int getVerteidigung() { return verteidigung; }
    public int getWillenskraft() { return willenskraft; }

    public double getMaxLebensenergie() { return maxLebensenergie; }
    public double getAktLebensenergie() { return aktuelleLebensenergie; }
    public double getMaxZauberenergie() { return maxZauberenergie; }
    public double getAktZauberenergie() { return aktuelleZauberenergie; }

    public void setAktLebensenergie(double energie) {
        if (energie < 0) {
            this.aktuelleLebensenergie = 0;
        } else if (energie > maxLebensenergie) {
            this.aktuelleLebensenergie = maxLebensenergie;
        } else {
            this.aktuelleLebensenergie = energie;
        }
    }

    // Setter-Methode für aktuelle Zauberenergie
    public void setAktZauberenergie(double energie) {
        if (energie < 0) {
            this.aktuelleZauberenergie = 0;
        } else if (energie > maxZauberenergie) {
            this.aktuelleZauberenergie = maxZauberenergie;
        } else {
            this.aktuelleZauberenergie = energie;
        }
    }
}