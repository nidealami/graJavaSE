public class NPC {
    private String name;

    private int health;
    private int strength;

    public NPC(String name) {
        this.name = name;

    }

    public NPC(String name, int health, int strength) {
        this.name = name;
        this.health=health;
        this.strength=strength;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return health>0;
    }

    public void damageTaken(int hit) {
        this.health=this.health-hit;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
