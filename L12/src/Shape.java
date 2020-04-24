public class Shape {
    protected int rows;
    protected char character;

    public Shape() {
    };

    public Shape(int x, char c) {
        rows = x;
        character = c;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int x) {
        this.rows = x;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public String toString() {
        return "rows:" + rows + " character:" + character;
    }

}