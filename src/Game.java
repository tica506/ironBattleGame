import java.util.Random;

public class Game {

    public static class Wizard extends Character implements Attacker {
        private int mana;
        private int intelligence;

        public Wizard(String name) {
            super(name, new Random().nextInt(51) + 50);
            this.mana = new Random().nextInt(41) + 10;
            this.intelligence = new Random().nextInt(50) + 1;
        }

        public int getMana() {
            return mana;
        }

        public int getIntelligence() {
            return intelligence;
        }

        public void setMana(int mana) {
            this.mana = mana;
        }

        public void setIntelligence(int intelligence) {
            this.intelligence = intelligence;
        }

        @Override
        public void attack(Character opponent) {
            if (mana > 0) {
                opponent.receiveDamage(intelligence);
                mana--;
            }
        }

        @Override
        public void receiveDamage(int damage) {
            setHp(getHp() - damage);
        }
    }

    public static void main(String[] args) {
        Character wizard = new Game.Wizard("Wizard");

        // Example usage
        System.out.println("Created a wizard named " + wizard.getName());
    }
}
