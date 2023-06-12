import java.util.Scanner;


public class GameModel {
    private int count = 0;

    public void startGame() {
        Scanner input = new Scanner(System.in);
        String cmd;
        System.out.println("Ho there traveler, first can you tell me your name?");
        TheHero player = new TheHero();
        player.setHP(50);
        player.setMaxHP(50);
        player.setName(cmd = input.next());
        player.setAttackPower(10);
        player.setGold(0);
        TheBoss boss = new TheBoss();

        while (boss.isAlive() && player.isAlive()) {
            if (count == 0) {
                System.out.println("Hi " + player.getName() + "! I see, another adventure has stumbled our village.");
                System.out.println("First, let me explain the you our village dire situation");
                System.out.println("A dragon has make a lair somewhere in the village and it threaten us to give it 100 Gold within 2 months or it will burn this village to the ground");
                System.out.println("Oh! Brave adventurer " + player.getName() + ". Can you help us with this quest? Yes or No.");
                cmd = input.next();
                if (cmd.equalsIgnoreCase("no")) {
                    System.out.println("I see, I understand it is a difficult thing we are asking from you.");
                    System.out.println("Very well, I give you my best regard for your journey ahead. Hope that a worthy adventure will come around one day.");
                    break;
                }
                if (cmd.equalsIgnoreCase("yes")) {
                    System.out.println("Great! First, let's take a look at your current stats:");
                    System.out.println("Your starting HP is 50, finding healing well in Peaceful encounter will help restore your health");
                    System.out.println("Your base attack power is 5, fighting monster and joining training session will help you improve your skill");
                    System.out.println("Your current gold is 0, find gold along the journey, accumulating wealth may help you tremendously.");
                    System.out.println("Are you ready to take on this quest? Input 'yes' to continue.");
                    boolean stillAsking = true;
                    while (stillAsking) {
                        cmd = input.next();
                        if (cmd.equalsIgnoreCase("yes")) {
                            stillAsking = false;
                            count++;
                        } else {
                            System.out.println("That's not a valid input.");
                        }
                    }
                }
            }
                int rand = (int) Math.floor(Math.random() * (10 - 1 + 1) + 1);

                //Peaceful Encounters:
                //Training:
                if (((count <= 10) && (rand == 1 || rand == 2)) || ((count > 10) && (rand == 1))) {
                    System.out.println("You encountered a traveling sword man, they offer you training for 5 Gold.");
                    System.out.println("Your current amount of gold is: " + player.getGold());
                    System.out.println("Do you take up their offer? yes or no?");
                    boolean stillAsking = true;
                    while (stillAsking) {
                        cmd = input.next();
                        if (cmd.equalsIgnoreCase("yes")) {
                            if (player.getGold() >= 5) {
                                System.out.println("You received training from the sword man.");
                                player.levelUp();
                                player.useGold(5);
                                stillAsking = false;
                                count++;
                            } else {
                                System.out.println("You don't have enough money for the training. So you decided to move on");
                                stillAsking = false;
                                count++;
                            }
                        }
                        if (cmd.equalsIgnoreCase("no")) {
                            System.out.println("You move on with your adventure, refusing the offer");
                            stillAsking = false;
                            count++;
                        }
                        if (!cmd.equalsIgnoreCase("yes") && !cmd.equalsIgnoreCase("no")) {
                            System.out.println("That's not a valid input.");
                        }
                    }
                }
                //Healing
                if (((count <= 10) && (rand == 3 || rand == 4)) || ((count > 10) && (rand == 2 || rand == 3))) {
                    System.out.println("You encountered a magical healing well.");
                    player.heal();
                    System.out.println("Input 'go' to continue with your journey");
                    boolean stillAsking = true;
                    while (stillAsking) {
                        cmd = input.next();
                        if (cmd.equalsIgnoreCase("go")) {
                            stillAsking = false;
                            count++;
                        } else {
                            System.out.println("That's not a valid input.");
                        }
                    }
                }
                //Finding Treasure
                if (rand == 5) {
                    System.out.println("You found a bag of gold lying on the ground. Someone must have dropped it.");
                    player.gainGold(20);
                    System.out.println("Input 'go' to continue with your journey");
                    boolean stillAsking = true;
                    while (stillAsking) {
                        cmd = input.next();
                        if (cmd.equalsIgnoreCase("go")) {
                            stillAsking = false;
                            count++;
                        } else {
                            System.out.println("That's not a valid input.");
                        }
                    }
                }

                //Fighting Stuffs:
                //Low Level Monster:
                if (((count <= 5) && (rand > 5))) {
                    Monsters lowLevel = new Monsters(20, 10);
                    System.out.println("You encountered a low level monster.");
                    System.out.println("Your current HP is: " + player.getHP());
                    System.out.println("Do you want to fight this monster? yes or no?");
                    boolean stillAsking = true;
                    while (stillAsking) {
                        cmd = input.next();
                        if (cmd.equalsIgnoreCase("yes")) {
                            if ((lowLevel.getHP() * lowLevel.getDamage()) / player.getAttackPower() < player.getHP()) {
                                player.beingAttacked((lowLevel.getHP() * lowLevel.getDamage()) / player.getAttackPower());
                                player.gainXP(30);
                                player.gainGold(5);
                                stillAsking = false;
                                count++;
                            } else {
                                System.out.println("You have underestimated the monster's power. You didn't survive the encounter.");
                                player.setHP(0);
                                break;
                            }
                        }
                        if (cmd.equalsIgnoreCase("no")) {
                            System.out.println("You move on with your adventure, dodging the monster.");
                            stillAsking = false;
                            count++;
                        }
                        if (!cmd.equalsIgnoreCase("yes") && !cmd.equalsIgnoreCase("no")) {
                            System.out.println("That's not a valid input.");
                        }
                    }
                }

                //Mid Level Monster:
                if (((count > 5 && count <= 10) && (rand > 5)) || (count > 10) && (rand == 4)) {
                    Monsters midLevel = new Monsters(30, 15);
                    System.out.println("You encountered a middle level monster.");
                    System.out.println("Your current HP is: " + player.getHP());
                    System.out.println("Do you want to fight this monster? yes or no?");
                    boolean stillAsking = true;
                    while (stillAsking) {
                        cmd = input.next();
                        if (cmd.equalsIgnoreCase("yes")) {
                            if ((midLevel.getHP() * midLevel.getDamage()) / player.getAttackPower() < player.getHP()) {
                                player.beingAttacked((midLevel.getHP() * midLevel.getDamage()) / player.getAttackPower());
                                player.gainXP(60);
                                player.gainGold(10);
                                stillAsking = false;
                                count++;
                            } else {
                                System.out.println("You have underestimated the monster's power. You didn't survive the encounter.");
                                player.setHP(0);
                                break;
                            }
                        }
                        if (cmd.equalsIgnoreCase("no")) {
                            System.out.println("You move on with your adventure, dodging the monster.");
                            stillAsking = false;
                            count++;
                        }
                        if (!cmd.equalsIgnoreCase("yes") && !cmd.equalsIgnoreCase("no")) {
                            System.out.println("That's not a valid input.");
                        }
                    }
                }

                //High Level Monster:
                if ((count > 10) && (rand == 6 || rand == 7 || rand == 8)) {
                    Monsters highLevel = new Monsters(50, 20);
                    System.out.println("You encountered a high level monster.");
                    System.out.println("Your current HP is: " + player.getHP());
                    System.out.println("Do you want to fight this monster? yes or no?");
                    boolean stillAsking = true;
                    while (stillAsking) {
                        cmd = input.next();
                        if (cmd.equalsIgnoreCase("yes")) {
                            if ((highLevel.getHP() * highLevel.getDamage()) / player.getAttackPower() < player.getHP()) {
                                player.beingAttacked((highLevel.getHP() * highLevel.getDamage()) / player.getAttackPower());
                                player.gainXP(90);
                                player.gainGold(15);
                                stillAsking = false;
                                count++;
                            } else {
                                System.out.println("You have underestimated the monster's power. You didn't survive the encounter.");
                                player.setHP(0);
                                break;
                            }
                        }
                        if (cmd.equalsIgnoreCase("no")) {
                            System.out.println("You move on with your adventure, dodging the monster.");
                            stillAsking = false;
                            count++;
                        }
                        if (!cmd.equalsIgnoreCase("yes") && !cmd.equalsIgnoreCase("no")) {
                            System.out.println("That's not a valid input.");
                        }
                    }
                }

                //The Boss:
                if (count > 10 && (rand == 9 || rand == 10)) {
                    System.out.println("You have stumbled upon the dragon lair.");
                    System.out.println("Your current stats is:");
                    System.out.println("HP: " + player.getHP());
                    System.out.println("Attack power: " + player.getAttackPower());
                    System.out.println("Gold: " + player.getGold());
                    System.out.println("Do you wish to challenge the sleeping beast? yes or no?");
                    boolean stillAsking = true;
                    while (stillAsking) {
                        cmd = input.next();
                        if (cmd.equalsIgnoreCase("yes")) {
                            System.out.println("'Welcome brave challenger, we'll see if you're of any competence or will you just end up like all of your predecessor. Muahahahaha' - The Dragon said");
                            if (player.getGold() >= 100) {
                                System.out.println("'Wait.' The monster stop you as you're drawing out your sword.");
                                System.out.println("'I have noticed that you have quite a fortune yourself. And as a gold lover myself, I respect that'");
                                System.out.println("'It would be such a waste to kill you. Do you want to make a deal?' - The beast offers");
                                System.out.println("Do you agree to trade all of your gold to enact a peace treaty? Yes or No");
                                cmd = input.next();
                                if (cmd.equalsIgnoreCase("yes")) {
                                    boss.setHP(0);
                                    break;
                                } else {
                                    System.out.println("'Very well, then we will do this the hard way' - said the Dragon");
                                }
                            }
                            if ((boss.getHP() * boss.getDamage()) / player.getAttackPower() < player.getHP()) {
                                System.out.println("With great power accumulating from previous encountered. You have survived the dragon's dreadful attacks and successfully strike down the horrid beast.");
                                boss.setHP(0);
                                break;
                            }
                            else{
                                System.out.println("Unfortunately, the dragon is even more powerful than you have expected.");
                                System.out.println("You was not able to survive it's dreadful attacks.");
                                player.setHP(0);
                                break;
                            }
                        }
                        if (cmd.equalsIgnoreCase("no")) {
                            System.out.println("You move on with you adventure, leaving the task of challenging the horrid beast for another day.");
                            stillAsking = false;
                            count++;
                        }
                        if (!cmd.equalsIgnoreCase("yes") && !cmd.equalsIgnoreCase("no")) {
                            System.out.println("That's not a valid input.");
                        }
                    }
                }
                if (count == 20) {
                    System.out.println("You took too long to find the the dragon, it has woken up from its slumber and burn the village to the ground");
                    player.setHP(0);
                    break;
                }

                //LevelUp system by XP
                if (player.getXP() >= 100) {
                    System.out.println("Your XP has reached the threshold. You have leveled up.");
                    player.levelUp();
                    player.setXP(player.getXP() - 100);
                }
            }
            if (!player.isAlive()) {
                System.out.println("You're dead.");
                System.out.println("You have failed to defeat the dragon. The village now lies in ruin :(.");
                System.out.println("Good luck next time");
            }
            if (!boss.isAlive()) {
                System.out.println("You have defeated the evil beast. Now peace has returned to the village.");
                System.out.println("The king has appointed you to be the royal knight and give you enormous wealth. CONGRATS :)");
            }
        }
    }

