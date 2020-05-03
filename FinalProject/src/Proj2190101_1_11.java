import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Proj2190101_1_11 {
    public static CountryInfected[] getInfected() throws IOException {
        ArrayList<CountryInfected> infected = new ArrayList<CountryInfected>();
        ArrayList<CountryInfected> infectedPass = new ArrayList<CountryInfected>();
        BufferedReader csv = new BufferedReader(new FileReader("../time_series_covid19_confirmed_global.csv"));
        String row = csv.readLine();
        int totalDays = row.split(",").length;
        totalDays -= 4;
        String countryName = null;
        while ((row = csv.readLine()) != null) {
            String[] rowData = row.split(",");
            if (rowData[1].equals("Holy See"))
                rowData[1] = "Vatican City";
            else if (rowData[1].equals("Korea South"))
                rowData[1] = "South Korea";
            else if (rowData[1].equals("Taiwan*"))
                rowData[1] = "Taiwan";
            countryName = rowData[1];
            int index = countryIndex(infected, countryName);
            addData(index, infected, rowData);
        }
        csv.close();
        for (int i = 0; i < infected.size(); i++) {
            CountryInfected eachCountry = infected.get(i);
            if (eachCountry.getInfectedNumbersByIndex(totalDays - 1) > 100)
                infectedPass.add(eachCountry);
        }
        CountryInfected[] infectedPassArray = infectedPass.toArray(new CountryInfected[infectedPass.size()]);
        return infectedPassArray;
    }

    public static int countryIndex(ArrayList<CountryInfected> infected, String countryName) {
        for (int i = 0; i < infected.size(); i++) {
            if (infected.get(i).getCountry().equals(countryName))
                return i;
        }
        return -1;
    }

    public static void addData(int index, ArrayList<CountryInfected> infected, String[] rowData) {
        String countryName = rowData[1];
        if (index == -1) {
            CountryInfected newCountry = new CountryInfected(countryName, rowData);
            infected.add(newCountry);
        } else {
            CountryInfected existedCountry = infected.get(index);
            existedCountry.addInfected(rowData);
        }
    }

    public static double[] getSCurve(int[] pastData, int numFutureDays, double[] paramLowerBounds,
            double[] paramUpperBounds) {
        double bestSDLM[] = new double[4];
        double Factor[] = new double[] { 0.2, 0.5, 0.01, 10 };
        double minMSE = Double.MAX_VALUE;
        for (double S = paramLowerBounds[0]; S <= paramUpperBounds[0]; S += Factor[0]) {
            for (double D = paramLowerBounds[1]; D <= paramUpperBounds[1]; D += Factor[1]) {
                for (double L = paramLowerBounds[2]; L <= paramUpperBounds[2]; L += Factor[2]) {
                    for (double M = paramLowerBounds[3]; M <= paramUpperBounds[3]; M += Factor[3]) {
                        double sum = 0;
                        for (int i = 0; i < pastData.length; i++) {
                            sum += Math.pow((S + (M / (1.0 + Math.exp(-L * (i - D))))) - pastData[i], 2);
                        }
                        double MSE = sum / pastData.length;
                        if (MSE < minMSE) {
                            minMSE = MSE;
                            bestSDLM = new double[] { S, D, L, M };
                        }
                    }
                }
            }
        }
        ArrayList<Double> predictedList = new ArrayList<Double>();
        double S = bestSDLM[0];
        double D = bestSDLM[1];
        double L = bestSDLM[2];
        double M = bestSDLM[3];
        System.out.println("Minimum MSE: " + minMSE);
        for (int i = 1; i <= numFutureDays; i++) {
            int day = i + pastData.length;
            double predictedValue = (S + (M / (1.0 + Math.exp(-L * (day - D)))));
            predictedList.add(predictedValue);
        }
        double[] predictedArray = new double[predictedList.size()];
        Iterator<Double> iterator = predictedList.iterator();
        int i = 0;
        while (iterator.hasNext())
            predictedArray[i++] = iterator.next();
        System.out.println("The fitted S-curve model has S=" + S + ", D=" + D + ", L=" + L + ", M=" + M
                + ", with the first projected day being d=" + (int) (1 + pastData.length) + ".");
        return predictedArray;
    }

    public static double[] getDoNothingCurve(int[] pastData, int numFutureDays) {
        ArrayList<Double> newData = new ArrayList<Double>();
        double[] x = new double[numFutureDays];
        int lastIndex = pastData.length - 1;
        for (int i = 0; i < pastData.length; i++) {
            newData.add((double) pastData[i]);
        }
        for (int j = 0; j < numFutureDays; j++) {
            x[j] = ((newData.get(lastIndex + j) / newData.get(lastIndex - 1 + j)
                    + newData.get(lastIndex - 1 + j) / newData.get(lastIndex - 2 + j)
                    + newData.get(lastIndex - 2 + j) / newData.get(lastIndex - 3 + j)) / 3.0)
                    * newData.get(lastIndex + j);
            newData.add(x[j]);
        }
        return x;
    }

    public static void main(String[] args) throws IOException {
        CountryInfected[] dataArray = getInfected();
        ArrayList<CountryInfected> data = new ArrayList<CountryInfected>(Arrays.asList(dataArray));
        Scanner sc = new Scanner(System.in);
        BufferedWriter br = new BufferedWriter(new FileWriter("1_11.csv"));
        String[] queryCountry = new String[3];
        CountryInfected[] foundCountry = new CountryInfected[3];
        // for (int i = 0; i < 3; i++)
        // queryCountry[i] = sc.next();
        queryCountry[0] = "US";
        queryCountry[1] = "Czechia";
        queryCountry[2] = "Thailand";
        String[] s = new String[3];
        String[] n = new String[3];
        for (int i = 0; i < 3; i++) {
            s[i] = "";
            n[i] = "";
            int foundCountryIndex = countryIndex(data, queryCountry[i]);
            if (foundCountryIndex == -1) {
                System.out.println("Not Found!");
                continue;
            }
            foundCountry[i] = data.get(foundCountryIndex);
            System.out.println(queryCountry[i] + " Total(100 Days): " + foundCountry[i].getInfectedNumbersByIndex(99));
            int[] pastData = foundCountry[i].getInfectedNumbers();
            // System.out.print("Enter number of future days: ");
            // int numFutureDays = sc.nextInt();
            int numFutureDays = 90;
            double[] getNothingCurve = getDoNothingCurve(pastData, numFutureDays);
            for (int j = 0; j < getNothingCurve.length; j++) {
                System.out.print(getNothingCurve[j] + " ");
                if (j < 10)
                    n[i] += getNothingCurve[j] + ",";
            }
            System.out.println();
            double[] paramLowerBounds = new double[4];
            double[] paramUpperBounds = new double[4];
            // System.out.print("\nEnter S,D,L,M lower bound respectively: ");
            // for (int j = 0; j < 4; j++)
            // paramLowerBounds[j] = sc.nextDouble();
            // System.out.print("Enter S,D,L,M upper bound respectively: ");
            // for (int j = 0; j < 4; j++)
            // paramUpperBounds[j] = sc.nextDouble();
            if (i == 0) {
                // US
                paramLowerBounds = new double[] { 0, 75, 0, 1100000 };
                paramUpperBounds = new double[] { 1, 90, 0.4, 1250000 };
            } else if (i == 1) {
                // Czechia
                paramLowerBounds = new double[] { 0, 65, 0, 5000 };
                paramUpperBounds = new double[] { 1, 90, 0.4, 9000 };
            } else {
                // Thailand
                paramLowerBounds = new double[] { 2, 60, 0, 1500 };
                paramUpperBounds = new double[] { 3, 70, 0.4, 3500 };
            }
            double[] predictedSCurve = getSCurve(pastData, numFutureDays, paramLowerBounds, paramUpperBounds);
            for (int j = 0; j < predictedSCurve.length; j++) {
                System.out.print(predictedSCurve[j] + " ");
                if (j < 10)
                    s[i] += predictedSCurve[j] + ",";
            }
            System.out.println("\n====================");
        }
        sc.close();
        for (int j = 0; j < 3; j++) {
            br.write(s[j].substring(0, s[j].length() - 1));
            br.newLine();
            br.write(n[j].substring(0, n[j].length() - 1));
            if (j != 2)
                br.newLine();
        }
        br.close();
        // Most optimize(I think)
        // US Lower = {0, 75, 0, 1100000}, Upper = {1, 90, 0.4, 1250000}
        // Czechia Lower = {0, 65, 0, 5000}, Upper = {1, 90, 0.4, 9000}
        // Thailand Lower={2, 60, 0, 1500}, Upper={3, 70, 0.4, 3500}

    }
}