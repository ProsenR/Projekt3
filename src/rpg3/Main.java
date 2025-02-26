package rpg3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen");
        System.out.println("Barbar | Dämonenjäger | Mönch | Hexendoktor | Zauberer ");

        System.out.print("Gib den Namen deines Charakters ein: ");
        String name = scanner.nextLine();

        System.out.print("Gib die Klasse deines Charakters ein: ");
        String spielerklasse = scanner.nextLine();

        spieler spieler = new spieler(name, spielerklasse);
        System.out.println("\nCharakter erstellt:");
        spieler.zeigeInfo();

        // Erstellen und Ausrüsten einer Waffe, Testen Schwert
        Waffe schwert = new Waffe("Schwert", 10, 0);
        spieler.waffeAusruesten(schwert);

        // Erstellen und Ausrüsten einer Rüstung, Testen Brustplatte
        Rüstungsklasse brustplatte = new Rüstungsklasse("brustplatte", 5, 0);
        spieler.ruestungAusruesten(brustplatte);

        System.out.println("\nNach Ausrüstung:");
        spieler.zeigeInfo();

        // Erstellen eines BEISPIEL Gegners und Durchführen eines Angriffs
        rpg3.spieler gegner = new spieler("Böser Ork", "Barbar");
        spieler.angreifen(gegner);

        System.out.println("\nNach dem Angriff:");
        spieler.zeigeInfo();
        gegner.zeigeInfo();

        scanner.close();
    }
}