package rpgHell;

import java.util.Scanner;
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
    private double aktLebensenergie;
    private double maxLebensenergie;
    private double aktZauberenergie;
    private double maxZauberenergie;
    private Waffe ausgeruesteteWaffe;
    private Ruestung ausgeruesteteRuestung;

    public Spieler(String name, String spielerKlasse) {
        this.name = name;
        this.spielerKlasse = spielerKlasse;
        this.level = 1;
        initialisiereEigenschaften();
    }

    private void initialisiereEigenschaften() {
        // Hier die Logik für die Initialisierung der Eigenschaften basierend auf der Klasse
        // Dies ist ein Platzhalter und sollte an Ihre spezifische Implementierung angepasst werden
        this.angriff = 10;
        this.praezision = 10;
        this.vitalitaet = 10;
        this.verteidigung = 10;
        this.willenskraft = 10;
        aktualisiereLebenUndZauberenergie();
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
        aktLebensenergie -= schaden;
        if (aktLebensenergie < 0) {
            aktLebensenergie = 0;
        }
    }

    public boolean levelUp(boolean erhoeheAngriff, boolean erhoehePraezision, boolean erhoeheVitalitaet,
                           boolean erhoeheVerteidigung, boolean erhoeheWillenskraft) {
        int anzahlErhoehungen = (erhoeheAngriff ? 1 : 0) + (erhoehePraezision ? 1 : 0) +
                (erhoeheVitalitaet ? 1 : 0) + (erhoeheVerteidigung ? 1 : 0) +
                (erhoeheWillenskraft ? 1 : 0);

        if (anzahlErhoehungen > 2 || level >= 10) {
            return false;
        }

        level++;
        if (erhoeheAngriff) angriff++;
        if (erhoehePraezision) praezision++;
        if (erhoeheVitalitaet) vitalitaet++;
        if (erhoeheVerteidigung) verteidigung++;
        if (erhoeheWillenskraft) willenskraft++;

        aktualisiereLebenUndZauberenergie();
        return true;
    }

    private void aktualisiereLebenUndZauberenergie() {
        maxLebensenergie = vitalitaet * 10;
        maxZauberenergie = willenskraft * 10;
        aktLebensenergie = maxLebensenergie;
        aktZauberenergie = maxZauberenergie;
    }



    public void zeichnen() {
        System.out.println("Spieler: " + name + " (" + spielerKlasse + ")");
        System.out.println("Level: " + level);
        System.out.println("LP: " + aktLebensenergie + "/" + maxLebensenergie +
                " | ZE: " + aktZauberenergie + "/" + maxZauberenergie);
        System.out.println("Angriff: " + angriff + " | Präzision: " + praezision +
                " | Vitalität: " + vitalitaet + " | Verteidigung: " + verteidigung +
                " | Willenskraft: " + willenskraft);
        if (ausgeruesteteWaffe != null) {
            ausgeruesteteWaffe.zeichnen();
        }
        if (ausgeruesteteRuestung != null) {
            ausgeruesteteRuestung.zeichnen();
        }
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
    public double getAktLebensenergie() { return aktLebensenergie; }
    public double getMaxLebensenergie() { return maxLebensenergie; }
    public double getAktZauberenergie() { return aktZauberenergie; }
    public double getMaxZauberenergie() { return maxZauberenergie; }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gib deinen Namen ein:");
        String name = scanner.nextLine();

        System.out.println("Wähle deine Klasse: \n----------------------------------- \n -Barbar \n -Dämonenjäger \n -Mönch \n -Hexendoktor \n -Zauberer \n-----------------------------------");
        System.out.print("Klasse: ");
        String klasse = scanner.nextLine();

        Spieler spieler = new Spieler(name, klasse);

        System.out.println("Spieler " + spieler.getName() + " wurde als " + spieler.getSpielerKlasse() + " erstellt.");

        zeigeEigenschaften(spieler);

        while (true) {
            System.out.println("\nMöchtest du ein Level-Up durchführen? (ja/nein)");
            String antwort = scanner.nextLine().toLowerCase();
            if (!antwort.equals("ja")) {
                break;
            }

            System.out.println("Wähle bis zu zwei Eigenschaften zum Erhöhen:");
            System.out.println("1. Angriff");
            System.out.println("2. Präzision");
            System.out.println("3. Vitalität");
            System.out.println("4. Verteidigung");
            System.out.println("5. Willenskraft");
            System.out.println("Gib die Nummern der gewählten Eigenschaften ein (z.B. '1 3' oder '2'):");

            String[] auswahl = scanner.nextLine().split(" ");
            boolean[] erhoeheEigenschaften = new boolean[5];

            for (String s : auswahl) {
                int wahl = Integer.parseInt(s) - 1;
                if (wahl >= 0 && wahl < 5) {
                    erhoeheEigenschaften[wahl] = true;
                }
            }

            boolean erfolgreich = spieler.levelUp(
                    erhoeheEigenschaften[0],
                    erhoeheEigenschaften[1],
                    erhoeheEigenschaften[2],
                    erhoeheEigenschaften[3],
                    erhoeheEigenschaften[4]
            );

            if (erfolgreich) {
                System.out.println("Level-Up erfolgreich!");
                zeigeEigenschaften(spieler);
            } else {
                System.out.println("Level-Up nicht möglich. Entweder wurde das maximale Level erreicht oder zu viele Eigenschaften ausgewählt.");
            }
        }

        scanner.close();
    }

    private static void zeigeEigenschaften(Spieler spieler) {
        spieler.zeichnen();
    }
}