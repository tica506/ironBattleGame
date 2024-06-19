import java.util.Random;

public class Wizard extends Character implements Attacker {
    private int intelligence;
    private int mana;

    public Wizard(String name) {
        super(name, 150); // Example HP value for Wizard
        this.intelligence = 40; // Example intelligence value
        this.mana = 10; // Example initial mana value
    }

    @Override
    public void receiveDamage(int damage) {
        setHp(getHp() - damage);
    }

    @Override
    public void attack(Character opponent) {
        Random random = new Random();
        boolean castFireball = random.nextBoolean();

        if (castFireball && mana >= 5) {
            int damage = intelligence;
            opponent.receiveDamage(damage);
            mana -= 5;
            System.out.println(getName() + " casts a Fireball on " + opponent.getName() + " for " + damage + " damage.");
        } else if (mana >= 1) {
            int damage = 2;
            opponent.receiveDamage(damage);
            mana += 1;
            System.out.println(getName() + " performs a Staff hit on " + opponent.getName() + " for " + damage + " damage.");
        } else {
            mana += 2;
            System.out.println(getName() + " does not have enough mana to cast a spell and recovers 2 mana.");
        }
    }
}
