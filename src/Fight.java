import java.util.Random;

public class Fight {

    public static void main(String[] args) {
        int ownSpeed = 0;
        int ownForce = 1;
        int ownDexterity = 0;
        int numOfWins = 0;
        int maxWins = 0;
        Soldier bestSoldier = null;

        for (int i = 0; i <= 5; i++) {
            ownSpeed = i;
            for (int j = 1; j <= 6 - ownSpeed; j++) {
                numOfWins = 0; //új fight/fordulo kezdése előtt ki legyen nullázva
                ownForce = j;
                ownDexterity = 6 - ownSpeed - ownForce;
                Soldier ownSoldier = new Soldier(ownSpeed, ownForce, ownDexterity);
                System.out.println("iBalage " + ownSoldier);
                //Fightings
                for (int fight=1; fight<=1000; fight++) {
                    boolean toHitEnemy = false;
                    boolean isWinner = false;
                    Soldier enemy = createEnemy();
                    boolean isOwnSoldierWinner = ownSoldier.fight(enemy); //ha a fight/ visszateresi értéke true, akkor a mi katonánk nyert
                    if (isOwnSoldierWinner){
                        numOfWins++; //iBalage nyereseinek összegzése egy forduloban.
                    }
                }
                System.out.println("Nyert kuzdelmek: " + numOfWins);
                if (numOfWins > maxWins) {
                    maxWins = numOfWins;
                    bestSoldier = ownSoldier;
                    System.out.println("Az eddigi legjobb tulajdonságu katona:" + bestSoldier);
                }
            }
        }
        System.out.println("\nLegnagyobb esellyel indulo harcosom: \niBalage es tulajdonsagai: \n"  + bestSoldier);
    }


    public static Soldier createEnemy (){
        int speed;
        int force;
        int dex;

        Random random = new Random();
        speed = random.nextInt(6); //speed of enemy
        force = (random.nextInt(6 - speed)+ 1); //force of enemy
        dex = 6 - speed - force; //dexterity of enemy

        return new Soldier (speed, force, dex);
    }
}