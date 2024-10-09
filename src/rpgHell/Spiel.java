package rpgHell;

public class Spiel {

    private int level;
    private String name, spielerKlasse;
    private int angriff, praezision, vitalitaet, verteidigung, willenskraft;

    public Spiel(String name, String spielerKlasse) {
        this.name = name;
        this.spielerKlasse = spielerKlasse;
        this.level = 1;
        stats();
    }

    private void stats() {
        switch (spielerKlasse) {
            case "Barbar":
                angriff = 5; praezision = 3; vitalitaet = 4; verteidigung = 2; willenskraft = 1;
                break;
            case "Dämonenjäger":
                angriff = 4; praezision = 3; vitalitaet = 2; verteidigung = 2; willenskraft = 5;
                break;
            case "Mönch":
                angriff = 3; praezision = 4; vitalitaet = 3; verteidigung = 5; willenskraft = 5;
                break;
            case "Hexendoktor":
                angriff = 5; praezision = 3; vitalitaet = 2; verteidigung = 1; willenskraft = 5;
                break;
            case "Zauberer":
                angriff = 4; praezision = 4; vitalitaet = 2; verteidigung = 2; willenskraft = 5;
                break;
        }
    }
}