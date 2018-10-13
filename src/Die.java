import java.util.Random;

public class Die {

    private Random random = new Random();

    public int roll(){
        int number;
        number = random.nextInt(6) + 1;
        return number;
    }
}
