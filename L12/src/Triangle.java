public class Triangle extends Shape {

    private boolean isHorizontalFlip;

    public Triangle(int rows) {
        super.rows = rows;
        super.character = '#';
        isHorizontalFlip = false;
    }

    public Triangle(int rows, char character) {
        super.rows = rows;
        super.character = character;
        isHorizontalFlip = false;
    }

    public void draw() {
        if (isHorizontalFlip) {
            for (int i = rows; i >= 1; i--) {
                for (int k = 1; k <= rows - i; k++)
                    System.out.print(" ");
                for (int j = 1; j <= i; j++) {
                    System.out.print(character + " ");
                }
                System.out.println();
            }
        } else {
            for (int i = 1; i <= rows; i++) {
                for (int k = 1; k <= rows - i; k++)
                    System.out.print(" ");
                for (int j = 1; j <= i; j++) {
                    System.out.print(character + " ");
                }
                System.out.println();
            }
        }
    }

    public void draw(int x, int y) {
        x++;
        y++;
        if (isHorizontalFlip) {
            for (int i = rows + y - 1; i >= 1; i--) {
                if (rows - i + 1 >= y) {
                    if (isHorizontalFlip()) {
                        for (int k = 1; k <= rows - i; k++)
                            System.out.print(" ");
                    }
                    for (int j = 1; j <= i + x - 1; j++) {
                        if (j >= x)
                            System.out.print(character + " ");
                        else
                            System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } else {
            for (int i = 1; i <= rows + y - 1; i++) {
                if (i >= y) {
                    for (int k = 1; k <= rows - i; k++)
                        System.out.print(" ");
                    for (int j = 1; j <= i + x - 1; j++) {
                        if (j >= x)
                            System.out.print(character + " ");
                        else
                            System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    public double getArea() {
        return 0.5 * rows * rows / Math.tan(60);
    }

    public double getPerimeter() {
        return 3 * rows / Math.sin(60);
    }

    public String toString() {
        return "Square: rows:" + rows + " character:" + character + " isHorizontalFlip:" + isHorizontalFlip;
    }

    public boolean isHorizontalFlip() {
        return isHorizontalFlip;
    }

    public void setHorizontalFlip(boolean isHorizontalFlip) {
        this.isHorizontalFlip = isHorizontalFlip;
    }

}