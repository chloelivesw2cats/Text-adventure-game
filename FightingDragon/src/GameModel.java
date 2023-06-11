import java.util.Scanner;


public class GameModel {
    private int count = 0;

    public void startGame() {
        System.out.println("Ho there traveler, first can you tell me your name?");
            TheHero player = new TheHero();
                player.setHP(50);
                player.setName(askForInput());
                player.setAttackPower(5);
                player.setStamina(10);
            TheBoss boss = new TheBoss();
        while (boss.isAlive() && player.isAlive()) {
            if (count == 0) {
                System.out.println("Hi "+ player.getName() + "! I see another one has came here to attempt this treacherous quest");
                //add script later, this is for the introduction.
                System.out.println("First, let's take a look at your current stats:");
                System.out.println("Your starting HP is 50, finding healing stone in Peaceful encounter will help restore your health");
                System.out.println("Your starting Stamina is 10, this is crucial if you want to continue fight off enemies, you can rest to restore your Stamina");
                System.out.println("Your base attack power is 5, fighting monster and joining training session will help you improve your skill");
                count++;
            }
            int rand = (int) Math.floor(Math.random() * (10 - 1 + 1) + 1);
            if (rand <= 3) {

            }
            if (((count <= 10) && (rand > 3)) || ((count > 10) && ((3 < rand) && (rand < 6)))) {

            }
            if (count > 10 && rand > 5) {
                System.out.println("You have stumbled upon the dragon lair. Do you wish to challenge the sleeping beast?");
                System.out.println("yes or no?");
                boolean stillAsking = true;
                if (stillAsking) {
                    String yn = askForInput();
                    if (yn == "yes") {
                        stillAsking = false;
                    }
                    if (yn == "no") {
                        System.out.println("You move on with you adventure, leaving the task of challenging the horrid beast for another day.");
                        stillAsking = false;
                        count++;
                    } else {
                        System.out.println("That's not a valid input.");
                    }
                }
            }
            if (count > 20) {
                System.out.println("You took too long to find the the dragon, it has woken up from its slumber and burn the village to the ground");
                break;
            }
        }
    }
    public static String askForInput () {
        Scanner choice = new Scanner(System.in);
        System.out.println("Input: ");
        String input = choice.nextLine();
        return input;
    }
}
