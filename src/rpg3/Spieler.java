package rpg3;

import java.util.ArrayList;
import java.util.List;

public class Spieler {
    // Datenfelder
    private String name, spielerKlasse;
    private int level, angriff, praezision, vitalitaet, verteidigung, willenskraft;
    private int lebensenergie, zauberenergie;
    private double maxLebensenergie, maxZauberenergie;
    private static final int MAX_LEVEL = 40;
    private Waffe ausgeruesteteWaffe;
    private Rüstungsklasse ausgeruesteteRuestung;
    private List<Zaubertränke> trankliste;
    private static final int MAX_TRAENKE = 5; // Höchstgrenze für Tränke


    // Konstruktor
    public Spieler(String name, String klasse) {
        this.name = name;
        this.spielerKlasse = klasse;
        this.level = 1;
        setzeDatenfelder(klasse);
        this.trankliste = new ArrayList<>();
    }

    public void trankAufnehmen1(Zaubertränke trank) {
        trankliste.add(trank);
    }

    public void trankTrinken(String trankName) {
        for (int i = 0; i < trankliste.size(); i++) {
            Zaubertränke trank = trankliste.get(i);
            if (trank.getName().equals(trankName)) {
                if (trank.getName().contains("Heiltrank")) {
                    this.lebensenergie = Math.min(this.lebensenergie + trank.getRegenerationswert(), (int)maxLebensenergie);
                } else if (trank.getName().contains("Manatrank")) {
                    this.zauberenergie = Math.min(this.zauberenergie + trank.getRegenerationswert(), (int)maxZauberenergie);
                }
                trankliste.remove(i);
                break;

            }
        }
    }

    public List<Zaubertränke> getTrankliste() {
        return new ArrayList<>(trankliste);
    }

    // Bestehende Methoden...

    // Angepasste zeigeInfo() Methode
    public void zeigeInfo() {


        System.out.println("Tränke im Besitz:");
        for (Zaubertränke trank : trankliste) {
            System.out.println("- " + trank.getName() + " (Regenerationswert: " + trank.getRegenerationswert() + ")");
        }
    }

    public boolean trankAufnehmen(Zaubertränke trank) {
        if (trankliste.size() < MAX_TRAENKE) {
            trankliste.add(trank);
            System.out.println(name + " hat einen " + trank.getName() + " aufgenommen.");
            return true;
        } else {
            System.out.println(name + " kann keine weiteren Tränke aufnehmen. Maximale Anzahl erreicht.");
            return false;
        }
    }





    // Methode zum Initialisieren der Datenfelder basierend auf der Spielerklasse
    private void setzeDatenfelder(String klasse) {
        // Überprüft die Spielerklasse und setzt entsprechend die Werte für die Attribute
        switch (klasse) {
            case "Barbar":
                // Setzt die Attribute für den Barbar
                angriff = 5; praezision = 3; vitalitaet = 4; verteidigung = 2; willenskraft = 1;
                break; // Verhindert, dass der Code in den nächsten Fall übergeht
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
            default:
                // Wenn keine der Klassen passt, werden Standardwerte gesetzt
                System.out.println("Ungültige Klasse! Standardwerte werden verwendet.");
                angriff = praezision = vitalitaet = verteidigung = willenskraft = 3;
        }
        // Setzt die maximalen Lebens- und Zauberenergie des Spielers
        maxLebensenergie = maxZauberenergie = 10;
        // Berechnet die aktuellen Energien des Spielers
        berechneEnergien();
    }


    // Berechnet die aktuellen Werte für Lebensenergie und Zauberenergie
    private void berechneEnergien() {
        lebensenergie = (int) maxLebensenergie;
        zauberenergie = (int) maxZauberenergie;
    }

    // Gibt Informationen über den Spieler auf der Konsole aus
    public void zeigeInfo1() {
        System.out.println("Klassen: " + name + ", Klasse: " + spielerKlasse + ", Level: " + level);
        System.out.println("Angriff: " + angriff + ", Präzision: " + praezision + ", Vitalität: " + vitalitaet);
        System.out.println("Verteidigung: " + verteidigung + ", Willenskraft: " + willenskraft);
        System.out.println("Lebensenergie: " + lebensenergie + "/" + (int)maxLebensenergie);
        System.out.println("Zauberenergie: " + zauberenergie + "/" + (int)maxZauberenergie);

        // Überprüft, ob eine Waffe ausgerüstet ist
        if (ausgeruesteteWaffe != null) {
            // Wenn eine Waffe ausgerüstet ist, wird die Methode 'zeichnen' der Waffe aufgerufen
            ausgeruesteteWaffe.zeichnen();
        }

// Überprüft, ob eine Rüstung ausgerüstet ist
        if (ausgeruesteteRuestung != null) {
            // Wenn eine Rüstung ausgerüstet ist, wird die Methode 'zeichnen' der Rüstung aufgerufen
            ausgeruesteteRuestung.zeichnen();
        }

    }





    // Methode, um zu überprüfen, ob der Spieler das maximale Level erreicht hat
    public boolean isMaxLevel() {
        return level >= MAX_LEVEL;
    }

    // Getter-Methoden,manche noch kein gebrauch
    public int getLevel() { return level; }
    public String getName() { return name; }
    public String getSpielerKlasse() { return spielerKlasse; }
    public int getAngriff() { return angriff; }
    public int getPraezision() { return praezision; }
    public int getVitalitaet() { return vitalitaet; }
    public int getVerteidigung() { return verteidigung; }
    public int getWillenskraft() { return willenskraft; }
    public int getLebensenergie() { return lebensenergie; }
    public int getZauberenergie() { return zauberenergie; }
    public double getMaxLebensenergie() { return maxLebensenergie; }
    public double getMaxZauberenergie() { return maxZauberenergie; }

    // Methoden für Waffen und Rüstungen, hier wird geprüft, ob der Charakter bereits eine Waffe ausgerüstet hat.
    //Falls ja, wird der Angriffswert dieser Waffe vom Gesamtangriffswert des Charakters addiert

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

    //gleich wie bei waffeausruesten
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
    //Gegner: Böser Ork, Standarttyp/vv
    public void angreifen(Spieler gegner) {
        int maxSchaden = this.angriff;
        int schaden = (int) (Math.random() * (maxSchaden + 1));

        if (this.ausgeruesteteWaffe != null) {
            if (gegner.getVerteidigung() > this.ausgeruesteteWaffe.getAngriffswert()) {
                schaden = 0;
            } else {
                schaden = Math.max(0, schaden - gegner.getVerteidigung());
            }
            int neuerReparaturwert = this.ausgeruesteteWaffe.getReparaturwert() + schaden / 2;
            this.ausgeruesteteWaffe.setReparaturwert(neuerReparaturwert);
            if (neuerReparaturwert >= 100) {
                this.waffeAblegen();
            }
        } else {
            schaden = Math.max(0, schaden - gegner.getVerteidigung());
        }

        gegner.nimmSchaden(schaden);
    }
    //schaden nehmen
    private void nimmSchaden(int schaden) {
        // Überprüfe, ob Rüstung getragen wird
        if (this.ausgeruesteteRuestung != null) {
            // Berechne den Schaden, den die Rüstung absorbiert
            int absorbierterSchaden = Math.min(schaden, this.ausgeruesteteRuestung.getRüstungswert());
            schaden -= absorbierterSchaden; // Subtrahiere den absorbierten Schaden vom Gesamtschaden

            // Aktualisiere den Reparaturwert der Rüstung
            int neuerReparaturwert = this.ausgeruesteteRuestung.getReparaturwert() + absorbierterSchaden / 2;
            this.ausgeruesteteRuestung.setReparaturwert(neuerReparaturwert);

            // Ablage der Rüstung, wenn der Reparaturwert 100 erreicht
            if (neuerReparaturwert >= 100) {
                this.ruestungAblegen();
            }
        }
        // Anpassung der Lebensenergie nach Abzug des verbleibenden Schadens
        this.lebensenergie = Math.max(0, this.lebensenergie - schaden);
    }
}