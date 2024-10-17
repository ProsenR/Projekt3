package de.habelitz.uebung06;

public class Seriennummerntest {
    public static void main(String[] args) {
        BruchMitSeriennummer b1 = new BruchMitSeriennummer(1, 2);
        BruchMitSeriennummer b2 = new BruchMitSeriennummer(3, 4);
        BruchMitSeriennummer b3 = new BruchMitSeriennummer(5);
        BruchMitSeriennummer b4 = new BruchMitSeriennummer();
        BruchMitSeriennummer b5 = new BruchMitSeriennummer(6, 8);

        b1.ausgeben();
        System.out.println();
        b2.ausgeben();
        System.out.println();
        b3.ausgeben();
        System.out.println();
        b4.ausgeben();
        System.out.println();
        b5.ausgeben();
        System.out.println();
    }
}
