package rpg3;

import java.util.ArrayList;
import java.util.Random;

public class Spieler {

    // Datenfelder
    private String name, spielerKlasse;
    private int level, angriff, praezision, vitalitaet, verteidigung, willenskraft;
    private int lebensenergie, zauberenergie;
    private double maxLebensenergie, maxZauberenergie;
    private static final int MAX_LEVEL = 40;
    private Waffe ausgeruesteteWaffe;
    private Rüstungsklasse ausgeruesteteRuestung;
    private Räume raum;
    private String typ;
    private ArrayList<Zaubertränke> tränke = new ArrayList<>(3);

    public Spieler(String name, String typ, Räume raum) {
        this.name = name;
        this.typ = typ;
        this.raum = raum;
        initializeSpieler(typ);
    }

    public ArrayList<Zaubertränke> getTränke() {
        return tränke;
    }

    public String getTyp() {
        return typ;
    }

    public double getMaxZauberenergie() {
        return maxZauberenergie;
    }

    public String getSpielerKlasse() {
        return spielerKlasse;
    }
    private void initializeSpieler(String klasse) {
        level = 1;
        this.spielerKlasse = klasse;
        switch (klasse) {
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
            default:
                System.out.println("Ungültige Klasse! Standardwerte werden verwendet.");
                angriff = praezision = vitalitaet = verteidigung = willenskraft = 3;
        }

        maxLebensenergie = maxZauberenergie = 10;
        berechneEnergien();
    }

    private void berechneEnergien() {
        lebensenergie = (int) maxLebensenergie;
        zauberenergie = (int) maxZauberenergie;
    }

    public void zeigeInfo() {
        System.out.println("Name: " + name + ", Klasse: " + spielerKlasse + ", Level: " + level);
        System.out.println("Angriff: " + angriff + ", Präzision: " + praezision + ", Vitalität: " + vitalitaet);
        System.out.println("Verteidigung: " + verteidigung + ", Willenskraft: " + willenskraft);
        System.out.println("Lebensenergie: " + lebensenergie + "/" + (int) maxLebensenergie);
        System.out.println("Zauberenergie: " + zauberenergie + "/" + (int) maxZauberenergie);
        if (ausgeruesteteWaffe != null) {
            System.out.println("Ausrüstete Waffe:");
            ausgeruesteteWaffe.zeichnen();
        } else {
            System.out.println("Keine Waffe ausgerüstet.");
        }

        if (ausgeruesteteRuestung != null) {
            System.out.println("Ausrüstete Rüstung:");
            ausgeruesteteRuestung.zeichnen();
        } else {
            System.out.println("Keine Rüstung ausgerüstet.");
        }
    }

    public boolean isMaxLevel() {
        return level >= MAX_LEVEL;
    }

    // Getter-Methoden
    public String getName() {
        return name;
    }

    public String getKlasse() {
        return spielerKlasse;
    }

    public int getLevel() {
        return level;
    }

    public int getAngriff() {
        return angriff;
    }

    public int getPraezision() {
        return praezision;
    }

    public int getVitalitaet() {
        return vitalitaet;
    }

    public int getVerteidigung() {
        return verteidigung;
    }

    public int getWillenskraft() {
        return willenskraft;
    }

    public int getLebensenergie() {
        return lebensenergie;
    }

    public int getZauberenergie() {
        return zauberenergie;
    }

    public Räume getRaum() {
        return raum;
    }

    public Waffe getAusgeruesteteWaffe() {
        return ausgeruesteteWaffe;
    }

    public Rüstungsklasse getAusgeruesteteRuestung() {
        return ausgeruesteteRuestung;
    }

    public void waffeAusruesten(Waffe waffe) {
        if (this.ausgeruesteteWaffe != null) {
            this.angriff -= this.ausgeruesteteWaffe.getAngriffswert();
        }

        this.ausgeruesteteWaffe = waffe;
        this.angriff += waffe.getAngriffswert();
    }

    public void waffeAblegen() {
        if (this.ausgeruesteteWaffe != null) {
            this.angriff -= this.ausgeruesteteWaffe.getAngriffswert();
            this.ausgeruesteteWaffe = null;
        }
    }

    public void ruestungAusruesten(Rüstungsklasse ruestung) {
        if (this.ausgeruesteteRuestung != null) {
            this.verteidigung -= this.ausgeruesteteRuestung.getRüstungswert();
        }

        this.ausgeruesteteRuestung = ruestung;
        this.verteidigung += ruestung.getRüstungswert();
    }

    public void ruestungAblegen() {
        if (this.ausgeruesteteRuestung != null) {
            this.verteidigung -= this.ausgeruesteteRuestung.getRüstungswert();
            this.ausgeruesteteRuestung = null;
        }
    }

    public void angreifen(Spieler gegner) {
        if (gegner.getRaum().equals(raum)) {
            Random random = new Random();
            int zufallsZahl = random.nextInt(angriff / 2, angriff + 1);
            if (zufallsZahl > gegner.getVerteidigung()) {
                gegner.lebensenergie -= zufallsZahl - gegner.getVerteidigung();
                System.out.println("Angriff passiert");
            } else {
                System.out.println("Gegner hat erfolgreich geblockt!");
            }
        } else {
            System.out.println("Spieler befindet sich nicht im selben Raum");
        }
    }

    public void raumWechseln() {
        if (raum.getKey().equals("oben") || raum.getKey().equals("unten") || raum.getKey().equals("links") || raum.getKey().equals("rechts")) {
            raum = (Räume) raum.getRaeume().get("mitte");
            raum.raumFuellen();
        }
    }

    public void raumWechseln(int richtung) {
        Räume neuerRaum = null;
        if (richtung == 1) {
            neuerRaum = (Räume) raum.getRaeume().get("oben");
        } else if (richtung == 2) {
            neuerRaum = (Räume) raum.getRaeume().get("rechts");
        } else if (richtung == 3) {
            neuerRaum = (Räume) raum.getRaeume().get("unten");
        } else if (richtung == 4) {
            neuerRaum = (Räume) raum.getRaeume().get("links");
        } else {
            System.out.println("Fehler!");
            return;
        }

        if (neuerRaum != null) {
            raum = neuerRaum;
            raum.raumFuellen();
        } else {
            System.out.println("Kein Raum in dieser Richtung!");
        }
    }

    public void raumUntersuchen() {
        ArrayList<Object> inhalt = new ArrayList<>();
        inhalt.add(raum.getSpieler());
        inhalt.add(raum.getWaffen());
        inhalt.add(raum.getRüstung());
        inhalt.add(raum.getTraenke());
        System.out.println(inhalt);
    }

    public double getMaxLebensenergie() {
        return maxLebensenergie;
    }

    public ArrayList<Zaubertränke> getTraenke() {
        return tränke;
    }

    public void tranktrinken() {
        if (!tränke.isEmpty()) {
            Zaubertränke trank = tränke.remove(0);
            lebensenergie = Math.min(lebensenergie + trank.getRegenerationswert(), (int)maxLebensenergie);
            System.out.println("Du hast einen Trank getrunken und " + trank.getRegenerationswert() + " Lebensenergie regeneriert.");
        } else {
            System.out.println("Du hast keine Tränke!");
        }
    }


    public class Zaubertränke {
        private int regenerationswert;
        public Zaubertränke(int regenerationswert) {
            this.regenerationswert = regenerationswert;
        }

        public int getRegenerationswert() {
            return regenerationswert;
        }

        public void setRegenationswert(int regenerationswert) {
            this.regenerationswert = regenerationswert;
        }
    }


    public void trankaufnehmen(Zaubertränke trank) {
        if (tränke.size() < 3) {
            tränke.add(trank);
            System.out.println("Der Trank wurde aufgenommen. Regenerationswert: " + trank.getRegenerationswert());
        } else {
            System.out.println("Du kannst nicht mehr als 3 Tränke tragen!");
        }
    }
}
