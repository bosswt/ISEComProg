public class PartA {
    public static void main(String[] args) {
        Point p = new Point(2, 3);
        double dist = p.distance(Point.origin);
        System.out.println(dist);
        p.clear();
    }
}