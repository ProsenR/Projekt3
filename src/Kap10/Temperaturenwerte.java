package Kap10;

import java.util.Random;

public class Temperaturenwerte {

    public static void main(String[] args) {

        // double array
        // 365 zufallszahlen, bereich -20 bis 40
        // mittelwert

        Random random = new Random();
        double[] messwerte = new double[365];

        for (int i = 0; i < messwerte.length; i++) {
                                                                                                                                                                                                          messwerte[i] = Math.random() * 60 - 20;
        }

        for(Double m : messwerte) {
            System.out.println(m);
        }

        double mittelwert = 0;

        for(int i = 0; i < messwerte.length; i++){
            mittelwert += messwerte[i];
        }

        System.out.println("---------------");

        mittelwert /= messwerte.length;
        System.out.println(mittelwert);

    }
}
 