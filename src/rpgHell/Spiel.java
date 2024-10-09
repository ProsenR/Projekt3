package rpgHell;

public class Spiel {

    private int level;
    private String name, spielerKlasse;
    private int angriff, praezision, vitalitaet, verteidigung, willenskraft;
    private double maxLebensenergie, aktuelleLebensenergie;
    private double maxZauberenergie, aktuelleZauberenergie;

    public Spiel(String name, String spielerKlasse) {
        this.name = name;
        this.spielerKlasse = spielerKlasse;
        this.level = 1;
        stats();
        berechneLebensUndZauberenergie();
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

    private void berechneLebensUndZauberenergie() {
        maxLebensenergie = vitalitaet * 10 * level;
        aktuelleLebensenergie = maxLebensenergie;
        maxZauberenergie = willenskraft * 5 * level;
        aktuelleZauberenergie = maxZauberenergie;
    }

    public void levelUp() {
        if (level <= 40) {
            level++;
            angriff++;
            praezision++;
            vitalitaet++;
            verteidigung++;
            willenskraft++;
            berechneLebensUndZauberenergie();
        }
    }

    // Getter-Methoden
    public String getName() { return name; }
    public String getSpielerKlasse() { return spielerKlasse; }
    public int getLevel() { return level; }
    public int getAngriff() { return angriff; }
    public int getPraezision() { return praezision; }
    public int getVitalitaet() { return vitalitaet; }
    public int getVerteidigung() { return verteidigung; }
    public int getWillenskraft() { return willenskraft; }

    public double getMaxLebensenergie() { return maxLebensenergie; }
    public double getAktLebensenergie() { return aktuelleLebensenergie; }
    public double getMaxZauberenergie() { return maxZauberenergie; }
    public double getAktZauberenergie() { return aktuelleZauberenergie; }

    public void setAktLebensenergie(double energie) {
        if (energie < 0) {
            this.aktuelleLebensenergie = 0;
        } else if (energie > maxLebensenergie) {
            this.aktuelleLebensenergie = maxLebensenergie;
        } else {
            this.aktuelleLebensenergie = energie;
        }
    }

    public void setAktZauberenergie(double energie) {
        if (energie < 0) {
            this.aktuelleZauberenergie = 0;
        } else if (energie > maxZauberenergie) {
            this.aktuelleZauberenergie = maxZauberenergie;
        } else {
            this.aktuelleZauberenergie = energie;
        }
    }
    public boolean levelUp(boolean erhoeheAngriff, boolean erhoehePraezision, boolean erhoeheVitalitaet, boolean erhoeheVerteidigung, boolean erhoeheWillenskraft) {
        if (level > 40) {
            return false;
        }

        int anzahlGewaehlterEigenschaften = 0;
        if (erhoeheAngriff) anzahlGewaehlterEigenschaften++;
        if (erhoehePraezision) anzahlGewaehlterEigenschaften++;
        if (erhoeheVitalitaet) anzahlGewaehlterEigenschaften++;
        if (erhoeheVerteidigung) anzahlGewaehlterEigenschaften++;
        if (erhoeheWillenskraft) anzahlGewaehlterEigenschaften++;

        if (anzahlGewaehlterEigenschaften > 2) {
            return false; // Zu viele Eigenschaften gewählt, Level-Up nicht möglich
        }

        // Level-Up durchführen
        level++;

        // Eigenschaften erhöhen
        if (anzahlGewaehlterEigenschaften == 1) {
            // Wenn nur eine Eigenschaft gewählt wurde, diese um 2 erhöhen
            if (erhoeheAngriff) angriff += 2;
            if (erhoehePraezision) praezision += 2;
            if (erhoeheVitalitaet) vitalitaet += 2;
            if (erhoeheVerteidigung) verteidigung += 2;
            if (erhoeheWillenskraft) willenskraft += 2;
        } else {
            // Ansonsten die gewählten Eigenschaften um 1 erhöhen
            if (erhoeheAngriff) angriff++;
            if (erhoehePraezision) praezision++;
            if (erhoeheVitalitaet) vitalitaet++;
            if (erhoeheVerteidigung) verteidigung++;
            if (erhoeheWillenskraft) willenskraft++;
        }

        berechneLebensUndZauberenergie();
        return true; // Level-Up erfolgreich durchgeführt
    }
}