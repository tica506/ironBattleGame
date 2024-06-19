import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character character1 = createCharacter(scanner);
        Character character2 = createCharacter(scanner);

        while (character1.isAlive() && character2.isAlive()) {
            battleRound(character1, character2);
            if (!character1.isAlive() && !character2.isAlive()) {
                System.out.println("It's a tie! Restarting the battle...");
                character1.setHp(new Random().nextInt(101) + 100);
                character2.setHp(new Random().nextInt(101) + 100);
                character1.setAlive(true);
                character2.setAlive(true);
            }
        }

        if (character1.isAlive()) {
            System.out.println(character1.getName() + " wins!");
        } else {
            System.out.println(character2.getName() + " wins!");
        }

        scanner.close();
    }

    private static Character createCharacter(Scanner scanner) {
        System.out.print("Enter character type (warrior/wizard): ");
        String type = scanner.nextLine().toLowerCase();
        System.out.print("Enter character name: ");
        String name = scanner.nextLine();

        if (type.equals("warrior")) {
            return new Warrior(name);
        } else if (type.equals("wizard")) {
            return new Wizard(name);
        } else {
            System.out.println("Invalid type, creating a default warrior.");
            return new Warrior(name);
        }
    }

    private static void battleRound(Character character1, Character character2) {
        if (character1 instanceof Attacker) {
            ((Attacker) character1).attack(character2);
        }
        if (character2 instanceof Attacker) {
            ((Attacker) character2).attack(character1);
        }
        System.out.println(character1.getName() + " HP: " + character1.getHp() + ", " + character2.getName() + " HP: " + character2.getHp());
    }
}
