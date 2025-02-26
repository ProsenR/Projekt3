package Kap10;

import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {

        Integer[] i = new Integer[6];

        ArrayList<Integer> Werte = new ArrayList<>();

        Werte.add(3);
        Werte.add(7);
        Werte.add(10);
        Werte.add(13);
        Werte.add(17);
        Werte.add(20);

        double b = 0;
        for (Integer p : Werte){
            b += p.intValue();;
        }


    }
}

