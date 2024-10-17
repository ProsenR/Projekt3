package rpgHell;

import java.util.Scanner;

public class Spieler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gib deinen Namen ein:");
        String name = scanner.nextLine();

        System.out.println("Wähle deine Klasse: \n----------------------------------- \n -Barbar \n -Dämonenjäger \n -Mönch \n -Hexendoktor \n -Zauberer \n-----------------------------------");
        System.out.print("Klasse: ");
        String klasse = scanner.nextLine();

        Spiel spiel = new Spiel(name, klasse);

        System.out.println("Spieler " + spiel.getName() + " wurde als " + spiel.getSpielerKlasse() + " erstellt.");

        zeigeEigenschaften(spiel);

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

            boolean erfolgreich = spiel.levelUp(
                    erhoeheEigenschaften[0],
                    erhoeheEigenschaften[1],
                    erhoeheEigenschaften[2],
                    erhoeheEigenschaften[3],
                    erhoeheEigenschaften[4]
            );

            if (erfolgreich) {
                System.out.println("Level-Up erfolgreich!");
                zeigeEigenschaften(spiel);
            } else {
                System.out.println("Level-Up nicht möglich. Entweder wurde das maximale Level erreicht oder zu viele Eigenschaften ausgewählt.");
            }
        }

        scanner.close();
    }

    private static void zeigeEigenschaften(Spiel spiel) {
        System.out.println("\nEigenschaften für " + spiel.getSpielerKlasse() + ":");
        System.out.println("-----------------------------------");
        System.out.println("Level: " + spiel.getLevel());
        System.out.println("Angriff: " + spiel.getAngriff());
        System.out.println("Präzision: " + spiel.getPraezision());
        System.out.println("Vitalität: " + spiel.getVitalitaet());
        System.out.println("Verteidigung: " + spiel.getVerteidigung());
        System.out.println("Willenskraft: " + spiel.getWillenskraft());
        System.out.printf("Lebensenergie: %.2f / %.2f%n", spiel.getAktLebensenergie(), spiel.getMaxLebensenergie());
        System.out.printf("Zauberenergie: %.2f / %.2f%n", spiel.getAktZauberenergie(), spiel.getMaxZauberenergie());
    }
}  