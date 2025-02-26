package rpgHell;

public class Waffe {
    private String name;
    private int angriffswert;
    private int reparaturwert;

    public Waffe(String name, int angriffswert, int i) {
        this.name = name;
        this.angriffswert = angriffswert;
        this.reparaturwert = 0;
    }

    public String getName() {
        return name;
    }

    public int getAngriffswert() {
        return angriffswert;
    }

    public int getReparaturwert() {
        return reparaturwert;
    }

    public void erhoeheReparaturwert(int wert) {
        reparaturwert += wert;
        if (reparaturwert > 100) {
            reparaturwert = 100;
        }
    }

    public boolean istKaputt() {
        return reparaturwert >= 100;
    }

    public void zeichnen() {
        System.out.println("Waffe: " + name + " (Angriff: " + angriffswert + ", Reparatur: " + reparaturwert + ")");
    }

    public static void zeichneSchwert() {
        System.out.println("    /\\");
        System.out.println("   //\\\\");
        System.out.println("  //  \\\\");
        System.out.println(" //    \\\\");
        System.out.println("||======||");
        System.out.println("    ||");
        System.out.println("    ||");
        System.out.println("    ||");
        System.out.println("    ()");
    }
}