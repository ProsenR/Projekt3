package de.habelitz.uebung5;

public class Kreis {
    private double radius;

    public Kreis() {
        this(0);
    }

    public Kreis(double radius) {
        setRadius(radius);
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = Math.max(radius, 0);
    }

    public double getUmfang() {
        return 2 * Math.PI * getRadius();
    }

    public double getFlaeche() {
        double r = getRadius();
        return Math.PI * r * r;
    }
}