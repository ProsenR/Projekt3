package de.habelitz.uebung5;

import javax.swing.JOptionPane;

public class KreisTest {
    public static void main(String[] args) {

        String input = JOptionPane.showInputDialog("Geben Sie den Radius des Kreises ein: ");

        double radius = Double.parseDouble(input);

        Kreis kreis = new Kreis(radius);

        System.out.println("Radius: " + kreis.getRadius());
        System.out.println("Umfang: " + kreis.getUmfang());
        System.out.println("Fläche: " + kreis.getFlaeche());
    }
}
