import java.util.Scanner;
import java.io.*;
import java.lang.Math;

public class PartA {
    public static void main(String[] args) {
        double a = 2.0;
        int b = -4;
        double result1 = Math.pow(a, b);
        double result2 = 1;
        for (int i = 0; i < Math.abs(b); i++)
            result2 *= a;
        if (b < 0)
            result2 = 1 / result2;
        System.out.println(result1);
        System.out.println(result2);
    }
}