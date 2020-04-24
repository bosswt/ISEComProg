public class Draw {
    public static void main(String[] args) {
        Triangle head = new Triangle(7, '#');
        Square body = new Square(15, '%');
        RightTriangle legs = new RightTriangle(7, '&');
        head.draw(8, 0);
        // head.setHorizontalFlip(true);
        // head.draw(8, 0);
        body.draw();
        legs.drawDoubleTriangle(2);
    }
}