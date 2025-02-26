package rpgHell;

import java.util.Random;

public class Spieler {
    private String name;
    private String spielerKlasse;
    private int level;
    private int angriff;
    private int praezision;
    private int vitalitaet;
    private int verteidigung;
    private int willenskraft;
    private double maxLebensenergie;
    private double aktuelleLebensenergie;
    private double maxZauberenergie;
    private double aktuelleZauberenergie;
    private static Waffe ausgeruesteteWaffe;
    private Ruestung ausgeruesteteRuestung;

    // Statische Waffe und Rüstung
    public static final Waffe SCHWERT = new Waffe("Schwert", 10, 0);
    public static final Ruestung BRUSTPLATTE = new Ruestung("Brustplatte", 5, 0);

    public Spieler(String name, String spielerKlasse) {
        this.name = name;
        this.spielerKlasse = spielerKlasse;
        this.level = 1;
        initialisiereEigenschaften();
        berechneLebensUndZauberenergie();
    }

    private void initialisiereEigenschaften() {
        switch (spielerKlasse) {
            case "Barbar":
                angriff = 5;
                praezision = 3;
                vitalitaet = 4;
                verteidigung = 2;
                willenskraft = 1;
                break;
            case "Dämonenjäger":
                angriff = 4;
                praezision = 3;
                vitalitaet = 2;
                verteidigung = 2;
                willenskraft = 5;
                break;
            case "Mönch":
                angriff = 3;
                praezision = 4;
                vitalitaet = 3;
                verteidigung = 5;
                willenskraft = 5;
                break;
            case "Hexendoktor":
                angriff = 5;
                praezision = 3;
                vitalitaet = 2;
                verteidigung = 1;
                willenskraft = 5;
                break;
            case "Zauberer":
                angriff = 4;
                praezision = 4;
                vitalitaet = 2;
                verteidigung = 2;
                willenskraft = 5;
                break;
        }
    }

    private void berechneLebensUndZauberenergie() {
        maxLebensenergie = vitalitaet * 10;
        aktuelleLebensenergie = maxLebensenergie;
        maxZauberenergie = willenskraft * 10;
        aktuelleZauberenergie = maxZauberenergie;
    }

    public void waffeAusruesten(Waffe waffe) {
        if (ausgeruesteteWaffe != null) {
            angriff -= ausgeruesteteWaffe.getAngriffswert();
        }
        ausgeruesteteWaffe = waffe;
        angriff += waffe.getAngriffswert();
    }

    public void waffeAblegen() {
        if (ausgeruesteteWaffe != null) {
            angriff -= ausgeruesteteWaffe.getAngriffswert();
            ausgeruesteteWaffe = null;
        }
    }

    public void ruestungAnlegen(Ruestung ruestung) {
        if (ausgeruesteteRuestung != null) {
            verteidigung -= ausgeruesteteRuestung.getRuestungswert();
        }
        ausgeruesteteRuestung = ruestung;
        verteidigung += ruestung.getRuestungswert();
    }

    public void ruestungAblegen() {
        if (ausgeruesteteRuestung != null) {
            verteidigung -= ausgeruesteteRuestung.getRuestungswert();
            ausgeruesteteRuestung = null;
        }
    }

    public void angreifen(Spieler gegner) {
        Random random = new Random();
        int schaden = random.nextInt(angriff + 1);

        if (ausgeruesteteWaffe != null && !ausgeruesteteWaffe.istKaputt()) {
            ausgeruesteteWaffe.erhoeheReparaturwert(schaden / 2);
            if (ausgeruesteteWaffe.istKaputt()) {
                waffeAblegen();
            }
        }

        int effektiverSchaden = Math.max(0, schaden - gegner.getVerteidigung());
        gegner.schadenNehmen(effektiverSchaden);
    }

    public void schadenNehmen(int schaden) {
        if (ausgeruesteteRuestung != null) {
            int absorbierterSchaden = Math.min(schaden, ausgeruesteteRuestung.getRuestungswert());
            schaden -= absorbierterSchaden;
            ausgeruesteteRuestung.erhoeheReparaturwert(absorbierterSchaden);
            if (ausgeruesteteRuestung.istKaputt()) {
                ruestungAblegen();
            }
        }
        aktuelleLebensenergie -= schaden;
        if (aktuelleLebensenergie < 0) {
            aktuelleLebensenergie = 0;
        }
    }

    public boolean levelUp(boolean erhoeheAngriff, boolean erhoehePraezision, boolean erhoeheVitalitaet,
                           boolean erhoeheVerteidigung, boolean erhoeheWillenskraft) {
        int anzahlErhoehungen = (erhoeheAngriff ? 1 : 0) + (erhoehePraezision ? 1 : 0) +
                (erhoeheVitalitaet ? 1 : 0) + (erhoeheVerteidigung ? 1 : 0) +
                (erhoeheWillenskraft ? 1 : 0);

        if (anzahlErhoehungen > 2 || level >= 40) {
            return false;
        }

        level++;
        if (anzahlErhoehungen == 1) {
            if (erhoeheAngriff) angriff += 2;
            if (erhoehePraezision) praezision += 2;
            if (erhoeheVitalitaet) vitalitaet += 2;
            if (erhoeheVerteidigung) verteidigung += 2;
            if (erhoeheWillenskraft) willenskraft += 2;
        } else {
            if (erhoeheAngriff) angriff++;
            if (erhoehePraezision) praezision++;
            if (erhoeheVitalitaet) vitalitaet++;
            if (erhoeheVerteidigung) verteidigung++;
            if (erhoeheWillenskraft) willenskraft++;
        }

        maxLebensenergie *= 1.05;
        aktuelleLebensenergie *= (maxLebensenergie / aktuelleLebensenergie);

        maxZauberenergie *= 1.05;
        aktuelleZauberenergie *= (maxZauberenergie / aktuelleZauberenergie);

        return true;
    }

    // Getter-Methoden
    public String getName() { return name; }
    public String getSpielerKlasse() { return spielerKlasse; }
    public int getLevel() { return level; }
    public int getAngriff() { return angriff; }
    public int getPraezision() { return praezision; }
    public int getVitalitaet() { return vitalitaet; }
    public int getVerteidigung() { return verteidigung; }
    public int getWillenskraft() { return willenskraft; }
    public double getAktLebensenergie() { return aktuelleLebensenergie; }
    public double getMaxLebensenergie() { return maxLebensenergie; }
    public double getAktZauberenergie() { return aktuelleZauberenergie; }
    public double getMaxZauberenergie() { return maxZauberenergie; }

    public void setAktLebensenergie(double energie) {
        if (energie < 0) {
            this.aktuelleLebensenergie = 0;
        } else if (energie > maxLebensenergie) {
            this.aktuelleLebensenergie = maxLebensenergie;
        } else {
            this.aktuelleLebensenergie = energie;
        }
    }

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