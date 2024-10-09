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

        System.out.println("Spieler " + name + " wurde als " + klasse + " erstellt.");

        scanner.close();
    }
}
