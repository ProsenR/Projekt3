package rpg3;

public class Gegner {
    private String name;
    private String gegnerTyp;
    private int level;
    private int angriff;
    private int verteidigung;
    private int lebensenergie;
    private Waffe ausgeruesteteWaffe;
    private Rüstungsklasse ausgeruesteteRuestung;

    public Gegner(String name, String gegnerTyp, int level) {
        this.name = name;
        this.gegnerTyp = gegnerTyp;
        this.level = level;
        this.lebensenergie = level * 10; // Beispiel: Lebensenergie skaliert mit Level
        setzeWerteBasierendAufTyp();
    }

    private void setzeWerteBasierendAufTyp() {
        switch (gegnerTyp) {
            case "Goblin":
                angriff = 2 + level;
                verteidigung = 1 + level;
                break;
            case "Ork":
                angriff = 5 + level;
                verteidigung = 3 + level;
                break;
            case "Zauberer":
                angriff = 3 + level;
                verteidigung = 2 + level;
                break;
            default:
                angriff = 1 + level;
                verteidigung = 1 + level;
        }
    }
    public void ruestungAusruesten(Rüstungsklasse ruestung) {
        this.ausgeruesteteRuestung = ruestung;
    }

    public void waffeAusruesten(Waffe waffe) {
        this.ausgeruesteteWaffe = waffe;
    }

    public void angreifen(Spieler spieler) {
        int schaden = this.angriff;

        // Modifiziere Schaden basierend auf Waffe (falls vorhanden)
        if (ausgeruesteteWaffe != null) {
            schaden += ausgeruesteteWaffe.getAngriffswert();
        }

        // Schadensreduktion durch Spielerverteidigung
        schaden -= spieler.getVerteidigung();
        if (schaden < 0) {
            schaden = 0; // Minimaler Schaden ist 0
        }

        spieler.nimmSchaden(schaden);
        System.out.println(this.name + " greift " + spieler.getName() + " an und verursacht " + schaden + " Schaden!");
    }

    public void nimmSchaden(int schaden) {
        this.lebensenergie -= schaden;
        if (this.lebensenergie < 0) {
            this.lebensenergie = 0;
        }
        System.out.println(this.name + " nimmt " + schaden + " Schaden. Lebensenergie: " + this.lebensenergie);
    }

    public boolean istTot() {
        return lebensenergie <= 0;
    }

    // Getter-Methoden
    public String getName() { return name; }
    public int getAngriff() { return angriff; }
    public int getVerteidigung() { return verteidigung; }
    public int getLebensenergie() { return lebensenergie; }
    public String getGegnerTyp() {return gegnerTyp;}

    public Rüstungsklasse getAusgeruesteteRuestung() {
        return ausgeruesteteRuestung;
    }

    public Waffe getAusgeruesteteWaffe() {
        return ausgeruesteteWaffe;
    }
}
 