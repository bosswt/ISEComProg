import java.util.Random;
import java.lang.Math;

public class Num_Gen {
    public static void main(String[] args) {
        Random rn = new Random();
        for (int i = 0; i < 30; i++) {
            double randomNum = Math.ceil(rn.nextGaussian() * 2 + 5);
            if (randomNum < 1) {
                randomNum = 1;
            }
            if (randomNum > 10) {
                randomNum = 10;
            }
            System.out.print(randomNum + ",");
        }
    }
}