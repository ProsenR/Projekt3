package rpg3;

import java.util.ArrayList;
import java.util.List;

public class Zaubertränke {

        private String name;
        private int regenerationswert;

        public Zaubertränke(String name, int regenerationswert) {
            this.name = name;
            this.regenerationswert = regenerationswert;
        }

        public String getName() {
            return name;
        }

        public int getRegenerationswert() {
            return regenerationswert;
        }
    }

