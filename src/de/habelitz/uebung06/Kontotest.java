package de.habelitz.uebung06;

public class Kontotest {
    public static void main(String[] args) {

        Konto meinKonto = new Konto("0000000001", 1000.0);

        System.out.println("Initiale Kontoinformationen:");
        System.out.println("Kontonummer: " + meinKonto.getKontonummer());
        System.out.println("Kontostand: " + meinKonto.getKontostand() + " €");

        meinKonto.einzahlen(500.0);

        meinKonto.auszahlen(750.50);

        System.out.println("\nKontoinformationen nach Transaktionen:");
        System.out.println("Kontonummer: " + meinKonto.getKontonummer());
        System.out.println("Kontostand: " + meinKonto.getKontostand() + " €");
    }
}
