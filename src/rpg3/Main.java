package rpg3;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Räume[] raueme = new Räume[5];
        raueme[0] = new Räume("mitte");
        raueme[1] = new Räume("oben");
        raueme[2] = new Räume("unten");
        raueme[3] = new Räume("rechts");
        raueme[4] = new Räume("links");

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gib deinen Namen ein:");
        String name = scanner.nextLine();
        System.out.println("Wähle deine Klasse: \n----------------------------------- \n -Barbar \n -Dämonenjäger \n -Mönch \n -Hexendoktor \n -Zauberer \n-----------------------------------");
        System.out.print("Klasse: ");
        String klasse = scanner.nextLine();

        Spieler spieler = new Spieler(name, klasse, raueme[0]);
        Rüstungsklasse ruestung = new Rüstungsklasse("Brustplatte", 50, 100);
        Waffe waffe = new Waffe("Master Sword", 50, 100);
        spieler.ruestungAusruesten(ruestung);
        spieler.waffeAusruesten(waffe);

        System.out.println("Spieler " + spieler.getName() + " wurde als " + spieler.getKlasse() + " erstellt.");

        // Hauptspielschleife
        while (true) {
            System.out.println("\nWas möchtest du tun?");
            System.out.println("1. Statistiken anzeigen");
            System.out.println("2. Raum wechseln");
            System.out.println("3. Trank trinken");
            System.out.println("4. Raum untersuchen");
            System.out.println("5. Ausrüstung verwalten");
            System.out.println("6. Spiel beenden");

            int wahl = scanner.nextInt();
            scanner.nextLine();

            switch (wahl) {
                case 1:
                    spieler.zeigeInfo();
                    break;
                case 2:
                    System.out.println("In welche Richtung möchtest du gehen? (1: oben, 2: rechts, 3: unten, 4: links)");
                    int richtung = scanner.nextInt();
                    scanner.nextLine();

                    Räume alterRaum = spieler.getRaum();
                    spieler.raumWechseln(richtung);
                    Räume neuerRaum = spieler.getRaum();

                    if (neuerRaum != null && neuerRaum != alterRaum) {
                        System.out.println("Du bist jetzt im Raum: " + spieler.getRaum().getKey());
                        raumEvent(spieler.getRaum());
                    } else {
                        System.out.println("Du bist im selben Raum geblieben.");
                    }
                    break;
                case 3:
                    if (spieler.getTraenke().isEmpty()) {
                        System.out.println("Du hast keine Tränke zum Trinken.");
                    } else {
                        spieler.tranktrinken();
                    }
                    break;
                case 4:
                    spieler.raumUntersuchen();
                    break;
                case 5:
                    ausruestungVerwalten(spieler, scanner, raueme[0]);
                    break;
                case 6:
                    System.out.println("Danke fürs Spielen!");
                    return;
                default:
                    System.out.println("Ungültige Eingabe. Bitte wähle eine Zahl zwischen 1 und 6.");
            }
        }
    }


    private static void raumEvent(Räume raum) {
        Random random = new Random();
        int ereignis = random.nextInt(2); // 0 oder 1

        switch (ereignis) {
            case 0:
                // Gegner spawnen
                Gegner gegner = new Gegner("Gegner", raum);
                raum.getSpieler().add(gegner);
                System.out.println("Ein Gegner ist im Raum erschienen!");
                break;
            case 1:
                // Trank spawnen
                Zaubertränke trank = new Zaubertränke(random.nextInt(20, 51));
                raum.getTraenke().add(trank);
                System.out.println("Ein Zaubertrank ist im Raum erschienen!");
                break;
        }
    }

    //Methode um Ausrüstung zu verwalten
    private static void ausruestungVerwalten(Spieler spieler, Scanner scanner, Räume raum) {
        System.out.println("\nMöchtest du deine Waffe oder Rüstung ablegen oder anlegen?");
        System.out.println("1. Waffe ablegen");
        System.out.println("2. Rüstung ablegen");
        System.out.println("3. Waffe anlegen");
        System.out.println("4. Rüstung anlegen");
        System.out.println("5. Zurück zum Hauptmenü");

        int wahl = scanner.nextInt();
        scanner.nextLine();

        switch (wahl) {
            case 1:
                //Waffe ablegen
                if (spieler.getAusgeruesteteWaffe() != null) {
                    raum.getWaffen().add(spieler.getAusgeruesteteWaffe());
                    spieler.waffeAblegen();
                    System.out.println("Du hast deine Waffe abgelegt.");
                } else {
                    System.out.println("Du trägst keine Waffe.");
                }
                break;
            case 2:
                //Rüstung ablegen
                if (spieler.getAusgeruesteteRuestung() != null) {
                    raum.getRüstung().add(spieler.getAusgeruesteteRuestung());
                    spieler.ruestungAblegen();
                    System.out.println("Du hast deine Rüstung abgelegt.");
                } else {
                    System.out.println("Du trägst keine Rüstung.");
                }
                break;
            case 3:
                // Waffe anlegen
                if (!raum.getWaffen().isEmpty()) {
                    System.out.println("Welche Waffe möchtest du anlegen?");
                    for (int i = 0; i < raum.getWaffen().size(); i++) {
                        System.out.println((i + 1) + ". " + ((Waffe) raum.getWaffen().get(i)).getName());
                    }
                    int waffenWahl = scanner.nextInt();
                    scanner.nextLine();

                    if (waffenWahl > 0 && waffenWahl <= raum.getWaffen().size()) {
                        Waffe gewaehlteWaffe = (Waffe) raum.getWaffen().remove(waffenWahl - 1);
                        spieler.waffeAusruesten(gewaehlteWaffe);
                        System.out.println("Du hast " + gewaehlteWaffe.getName() + " angelegt.");
                    } else {
                        System.out.println("Ungültige Wahl.");
                    }
                } else {
                    System.out.println("Es liegen keine Waffen im Raum.");
                }
                break;
            case 4:
                // Rüstung anlegen
                if (!raum.getRüstung().isEmpty()) {
                    System.out.println("Welche Rüstung möchtest du anlegen?");
                    for (int i = 0; i < raum.getRüstung().size(); i++) {
                        System.out.println((i + 1) + ". " + ((Rüstungsklasse) raum.getRüstung().get(i)).getName());
                    }
                    int ruestungsWahl = scanner.nextInt();
                    scanner.nextLine();

                    if (ruestungsWahl > 0 && ruestungsWahl <= raum.getRüstung().size()) {
                        Rüstungsklasse gewaehlteRuestung = (Rüstungsklasse) raum.getRüstung().remove(ruestungsWahl - 1);
                        spieler.ruestungAusruesten(gewaehlteRuestung);
                        System.out.println("Du hast " + gewaehlteRuestung.getName() + " angelegt.");
                    } else {
                        System.out.println("Ungültige Wahl.");
                    }
                } else {
                    System.out.println("Es liegt keine Rüstung im Raum.");
                }
                break;
            case 5:
                break;
            default:
                System.out.println("Ungültige Eingabe.");
        }
    }
}
