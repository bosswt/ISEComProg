public class Square extends Shape {

    public Square(int rows) {
        this.rows = rows;
        this.character = '*';
    }

    public Square(int rows, char character) {
        this.rows = rows;
        this.character = character;
    }

    public void draw() {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows; j++)
                System.out.print(character + " ");
            System.out.println();
        }
    }

    public void draw(int x, int y) {
        x++; // adjusting x position
        y++; // adjusting y position
        for (int i = 1; i <= rows + y; i++) {
            if (i >= y) { // only prints character after y rows
                for (int j = 1; j <= rows + x; j++) {
                    if (j >= x) // only prints character after x spaces
                        System.out.print(character + " ");
                    else
                        System.out.print(" "); // otherwise prints whitespace
                }
            }
            System.out.println(); // moves to next line
        }
    }

    public int getArea() {
        return rows * rows;
    }

    public int getPerimeter() {
        return 4 * rows;
    }

    public String toString() {
        return "Square: rows:" + rows + " character:" + character;
    }

}