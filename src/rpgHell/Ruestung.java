package rpgHell;

public class Ruestung {
    private String name;
    private int ruestungswert;
    private int reparaturwert;

    public Ruestung(String name, int ruestungswert, int i) {
        this.name = name;
        this.ruestungswert = ruestungswert;
        this.reparaturwert = 0;
    }

    public String getName() {
        return name;
    }

    public int getRuestungswert() {
        return ruestungswert;
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
        System.out.println("Rüstung: " + name + " (Schutz: " + ruestungswert + ", Reparatur: " + reparaturwert + ")");
    }

    public static void zeichneBrustplatte() {
        System.out.println(" _________");
        System.out.println("/  \\   /  \\");
        System.out.println("|   \\ /   |");
        System.out.println("|    V    |");
        System.out.println("|         |");
        System.out.println("\\        /");
        System.out.println(" \\______/");
    }
}
