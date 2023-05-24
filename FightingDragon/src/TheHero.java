public class TheHero {
    private int HP = 50;
    private int Stamina = 10;
    private int AttackPower = 5;

    public TheHero(int HP, int stamina, int attackPower) {
        this.HP = HP;
        this.Stamina = stamina;
        this.AttackPower = attackPower;
    }

    public int getHP() {
        return HP;
    }

    public int getStamina() {
        return Stamina;
    }

    public int getAttackPower() {
        return AttackPower;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setStamina(int stamina) {
        Stamina = stamina;
    }

    public void setAttackPower(int attackPower) {
        AttackPower = attackPower;
    }
    public void heal(int x){
        HP += x;
        System.out.println("You feel much better already, your current HP is: " + HP);
    }
    public void rest(){
        Stamina = 10;
        System.out.println("Your stamina has been topped off");
    }
    public void levelup(int z){
        AttackPower += z;
        System.out.println("You feel stronger, your current AttackPower power is: " + AttackPower);
    }
}
