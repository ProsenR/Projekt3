package rpg3;

public class Rüstungsklasse {
    private String name;
    private int rüstungswert;
    private int reparaturwert;
    private String rüstungsTyp;

    public Rüstungsklasse(String name, int rüstungswert, int reparaturwert) {
        this.name = name;
        this.rüstungswert = rüstungswert;
        this.reparaturwert = reparaturwert;
        this.rüstungsTyp = "Brustplatte";
    }


    public Rüstungsklasse(String name, int rüstungswert) {
    }

    public String getName() {
        return name;
    }

    public int getRüstungswert() {
        return rüstungswert;
    }


    public int getReparaturwert() {
        return reparaturwert;
    }

    public void setReparaturwert(int reparaturwert) {
        this.reparaturwert = Math.min(reparaturwert, 100);
    }

    public void erhöheReparaturwert(int wert) {
        this.reparaturwert = Math.min(this.reparaturwert + wert, 100);
    }

    public void zeichnen() {


        switch (rüstungsTyp.toLowerCase()) {
            case "helm":
                System.out.println("       _______");
                System.out.println("      /       \\");
                System.out.println("     /  O   O  \\");
                System.out.println("    |    ___    |");
                System.out.println("     \\  \\___/  /");
                System.out.println("      \\_______/");
                break;
            case "brustplatte":
                System.out.println("     __________");
                System.out.println("    /  ______  \\");
                System.out.println("   /  /      \\  \\");
                System.out.println("  |  |        |  |");
                System.out.println("  |  |        |  |");
                System.out.println("   \\  \\______/  /");
                System.out.println("    \\__________/");
                break;
            case "beinschienen":
                System.out.println("       _   _");
                System.out.println("      | | | |");
                System.out.println("      | | | |");
                System.out.println("      | | | |");
                System.out.println("      | | | |");
                System.out.println("      |_| |_|");
                System.out.println("      /_\\ /_\\");
                break;
            case "stiefel":
                System.out.println("       _____   _____");
                System.out.println("      |     | |     |");
                System.out.println("      |     | |     |");
                System.out.println("      |_____| |_____|");
                System.out.println("     /______\\/______\\");
                break;

        }

        System.out.println("┌─────────────────────────┐");
        System.out.println("│ Rüstung: " + name);
        System.out.println("│ Rüstungswert: " + rüstungswert);
        System.out.println("│ Reparaturwert: " + reparaturwert);
        System.out.println("└─────────────────────────┘");
    }

    public void erhoehereparaturwert(int wert) {
        reparaturwert += wert;
        if (reparaturwert > 100) {
            reparaturwert = 100;
        }

    }

    public boolean istKaputt() {
        return reparaturwert >= 100;
    }

}