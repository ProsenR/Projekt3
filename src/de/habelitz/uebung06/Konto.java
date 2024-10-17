package de.habelitz.uebung06;

public class Konto {
    private String kontonummer;
    private double kontostand;

    public Konto(String kontonummer, double kontostand) {
        this.kontonummer = kontonummer;
        this.kontostand = kontostand;
    }

    public double getKontostand() {
        return kontostand;
    }

    public String getKontonummer() {
        return kontonummer;
    }

    public void einzahlen(double betrag) {
        if (betrag > 0) {
            kontostand += betrag;
        }
    }

    public void auszahlen(double betrag) {
        if (betrag > 0 && betrag <= kontostand) {
            kontostand -= betrag;
        }
    }
}
