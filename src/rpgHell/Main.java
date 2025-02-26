package rpgHell;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gib deinen Namen ein:");
        String name = scanner.nextLine();

        System.out.println("Wähle deine Klasse: \n----------------------------------- \n -Barbar \n -Dämonenjäger \n -Mönch \n -Hexendoktor \n -Zauberer \n-----------------------------------");
        System.out.print("Klasse: ");
        String klasse = scanner.nextLine();

        Spieler spieler = new Spieler(name, klasse);

        System.out.println("Spieler " + spieler.getName() + " wurde als " + spieler.getSpielerKlasse() + " erstellt.");

        // Ausgabe der Anfangsstatistiken
        System.out.println("\nAnfangsstatistiken:");
        System.out.println("Level: " + spieler.getLevel());
        System.out.println("Angriff: " + spieler.getAngriff());
        System.out.println("Präzision: " + spieler.getPraezision());
        System.out.println("Vitalität: " + spieler.getVitalitaet());
        System.out.println("Verteidigung: " + spieler.getVerteidigung());
        System.out.println("Willenskraft: " + spieler.getWillenskraft());
        System.out.println("Lebensenergie: " + spieler.getAktLebensenergie() + "/" + spieler.getMaxLebensenergie());
        System.out.println("Zauberenergie: " + spieler.getAktZauberenergie() + "/" + spieler.getMaxZauberenergie());

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

                System.out.println("\nAktualisierte Statistiken:");
                System.out.println("Level: " + spieler.getLevel());
                System.out.println("Angriff: " + spieler.getAngriff());
                System.out.println("Präzision: " + spieler.getPraezision());
                System.out.println("Vitalität: " + spieler.getVitalitaet());
                System.out.println("Verteidigung: " + spieler.getVerteidigung());
                System.out.println("Willenskraft: " + spieler.getWillenskraft());
                System.out.println("Lebensenergie: " + spieler.getAktLebensenergie() + "/" + spieler.getMaxLebensenergie());
                System.out.println("Zauberenergie: " + spieler.getAktZauberenergie() + "/" + spieler.getMaxZauberenergie());
            } else {
                System.out.println("Level-Up nicht möglich. Entweder wurde das maximale Level erreicht oder zu viele Eigenschaften ausgewählt.");
            }
        }

        // Rüstung und Waffe
        Ruestung ruestung = new Ruestung("\n Eiserne Brustplatte", 50, 0);
        ruestung.zeichnen();

        ruestung.erhoeheReparaturwert(30);
        ruestung.zeichnen();

        if (ruestung.istKaputt()) {
            System.out.println("Die Rüstung ist kaputt.");
        } else {
            System.out.println("Die Rüstung ist noch okay.");
        }

        Ruestung.zeichneBrustplatte();

        Waffe waffe = new Waffe("Schwert", 10, 0);
        System.out.println("\nWaffe:");
        waffe.zeichnen();

        spieler.waffeAusruesten(waffe);
        System.out.println("Waffe wurde ausgerüstet. Neuer Angriffswert: " + spieler.getAngriff());

        Waffe.zeichneSchwert();


        scanner.close();
    }
}