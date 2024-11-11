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

        maxLebensenergie = 100.0;
        aktuelleLebensenergie = maxLebensenergie;

        maxZauberenergie = 100.0;
        aktuelleZauberenergie = maxZauberenergie;
    }

    public boolean levelUp(boolean erhoeheAngriff, boolean erhoehePraezision, boolean erhoeheVitalitaet, boolean erhoeheVerteidigung, boolean erhoeheWillenskraft) {
        if (level >= 40) {
            return false;
        }

        int anzahlGewaehlterEigenschaften = 0;
        if (erhoeheAngriff) anzahlGewaehlterEigenschaften++;
        if (erhoehePraezision) anzahlGewaehlterEigenschaften++;
        if (erhoeheVitalitaet) anzahlGewaehlterEigenschaften++;
        if (erhoeheVerteidigung) anzahlGewaehlterEigenschaften++;
        if (erhoeheWillenskraft) anzahlGewaehlterEigenschaften++;

        if (anzahlGewaehlterEigenschaften > 2) {
            return false;
        }

        level++;

        if (anzahlGewaehlterEigenschaften == 1) {
            if (erhoeheAngriff) angriff += 2;
            if (erhoehePraezision) praezision += 2;
            if (erhoeheVitalitaet) vitalitaet += 2;
            if (erhoeheVerteidigung) verteidigung += 2;
            if (erhoeheWillenskraft) willenskraft += 2;
        } else {
            if (erhoeheAngriff) angriff++;
            if (erhoehePraezision) praezision++;
            if (erhoeheVitalitaet) vitalitaet++;
            if (erhoeheVerteidigung) verteidigung++;
            if (erhoeheWillenskraft) willenskraft++;
        }

        maxLebensenergie *= 1.05;
        aktuelleLebensenergie *= (maxLebensenergie / aktuelleLebensenergie);

        maxZauberenergie *= 1.05;
        aktuelleZauberenergie *= (maxZauberenergie / aktuelleZauberenergie);

        return true;
    }

    // Getter
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

    public class Waffe {
        private String name;
        private int angriffswert;
        private int reparaturwert;

        public Waffe(String name, int angriffswert) {
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
    }

    public class Ruestung {
        private String name;
        private int ruestungswert;
        private int reparaturwert;

        public Ruestung(String name, int ruestungswert) {
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
    }
}