package de.habelitz.uebung06;

public class BruchMitSeriennummer extends Bruch {
    private static int naechsteSeriennummer = 1;
    private final int seriennummer;

    public BruchMitSeriennummer() {
        super();
        this.seriennummer = naechsteSeriennummer++;
    }

    public BruchMitSeriennummer(int x) {
        super(x);
        this.seriennummer = naechsteSeriennummer++;
    }

    public BruchMitSeriennummer(int x, int y) {
        super(x, y);
        this.seriennummer = naechsteSeriennummer++;
    }

    public int getSeriennummer() {
        return seriennummer;
    }

    public void ausgeben() {
        System.out.print("Bruch #" + seriennummer + ": ");
        super.ausgeben();
    }
}


