package de.habelitz.uebung5;

import java.util.Scanner;

public class RechteckTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Geben Sie die Länge des Rechtecks ein: ");
        double laenge = scanner.nextDouble();

        System.out.print("Geben Sie die Breite des Rechtecks ein: ");
        double breite = scanner.nextDouble();

        Rechteck rechteck = new Rechteck(laenge, breite);

        System.out.println("Ursprüngliche Werte:");
        System.out.println("Länge: " + rechteck.getLaenge() + ", Breite: " + rechteck.getBreite());

        System.out.print("Um wie viel möchten Sie die Länge vergrößern? ");
        double laengeVergroessern = scanner.nextDouble();
        rechteck.laengeVergroessern(laengeVergroessern);

        System.out.print("Um wie viel möchten Sie die Breite vergrößern? ");
        double breiteVergroessern = scanner.nextDouble();
        rechteck.breiteVergroessern(breiteVergroessern);

        System.out.print("Um wie viel möchten Sie die Länge verkleinern? ");
        double laengeVerkleinern = scanner.nextDouble();
        rechteck.laengeVerkleinern(laengeVerkleinern);

        System.out.print("Um wie viel möchten Sie die Breite verkleinern? ");
        double breiteVerkleinern = scanner.nextDouble();
        rechteck.breiteVerkleinern(breiteVerkleinern);

        System.out.println("Aktualisierte Werte:");
        System.out.println("Länge: " + rechteck.getLaenge() + ", Breite: " + rechteck.getBreite());

        scanner.close();
    }
}
