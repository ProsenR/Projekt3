import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        class Bruch{

        int zähler;
        int nenner;

        }


        Bruch bruch1;
        bruch1 = new Bruch();
        bruch1.zähler= 2;
        bruch1.nenner = 3;

        JOptionPane.showInternalMessageDialog(null,"Bruch: " + bruch1.zähler+ " / " + bruch1.nenner);

        Bruch bruch2;
        bruch2 = new Bruch();
        bruch2.zähler = 5;
        bruch2.nenner = 7;
        JOptionPane.showInternalMessageDialog(null,"Bruch: " + bruch2.zähler+ " / " + bruch2.nenner);

    }
}

