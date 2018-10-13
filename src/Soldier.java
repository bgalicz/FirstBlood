import java.util.Random;

public class Soldier {
    int speed;
    int force;
    int dexterity;
    Die die = new Die();

    //Konstruktor
    public Soldier(int speed, int force, int dexterity) {
        this.speed = speed;
        this.force = force;
        this.dexterity = dexterity;
    }

    //Metodusok
    public boolean fight(Soldier enemy) {

        boolean toHitEnemy = false;

        //Eldontjuk ki kezd true->ownSoldier kezd, false->enemy kezd
        if (this.getSpeed() == enemy.getSpeed()) {
            Random random = new Random();
            toHitEnemy = random.nextBoolean();
        } else if (this.getSpeed()>enemy.getSpeed()){
            toHitEnemy = true;
        } else if (this.getSpeed()<enemy.getSpeed()){
            toHitEnemy = false;
        }
        while (true){
            int rollResult;

            if (toHitEnemy){
                rollResult = die.roll(); //iBalage, hogy eltalálom e
                if (rollResult <= this.getForce()){
                    rollResult = die.roll(); //ellenség proálja védeni ha megdobtam az erőpróbát
                    if (rollResult<=enemy.getDexterity()){
                        //ellenfél védett, ö jön ütéssel, azaz go to enemyStart:
                        toHitEnemy = false;
                    } else {
                        //ownsSoldier nyert
                        return true;
                    }
                } else {
                    //luftot ütött a harcosom, enemy jön:
                    toHitEnemy = false;
                }
            } else {
                rollResult = die.roll(); //enemy, hogy eltalál e
                if (rollResult <= enemy.getForce()){
                    rollResult = die.roll(); //meprobalom hárítani, ha megdobta az erőpróbát
                    if (rollResult<=this.getDexterity()){ //védtem, sajat katonam kiserletezhet tamdassal
                        toHitEnemy = true;
                    } else { //enemy nyert
                        return false;
                    }
                } else { //luftot ütött enemy, sajat katonam kiserletezhet tamdassal
                    toHitEnemy = true;
                }
            }
        }
    }

    public String toString() {
        return "Gyorsasag: " + this.speed + ", "
                + "Ero: " + this.force + ", " + "Ugyesseg: "
                + this.dexterity;
    }

    public int getSpeed() {
        return speed;
    }

    public int getForce() {
        return force;
    }

    public int getDexterity() {
        return dexterity;
    }
}
