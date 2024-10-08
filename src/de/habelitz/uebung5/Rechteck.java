package de.habelitz.uebung5;

public class Rechteck {
    private double laenge;
    private double breite;

    public Rechteck() {
        this(0, 0);
    }

    public Rechteck(double laenge, double breite) {
        this.laenge = laenge;
        this.breite = breite;
    }

    public void setLaenge(double l) {
        this.laenge = l;
    }

    public void setBreite(double b) {
        this.breite = b;
    }

    public void setSeiten(double l, double b) {
        this.laenge = l;
        this.breite = b;
    }

    public double getLaenge() {
        return laenge;
    }

    public double getBreite() {
        return breite;
    }

    public double getLangeSeite() {
        return Math.max(laenge, breite);
    }

    public double getKurzeSeite() {
        return Math.min(laenge, breite);
    }

    public double getDiagonale() {
        return Math.sqrt(laenge * laenge + breite * breite);
    }

    public double getFlaeche() {
        return laenge * breite;
    }

    public double getUmfang() {
        return 2 * (laenge + breite);
    }

    public void laengeVergroessern(double l) {
        this.laenge += l;
    }


    public void breiteVergroessern(double b) {
        this.breite += b;
    }

    public void laengeVerkleinern(double l) {
        this.laenge -= l;
    }

    public void breiteVerkleinern(double b) {
        this.breite -= b;
    }
}
