package FileSaves;

import java.io.Serializable;

public class GameProgress implements Serializable {
    public static final long serialVersionUID = 1L;

    private final int health;
    private final int weapons;
    private final int level;
    private final double distance;

    public GameProgress(int health, int weapons, int level, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.level = level;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", level=" + level +
                ", distance=" + distance +
                '}';
    }
}
