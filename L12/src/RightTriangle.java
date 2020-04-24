public class RightTriangle extends Shape {

    private boolean isVerticalFlip;

    public RightTriangle(int rows) {
        super.rows = rows;
        super.character = '%';
        isVerticalFlip = false;
    }

    public RightTriangle(int rows, char character) {
        super.rows = rows;
        super.character = character;
        isVerticalFlip = false;
    }

    public void draw() {
        for (int i = 1; i <= rows; i++) {
            if (isVerticalFlip) { // when vertical flipped print some whitespaces first to push the triangle to
                                  // the right
                for (int k = 1; k <= rows - i; k++)
                    System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(character + " ");
            }
            System.out.println();
        }
    }

    public void draw(int x, int y) {
        x++;
        y++;
        for (int i = 1; i <= rows + y; i++) {
            if (i >= y) {
                if (isVerticalFlip) {
                    for (int k = 1; k <= rows - i; k++)
                        System.out.print("  ");
                }
                for (int j = 1; j <= i + x; j++) {
                    if (j >= x)
                        System.out.print(character + " ");
                    else
                        System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void drawDoubleTriangle(int space) { // for the two triangle at the last part
        for (int i = 1; i <= rows; i++) {
            // Left triangle
            for (int k = 1; k <= rows - i; k++)
                System.out.print("  ");
            for (int j = 1; j <= i; j++) {
                System.out.print(character + " ");
            }

            for (int index = 1; index <= space; index++)
                System.out.print(" ");

            // Right triangle
            for (int j = 1; j <= i; j++) {
                System.out.print(character + " ");
            }
            System.out.println();
        }
    }

    public double getArea() {
        return 0.5 * rows * rows;
    }

    public double getPerimeter() {
        return 2.0 * rows + Math.sqrt(2.0 * rows * rows);
    }

    public String toString() {
        return "RightTriangle: rows:" + rows + " character:" + character + " isVerticalFlip:" + isVerticalFlip;
    }

    public boolean isVerticalFlip() {
        return isVerticalFlip;
    }

    public void setVerticalFlip(boolean isVerticalFlip) {
        this.isVerticalFlip = isVerticalFlip;
    }

}