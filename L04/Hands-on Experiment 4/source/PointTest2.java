import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class PointTest2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("location.txt"));
        String p1 = in.readLine();
        int x = Integer.parseInt(p1);
        String p2 = in.readLine();
        int y = Integer.parseInt(p2);
        Point p = new Point(x, y);
        System.out.print("X = " + x + " Y = " + y + '\n');
        double dist = p.distance(Point.origin);
        System.out.println(dist);
    }
}