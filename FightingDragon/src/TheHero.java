public class TheHero {
    private int HP;
    private int Stamina;
    private int AttackPower;
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive(){
        return HP > 0;
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
