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

        // Hier rufen wir die zeigeEigenschaften-Methode auf
        zeigeEigenschaften(spiel);

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