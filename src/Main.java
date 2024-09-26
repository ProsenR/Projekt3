import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        class Bruch {

            int zähler;
            int nenner;




        }

        Scanner scanner = new Scanner(System.in);


        Bruch bruch1;
        bruch1 = new Bruch();
        bruch1.zähler= 6;
        bruch1.nenner = 8;

        JOptionPane.showInternalMessageDialog(null,"Bruch: " + bruch1.zähler+ " / " + bruch1.nenner);

        System.out.println("Möchtest du diesen Bruch gekürzt haben?");
        String antwort = scanner.nextLine();

        if (antwort.equals("J") || antwort.equals("j")){
            System.out.println("Hier ist Ihr gekürzter Bruch: " + bruch1.zähler/2 + " / " + bruch1.nenner/2);
        }
        else if (antwort.equals("N")  || antwort.equals("n")) {
            System.out.println("Alles klar");
        }
        else {
            System.out.println("Ungültige Eingabe. Bitte geben Sie j oder n ein.");
        }

    }
}

