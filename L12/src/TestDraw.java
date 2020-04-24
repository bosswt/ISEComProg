public class TestDraw {
    public static void main(String[] args) {
        Triangle head = new Triangle(7, '*');
        Square tail = new Square(5, '*');
        head.draw();
        tail.draw(5, 0);
    }
}