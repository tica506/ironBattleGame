import java.util.UUID;

public abstract class Character {
    private final String id; // Marked as final
    private String name;
    private int hp;
    private boolean isAlive; // Kept private to encapsulate the field properly

    public Character(String name, int hp) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.hp = hp;
        this.isAlive = true;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() { // Changed method name to match Main class usage
        return isAlive;
    }

    public void setHp(int hp) {
        this.hp = hp;
        if (this.hp <= 0) {
            this.hp = 0;
            this.isAlive = false;
        }
    }

    public void setAlive(boolean isAlive) { // Changed method name to match Main class usage
        this.isAlive = isAlive;
    }

    public abstract void receiveDamage(int damage);
}
