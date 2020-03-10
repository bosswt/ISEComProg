import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class PartB {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("score.csv"));
        in.nextLine();
        in.useDelimiter("\\r\\n|,");
        int q[][] = new int[1000][5];
        double sumpowdiff[] = new double[5];
        int sum[] = new int[5];
        int max[] = new int[5];
        int min[] = new int[5];
        int num = 0;
        double count = 0;
        double avg[] = new double[5];
        double sd[] = new double[5];
        double sumavgpowdiff = 0;
        double sumavg = 0;
        double avgq, sdq;
        double totalsumpowdiff = 0;
        Arrays.fill(max, -99999);
        Arrays.fill(min, 99999);
        while (in.hasNext()) {
            String id = in.next();
            for (int i = 0; i < 5; i++) {
                q[num][i] = in.nextInt();
                sum[i] += q[num][i];
                if (q[num][i] > max[i])
                    max[i] = q[num][i];
                if (q[num][i] < min[i])
                    min[i] = q[num][i];
            }
            count++;
            num++;
        }
        for (int i = 0; i < 5; i++) {
            avg[i] = sum[i] / count;
            System.out.println("Avg for Q" + (i + 1) + ": " + avg[i]);
            System.out.println("Min = " + min[i] + " Max = " + max[i]);
            for (int j = 0; j < 1000; j++) {
                sumpowdiff[i] += Math.pow(q[j][i] - avg[i], 2);
                totalsumpowdiff += Math.pow(q[j][i] - avg[i], 2);
            }
            sumavg += avg[i];
            sd[i] = Math.sqrt(sumpowdiff[i] / 1000);
            System.out.println("SD For Q" + (i + 1) + ": " + sd[i]);
        }
        avgq = sumavg / 5;
        System.out.println("Avg for all Q : " + avgq);
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 1000; j++)
                sumavgpowdiff += Math.pow(q[j][i] - avgq, 2);
        sdq = Math.sqrt(sumavgpowdiff / 5000);
        System.out.println("SD for all Q : " + sdq);
    }
}