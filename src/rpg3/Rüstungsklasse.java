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
        this.rüstungsTyp = "brustplatte"; // Standardtyp
    }
    // Getter-Methoden: Sie schützen die Daten und verhindern direkten Zugriff von außen.

    // Methode, um den Namen eines Objekts zurückzugeben
    public String getName() {
        return name; // Gibt den Wert des Attributs "name" zurück
    }

    // Methode, um den Rüstungswert eines Objekts zurückzugeben
    public int getRüstungswert() {
        return rüstungswert; // Gibt den Wert des Attributs "rüstungswert" zurück
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
        System.out.println("┌─────────────────────────┐");
        System.out.println("│ Rüstung: " + name);
        System.out.println("│ Rüstungswert: " + rüstungswert);
        System.out.println("│ Reparaturwert: " + reparaturwert);

        switch (rüstungsTyp.toLowerCase()) {
            case "helm":
                System.out.println("│      _______");
                System.out.println("│     /       \\");
                System.out.println("│    /  O   O  \\");
                System.out.println("│   |    ___    |");
                System.out.println("│    \\  \\___/  /");
                System.out.println("│     \\_______/");
                break;
            case "brustplatte":
                System.out.println("│    __________");
                System.out.println("│   /  ______  \\");
                System.out.println("│  /  /      \\  \\");
                System.out.println("│ |  |        |  |");
                System.out.println("│ |  |        |  |");
                System.out.println("│  \\  \\______/  /");
                System.out.println("│   \\__________/");
                break;
            case "beinschienen":
                System.out.println("│      _   _");
                System.out.println("│     | | | |");
                System.out.println("│     | | | |");
                System.out.println("│     | | | |");
                System.out.println("│     | | | |");
                System.out.println("│     |_| |_|");
                System.out.println("│     /_\\ /_\\");
                break;
            case "stiefel":
                System.out.println("│      _____   _____");
                System.out.println("│     |     | |     |");
                System.out.println("│     |     | |     |");
                System.out.println("│     |_____| |_____|");
                System.out.println("│    /______\\/______\\");
                break;

        }
        System.out.println("└─────────────────────────┘");
    }
}