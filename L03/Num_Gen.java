import java.util.Random;
import java.lang.Math;

public class Num_Gen {
    public static void main(String[] args) {
        Random rn = new Random();
        for (int i = 0; i < 30; i++) {
            double randomNum = Math.ceil(rn.nextGaussian() * 2 + 5);
            System.out.print(Math.max(1, Math.min(randomNum, 10)) + ",");
        }
    }
}