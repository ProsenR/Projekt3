package rpg3;

public class Waffe {
    private String name;
    private int angriffswert;
    private int reparaturwert;
    private String waffenTyp;

    public Waffe(String name, int angriffswert, int reparaturwert) {
        this.name = name;
        this.angriffswert = angriffswert;
        this.reparaturwert = reparaturwert;
        this.waffenTyp = "schwert";
    }

    public Waffe(String name, int angriffswert) {
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

    public void setReparaturwert(int reparaturwert) {
        this.reparaturwert = Math.min(reparaturwert, 100);
    }


    public void zeichnen() {
        switch (waffenTyp.toLowerCase()) {
            case "pfeil und bogen":
                System.out.println("   (");
                System.out.println("    \\");
                System.out.println("     )");
                System.out.println("##------>");
                System.out.println("     )");
                System.out.println("    /");
                System.out.println("   (");
                break;
            case "schwert":
                System.out.println("         /\\  ");
                System.out.println("        /  \\  ");
                System.out.println("       /    \\");
                System.out.println("      /  ||  \\");
                System.out.println("     |   ||   |");
                System.out.println("     |   ||   |");
                System.out.println("     |   ||   |");
                System.out.println("     |   ||   |");
                System.out.println("      \\  ||  /");
                System.out.println("       \\ || /");
                System.out.println("        \\||/");
                System.out.println("         ||");
                System.out.println("         ||");
                System.out.println("        /  \\");
                System.out.println("       /____\\");

                break;
            case "dolch":
                System.out.println("        /\\  ");
                System.out.println("       /  \\");
                System.out.println("      | || |");
                System.out.println("      | || |");
                System.out.println("      \\ || /");
                System.out.println("       \\||/");
                System.out.println("        ||");
                System.out.println("        ||");
                System.out.println("       /  \\");
                System.out.println("      /____\\");

                break;

        }

        System.out.println("┌─────────────────────────┐");
        System.out.println("│ Waffe: " + name);
        System.out.println("│ Angriffswert: " + angriffswert);
        System.out.println("│ Reparaturwert: " + reparaturwert);
        System.out.println("└─────────────────────────┘");
    }
}