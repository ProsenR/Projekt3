package de.habelitz.uebung06;

public class Girokonto extends Konto {

    private double limit;

    public Girokonto(String kontonummer, double kontostand, double limit) {
        super(kontonummer, kontostand);
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public void auszahlen(double betrag) {
        if (getKontostand() - betrag >= -limit) {
            super.auszahlen(betrag);
        } else {
            System.out.println("Fehler: Kreditlimit überschritten!");
        }
    }
}


