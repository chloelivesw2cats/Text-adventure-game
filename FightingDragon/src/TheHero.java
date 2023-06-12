public class TheHero {
    private int HP;
    private int maxHP;
    private int AttackPower;
    private int Gold;
    private int XP;
    private String name;

    public int getHP() {
        return HP;
    }

    public int getAttackPower() {
        return AttackPower;
    }

    public void setHP(int HP) {this.HP = HP;    }

    public void setAttackPower(int attackPower) {
        AttackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() { return Gold; }

    public void setGold(int gold) { Gold = gold; }

    public int getMaxHP() {return maxHP;   }

    public void setMaxHP(int maxHP) {this.maxHP = maxHP;   }

    public int getXP() { return XP;    }

    public void setXP(int XP) {   this.XP = XP;    }


    public boolean isAlive(){
        return HP > 0;
    }
    public void beingAttacked(int x){
        HP -= x;
        System.out.println("You suffered from damage, your current HP is: " + HP);
    }

    public void heal(){
        HP = maxHP;
        System.out.println("You feel much better already, your current HP is: " + HP);
    }

    public void gainXP(int x){
        XP += x;
        System.out.println("You gained some XP. Your current XP is: " + XP +"/100");
    }

    public void levelUp() {
        AttackPower += 5;
        maxHP += 10;
        HP = maxHP;
        System.out.println("You feel stronger, your current AttackPower power is: " + AttackPower);
        System.out.println("You feel stronger, your new HP is: " + maxHP);
    }

    public void gainGold(int x){
        Gold += x;
        System.out.println("You gained " + x +" golds");
        System.out.println("Your current amount of Gold is: " + Gold);
    }

    public void useGold(int x){
        Gold -= x;
        System.out.println("You used " + x +" golds");
        System.out.println("Your current amount of Gold is: " + Gold);
    }
}
