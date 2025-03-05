package rpg3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Räume {
    ArrayList<Gegner> spieler = new ArrayList<>();
    ArrayList<Waffe> waffen = new ArrayList<>();
    ArrayList<Rüstungsklasse> rüstung = new ArrayList<>();
    ArrayList<Zaubertränke> traenke = new ArrayList<>();
    static HashMap<String, Räume> raeume = new HashMap<>();
    Random random = new Random();
    String key;

    public Räume(String raumKey) {
        raeume.put(raumKey, this);
        key = raumKey;
    }

    public String getKey() {
        return key;
    }

    public HashMap<String, Räume> getRaeume() {
        return raeume;
    }

    public ArrayList<Gegner> getSpieler() {
        return spieler;
    }

    public ArrayList<Waffe> getWaffen() {
        return waffen;
    }

    public ArrayList<Rüstungsklasse> getRüstung() {
        return rüstung;
    }

    public ArrayList<Zaubertränke> getTraenke() {
        return traenke;
    }

    public void raumFuellen() { //Benjamin Hilfe
        if (random.nextInt(0, 4) == 2) {
            for (int i = 0; i < random.nextInt(0, 4); i++) {
                spieler.add(new Gegner("Gegner" + (i + 1), this));
            }
        }
        if (random.nextInt(0, 11) == 1) {
            traenke.add(new Zaubertränke(random.nextInt(0, 101)));
        }
        if (random.nextInt(0, 11) == 4) {
            waffen.add(new Waffe("Waffe" + waffen.size(), random.nextInt(1, 7)));
        }
        if (random.nextInt(0, 11) == 4) {
            rüstung.add(new Rüstungsklasse("Ruestung" + rüstung.size(), random.nextInt(1, 7)));
        }
    }
}
