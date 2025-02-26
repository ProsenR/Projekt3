package RPG.Hell.RPG.PART1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Räume {
    private String name;
    private Map<String, Räume> türen;
    private List<Spieler> spielerImRaum;
    private List<Object> gegenständeImRaum;

    public static Räume aktuellerRaum;

    public Räume(String name) {
        this.name = name;
        this.türen = new HashMap<>();
        this.spielerImRaum = new ArrayList<>();
        this.gegenständeImRaum = new ArrayList<>();
    }


    public void gegenstandAblegen(Object gegenstand) {
        gegenständeImRaum.add(gegenstand);
    }

    public Object gegenstandAufheben(String gegenstandName) {
        for (Object g : gegenständeImRaum) {
            if (g.toString().equals(gegenstandName)) {
                gegenständeImRaum.remove(g);
                return g;
            }
        }
        return null;
    }


    public List<Object> getGegenständeImRaum() {
        return new ArrayList<>(gegenständeImRaum);
    }
}
