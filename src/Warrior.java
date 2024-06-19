import java.util.Random;

public class Warrior extends Character implements Attacker {
    private int strength;
    private int stamina;

    public Warrior(String name) {
        super(name, 200); // Example HP value for Warrior
        this.strength = 30; // Example strength value
        this.stamina = 10; // Example initial stamina value
    }

    @Override
    public void receiveDamage(int damage) {
        setHp(getHp() - damage);
    }

    @Override
    public void attack(Character opponent) {
        Random random = new Random();
        boolean heavyAttack = random.nextBoolean();

        if (heavyAttack && stamina >= 5) {
            int damage = strength;
            opponent.receiveDamage(damage);
            stamina -= 5;
            System.out.println(getName() + " performs a Heavy attack on " + opponent.getName() + " for " + damage + " damage.");
        } else if (stamina >= 1) {
            int damage = strength / 2;
            opponent.receiveDamage(damage);
            stamina += 1;
            System.out.println(getName() + " performs a Weak attack on " + opponent.getName() + " for " + damage + " damage.");
        } else {
            stamina += 2;
            System.out.println(getName() + " does not have enough stamina to attack and recovers 2 stamina.");
        }
    }
}
